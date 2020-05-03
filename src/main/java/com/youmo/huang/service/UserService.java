package com.youmo.huang.service;

import com.youmo.huang.bean.User;
import com.youmo.huang.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 2257
 * @date 2020/4/25 - 14:57
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(String username){
        User user = userMapper.getUser(username);
        return user;
    }

}
