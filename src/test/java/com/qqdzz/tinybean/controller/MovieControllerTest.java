package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.dao.MovieMapper;
import com.qqdzz.tinybean.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MovieControllerTest {

    @Autowired
    private MovieController movieController;

    @Autowired
    private MovieMapper movieMapper;
    @Test
    public void getMovieByCondition() {
       // System.out.println(movieController.getMovieByCondition("药神").toString());
    }

    @Test
    public void getMovieById() {
        System.out.println(movieController.getMovieById(2158490).toString());
    }

    @Test
    public void deleteMovieById() {
    }

    @Test
    public void uploadMovie() {
    }

    @Test
    public void newestMovieListInIndex() {
        System.out.println(movieController.newestMovieListInIndex().toString());
    }

    @Test
    public void recommendationMovie() {
        System.out.println(movieController.recommendationMovie("").toString());
    }

    @Test
    public void commentMovieList() {
        System.out.println(movieController.commentMovieList().toString());
    }

    @Test
    public void ratingMovieList() {
        System.out.println(movieController.ratingMovieList().toString());
    }

    @Test
    public void chooseMovie() {
    }

    @Test
    public void billboardMovie() {
    }

    @Test
    public void getMoviesByType() {
    }

    @Test
    public void movieDetails() {
        System.out.println(movieController.movieDetails(5350027).toString());
    }

    @Test
    public void getRecommendaMovies() {
        System.out.println(movieController.getRecommendaMovies(5350027).toString());
    }

    @Test
    public void modifyScore(){
//        movieMapper.modifyScore(3036465, 8.1);
//        System.out.println(movieMapper.findByClassification("爱情").toString());
//        Movie movie = new Movie();
//        movie.setId(100);
//        movie.setLanguage("chinese");
//        movieMapper.update(movie);
//        System.out.println(movieMapper.findById(3036465).toString());
        System.out.println(movieController.getMovieByCondition("我不是",0).toString());
    }
}