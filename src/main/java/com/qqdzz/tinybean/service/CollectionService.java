package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.CollectionMapper;
import com.qqdzz.tinybean.entity.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@Service
public class CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    public boolean doAdd(Collection collection){
        int row = collectionMapper.add(collection);
        return row>0;
    }

    public boolean doModify(Collection collection){
       int row = collectionMapper.update(collection);
       return row>0;
    }

    public boolean doRemove(int id){
        int row = collectionMapper.delete(id);
        return row>0;
    }

    /**
     *
     * @param id
     * @return
     */
    public Collection findById(Integer id){
        Collection collection = collectionMapper.findById(id);
        return collection;
    }

    /**
     *
     * @param userId
     * @return
     */
    public List<Collection> findByUserID(Integer userId){
        List<Collection> collectionList = collectionMapper.findByUserId(userId);
        return collectionList;
    }
}
