package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest

public class LoginControllerTest {

    @Autowired
    private LoginController loginController;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void login() {
        String userName = "wangchen";
        String password = "wcdzwj";
        //System.out.println(userMapper.findById(1).toString());
        //System.out.println(userMapper.isUser(userName, password).toString());
        //System.out.println(userMapper.isRoot(userName));
        System.out.println(loginController.login(userName, password).toString());
    }

    @Test
    public void register() {
    }
}