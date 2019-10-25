package com.bandweaver.maxtunnelshiro.mapper;

import com.bandweaver.maxtunnelshiro.entity.SecurityRolePermission;

public interface SecurityRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecurityRolePermission record);

    int insertSelective(SecurityRolePermission record);

    SecurityRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecurityRolePermission record);

    int updateByPrimaryKey(SecurityRolePermission record);
}