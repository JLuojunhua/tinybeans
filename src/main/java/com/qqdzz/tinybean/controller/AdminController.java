package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.entity.Comment;
import com.qqdzz.tinybean.entity.JsonResult;
import com.qqdzz.tinybean.entity.Movie;
import com.qqdzz.tinybean.entity.User;
import com.qqdzz.tinybean.service.CommentService;
import com.qqdzz.tinybean.service.MovieService;
import com.qqdzz.tinybean.service.UserService;
import com.qqdzz.tinybean.vo.CommentVO;
import com.qqdzz.tinybean.vo.SearchUserVO;
import com.qqdzz.tinybean.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private MovieService movieService;

    /**
     * 根据用户id或用户名查找用户
     * @param userIdOrName
     * @return
     */
    @GetMapping("/searchuser")
    public JsonResult<SearchUserVO> searchUser(String userIdOrName){
        List<SearchUserVO> searchUserVOList = new ArrayList<SearchUserVO>();
        Integer userId = Integer.valueOf(userIdOrName);
        User user = userService.findById(userId);
        if (user != null) {
            searchUserVOList.add(new SearchUserVO(userId, user.getIcon(), user.getUserName()));
        }
        String userName = userIdOrName;
        user = userService.findByUserName(userName);
        if (user != null) {
            searchUserVOList.add(new SearchUserVO(userId, user.getIcon(), user.getUserName()));
        }
        return new JsonResult<SearchUserVO>(searchUserVOList);
    }

    /**
     * 根据用户id删除用户+返回再次搜索结果
     * @param userId
     * @return
     */
    @DeleteMapping("/user")
    public JsonResult<SearchUserVO> deleteUser(Integer userId){
        userService.doRemove(userId);
        return this.searchUser(userId.toString());
    }

    /**
     * 根据userId/commentId/commentText进行搜索
     * 若搜索内容为空 返回十条
     * @param condition
     * @return
     */
    @GetMapping("/comment")
    public JsonResult<CommentVO> getCommentByCondition(String condition){
        List<CommentVO> commentVOList = new ArrayList<CommentVO>();
        if (condition != "") {
            List<Comment> commentList = new ArrayList<Comment>();
            Integer userId = Integer.valueOf(condition);
            commentList = commentService.findByUserId(userId);
            for (Comment comment : commentList) {
                if (comment != null) {
                    User user = userService.findById(comment.getUserId());
                    commentVOList.add(new CommentVO(user.getId(), user.getIcon(), user.getUserName(), comment.getId(), comment.getComment()));
                }
            }

            Integer commentId = Integer.valueOf(condition);
            Comment c = commentService.findById(commentId);
            if (c != null) {
                User user = userService.findById(c.getUserId());
                commentVOList.add(new CommentVO(user.getId(), user.getIcon(), user.getUserName(), c.getId(), c.getComment()));
            }

            String commentText = condition;
            commentList = commentService.findByCommentText(commentText);
            for (Comment comment : commentList) {
                if (comment != null) {
                    User user = userService.findById(comment.getUserId());
                    commentVOList.add(new CommentVO(user.getId(), user.getIcon(), user.getUserName(), comment.getId(), comment.getComment()));
                }
            }
        } else {
            List<Comment> commentList = commentService.findBannedAll();
            int time = 10;
            for (int index = 0; index < time; index++) {
                Comment comment = commentList.get(index);
                User user = userService.findById(comment.getUserId());
                commentVOList.add(new CommentVO(user.getId(), user.getIcon(), user.getUserName(), comment.getId(), comment.getComment()));
            }
        }
        return new JsonResult<CommentVO>(commentVOList);
    }

    @DeleteMapping("/comment")
    public JsonResult<CommentVO> deleteCommentByCommentId(Integer commentId){
        commentService.doRemove(commentId);
        return this.getCommentByCondition(commentId.toString());
    }

    @GetMapping("/getbanned")
    public JsonResult<CommentVO> getAllBannedComment() {
        List<Comment> commentList = commentService.findBannedAll();
        List<CommentVO> commentVOList = new ArrayList<CommentVO>();
        for (Comment comment : commentList) {
            if (comment != null) {
                User user = userService.findById(comment.getUserId());
                commentVOList.add(new CommentVO(user.getId(), user.getIcon(), user.getUserName(),comment.getUserId(), comment.getComment())) ;
            }
        }
        return new JsonResult<CommentVO>(commentVOList);
    }

    @PostMapping("/addMovie")
    public JsonResult addMovie(String movieName, String director, String scriptwriter, String mainactor, String produceCountry, String language, String date, String movieDuration, String classification) {
        Movie movie = new Movie();
        movie.setMovieName(movieName);
        movie.setDirector(director);
        movie.setScriptwriter(scriptwriter);
        movie.setMainactor(mainactor);
        movie.setProduceCountry(produceCountry);
        movie.setLanguage(language);
        movie.setDate(date);
        movie.setMovieDuration(movieDuration);
        movie.setClassification(classification);
        movie.setOneStar(0);
        movie.setTwoStar(0);
        movie.setThreeStar(0);
        movie.setFourStar(0);
        movie.setFiveStar(0);
        movie.setCommentNum(0);
        movie.setScore(0.0);
        if (movieService.doAdd(movie)) {
            return new JsonResult("上传成功");
        } else {
            return new JsonResult("上传失败");
        }
    }

    @GetMapping("/getAllUsers")
    public JsonResult<User> getAllUsers() {
        List<User> userList = userService.findAll();
        return new JsonResult<User>(userList);
    }

}
