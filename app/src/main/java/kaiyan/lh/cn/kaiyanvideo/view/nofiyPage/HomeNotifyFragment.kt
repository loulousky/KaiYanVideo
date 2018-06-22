package kaiyan.lh.cn.kaiyanvideo.view.nofiyPage


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.hwangjr.rxbus.RxBus
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment
import kaiyan.lh.cn.kaiyanvideo.view.adapter.HomeMainPageAdapter
import kaiyan.lh.cn.kaiyanvideo.view.anniation.Anniation
import kaiyan.lh.cn.kaiyanvideo.view.attationPage.PublicFragment
import kotlinx.android.synthetic.main.fragment_home_notify.view.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [HomeNotifyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeNotifyFragment : BaseFragment() {
    val mTitles = arrayOf("官方", "互动")
    var mFragments = ArrayList<Fragment>();

    override fun setLayout(): Int {
      return R.layout.fragment_home_notify
    }

    override fun BindView(savedInstanceState: Bundle?, rootview: View) {
        rootview.text_title.setTypeface(typeface);//设置字体
        mFragments.add(GovFragment.newInstance())
        mFragments.add(CommFragment.newInstance())
        rootview.viewPager.adapter = HomeMainPageAdapter(childFragmentManager, mFragments, mTitles)
        rootview.sliding_layout.setViewPager(rootview.viewPager, mTitles)
        rootview.sliding_layout.setIndicatorWidthEqualTitle(true)
        rootview.mode_btn.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                start(PublicFragment.newInstance())//发布
                RxBus.get().post(Anniation.PUBLIS,this)
            }
        })
        rootview.search_btn.setOnClickListener {
            RxBus.get().post(Anniation.SEARCH,this)//搜索
        }






    }

    companion object {
        fun newInstance(): HomeNotifyFragment {
            val fragment = HomeNotifyFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
