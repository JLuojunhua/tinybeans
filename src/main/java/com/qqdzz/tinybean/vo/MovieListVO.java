package com.qqdzz.tinybean.vo;

public class MovieListVO {
    private String name;
    private Integer id;

    public MovieListVO() {
    }

    public MovieListVO(String name, Integer id) {
        this.name = name;
        this.id = id;
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
}
