package kaiyan.lh.cn.kaiyanvideo

import android.support.multidex.MultiDexApplication
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpManager
import kaiyan.lh.cn.kaiyanvideo.HttporImage.RetrofitUtils
import me.yokeyword.fragmentation.Fragmentation
import me.yokeyword.fragmentation.helper.ExceptionHandler


/**
 * Created by admin on 2018/6/15.
 */
class MainApplication :MultiDexApplication(){
    companion object {
        lateinit var  myapp:MainApplication;
    }
    override fun onCreate() {
        super.onCreate()
        myapp=this
        HttpManager.getInstance(this).setHttpUtils(RetrofitUtils());//初始化应用的网络请求框架
        initFragment()


    }


    /**
     * fragmentnation
     * 初始化框架
     */
    fun initFragment(){
        Fragmentation.builder()
                // 设置 栈视图 模式为 （默认）悬浮球模式   SHAKE: 摇一摇唤出  NONE：隐藏， 仅在Debug环境生效
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(true) // 实际场景建议.debug(BuildConfig.DEBUG)
                /**
                 * 可以获取到[me.yokeyword.fragmentation.exception.AfterSaveStateTransactionWarning]
                 * 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                 */
                .handleException(object : ExceptionHandler {
                    override fun onException(e: Exception) {
                        // 以Bugtags为例子: 把捕获到的 Exception 传到 Bugtags 后台。
                        // Bugtags.sendException(e);
                    }
                })
                .install()
    }



}