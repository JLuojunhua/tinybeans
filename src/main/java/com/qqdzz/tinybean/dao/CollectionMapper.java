package com.qqdzz.tinybean.dao;

import com.qqdzz.tinybean.entity.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface CollectionMapper {

    int add(Collection collection);
    int delete(Integer id);
    int update(Collection collection);
    Collection findById(Integer id);

    List<Collection> findByUserId(Integer userId);

}
