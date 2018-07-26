package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.controller.MovieController;
import com.qqdzz.tinybean.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieController movieController;

    @Test
    public void add() {
//        Movie movie = new Movie();
//        movie.setId(1008611);
//        movie.setMovieName("王璐薇sb");
//        movie.setClassification(">??");
//        movie.setCommentNum(1222);
//        movie.setDate("1997.2.28");
//        movie.setDirector("wangchen");
//        movie.setFiveStar(22);
//        movie.setFourStar(3);
//        movie.setScore(3.14);
//        movie.setIcon("http://121.192.180.66");
//        movie.setLanguage("English");
//        movie.setMainactor("dfsf");
//        movie.setMovieDuration("1903");
//        movie.setYear(1234);
//        movie.setTwoStar(33);
//        movie.setThreeStar(22);
//        movie.setScriptwriter("33333");
//        movie.setOneStar(2);
//        movieMapper.add(movie);

//        movie = movieMapper.findById(1008611);
//
//        System.out.println(movie.toString());

//        movieMapper.delete(1008611);
//
//        System.out.println(movieMapper.findById(1008611).toString());

    }

    @Test
    public void delete() {

    }

    @Test
    public void update() {

    }

    @Test
    @Autowired
    public void findById() {
        System.out.println(movieMapper.findById(2158490).toString());

    }

    @Test
    public void findAll() {
//        List<Movie> movieList= movieMapper.findAll();
//        Movie movie = movieList.get(0);
//        System.out.println(movie.toString());
        System.out.println(movieController.getMovieById(1578714).toString());
    }

    @Test
    public void findByMovieName() {
        System.out.println(movieMapper.findByMovieName("药神"));
    }

    @Test
    public void findByDirector() {
    }

    @Test
    public void findByMainactor() {
    }

    @Test
    public void findByClassification() {
        List<Movie> movielist = movieMapper.findByClassification("爱情");
        for (Movie movie : movielist) {
            System.out.println(movie.getMovieName()+movie.getClassification());
        }
    }
    @Test
    public void findByDate() {
        System.out.println(movieMapper.findByDate("2017-06-02"));
    }

    @Test
    public void sortMovieByHot() {
        List<Movie> movielist = movieMapper.sortMovieByHot();
        for(Movie movie : movielist){
            System.out.println(movie.toString());
        }
    }

    @Test
    public void sortMovieByScore() {
        List<Movie> movielist= movieMapper.sortMovieByScore();
        for (Movie movie: movielist) {
            System.out.println(movie.getMovieName()+movie.getScore());
        }

    }

    @Test
    public void sortMovieByTime() {
        List<Movie> movielist = movieMapper.sortMovieByTime();
        for(Movie movie : movielist){
            System.out.println(movie.getMovieName()+movie.getDate());
        }
    }
}