package com.bandweaver.maxtunnelem.service;

import com.bandweaver.maxtunnelem.entity.SecurityUser;

import java.util.List;

public interface SecurityUserService {

    SecurityUser selectByUserId(Integer userId);

    Integer addUser(SecurityUser user);

    Integer editUser(SecurityUser user);

    SecurityUser getByUser(SecurityUser user);

    List<SecurityUser> listAllUser();

    List<SecurityUser> listByUser(SecurityUser user);

    Integer getCountByUser(SecurityUser user);



}
