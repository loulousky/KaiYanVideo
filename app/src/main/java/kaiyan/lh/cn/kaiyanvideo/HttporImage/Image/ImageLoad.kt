package kaiyan.lh.cn.kaiyanvideo.HttporImage.Image

import android.content.Context
import android.widget.ImageView

/**
 * Created by admin on 2018/6/19.
 * 图片加载关联
 */
class ImageLoad(context: Context) : ImageUtil(context) {

    private var context: Context = context
    private  var imageutil: ImageUtil?=null
    init{
      if(imageutil==null){

          imageutil=GildUtils(context);

     }
    }
    companion object {
        fun getInstance(context: Context): ImageLoad {
            val imageload: ImageLoad = ImageLoad(context);

            return imageload;
        }
    }
    /**
     * 必掉函数设置具体什么Image工具类来执行操作
     */
    fun setImageUtils(imageUtil: ImageUtil) {
        this.imageutil = imageutil;
    }

    fun getImageUtils(): ImageUtil {
        return this.imageutil!!;
    }


    override fun Init(context: Context) {
        //初始化一些操作

    }

    override fun load(view: ImageView, url: String) {
        imageutil?.load(view, url)
    }

    override fun load(view: ImageView, url: String, callback: ImageCallBak) {
        imageutil?.load(view, url, callback)
    }


}

