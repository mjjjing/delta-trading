package com.gdut.trade.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdut.trade.model.SysUser;

import java.util.List;

public interface SysUserService extends IService<SysUser> {
    /**
     * 查询
     */
    List<SysUser> getUserList();

    /**
     * 添加
     */
    boolean addUser(SysUser user);

    /**
     * 修改
     */
    boolean updateUser(SysUser user);

    /**
     * 删除
     */
    boolean deleteUser(Long id);
}
