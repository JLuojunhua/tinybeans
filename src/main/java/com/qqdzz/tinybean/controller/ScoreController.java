package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.entity.JsonResult;
import com.qqdzz.tinybean.entity.Movie;
import com.qqdzz.tinybean.entity.Score;
import com.qqdzz.tinybean.service.MovieService;
import com.qqdzz.tinybean.service.ScoreService;
import com.sun.xml.internal.ws.assembler.MetroConfigName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private MovieService movieService;

    @PostMapping("/score")
    public JsonResult submitScore(Double score, Integer userId, Integer movieId) {
        Score s = new Score();
        s.setScore(score);
        s.setUserId(userId);
        s.setMovieId(movieId);
        if (scoreService.doAdd(s)) {
            Movie movie = movieService.findById(movieId);
            Integer scorePopulation = movie.getScoredPopulation();
            Double scoreMovie = (movie.getScore() * scorePopulation + score)/(scorePopulation+1);
            movieService.modifyScore(movieId, score);
            return new JsonResult("提交评分成功");
        } else {
            return new JsonResult("提交评分失败");
        }
    }

    @GetMapping("/score")
    public JsonResult<Double> getScore(Integer userId, Integer movieId) {
        Score score = scoreService.getScore(userId, movieId);
        return new JsonResult<Double>(score.getScore());
    }
}
