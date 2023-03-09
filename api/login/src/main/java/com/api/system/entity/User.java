package com.api.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@TableName("user")
public class User extends Model<User> implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private long id= Long.parseLong(UUID.randomUUID().toString().replaceAll("-",""));
    /**
     * 账号
     */

    private String username;
    /**
     * 用户名
     */

    private String realname;

    /**
     * 手机号
     */
    private String iphone;

    /**
     * 创建时间
     */
    private Date createdtime;

    /**
     * 更新时间
     */
    private Date updatatime;

    /**
     * 操作人
     */
    private String operator;
}
