package com.xznn.retrofit_rxjava;

import com.xznn.retrofit_rxjava.bean.HttpResult;
import com.xznn.retrofit_rxjava.bean.Subjects;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 16/11/14.
 */

public interface MovieService {
//    https://api.douban.com/v2/movie/top250?start=0&count=10
    @GET("top250")
//    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
    Observable<HttpResult<List<Subjects>>> getTopMovie(@Query("start") int start, @Query("count") int count);

}
