package com.qqdzz.tinybean.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {

    @Autowired
    private AdminController adminController;

    @Test
    public void searchUser() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void getCommentByCondition() {
    }

    @Test
    public void deleteCommentByCommentId() {
    }

    @Test
    public void getAllBannedComment() {
        System.out.println(adminController.getAllBannedComment().toString());
    }
}