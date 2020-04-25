package com.ch.service;

import com.ch.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> selAll(String username,Integer pageNo, Integer pagesize);

    List<User> selc(String username);

    int updateByPrimaryKeySelective(User record);
}
