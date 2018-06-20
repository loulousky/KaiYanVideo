package kaiyan.lh.cn.kaiyanvideo.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import java.util.*

/**
 * Created by admin on 2018/6/20.
 */
class HomeMainPageAdapter(var context: FragmentManager,var mFragments:ArrayList<Fragment>,var mTitles:Array<String>):FragmentPagerAdapter(context){

    override fun getItem(position: Int): Fragment {

        return mFragments.get(position)
    }

//    override fun getPageTitle(position: Int): CharSequence {
//        return mTitles.get(position)
//    }

    override fun getCount(): Int {

        return mFragments.size
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {

    }
}