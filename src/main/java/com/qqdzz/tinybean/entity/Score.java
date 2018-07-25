package com.qqdzz.tinybean.entity;

public class Score {
    private Integer id;
    private Integer movieId;
    private Integer userId;
    private Double score;

    public Score() {
    }


    public Score(Integer id, Integer movieId, Integer userId, Double score) {
        this.id = id;
        this.movieId = movieId;
        this.userId = userId;
        this.score = score;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", userId=" + userId +
                ", score=" + score +
                '}';
    }
}
