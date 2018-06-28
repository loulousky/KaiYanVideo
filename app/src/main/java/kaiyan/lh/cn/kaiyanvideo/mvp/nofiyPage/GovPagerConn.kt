package kaiyan.lh.cn.kaiyanvideo.mvp.nofiyPage

import kaiyan.lh.cn.kaiyanvideo.Data.GovNews
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpResultCallBack
import kaiyan.lh.cn.kaiyanvideo.mvp.BasePresenter
import kaiyan.lh.cn.kaiyanvideo.mvp.BaseView

/**
 * Created by admin on 2018/6/28.
 */
class GovPagerConn {
    companion object {
        interface Presenter<T>:BasePresenter<T>{
            fun loadData()

            fun refreshData()

        }


        interface View:BaseView{

            fun loadmoreSuccess(data:List<GovNews>)

            fun loadmoreError()

            fun refreshSuccess(data:List<GovNews>)

            fun refreshError()


        }

        interface Mode{
            fun <T>loadData(url:String,callBack: HttpResultCallBack<T>)

        }




    }

}