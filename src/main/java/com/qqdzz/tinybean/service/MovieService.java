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

    //
    public Movie findByMovieName(String movieName){
        Movie movie = new Movie();
        return movie;
    }

    //
    public List<Movie> findByDirector(String director){
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }

    //
    public List<Movie> findByMainactor(String mainactor){
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }

    //
    public List<Movie> findByClassification(String classification){
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }

    //
    public List<Movie> findByDate(String date){
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }

    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    //
    public List<Movie> findByCondition(String movieName) {
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }

    //
    public List<Movie> sortMovieByHot() {
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }

    //
    public List<Movie> sortMovieByScore() {
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }

    //
    public List<Movie> sortMovieByTime() {
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }
}
