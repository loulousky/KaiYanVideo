package kaiyan.lh.cn.kaiyanvideo

import android.os.Bundle
import kaiyan.lh.cn.kaiyanvideo.view.HomeFragment

class MainActivity : BaseAcvitity() {


    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun Bindview(savedInstanceState: Bundle?) {
        val myclass: Class<HomeFragment> = HomeFragment::class.java
        //设置根Fragment
        if (findFragment(myclass) == null) {
            loadRootFragment(R.id.fl_container, HomeFragment())  //load root Fragment
        }

    }

}
