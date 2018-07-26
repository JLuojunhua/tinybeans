package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.UserMapper;
import com.qqdzz.tinybean.entity.JsonResult;
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

    /**
     *
     * @param userId
     * @param icon
     * @return
     */
    public boolean doModifyIcon(Integer userId, String icon){
        return userMapper.updatePhoto(userId, icon)>0;
    }

    public boolean doRemove(int id){
        return userMapper.delete(id) > 0;
    }

    public User findById(int id){
        return userMapper.findById(id);
    }

    /**
     *
     * @param userName
     * @return
     */
    public User findByUserName(String userName){
        User user = userMapper.findByUserName(userName);
        return user;
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public JsonResult<Integer> login(String userName, String password) {
        User User = userMapper.isUser(userName, password);
        if (User != null) {
            int root = userMapper.isRoot(userName);
            if (root == 0) {
                return new JsonResult<Integer>(1);
            } else {
                return new JsonResult<Integer>(2);
            }
        } else {
            return new JsonResult<Integer>(0);
        }
    }
}
