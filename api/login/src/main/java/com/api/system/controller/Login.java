package com.api.system.controller;

import com.api.common.Result;
import com.api.system.entity.User;
import com.api.system.service.UserService;
import com.api.utils.JwtUtil;
import com.api.utils.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class Login {
    public static final String UTF_8 = "UTF-8";
    //编码
    final Base64.Decoder decoder = Base64.getDecoder();
    final Base64.Encoder encoder = Base64.getEncoder();
    @Resource
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;

    /**
     * 登录接口
     */
    @RequestMapping("/signIn")
    public Result signIn(@RequestParam("username") String username, @RequestParam("password") String password) throws UnsupportedEncodingException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userService.getOne(queryWrapper);
        String decode = new String(decoder.decode(user.getPassword()), "UTF-8").toString();
        if (password.equals(decode)) {
            String token = JwtUtil.createJwt(String.valueOf(user.getId()), user.getUsername(), null);
            Map<String, String> map = new HashMap<>();
            map.put("id", String.valueOf(user.getId()));
            map.put("username", user.getUsername());
            map.put("token", token);
            redisUtil.set(user.getId(), map.toString(),900);
            return Result.ok(map);
        }
        return Result.error("账号或密码错误！");
    }

    /**
     * 注册接口
     */
    @RequestMapping("/signUp")
    public Result signUp(@RequestBody User user) throws UnsupportedEncodingException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User serviceOne = userService.getOne(queryWrapper);
        if (serviceOne != null) {
            return Result.error("账号已存在！");
        }
        String encode = encoder.encodeToString(user.getPassword().getBytes(UTF_8));
        user.setPassword(encode);
        boolean b = userService.save(user);
        return Result.ok();
    }
}
