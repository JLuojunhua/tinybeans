package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.entity.Collection1;
import com.qqdzz.tinybean.entity.JsonResult;
import com.qqdzz.tinybean.entity.Movie;
import com.qqdzz.tinybean.service.CollectionService;
import com.qqdzz.tinybean.service.MovieService;
import com.qqdzz.tinybean.vo.MovieCollectionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@RestController
public class CollectionController {

    @Autowired
    private CollectionService collectionService;
    @Autowired
    private MovieService movieService;

    /**
     * 获取当前用户的八部收藏电影
     * @param userId
     * @return
     */
    @GetMapping("/getusercollection")
    public JsonResult<MovieCollectionVO> getUserCollection(Integer userId){
        List<Collection1> collection1List = collectionService.findByUserID(userId);
        List<MovieCollectionVO> movieCollectionVOList = new ArrayList<MovieCollectionVO>();
        int movieNum = 0;
        for (Collection1 collection1 : collection1List) {
            Movie movie = movieService.findById(collection1.getMovieId());
            if (movie == null) {
                break;
            }
            MovieCollectionVO movieCollectionVO = new MovieCollectionVO(movie.getMovieName(), movie.getId(), movie.getScore(), movie.getIcon());
            movieCollectionVOList.add(movieCollectionVO);
            movieNum++;
            if (movieNum == 8){
                break;
            }
        }
        return new JsonResult<MovieCollectionVO>(movieCollectionVOList);
    }

    /**
     * 获取用户的所有电影收藏
     *
     * @param userId
     * @return
     */
    @GetMapping("/getuserallcollection")
    public JsonResult<MovieCollectionVO> getUserAllCollection(Integer userId){
        List<Collection1> collection1List = collectionService.findByUserID(userId);
        List<MovieCollectionVO> movieCollectionVOList = new ArrayList<MovieCollectionVO>();
        for (Collection1 collection1 : collection1List) {
            Movie movie = movieService.findById(collection1.getMovieId());
            if (movie == null) {
                break;
            }
            MovieCollectionVO movieCollectionVO = new MovieCollectionVO(movie.getMovieName(), movie.getId(), movie.getScore(), movie.getIcon());
            movieCollectionVOList.add(movieCollectionVO);
        }
        return new JsonResult<MovieCollectionVO>(movieCollectionVOList);
    }
}
