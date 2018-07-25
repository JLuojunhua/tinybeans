package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Collection1;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface CollectionMapper {

    int add(Collection1 collection1);
    int delete(Integer id);
    int update(Collection1 collection1);
    Collection1 findById(Integer id);

    List<Collection1> findByUserId(Integer userId);

}
