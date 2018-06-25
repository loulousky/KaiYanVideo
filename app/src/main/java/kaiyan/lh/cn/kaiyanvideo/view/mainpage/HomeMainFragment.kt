package kaiyan.lh.cn.kaiyanvideo.view.mainpage


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import com.hwangjr.rxbus.RxBus
import io.reactivex.Observable
import kaiyan.lh.cn.kaiyanvideo.Data.Categories
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpManager
import kaiyan.lh.cn.kaiyanvideo.HttporImage.HttpResultCallBack
import kaiyan.lh.cn.kaiyanvideo.HttporImage.RetrofitApi
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment
import kaiyan.lh.cn.kaiyanvideo.view.anniation.Anniation
import kotlinx.android.synthetic.main.fragment_home_main.view.*


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
        HttpManager.getInstance().GetRequest(RetrofitApi.Categories, object : HttpResultCallBack<Observable<ArrayList<Categories>>> {
            override fun error() {

            }
            override fun success(t2: Observable<ArrayList<Categories>>?) {

                t2?.subscribe({Log.e(
                       "tag", it.get(0).name
                )})
//                t2!!.subscribeOn(Schedulers.io()).
//                        observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread()).
//                        map {
//                            object : Func1<Array<Categories>, Array<String>> {
//                                override fun call(t: Array<Categories>?): Array<String> {
//                                    var myarry = Array<String>(t!!.size, { "" })
//                                    for (i in 0..t!!.size-1) {
//                                        myarry[i] = t.get(i).name
//                                    }
//                                    return myarry
//                                }
//                            }
//                        }.subscribe ({object : Action1<Array<String>> {
//                    override fun call(t: Array<String>?) {
//                        for (i in 0..t!!.size - 1) {
//                            mFragments.add(HomeMainListFragment.newInstance(t[i], "i" + i))//添加Fragment
//                        }
//                        rootview.viewPager.adapter = HomeMainPageAdapter(childFragmentManager, mFragments, t)
//                        rootview.sliding_layout.setViewPager(rootview.viewPager, t)
//                        rootview.sliding_layout.setIndicatorWidthEqualTitle(true)
//                    }
//                }})
//
//
            } })


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

}
