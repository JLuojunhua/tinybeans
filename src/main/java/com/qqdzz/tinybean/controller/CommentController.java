package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.entity.Comment;
import com.qqdzz.tinybean.entity.JsonResult;
import com.qqdzz.tinybean.entity.User;
import com.qqdzz.tinybean.service.CommentService;
import com.qqdzz.tinybean.service.UserService;
import com.qqdzz.tinybean.vo.MovieCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    /**
     * 影评 每次10条
     * @param movieId
     * @param userId
     * @param time
     * @return
     */
    @GetMapping("/getComment")
    public JsonResult<MovieCommentVO> getComment(Integer movieId, Integer userId, int time) {
        List<Comment> commentList = commentService.findByMovieIdAndUserId(movieId, userId);
        List<MovieCommentVO> movieCommentVOList = new ArrayList<MovieCommentVO>();
        int timeA = 10*time;
        int timeB = 10*time+9;
        timeB = (timeB > commentList.size()-1)? commentList.size()-1 : timeB;
        for (int i = timeA; i<= timeB; i++) {
            Comment comment = commentList.get(i);
            if (comment != null) {
                User user = userService.findById(comment.getUserId());
                MovieCommentVO movieCommentVO = new MovieCommentVO(user.getUserName(), comment.getComment(), comment.getIsBanned());
                movieCommentVOList.add(movieCommentVO);
            } else {
                break;
            }
        }
        return new JsonResult<MovieCommentVO>(movieCommentVOList);
    }

    /**
     *
     * @param movieId
     * @param time
     * @return
     */
    @GetMapping("/getCommentByMovieId")
    public JsonResult<MovieCommentVO> getCommentByMovieId(Integer movieId, int time) {
        List<Comment> commentList = commentService.findByMovieId(movieId);
        List<MovieCommentVO> movieCommentVOList = new ArrayList<MovieCommentVO>();
        int timeA = 10*time;
        int timeB = 10*time+9;
        timeB = (timeB > commentList.size()-1)? commentList.size()-1 : timeB;
        for (int i = timeA; i<= timeB; i++) {
            Comment comment = commentList.get(i);
            if (comment != null) {
                User user = userService.findById(comment.getUserId());
                MovieCommentVO movieCommentVO = new MovieCommentVO(user.getUserName(), comment.getComment(), comment.getIsBanned());
                movieCommentVOList.add(movieCommentVO);
            } else {
                break;
            }
        }
        return new JsonResult<MovieCommentVO>(movieCommentVOList);
    }

    @PostMapping("/comment")
    public JsonResult submitComment(Integer userId, Integer movieId, String commentText) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setIsBanned(0);
        comment.setMovieId(movieId);
        comment.setComment(commentText);
        if (commentService.doAdd(comment)) {
            return new JsonResult("提交影评成功");
        } else {
            return new JsonResult("提交影评失败");
        }
    }

    @PutMapping("/commentbanned")
    public JsonResult banComment(Integer commentId) {
        if (commentService.setCommentBanned(commentId)) {
            return new JsonResult("举报影评成功");
        } else {
            return new JsonResult("举报影评失败");
        }
    }
}
