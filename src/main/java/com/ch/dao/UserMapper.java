package com.ch.dao;

import com.ch.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selAll(@Param("username") String username,@Param("pageNo")Integer pageNo, @Param("pagesize") Integer pagesize);

    List<User> selc(@Param("username")String username);

    List<User> login(@Param("username")String username,@Param("password")String password);

    int updateByUsername(@Param("signintime")String signintime,@Param("username")String username);

    int updateByUsernameOut(@Param("signout")String signout,@Param("username")String username);
}