package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.MovieMapper;
import com.qqdzz.tinybean.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;

    public boolean doAdd(Movie movie) {
        return movieMapper.add(movie) > 0;
    }

    public boolean doModify(Movie movie) {
        return movieMapper.update(movie) > 0;
    }

    public boolean modifyScore(Integer movieId, Double score) {
        return movieMapper.modifyScore(movieId, score) > 0;
    }

    public boolean doRemove(int id) {
        return movieMapper.delete(id) > 0;
    }

    /**
     *
     * @param id
     * @return
     */
    public Movie findById(int id) {
        Movie movie = movieMapper.findById(id);
        return movie;
    }

    /**
     *
     * @param movieName
     * @return
     */
    public List<Movie> findByMovieName(String movieName){
        List<Movie> movieList = movieMapper.findByMovieName(movieName);
        return movieList;
    }

    /**
     *
     * @param director
     * @return
     */
    public List<Movie> findByDirector(String director){
        List<Movie> movieList = movieMapper.findByDirector(director);
        return movieList;
    }

    /**
     *
     * @param mainactor
     * @return
     */
    public List<Movie> findByMainactor(String mainactor){
        List<Movie> movieList = movieMapper.findByMainactor(mainactor);
        return movieList;
    }

    /**
     *
     * @param classification
     * @return
     */
    public List<Movie> findByClassification(String classification){
        List<Movie> movieList = movieMapper.findByClassification(classification);
        return movieList;
    }

    /**
     *
     * @param date
     * @return
     */
    public List<Movie> findByDate(String date){
        List<Movie> movieList = movieMapper.findByDate(date);
        return movieList;
    }

    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    /**
     *
     * @return
     */
    public List<Movie> sortMovieByHot() {
        List<Movie> movieList = movieMapper.sortMovieByHot();
        return movieList;
    }

    /**
     *
     * @return
     */
    public List<Movie> sortMovieByScore() {
        List<Movie> movieList = movieMapper.sortMovieByScore();
        return movieList;
    }

    //
    public List<Movie> sortMovieByTime() {
        List<Movie> movieList = movieMapper.sortMovieByTime();
        return movieList;
    }
}
