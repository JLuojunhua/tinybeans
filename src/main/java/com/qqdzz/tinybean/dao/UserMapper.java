package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    int add(User collection);
    int delete(Integer id);
    int update(User collection);
    User findById(Integer id);
    List<User> findAll();
    int updatePhoto(Integer id, String icon);
    User findByUserName(String userName);
    int isUser(String userName, String password);
    int isRoot(String userName);
}
