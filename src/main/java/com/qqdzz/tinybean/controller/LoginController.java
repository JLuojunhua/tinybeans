package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.entity.JsonResult;
import com.qqdzz.tinybean.entity.User;
import com.qqdzz.tinybean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public JsonResult<Integer> login(@RequestParam(required = true)String userName, @RequestParam(required = true)String password, HttpServletRequest request) {
        return userService.login(userName, password);
    }

    @RequestMapping("/register")
    public JsonResult register(@RequestParam(required = true)String userName, @RequestParam(required = true)String password) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(password);
        boolean register = userService.doAdd(user);
        if (register == true) {
            return new JsonResult("注册成功");
        } else {
            return new JsonResult("注册失败");
        }
    }
}
