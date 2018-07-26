package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Score;
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

    @Test
    public void add()
    {
        Score score = new Score();
        score.setMovieId(26752088);
        score.setUserId(9);
        score.setScore(3.0);
        scoreMapper.add(score);
    }

}