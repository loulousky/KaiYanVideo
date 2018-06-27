package kaiyan.lh.cn.kaiyanvideo.Data

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * Created by admin on 2018/6/20.
 */
class TabEntity(var title: String, var selectedIcon: Int, var unSelectedIcon: Int) : CustomTabEntity {

    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabTitle(): String {
        return title
    }


}