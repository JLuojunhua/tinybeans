package com.qqdzz.tinybean.vo;

public class CommentVO {

    private Integer userId;
    private String userPhoto;
    private String userName;
    private Integer commentId;
    private String commentText;

    public CommentVO() {
    }

    public CommentVO(Integer userId, String userPhoto, String userName, Integer commentId, String commentText) {
        this.userId = userId;
        this.userPhoto = userPhoto;
        this.userName = userName;
        this.commentId = commentId;
        this.commentText = commentText;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "userId=" + userId +
                ", userPhoto='" + userPhoto + '\'' +
                ", userName='" + userName + '\'' +
                ", commentId=" + commentId +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}
