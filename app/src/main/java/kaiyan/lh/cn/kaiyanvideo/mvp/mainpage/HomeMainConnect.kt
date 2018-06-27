package kaiyan.lh.cn.kaiyanvideo.mvp.mainpage
import kaiyan.lh.cn.kaiyanvideo.Data.Categories
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpResultCallBack
import kaiyan.lh.cn.kaiyanvideo.mvp.BasePresenter
import kaiyan.lh.cn.kaiyanvideo.mvp.BaseView

/**
 * Created by admin on 2018/6/25.
 */
class HomeMainConnect{
    companion object {
         interface Presenter<T>:BasePresenter<T>{
            fun initcategoriesView()
        }
         interface View:BaseView{
            fun initcategoriesView()
            fun success(array:Array<String>,data:ArrayList<Categories>)
            fun error()
        }
         interface Mode{
            fun <T>loadcategories(url:String,callback: HttpResultCallBack<T>)
        }
    }
}