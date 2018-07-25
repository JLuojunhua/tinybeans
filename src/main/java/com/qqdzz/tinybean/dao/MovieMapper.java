package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Movie;
import com.qqdzz.tinybean.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MovieMapper {
    int add(Movie collection);
    int delete(Integer id);
    int update(Movie collection);
    Movie findById(Integer id);
    List<Movie> findAll();
    Movie findByMovieName(String movieName);
    List<Movie> findByDirector(String director);
    List<Movie> findByMainactor(String mainactor);
    List<Movie> findByClassification(String classification);
    List<Movie> findByDate(String date);
    List<Movie> sortMovieByHot();
    List<Movie> sortMovieByScore();
    List<Movie> sortMovieByTime();
}
