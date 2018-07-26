package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {

    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void findByCommentText() {
        List<Comment> commentList = commentMapper.findByCommentText("d");
        for (Comment comment:commentList
             ) {
            System.out.println(comment.toString());
        }
    }

    @Test
    public void findBannedAll() {
        System.out.println(commentMapper.findBannedAll().toString());
    }

    @Test
    public void findByMovieId() {
        System.out.println(commentMapper.findByMovieId(1).toString());
    }

    @Test
    public void findByMovieIdAndUserId() {
        System.out.println(commentMapper.findByMovieIdAndUserId(100, 1).toString());
    }
}