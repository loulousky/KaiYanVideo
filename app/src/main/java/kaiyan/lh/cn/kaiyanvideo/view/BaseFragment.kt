package kaiyan.lh.cn.kaiyanvideo.view

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.fragmentation.SupportFragment



/**
 * Created by admin on 2018/6/19.
 * 基类Fragment
 */
abstract  class BaseFragment:SupportFragment() {

    lateinit var typeface:Typeface;
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        typeface= Typeface.createFromAsset(_mActivity.getAssets(), "Lobster-1.4.otf")
        var view:View= inflater!!.inflate(setLayout(),container,false);
        BindView(savedInstanceState,view)
        return  view
    }

    abstract fun setLayout():Int;

    abstract fun BindView(savedInstanceState: Bundle?,rootview:View);

//
//    //懒加载处理
//    override fun onLazyInitView(savedInstanceState: Bundle?) {
//        super.onLazyInitView(savedInstanceState)
//
//    }
//
//    //fragment可见
//    override fun onSupportVisible() {
//        super.onSupportVisible()
//    }
//
//    //fragment不可见
//    override fun onSupportInvisible() {
//        super.onSupportInvisible()
//    }


}