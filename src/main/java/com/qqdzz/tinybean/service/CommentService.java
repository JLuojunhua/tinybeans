package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.CommentMapper;
import com.qqdzz.tinybean.dao.MovieMapper;
import com.qqdzz.tinybean.entity.Comment;
import com.qqdzz.tinybean.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private MovieMapper movieMapper;

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

    /**
     *
     * @param userId
     * @return
     */
    public List<Comment> findByUserId(int userId) {
        List<Comment> commentList = commentMapper.findByUserId(userId);
        return commentList;
    }

    /**
     *
     * @param commentText
     * @return
     */
    public List<Comment> findByCommentText(String commentText) {
        List<Comment> commentList = commentMapper.findByCommentText(commentText);
        return commentList;
    }

    /**
     *
     * @return
     */
    public List<Comment> findBannedAll() {
        List<Comment> commentList = commentMapper.findBannedAll();
        return commentList;
    }

    /**
     *
     * @param movieName
     * @return
     */
    public List<Comment> findByMovieName(String movieName) {
        Movie movie = movieMapper.findByMovieName(movieName);
        List<Comment> commentList = commentMapper.findByMovieId(movie.getId());
        return commentList;
    }

    /**
     *
     * @param movieId
     * @param userId
     * @return
     */
    public List<Comment> findByMovieIdAndUserId(Integer movieId, Integer userId) {
        List<Comment> commentList = commentMapper.findByMovieIdAndUserId(movieId, userId);
        return commentList;
    }

    public boolean setCommentBanned(Integer commentId) {
        Comment comment = this.findById(commentId);
        comment.setIsBanned(1);
        return this.doModify(comment);
    }
}
