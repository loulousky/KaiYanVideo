package kaiyan.lh.cn.kaiyanvideo

import android.os.Bundle

class MainActivity : BaseAcvitity() {
    override fun setLayout(): Int {
     return R.layout.activity_main
    }

    override fun Bindview(savedInstanceState: Bundle?) {

    }


    override fun onBackPressedSupport() {


            val topFragment = topFragment

            // 主页的Fragment
//            if (topFragment is BaseMainFragment) {
//
//            }

            if (supportFragmentManager.backStackEntryCount > 1) {
                //不是主页FRAGMENT 那么此fragment出栈
                pop()

            } else {
              //双击退出逻辑
            }
        }


}
