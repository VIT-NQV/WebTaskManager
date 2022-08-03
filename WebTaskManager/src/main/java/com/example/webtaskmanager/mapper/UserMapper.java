package com.example.webtaskmanager.mapper;

import com.example.webtaskmanager.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    Integer addUserMybatis(@Param("user") User user);

}
