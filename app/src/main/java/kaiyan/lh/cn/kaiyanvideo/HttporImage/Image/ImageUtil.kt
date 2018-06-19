package kaiyan.lh.cn.kaiyanvideo.HttporImage.Image

import android.content.Context
import android.widget.ImageView

/**
 * Created by admin on 2018/6/19.
 */
abstract class ImageUtil(context: Context){

    private var context:Context;
    init {
      this.context=context;
    }


    //初始化
    abstract fun Init(context:Context)

    //加载图片
    abstract fun load(view: ImageView,url:String )


    abstract fun load(view: ImageView,url:String,callback:ImageCallBak)



}