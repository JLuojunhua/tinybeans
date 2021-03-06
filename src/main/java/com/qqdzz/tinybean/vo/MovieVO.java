package com.qqdzz.tinybean.vo;

public class MovieVO {

    private String name;
    private Integer id;
    private Double score;
    private String poster;

    public MovieVO() {
    }

    public MovieVO(String name, Integer id, Double score, String poster) {
        this.name = name;
        this.id = id;
        this.score = score;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "MovieVO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", score=" + score +
                ", poster='" + poster + '\'' +
                '}';
    }
}
