package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.entity.JsonResult;
import com.qqdzz.tinybean.entity.User;
import com.qqdzz.tinybean.service.UserService;
import com.qqdzz.tinybean.vo.UserInfoVO;
import com.qqdzz.tinybean.vo.UserPhotoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 */
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public JsonResult<UserInfoVO> getUserInfo(Integer userId){
        User user = userService.findById(userId);
        UserInfoVO userInfoVO = new UserInfoVO(user.getUserName(), user.getUserSex(), user.getUserPhoneNum(), user.getUserLikeCategories());
        return new JsonResult<UserInfoVO>(userInfoVO);
    }

    @GetMapping("/getuserphoto")
    public JsonResult<UserPhotoVO> getUserPhoto(Integer userId){
        User user = userService.findById(userId);
        UserPhotoVO userPhotoVO = new UserPhotoVO(user.getIcon());
        return new JsonResult<UserPhotoVO>(userPhotoVO);
    }

    @PostMapping("/user")
    public JsonResult addUser(@RequestBody User user){
        userService.doAdd(user);
        return new JsonResult("添加成功");
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/user")
    public JsonResult updateUserInfo(@RequestBody User user){
        userService.doModify(user);
        return new JsonResult("修改成功");
    }

    /**
     * 修改用户头像
     * @param icon
     * @return
     */
    @PutMapping("/userphoto")
    public JsonResult changePhoto(Integer userId, String icon){
        userService.doModifyIcon(userId, icon);
        return new JsonResult("修改成功");
    }

    /**
     *
     * @param userId
     * @return
     */
    @GetMapping("/getuserstate")
    public boolean getUserState(Integer userId){
        User user = userService.findById(userId);
        //isManage
        if (user.getIsRoot() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
