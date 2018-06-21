package kaiyan.lh.cn.kaiyanvideo.view.attationPage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment
import kaiyan.lh.cn.kaiyanvideo.view.SearchFragment
import kaiyan.lh.cn.kaiyanvideo.view.adapter.HomeMainPageAdapter
import kotlinx.android.synthetic.main.fragment_home_attation.view.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeAttationFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeAttationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeAttationFragment : BaseFragment() {

    val mTitles = arrayOf("作品", "动态")

    var mFragments = ArrayList<Fragment>();


    override fun setLayout(): Int {

        return R.layout.fragment_home_attation
    }

    override fun BindView(savedInstanceState: Bundle?, rootview: View) {
        rootview.text_title.setTypeface(typeface);//设置字体
        mFragments.add(WorkFragment.newInstance())
        mFragments.add(NewEventsFragment.newInstance())
        rootview.viewPager.adapter = HomeMainPageAdapter(childFragmentManager, mFragments, mTitles)
        rootview.sliding_layout.setViewPager(rootview.viewPager, mTitles)
        rootview.sliding_layout.setIndicatorWidthEqualTitle(true)
        rootview.mode_btn.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                start(PublicFragment.newInstance())//发布
            }
        })
        rootview.search_btn.setOnClickListener {
            start(SearchFragment.newInstance())//搜索
        }
    }
    companion object {
        fun newInstance(): HomeAttationFragment {
            val fragment = HomeAttationFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
