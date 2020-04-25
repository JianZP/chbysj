package com.ch.service.impl;

import com.ch.dao.UserMapper;
import com.ch.entity.User;
import com.ch.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> selAll(String username,Integer pageNo, Integer pagesize) {
        return userMapper.selAll(username,pageNo, pagesize);
    }

    @Override
    public List<User> selc(String username) {
        return userMapper.selc(username);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }
}
