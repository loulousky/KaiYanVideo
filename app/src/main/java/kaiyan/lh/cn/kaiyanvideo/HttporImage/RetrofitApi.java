package kaiyan.lh.cn.kaiyanvideo.HttporImage;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by admin on 2018/6/15.
 * 请求API结合
 *
 */

public interface RetrofitApi {

   public static String Categories="1";//分类

   public static String GOVNEWS="2";//通知
   @GET(HttpUrlCommon.Categories)
   public Observable<ArrayList<kaiyan.lh.cn.kaiyanvideo.Data.Categories>> getCategoryData(); //获取分类







}
