package kaiyan.lh.cn.kaiyanvideo.HttporImage;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit 网络封装
 * Created by admin on 2018/6/15.
 */

public class RetrofitUtils implements HttpUtils {
    private static Retrofit retrofit;

    @Override
    public void init(Context context) {
        //Gson
        Gson gson = new GsonBuilder()
                //配置你的Gson
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
        //设置缓存

        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB Cache cache = new Cache(httpCacheDirectory, cacheSize);
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        //利用okhttp实现缓存
        OkHttpClient client = new OkHttpClient.Builder()
                //有网络时的拦截器
                .cache(cache)//服务器支持的缓存直接通过这个
                .addNetworkInterceptor(Okhttp3Interceptor.interceptorcache)//所有的都拦截
                .addInterceptor(new HttpLoggingInterceptor())//lOG拦截器
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                //没网络时的拦截器
                .build();
        //返回retrofit对象

        retrofit = new Retrofit.Builder()
                .baseUrl(HttpUrlCommon.BaseUrl)//URL头
                //可以接收自定义的Gson，当然也可以不传
                .addConverterFactory(GsonConverterFactory.create(gson)) //设置GSON解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//支持Rxjava返回
                .build();

    }




    //一般的网络请求封装
    @Override
    public void GetRequest(String url, HttpResultCallBack callBack) {
        switch (url){
            case RetrofitApi.Home:
                RetrofitApi api=retrofit.create(RetrofitApi.class);
        }
    }
    @Override
    public void PostRequest(String url, Map<String, String> head, HttpResultCallBack callBack) {

    }


}