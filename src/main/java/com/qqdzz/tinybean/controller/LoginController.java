package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.entity.JsonResult;
import com.qqdzz.tinybean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public JsonResult login(@RequestParam(required = true)String userName, @RequestParam(required = true)String password, HttpServletRequest request) {
        Integer root = userService.login(userName, password);
        return new JsonResult(root);
    }

    //@RequestMapping("/")
    //public JsonResult register()
}
