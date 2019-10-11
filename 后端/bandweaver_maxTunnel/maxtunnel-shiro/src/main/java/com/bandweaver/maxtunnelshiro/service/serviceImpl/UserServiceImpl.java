package com.bandweaver.maxtunnelshiro.service.serviceImpl;


import com.bandweaver.maxtunnelshiro.entity.User;
import com.bandweaver.maxtunnelshiro.mapper.UserMapper;
import com.bandweaver.maxtunnelshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getByUserName(String name) {
        return userMapper.getByName(name);
    }

    @Override
    public Set<String> getUserPermissions(String name) {
        // 查询数据库
        Set<String> userPermissions = userMapper.getUserPermissions(name);

        return userPermissions;
    }
}
