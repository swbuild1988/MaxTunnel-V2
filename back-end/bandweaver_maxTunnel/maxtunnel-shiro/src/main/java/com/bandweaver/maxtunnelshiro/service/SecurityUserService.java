package com.bandweaver.maxtunnelshiro.service;

import com.bandweaver.maxtunnelshiro.entity.SecurityUser;

import java.util.Set;

public interface SecurityUserService {

    SecurityUser getByUserName(String name);

    Set<String> getUserPermissions(String name);
}
