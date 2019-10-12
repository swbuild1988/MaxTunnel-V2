package com.bandweaver.maxtunnelshiro.service;

import com.bandweaver.maxtunnelshiro.entity.User;

import java.util.Set;

public interface UserService {

    User getByUserName(String name);

    Set<String> getUserPermissions(String name);

}
