package kaiyan.lh.cn.kaiyanvideo.mvp

/**
 * Created by admin on 2018/6/25.
 * 基类presenter
 */

abstract interface BasePresenter<T>{
    fun  attachView(myview:T)//关联
    fun  detachView(myview:T)//解除关联

    fun isDetacheView():Boolean//判断是否关联

}