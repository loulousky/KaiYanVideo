package kaiyan.lh.cn.kaiyanvideo

import android.app.Application
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpManager
import kaiyan.lh.cn.kaiyanvideo.HttporImage.RetrofitUtils

/**
 * Created by admin on 2018/6/15.
 */
class MainApplication :Application(){

    companion object {
        lateinit var  myapp:MainApplication;
    }

    override fun onCreate() {
        super.onCreate()
        myapp=this;
        HttpManager.getInstance(this).setHttpUtils(RetrofitUtils());//初始化应用的网络请求框架



    }



}