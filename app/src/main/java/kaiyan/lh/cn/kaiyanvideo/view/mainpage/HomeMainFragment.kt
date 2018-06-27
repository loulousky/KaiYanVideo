package kaiyan.lh.cn.kaiyanvideo.view.mainpage


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import com.hwangjr.rxbus.RxBus
import kaiyan.lh.cn.kaiyanvideo.Data.Categories
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.mvp.mainpage.HomeMainConnect
import kaiyan.lh.cn.kaiyanvideo.mvp.mainpage.HomeMainPresenter
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment
import kaiyan.lh.cn.kaiyanvideo.view.adapter.HomeMainPageAdapter
import kaiyan.lh.cn.kaiyanvideo.view.anniation.Anniation
import kotlinx.android.synthetic.main.fragment_home_main.*
import kotlinx.android.synthetic.main.fragment_home_main.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [HomeMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeMainFragment : BaseFragment(),
        HomeMainConnect.Companion.View{
    lateinit var presenter:HomeMainPresenter<HomeMainConnect.Companion.View>
    override fun ConnectPresenter() {
        presenter=HomeMainPresenter()
    }

    override fun initcategoriesView() {
        presenter.initcategoriesView()

    }

    override fun success(array: Array<String>, data: ArrayList<Categories>) {
        for (i in 0..array.size - 1) {
                            mFragments.add(HomeMainListFragment.newInstance(array[i], "i" + i))//添加Fragment
                        }
                        viewPager.adapter = HomeMainPageAdapter(childFragmentManager, mFragments, array)
                        sliding_layout.setViewPager(viewPager, array)
                        sliding_layout.setIndicatorWidthEqualTitle(true)
    }

    override fun error() {
    }

    var mFragments = ArrayList<Fragment>();
    override fun setLayout(): Int {
        return R.layout.fragment_home_main
    }

    override fun BindView(savedInstanceState: Bundle?, rootview: View) {

        initcategoriesView()
        rootview.mode_btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                RxBus.get().post(Anniation.CLASSIFY, this)
                Log.e("event:", Anniation.CLASSIFY)
            }
        })
        rootview.search_btn.setOnClickListener {
            RxBus.get().post(Anniation.SEARCH, this)
            Log.e("event:", Anniation.SEARCH)
        }

    }
    companion object {
        fun newInstance(): HomeMainFragment {
            val fragment = HomeMainFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        ConnectPresenter()
        presenter.attachView(this)
    }
    override fun onDetach() {
        super.onDetach()
        //生命周期监听
        presenter.detachView(this)

    }



}


