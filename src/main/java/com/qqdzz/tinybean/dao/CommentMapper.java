package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommentMapper {
    int add(Comment comment);
    int delete(Integer id);
    int update(Comment comment);
    Comment findById(Integer id);
    List<Comment> findByUserId(Integer userId);
    List<Comment> findByCommentText(String commentText);
    List<Comment> findBannedAll();
    List<Comment> findByMovieId(Integer movieId);
    List<Comment> findByMovieIdAndUserId(Integer movieId, Integer userId);
}
