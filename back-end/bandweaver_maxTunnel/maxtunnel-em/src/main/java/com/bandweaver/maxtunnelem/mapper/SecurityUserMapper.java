package com.bandweaver.maxtunnelem.mapper;


import com.bandweaver.maxtunnelem.entity.SecurityUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SecurityUserMapper {

    int deleteByPrimaryKey(Integer userId);

    SecurityUser selectByPrimaryKey(Integer userId);

    SecurityUser selectByMap(Map<String,Object> map);

    List<SecurityUser> listByMap(Map<String, Object> map);

    Integer getCountByMap(Map<String, Object> map);

}
