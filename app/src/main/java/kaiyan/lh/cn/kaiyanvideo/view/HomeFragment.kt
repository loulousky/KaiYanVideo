package kaiyan.lh.cn.kaiyanvideo.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.flyco.tablayout.listener.CustomTabEntity
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.entity.TabEntity
import kaiyan.lh.cn.kaiyanvideo.view.mainpage.HomeMainFragment
import kotlinx.android.synthetic.main.home_fragment_layout.view.*
import me.yokeyword.fragmentation.SupportFragment
import java.util.*

/**
 * Created by admin on 2018/6/20.
 */
class HomeFragment : BaseFragment() {
    val mTitles= arrayOf("首页","关注","通知","我的")
    //底部的ICON图标
    val mIconUnselectIds = intArrayOf(R.drawable.ic_tab_strip_icon_feed,
            R.drawable.ic_tab_strip_icon_follow,
            R.drawable.ic_tab_strip_icon_category,
            R.drawable.ic_tab_strip_icon_profile)
    val mIconSelectIds = intArrayOf(R.drawable.ic_tab_strip_icon_feed_selected,
            R.drawable.ic_tab_strip_icon_follow_selected,
            R.drawable.ic_tab_strip_icon_category_selected,
            R.drawable.ic_tab_strip_icon_profile_selected)
    //底部封装的实体类
    var mTabEntites = arrayListOf<CustomTabEntity>()
    var mFragments= ArrayList<Fragment>()
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(findChildFragment(HomeMainFragment::class.java)==null){
            mFragments.add(HomeMainFragment.newInstance())
            mFragments.add(SupportFragment())
            mFragments.add(SupportFragment())
            mFragments.add(SupportFragment())
            loadMultipleRootFragment(R.id.fl_change,0,mFragments.get(0) as SupportFragment,mFragments.get(1) as SupportFragment,
                    mFragments[2] as SupportFragment,mFragments[3] as SupportFragment)
        }else{
            mFragments.add(findChildFragment(HomeMainFragment::class.java))
            mFragments.add(findChildFragment(SupportFragment::class.java))
            mFragments.add(findChildFragment(SupportFragment::class.java))
            mFragments.add(findChildFragment(SupportFragment::class.java))
        }




    }

    override fun setLayout(): Int {
        return R.layout.home_fragment_layout
    }
    override fun BindView(savedInstanceState: Bundle?, rootview: View) {
        setBottomTab(rootview)
    }
    /**
     * 设置TAB数据
     */
    fun setBottomTab(rootview: View) {

        for (i in 0..mTitles.size-1){
            mTabEntites.add(TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]))
        }
        //设置tab的标题、选中图标、未选中图标
        rootview.tl.setTabData(mTabEntites,_mActivity,R.id.fl_change,mFragments)
        rootview.tl.showDot(3);//设置第三个ICON位置提示
    }
}