package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.CollectionMapper;
import com.qqdzz.tinybean.entity.Collection1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 */
@Service
public class CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    public boolean doAdd(Collection1 collection1){
        int row = collectionMapper.add(collection1);
        return row>0;
    }

    public boolean doModify(Collection1 collection1){
       int row = collectionMapper.update(collection1);
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
    public Collection1 findById(Integer id){
        Collection1 collection1 = collectionMapper.findById(id);
        return collection1;
    }

    /**
     *
     * @param userId
     * @return
     */
    public List<Collection1> findByUserID(Integer userId){
        List<Collection1> collection1List = collectionMapper.findByUserId(userId);
        return collection1List;
    }
}
