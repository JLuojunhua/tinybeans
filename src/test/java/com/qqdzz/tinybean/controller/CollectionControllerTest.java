package com.qqdzz.tinybean.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionControllerTest {

    @Autowired
    private CollectionController collectionController;

    @Test
    public void addCollection() {
        collectionController.addCollection(1,100);
    }

    @Test
    public void getUserCollection() {
        System.out.println(collectionController.getUserCollection(1).toString());
    }

    @Test
    public void getUserAllCollection() {
        System.out.println(collectionController.getUserAllCollection(1).toString());
    }
}