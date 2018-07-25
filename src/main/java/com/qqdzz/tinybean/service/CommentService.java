package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.CommentMapper;
import com.qqdzz.tinybean.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public boolean doAdd(Comment comment) {
        int row = commentMapper.add(comment);
        return row>0;
    }

    public boolean doModify(Comment comment) {
        int row = commentMapper.update(comment);
        return row>0;
    }

    public boolean doRemove(int id) {
        int row = commentMapper.delete(id);
        return row>0;
    }

    public Comment findById(Integer id) {
        Comment comment = commentMapper.findById(id);
        return comment;
    }

    //
    public List<Comment> findByUserId(int UserId) {
        List<Comment> commentList = new ArrayList<Comment>();
        return commentList;
    }

    //
    public List<Comment> findByCommentText(String commentText) {
        List<Comment> commentList = new ArrayList<Comment>();
        return commentList;
    }

    //
    public List<Comment> findBannedAll() {
        List<Comment> commentList = new ArrayList<Comment>();
        return commentList;
    }

    //
    public List<Comment> findByMovieName(String movieName) {
        List<Comment> commentList = new ArrayList<Comment>();
        return commentList;
    }

    //
    public List<Comment> findByMovieIdAndUserId(Integer movieId, Integer userId) {
        List<Comment> commentList = new ArrayList<Comment>();
        return commentList;
    }

    public boolean setCommentBanned(Integer commentId) {
        Comment comment = this.findById(commentId);
        comment.setIsBanned(1);
        return this.doModify(comment);
    }
}
