package kaiyan.lh.cn.kaiyanvideo.mvp.mainpage

import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpManager
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpResultCallBack

/**
 * Created by admin on 2018/6/27.
 */
class HomeMainMode:HomeMainConnect.Companion.Mode{

    override fun <T> loadcategories(url: String, callback: HttpResultCallBack<T>) {
         HttpManager.getInstance().GetRequest(url,callback)
    }


}