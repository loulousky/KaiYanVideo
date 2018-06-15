package kaiyan.lh.cn.kaiyanvideo.HttporImage;

import android.content.Context;

import java.util.Map;

/**
 * Created by admin on 2018/6/15.
 */

public interface HttpUtils {
    /**
     * 初始化网络框
     * @param context
     */
    public void init(Context context) throws HttpExcepter;

    /**
     * Get请求
     * @param url
     * @param callBack 请求回调
     */

    public void GetRequest(String url,HttpResultCallBack callBack) throws HttpExcepter;


    /**
     * POST请求
     * @param url
     * @param head
     * @param callBack 请求回调
     */
    public void PostRequest(String url, Map<String ,String> head,HttpResultCallBack callBack) throws HttpExcepter;


}
