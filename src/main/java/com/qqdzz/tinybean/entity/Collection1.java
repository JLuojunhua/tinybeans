package com.qqdzz.tinybean.entity;

public class Collection1 {

    private Integer id;
    private Integer userId;
    private Integer movieId;

    public Collection1() {
        super();
    }

    public Collection1(Integer id, Integer userId, Integer movieId) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}
