package com.bandweaver.maxtunnelem.service.serviceImpl;

import com.bandweaver.maxtunnelem.entity.User;
import com.bandweaver.maxtunnelem.mapper.UserMapper;
import com.bandweaver.maxtunnelem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectByUserId(Integer userId){
        User user = userMapper.selectByPrimaryKey(userId);

        return user;
    }

    @Override
    public Integer addUser(User user){
        Integer result = userMapper.insertSelective(user);

        return result;
    }

    @Override
    public Integer editUser(User user){
        Integer result = userMapper.updateByPrimaryKeySelective(user);

        return result;
    }


    @Override
    public User getByUser(User user){
        Map<String,Object> map = new HashMap<String,Object>();

        if (user != null && user.getName() != null && !user.getName().equals("")){
            map.put("userName",user.getName());
        }
        if(user != null && user.getPassword() != null && !user.getPassword().equals("")){
            map.put("password",user.getPassword());
        }

        User result = userMapper.selectByMap(map);

        return result;
    }

    @Override
    public List<User> listAllUser() {
        Map<String, Object> map = new HashMap<String,Object>();
        return userMapper.listByMap(map);
    }

    @Override
    public List<User> listByUser(User user) {
        Map<String, Object> map = new HashMap<String,Object>();
        if(user != null) {
            if(user.getName() != null && !"".equals(user.getName())) {
                map.put("userName", user.getName());
            }
        }


        return userMapper.listByMap(map);
    }

    @Override
    public Integer getCountByUser(User user) {
        Map<String, Object> map = new HashMap<String,Object>();
        if(user != null) {
            if(user.getName() != null && !"".equals(user.getName())) {
                map.put("userName", user.getName());
            }

        }

        return userMapper.getCountByMap(map);
    }


}
