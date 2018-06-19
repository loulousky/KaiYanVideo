package kaiyan.lh.cn.kaiyanvideo.HttporImage.Image

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/**
 * Created by admin on 2018/6/19.
 * Glide图片加载工具类
 */
public class GildUtils(context:Context):ImageUtil(context){
    private lateinit var context:Context;
    init {
        this.context=context;
    }
    override fun Init(context: Context) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //正常使用
    override fun load(view: ImageView, url: String) {
        Glide.with(context).load(url).into(view);
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //正常回调
    @SuppressLint("CheckResult")
    override fun load(view: ImageView, url: String, callback: ImageCallBak) {
        Glide.with(context).load(url).listener(object : RequestListener<Drawable>{
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                callback.onFaile("错误加载")


               return false;
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


                callback.onSuccess()
                return  false;

            }

        })
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //本类特有






}