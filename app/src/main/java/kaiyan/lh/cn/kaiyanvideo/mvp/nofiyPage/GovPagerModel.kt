package kaiyan.lh.cn.kaiyanvideo.mvp.nofiyPage

import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpManager
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpResultCallBack
import kaiyan.lh.cn.kaiyanvideo.HttporImage.RetrofitApi

/**
 * Created by admin on 2018/6/28.
 */
class GovPagerModel:
        GovPagerConn.Companion.Mode{
    override fun <T> loadData(url: String, callBack: HttpResultCallBack<T>) {
        HttpManager.getInstance().GetRequest(RetrofitApi.GOVNEWS,callBack)
    }


}
