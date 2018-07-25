package com.qqdzz.tinybean.entity;

public class Comment {

    private Integer id;
    private String comment;
    private Integer isBanned;
    private Integer movieId;
    private Integer userId;

    public Comment() {
    }

    public Comment(Integer id, String comment, Integer isBanned, Integer movieId, Integer userId) {
        this.id = id;
        this.comment = comment;
        this.isBanned = isBanned;
        this.movieId = movieId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Integer isBanned) {
        this.isBanned = isBanned;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
