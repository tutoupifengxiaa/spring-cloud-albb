package com.api.system.controller;

import com.api.system.entity.UserEntity;
import com.api.system.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Results;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService UserService;
    @RequestMapping("/add")
    public void add(){
//        UserEntity entity = new UserEntity();
//        entity.setId(String.valueOf(UUID.randomUUID()));
//        entity.setName("张五");
//        entity.setAge(25);
        QueryWrapper<UserEntity> user = new QueryWrapper<>();
        user.eq("name","张三");
        List<UserEntity> userEntities = UserService.list(user);
//        UserService.save(entity);
        for (UserEntity userEntity : userEntities) {
            userEntity.toString()
        }

    }
}
