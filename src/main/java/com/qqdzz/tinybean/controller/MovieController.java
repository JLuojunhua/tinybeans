package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.entity.JsonResult;
import com.qqdzz.tinybean.entity.Movie;
import com.qqdzz.tinybean.service.MovieService;
import com.qqdzz.tinybean.vo.MovieListVO;
import com.qqdzz.tinybean.vo.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 根据movieName/director/mainactor/classification/date进行搜索
     * @param condition
     * @return
     */
    @GetMapping("/movie")
    public JsonResult<Movie> getMovieByCondition(String condition){
        List<Movie> movieList = new ArrayList<Movie>();
        String movieName = condition;
        Movie movie = movieService.findByMovieName(movieName);
        if (movie != null) {
            movieList.add(movie);
        }

        String director = condition;
        List<Movie> movieByDirector = movieService.findByDirector(director);
        if (movieByDirector != null) {
            for (Movie m : movieByDirector) {
                movieList.add(m);
            }
        }

        String mainactor = condition;
        List<Movie> movieByMainactor = movieService.findByMainactor(mainactor);
        if (movieByMainactor != null) {
            for (Movie m : movieByMainactor) {
                movieList.add(m);
            }
        }
        String classification = condition;
        List<Movie> movieByClassification = movieService.findByClassification(classification);
        if (movieByClassification != null) {
            for (Movie m : movieByClassification) {
                movieList.add(m);
            }
        }
        String date = condition;
        List<Movie> movieByDate = movieService.findByDate(date);
        if (movieByDate != null) {
            for (Movie m : movieByDate) {
                movieList.add(m);
            }
        }
        return new JsonResult<Movie>(movieList);
    }

    /**
     * 根据id搜索movie
     * @param movieId
     * @return
     */
    @GetMapping("/movieById")
    public JsonResult<Movie> getMovieById(Integer movieId){
        Movie movie = movieService.findById(movieId);
        return new JsonResult<Movie>(movie);
    }

    /**
     * 管理员根据id删除movie
     * @param movieId
     * @return
     */
    @DeleteMapping("/movie")
    public JsonResult<Movie> deleteMovieById(Integer movieId){
        movieService.doRemove(movieId);
        return this.getMovieById(movieId);
    }

    /**
     * 管理员上传movie
     * @param movie
     * @return
     */
    @PutMapping("/movie")
    public JsonResult uploadMovie(@RequestBody Movie movie){
        movieService.doAdd(movie);
        return new JsonResult("添加成功");
    }

    /**
     * 正在热映的15部movie
     * @return
     */
    @GetMapping("/newmovie")
    public JsonResult<MovieVO> newestMovieListInIndex() {
        List<Movie> movieList = movieService.sortMovieByTime();
        List<MovieVO> movieVOList = new ArrayList<MovieVO>();
        int num = 15;
        for (int i = 0; i < num; i++) {
            Movie movie = movieList.get(i);
            if (movie != null) {
                movieVOList.add(new MovieVO(movie.getMovieName(), movie.getId(), movie.getScore(), movie.getIcon()));
            } else {
                break;
            }
        }
        return new JsonResult<MovieVO>(movieVOList);
    }

    /**
     * 根据电影类型进行推荐15部movie
     * @param classification
     * @return
     */
    @GetMapping("/recommendation")
    public JsonResult<MovieVO> recommendationMovie(String classification) {
        List<Movie> movieList = movieService.findByClassification(classification);
        List<MovieVO> movieVOList = new ArrayList<MovieVO>();
        int num = 15;
        for (int i = 0; i < num; i++) {
            Movie movie = movieList.get(i);
            if (movieList.get(i) != null) {
                MovieVO movieVO = new MovieVO(movie.getMovieName(), movie.getId(), movie.getScore(), movie.getIcon());
                movieVOList.add(movieVO);
            } else {
                break;
            }
        }
        return new JsonResult<MovieVO>(movieVOList);
    }

    /**
     * movie热度榜 scorePopulation
     * @return
     */
    @GetMapping("/commentList")
    public JsonResult<MovieVO> commentMovieList() {
        List<Movie> movieList = movieService.sortMovieByHot();
        List<MovieVO> movieVOList = new ArrayList<MovieVO>();
        int num = 15;
        for (int i = 0; i < num; i++) {
            Movie movie = movieList.get(i);
            if (movie != null) {
                movieVOList.add(new MovieVO(movie.getMovieName(), movie.getId(), movie.getScore(), movie.getIcon()));
            } else {
                break;
            }
        }
        return new JsonResult<MovieVO>(movieVOList);
    }

    /**
     * movie评分榜 score
     * @return
     */
    @GetMapping("/ratingList")
    public JsonResult<MovieVO> ratingMovieList() {
        List<Movie> movieList = movieService.sortMovieByScore();
        List<MovieVO> movieVOList = new ArrayList<MovieVO>();
        int num = 15;
        for (int i = 0; i < num; i++) {
            Movie movie = movieList.get(i);
            if (movie != null) {
                movieVOList.add(new MovieVO(movie.getMovieName(), movie.getId(), movie.getScore(), movie.getIcon()));
            } else {
                break;
            }
        }
        return new JsonResult<MovieVO>(movieVOList);
    }

    /**
     * 选择电影
     * @param time
     * @return
     */
    @GetMapping("choosemovie")
    public JsonResult<MovieVO> chooseMovie(int time) {
        List<MovieVO> movieVOList = new ArrayList<MovieVO>();
        List<Movie> movieList = movieService.findAll();
        int a = 16*time;
        int b = 16*time+15;
        for (int i = a; i <= b; i++) {
            Movie movie = movieList.get(i);
            if (movieList.get(i) != null) {
                MovieVO movieVO = new MovieVO(movie.getMovieName(), movie.getId(), movie.getScore(), movie.getIcon());
                movieVOList.add(movieVO);
            } else {
                break;
            }
        }
        return new JsonResult<MovieVO>(movieVOList);
    }

    /**
     * 排行榜，每次10部(1是按热度。2是按评分。3是按时间)
     * page=0为前1-10部
     * @param type
     * @param page
     * @return
     */
    @GetMapping("/billboardmovie")
    public JsonResult<Movie> billboardMovie(int type, int page) {
        List<Movie> movieList = new ArrayList<Movie>();
        List<Movie> movies = new ArrayList<>();
        int hot = 1, score = 2, time = 3;
        if (type == hot) {
            movieList = movieService.sortMovieByHot();
        } else if (type == score) {
            movieList = movieService.sortMovieByScore();
        } else if (type == time) {
            movieList = movieService.sortMovieByTime();
        }
        int a = page*10;
        int b = page*10+9;
        for (int i = a; i <= b; i++) {
            Movie movie = movieList.get(i);
            if (movie != null) {
                movies.add(movie);
            } else {
                break;
            }
        }
        return new JsonResult<Movie>(movies);
    }

    /**
     * 根据类型搜索电影
     * @param type
     * @param page
     * @return
     */
    @GetMapping("/tagmovie")
    public JsonResult<MovieVO> getMoviesByType(String type, int page) {
        List<Movie> movieList = movieService.findByClassification(type);
        List<MovieVO> movieVOList = new ArrayList<MovieVO>();
        int pageA = page*16;
        int pageB = page*16+15;
        for (int i = pageA; i<= pageB; i++) {
            Movie movie = movieList.get(i);
            if (movie != null) {
                MovieVO movieVO = new MovieVO(movie.getMovieName(), movie.getId(), movie.getScore(), movie.getIcon());
                movieVOList.add(movieVO);
            } else {
                break;
            }
        }
        return new JsonResult<MovieVO>(movieVOList);
    }

    /**
     * 展示电影细节
     * @param movieId
     * @return
     */
    @GetMapping("/moviedetails")
    public JsonResult<Movie> movieDetails(Integer movieId) {
        return this.getMovieById(movieId);
    }

    @GetMapping("/getrecommendamovies")
    public JsonResult<MovieVO> getRecommendaMovies(Integer movieId) {
        Movie movieById = movieService.findById(movieId);
        List<Movie> movieList = movieService.findByClassification(movieById.getClassification());
        List<MovieVO> movieVOList = new ArrayList<MovieVO>();
        int num = 6;
        for (int i = 0; i < num; i++) {
            Movie movie = movieList.get(i);
            if (movieList.get(i) != null) {
                movieVOList.add(new MovieVO(movie.getMovieName(), movie.getId(), movie.getScore(), movie.getIcon()));
            } else {
                break;
            }
        }
        return new JsonResult<MovieVO>(movieVOList);
    }
}
