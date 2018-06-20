package kaiyan.lh.cn.kaiyanvideo

import android.os.Bundle
import me.yokeyword.fragmentation.SupportActivity

/**
 * Created by admin on 2018/6/19.
 * 基类Activity
 */
abstract class BaseAcvitity:SupportActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        Bindview(savedInstanceState)
    }




    /**
     * 布局
     */

    abstract fun setLayout():Int


    /**
     * 具体事件
     */
    abstract fun Bindview(savedInstanceState: Bundle?)






}