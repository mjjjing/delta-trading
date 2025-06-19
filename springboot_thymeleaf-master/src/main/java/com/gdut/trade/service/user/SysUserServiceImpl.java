package com.gdut.trade.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdut.trade.mapper.SysUserMapper;
import com.gdut.trade.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Override
    public List<SysUser> getUserList() {
        return this.list();
    }

    @Override
    public boolean addUser(SysUser user) {
        return this.save(user);
    }

    @Override
    public boolean updateUser(SysUser user) {
        return this.updateById(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return this.removeById(id);
    }
}
