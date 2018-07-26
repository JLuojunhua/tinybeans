package com.qqdzz.tinybean.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreMapperTest {
    @Autowired
    private ScoreMapper scoreMapper;
    @Test
    public void getScore()
    {
        System.out.println(scoreMapper.getScore(1,2158490));
    }



}