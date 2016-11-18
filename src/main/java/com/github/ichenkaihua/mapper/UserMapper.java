package com.github.ichenkaihua.mapper;

import com.github.ichenkaihua.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    @ResultMap(value = "BaseResultMap")
    @Select("select * from user where user_name = #{userName} and password = #{password}")
    List<User> selectByNameAndPassword(@Param("userName")String userName, @Param("password")String password);
}