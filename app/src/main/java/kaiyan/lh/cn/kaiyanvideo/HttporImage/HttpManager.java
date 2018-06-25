package kaiyan.lh.cn.kaiyanvideo.HttporImage;

import android.content.Context;

import java.util.Map;

/**
 * Created by admin on 2018/6/15.
 * 应用网络请求主类
 *
 */

public class HttpManager implements HttpUtils{


    private static HttpManager httpManager;
    private HttpUtils httpUtils;

    private HttpManager(){

    }
    public static HttpManager getInstance(){
       if(httpManager==null){
           synchronized (HttpManager.class){

               httpManager=new HttpManager();

           }
       }
       return httpManager;
    }
    //初始化后必须设置
    public void setHttpUtils(HttpUtils httpUtils,Context context) throws HttpExcepter {
        this.httpUtils=httpUtils;
        init(context);
    }
    @Override
    public void init(Context context) throws HttpExcepter {
        if(httpUtils==null){
            throw new HttpExcepter("没有初始化HTTPUTILS");
        }
        httpUtils.init(context);

    }
    @Override
    public void GetRequest(String url, HttpResultCallBack callBack) throws HttpExcepter {
        if(httpUtils==null){
            throw new HttpExcepter("没有初始化HTTPUTILS");
        }
         httpUtils.GetRequest(url,callBack);

    }
    @Override
    public void PostRequest(String url, Map<String, String> head, HttpResultCallBack callBack) throws HttpExcepter {
        if(httpUtils==null){
            throw new HttpExcepter("没有初始化HTTPUTILS");
        }
         httpUtils.PostRequest(url,head,callBack);
    }
}
