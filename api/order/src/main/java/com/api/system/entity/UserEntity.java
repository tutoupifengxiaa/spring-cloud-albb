package com.api.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("user")
public class UserEntity extends Model<UserEntity> {
    private String id;
    private String name;
    private Integer age;
}
