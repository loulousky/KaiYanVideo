package kaiyan.lh.cn.kaiyanvideo.mvp.mainpage

import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import kaiyan.lh.cn.kaiyanvideo.Data.Categories
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpResultCallBack
import kaiyan.lh.cn.kaiyanvideo.HttporImage.RetrofitApi

/**
 * Created by admin on 2018/6/27.
 */
class  HomeMainPresenter<T:HomeMainConnect.Companion.View>():HomeMainConnect.Companion.Presenter<T>{


    val mode:HomeMainMode=HomeMainMode()//底层交互的mode
     var isdetacheview:Boolean=false

    lateinit var data:ArrayList<Categories>

    lateinit var view:HomeMainConnect.Companion.View;


    /**
     * 关联生命周期
     */
    override fun attachView(myview: T) {
        isdetacheview=true
        view=myview
    }

    /**
     * 关联生命周期
     */
    override fun detachView(myview: T) {
        isdetacheview=false
        view=myview
    }

    override fun isDetacheView():Boolean {

        return isdetacheview
    }

    //交互VIEW
    override fun initcategoriesView() {
        mode.loadcategories(RetrofitApi.Categories,object : HttpResultCallBack<Observable<ArrayList<Categories>>> {
            override fun error() {
                Log.e("liuhai", "错误")
            }

            override fun success(t2: Observable<ArrayList<Categories>>) {
                Log.e("liuhaisuccess",   t2.toString())
                t2.map(
                        object : Function<ArrayList<Categories>, Array<String>> {
                            override fun apply(t: ArrayList<Categories>): Array<String> {
                                Log.e("liuhai",   t.toString())
                                data=t
                                var myarry = Array<String>(t.size, { "" })
                                for (i in 0..t.size - 1) {
                                    myarry[i] = t.get(i).name

                                }
                                return myarry
                            }
                        }
                ).subscribe (
                        object : Consumer<Array<String>> {
                            override fun accept(t: Array<String>) {
                                //成功回调
                              view.success(t,data)
                            }

                        },
                        object : Consumer<Throwable> {
                            override fun accept(t: Throwable?) {
                                //失败回调
                                Log.e("liuhai",t.toString())

                                view.error()

                            }
                        }
                )
            }
        })

    }


}