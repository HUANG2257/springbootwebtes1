package com.youmo.huang.dao;

import com.youmo.huang.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 2257
 * @date 2020/4/25 - 14:54
 */
@Mapper
public interface UserMapper {

    //根据用户名查询数据库
    public User getUser(String username);

}
