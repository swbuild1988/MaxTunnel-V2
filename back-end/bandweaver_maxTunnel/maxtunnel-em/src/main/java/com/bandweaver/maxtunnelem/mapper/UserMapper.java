package com.bandweaver.maxtunnelem.mapper;

import com.bandweaver.maxtunnelem.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    User selectByMap(Map<String,Object> map);

    List<User> listByMap(Map<String, Object> map);

    Integer getCountByMap(Map<String, Object> map);



}
