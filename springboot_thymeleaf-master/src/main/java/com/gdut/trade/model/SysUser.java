package com.gdut.trade.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 系统用户表
 */
@Data
public class SysUser {
    /**
     * 主键ID，自动递增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账号
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
    * 性别：M-男, F-女
    */
    private Object sex;

    /**
     * 年龄
     */
    private Byte age;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 创建时间戳
     */
    private Date createdTime;

    /**
     * 更新时间戳
     */
    private Date updatedTime;
}
