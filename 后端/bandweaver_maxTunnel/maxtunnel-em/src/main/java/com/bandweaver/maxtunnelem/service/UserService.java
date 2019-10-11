package com.bandweaver.maxtunnelem.service;

import com.bandweaver.maxtunnelem.entity.User;

import java.util.List;

public interface UserService {

    User selectByUserId(Integer userId);

    Integer addUser(User user);

    Integer editUser(User user);

    User getByUser(User user);

    List<User> listAllUser();

    List<User> listByUser(User user);

    Integer getCountByUser(User user);

}
