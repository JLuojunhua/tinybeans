package com.qqdzz.tinybean.entity;

public class Movie {

    //电影编号
    private Integer id;
    //电影名称
    private String movieName;
    //评论数
    private Integer commentNum;
    //导演
    private String director;
    //编剧
    private String scriptwriter;
    //主演
    private String mainactor;
    //类型
    private String classification;
    //制片国家地区
    private String produceCountry;
    //语言
    private String language;
    //上映日期
    private String date;
    //上映年份
    private Integer year;
    //片长
    private String movieDuration;
    //评分
    private Double score;
    //评论人数
    private Integer scoredPopulation;
    //图片地址
    private String icon;

    private Integer oneStar;

    private Integer twoStar;

    private Integer threeStar;

    private Integer fourStar;

    private Integer fiveStar;


    public Movie(Integer id, String movieName, Integer commentNum, String director, String scriptwriter, String mainactor, String classification, String produceCountry, String language, String date, Integer year, String movieDuration, Double score, Integer scorePopulation, String icon, Integer oneStar, Integer twoStar, Integer threeStar, Integer fourStar, Integer fiveStar) {
        this.id = id;
        this.movieName = movieName;
        this.commentNum = commentNum;
        this.director = director;
        this.scriptwriter = scriptwriter;
        this.mainactor = mainactor;
        this.classification = classification;
        this.produceCountry = produceCountry;
        this.language = language;
        this.date = date;
        this.year = year;
        this.movieDuration = movieDuration;
        this.score = score;
        this.scoredPopulation = scoredPopulation;
        this.icon = icon;
        this.oneStar = oneStar;
        this.twoStar = twoStar;
        this.threeStar = threeStar;
        this.fourStar = fourStar;
        this.fiveStar = fiveStar;
    }

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    public String getMainactor() {
        return mainactor;
    }

    public void setMainactor(String mainactor) {
        this.mainactor = mainactor;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getProduceCountry() {
        return produceCountry;
    }

    public void setProduceCountry(String produceCountry) {
        this.produceCountry = produceCountry;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getScoredPopulation() {
        return scoredPopulation;
    }

    public void setScoredPopulation(Integer scoredPopulation) {
        this.scoredPopulation = scoredPopulation;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOneStar() {
        return oneStar;
    }

    public void setOneStar(Integer oneStar) {
        this.oneStar = oneStar;
    }

    public Integer getTwoStar() {
        return twoStar;
    }

    public void setTwoStar(Integer twoStar) {
        this.twoStar = twoStar;
    }

    public Integer getThreeStar() {
        return threeStar;
    }

    public void setThreeStar(Integer threeStar) {
        this.threeStar = threeStar;
    }

    public Integer getFourStar() {
        return fourStar;
    }

    public void setFourStar(Integer fourStar) {
        this.fourStar = fourStar;
    }

    public Integer getFiveStar() {
        return fiveStar;
    }

    public void setFiveStar(Integer fiveStar) {
        this.fiveStar = fiveStar;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", commentNum=" + commentNum +
                ", director='" + director + '\'' +
                ", scriptwriter='" + scriptwriter + '\'' +
                ", mainactor='" + mainactor + '\'' +
                ", classification='" + classification + '\'' +
                ", produceCountry='" + produceCountry + '\'' +
                ", language='" + language + '\'' +
                ", date='" + date + '\'' +
                ", year=" + year +
                ", movieDuration='" + movieDuration + '\'' +
                ", score=" + score +
                ", scoredPopulation=" + scoredPopulation +
                ", icon='" + icon + '\'' +
                ", oneStar=" + oneStar +
                ", twoStar=" + twoStar +
                ", threeStar=" + threeStar +
                ", fourStar=" + fourStar +
                ", fiveStar=" + fiveStar +
                '}';
    }
}
