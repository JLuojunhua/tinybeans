package com.qqdzz.tinybean.vo;

public class MovieCommentVO {

    private String userName;
    private String Comment;
    private Integer isBanned;

    public MovieCommentVO() {
    }

    public MovieCommentVO(String userName, String comment, Integer isBanned) {
        this.userName = userName;
        Comment = comment;
        this.isBanned = isBanned;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Integer isBanned() {
        return isBanned;
    }

    public void setBanned(Integer banned) {
        isBanned = banned;
    }
}
