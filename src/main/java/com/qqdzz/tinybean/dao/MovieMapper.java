package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Movie;
import com.qqdzz.tinybean.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MovieMapper {
    int add(Movie movie);
    int delete(Integer id);
    int update(Movie movie);
    Movie findById(Integer id);
    List<Movie> findAll();
    List<Movie> findByMovieName(String movieName);
    List<Movie> findByDirector(String director);
    List<Movie> findByMainactor(String mainactor);
    List<Movie> findByClassification(@Param("classification") String classification);
    List<Movie> findByDate(String date);
    List<Movie> sortMovieByHot();
    List<Movie> sortMovieByScore();
    List<Movie> sortMovieByTime();
    int modifyScore(@Param("movieId") Integer movieId,@Param("score") Double score);
}
