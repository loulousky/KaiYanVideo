package kaiyan.lh.cn.kaiyanvideo.mvp.nofiyPage

import kaiyan.lh.cn.kaiyanvideo.Data.GovNews
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpResultCallBack

/**
 * Created by admin on 2018/6/28.
 */
class GovPagerPresenter<T:GovPagerConn.Companion.View>:GovPagerConn.Companion.Presenter<T>{
    var isdetachview:Boolean=false;
    lateinit var view:T;


    val mode:GovPagerModel=GovPagerModel()



    override fun attachView(myview: T) {//关联VIEW
        isdetachview=true
        view=myview
    }

    override fun detachView(myview: T) {
        //取消关联
        isdetachview=false

    }

    override fun isDetacheView(): Boolean {

        return isdetachview
    }

    /**
     * 加载更多
     */
    override fun loadData() {

        mode.loadData("",object :HttpResultCallBack<List<GovNews>>{
            override fun success(t2: List<GovNews>?) {
                view.loadmoreSuccess(t2!!)
            }

            override fun error() {
                view.loadmoreError()
            }


        })


    }

    /**
     * 刷新
     */
    override fun refreshData() {
        mode.loadData("",object :HttpResultCallBack<List<GovNews>>{
            override fun success(t2: List<GovNews>?) {
                view.refreshSuccess(t2!!)
            }

            override fun error() {
                view.refreshError()
            }


        })
    }

}