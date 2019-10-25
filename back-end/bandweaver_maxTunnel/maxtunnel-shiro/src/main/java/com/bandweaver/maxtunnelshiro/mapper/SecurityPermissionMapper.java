package com.bandweaver.maxtunnelshiro.mapper;

import com.bandweaver.maxtunnelshiro.entity.SecurityPermission;

public interface SecurityPermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(SecurityPermission record);

    int insertSelective(SecurityPermission record);

    SecurityPermission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(SecurityPermission record);

    int updateByPrimaryKey(SecurityPermission record);
}