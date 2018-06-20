package kaiyan.lh.cn.kaiyanvideo.view.mainpage


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment
import kaiyan.lh.cn.kaiyanvideo.view.adapter.HomeMainPageAdapter
import kotlinx.android.synthetic.main.fragment_home_main.view.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [HomeMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeMainFragment : BaseFragment() {

    val mTitles = arrayOf("发现", "推荐", "日报", "广告", "生活", "动画", "搞笑",
            "开胃", "创意", "运动", "音乐", "萌宠", "剧情", "科技", "旅行", "影视",
            "记录", "游戏", "综艺", "时尚", "集锦")

    var mFragments = ArrayList<Fragment>();

    override fun setLayout(): Int {
        return R.layout.fragment_home_main
    }

    override fun BindView(savedInstanceState: Bundle?, rootview: View) {

        for (i in 0..mTitles.size - 1) {
            mFragments.add(HomeMainListFragment.newInstance(mTitles[i],"i"+i))//添加Fragment
        }
        rootview.viewPager.adapter = HomeMainPageAdapter(childFragmentManager, mFragments, mTitles)
        rootview.sliding_layout.setViewPager(rootview.viewPager, mTitles)
        rootview.sliding_layout.setIndicatorWidthEqualTitle(true)


    }

    companion object {
        fun newInstance(): HomeMainFragment {
            val fragment = HomeMainFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
