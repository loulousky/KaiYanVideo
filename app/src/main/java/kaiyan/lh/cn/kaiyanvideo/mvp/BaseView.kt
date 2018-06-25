package kaiyan.lh.cn.kaiyanvideo.mvp

/**
 * Created by admin on 2018/6/25.
 */



interface BaseView<T>{

    var mypresenter:T //关联的中间者

    fun ConnectPresenter();//关联中间者


}