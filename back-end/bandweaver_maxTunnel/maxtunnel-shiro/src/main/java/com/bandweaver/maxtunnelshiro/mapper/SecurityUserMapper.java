package com.bandweaver.maxtunnelshiro.mapper;

import com.bandweaver.maxtunnelshiro.entity.SecurityUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface SecurityUserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    SecurityUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);

    Set<String> getUserPermissions(String name);

    SecurityUser selectByName(String name);
}