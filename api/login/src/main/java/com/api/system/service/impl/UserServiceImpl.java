package com.api.system.service.impl;

import com.api.system.entity.User;
import com.api.system.mapper.UserMapper;
import com.api.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
