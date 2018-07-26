package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    int add(User user);
    int delete(Integer id);
    int update(User user);
    User findById(Integer id);
    List<User> findAll();
    int updatePhoto(Integer id, String icon);
    User findByUserName(String userName);
    User isUser(@Param("userName") String userName, @Param("userPassword") String userPassword);
    int isRoot(String userName);
}
