package com.bandweaver.maxtunnelshiro.service.serviceImpl;

import com.bandweaver.maxtunnelshiro.entity.SecurityUser;
import com.bandweaver.maxtunnelshiro.mapper.SecurityUserMapper;
import com.bandweaver.maxtunnelshiro.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Set;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {

   @Resource
   private SecurityUserMapper securityUserMapper;

    @Override
    public SecurityUser getByUserName(String name) {
        return securityUserMapper.selectByName(name);
    }

    @Override
    public Set<String> getUserPermissions(String name) {
        Set<String> userPermissions =   securityUserMapper.getUserPermissions(name);
        return userPermissions;
    }
}
