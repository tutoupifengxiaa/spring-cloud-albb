package com.api.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@TableName("user")
public class User extends Model<User> implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.INPUT)
    private String id= UUID.randomUUID().toString().replaceAll("-","");
    /**
     * 账号
     */

    private String username;
    /**
     * 用户名
     */

    private String realname;

    /**
     * 密码
     */
    private String password;

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
