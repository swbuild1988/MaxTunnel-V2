package com.bandweaver.maxtunnelem.service.serviceImpl;

import com.bandweaver.maxtunnelem.entity.SecurityUser;
import com.bandweaver.maxtunnelem.mapper.SecurityUserMapper;
import com.bandweaver.maxtunnelem.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecurityUserServiceImpl implements SecurityUserService{


    @Autowired
    private SecurityUserMapper securityUserMapper;


    @Override
    public SecurityUser selectByUserId(Integer userId) {
        return securityUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Integer addUser(SecurityUser user) {
        return null;
    }

    @Override
    public Integer editUser(SecurityUser user) {
        return null;
    }

    @Override
    public SecurityUser getByUser(SecurityUser user) {
        return null;
    }

    @Override
    public List<SecurityUser> listAllUser() {
        Map<String, Object> map = new HashMap<String,Object>();
        return securityUserMapper.listByMap(map);
    }

    @Override
    public List<SecurityUser> listByUser(SecurityUser user) {
        return null;
    }

    @Override
    public Integer getCountByUser(SecurityUser user) {
        return null;
    }
}
