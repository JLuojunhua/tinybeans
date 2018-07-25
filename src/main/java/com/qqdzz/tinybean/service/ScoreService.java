package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.ScoreMapper;
import com.qqdzz.tinybean.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    public boolean doAdd(Score score) {
        int row = scoreMapper.add(score);
        return row>0;
    }

    public boolean doModify(Score score) {
        int row = scoreMapper.update(score);
        return row>0;
    }

    public boolean doRemove(Integer scoreId) {
        int row = scoreMapper.delete(scoreId);
        return row>0;
    }

    public Score getScore(Integer userId, Integer movieId) {
        Score score = new Score();
        return score;
    }
}
