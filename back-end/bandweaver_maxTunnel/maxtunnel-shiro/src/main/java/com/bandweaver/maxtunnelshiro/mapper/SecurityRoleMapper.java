package com.bandweaver.maxtunnelshiro.mapper;

import com.bandweaver.maxtunnelshiro.entity.SecurityRole;

public interface SecurityRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SecurityRole record);

    int insertSelective(SecurityRole record);

    SecurityRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SecurityRole record);

    int updateByPrimaryKey(SecurityRole record);
}