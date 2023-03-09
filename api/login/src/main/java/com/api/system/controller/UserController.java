package com.api.system.controller;

import com.api.common.Result;
import com.api.system.entity.User;
import com.api.system.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Delete;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("list")
    public Result list(@RequestBody User user, long pages, long size) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Page<User> page = new Page<>(pages, size);
        IPage<User> iPage = userService.page(page, queryWrapper);
        return Result.ok(iPage);
    }

    @RequestMapping("add")
    public Result add(@RequestBody User user) {
        boolean save = userService.save(user);
        if (save == true) {
            return Result.ok("注册成功");
        }
        return Result.fail("注册失败");
    }

    @RequestMapping("edit")
    public Result edit(@RequestBody User user) {
        boolean update = userService.updateById(user);
        if (update == true) {
            return Result.ok("修改成功");
        }
        return Result.fail("修改失败");
    }

    @Delete("delete")
    public Result delete(String id) {
        boolean remove = userService.removeById(id);
        if (remove == true) {
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }
}
