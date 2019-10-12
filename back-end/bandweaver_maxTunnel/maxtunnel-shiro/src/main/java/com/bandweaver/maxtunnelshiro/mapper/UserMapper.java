package com.bandweaver.maxtunnelshiro.mapper;



import com.bandweaver.maxtunnelshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface UserMapper {

    User getByName(String name);

    Set<String> getUserPermissions(String name);

}
