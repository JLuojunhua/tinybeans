package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.UserMapper;
import com.qqdzz.tinybean.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean doAdd(User user){
        return userMapper.add(user) > 0;
    }

    public boolean doModify(User user){
        return userMapper.update(user) > 0;
    }

    //
    public boolean doModifyIcon(Integer userId, String icon){
        return true;
    }

    public boolean doRemove(int id){
        return userMapper.delete(id) > 0;
    }

    public User findById(int id){
        return userMapper.findById(id);
    }

    //
    public User findByUserName(String userName){
        User user = new User();
        return user;
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public Integer login(String userName, String password) {
        return 0;
    }
}
