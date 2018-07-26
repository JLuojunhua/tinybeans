package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ScoreMapper {
    int add(Score score);//返回插入行数
    int delete(Integer id);
    int update(Score score);//返回修改行数
    Score findById(Integer id);
    Score getScore(@Param("userId") Integer userId,@Param("movieId") Integer movieId);
}
