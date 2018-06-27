package kaiyan.lh.cn.kaiyanvideo.mvp.mainpage

import kaiyan.lh.cn.kaiyanvideo.Data.Categories
import kaiyan.lh.cn.kaiyanvideo.mvp.BasePresenter
import kaiyan.lh.cn.kaiyanvideo.mvp.BaseView

/**
 * Created by admin on 2018/6/25.
 */
class HomeMainListConnect {
    companion object {
        interface Presenter<T> : BasePresenter<T> {
        }
        interface View : BaseView {
            fun success(array: Array<String>, data: ArrayList<Categories>)
            fun error()
        }
        interface Model {
        }
    }


}