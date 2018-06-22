package kaiyan.lh.cn.kaiyanvideo.view.userPage


import android.os.Bundle
import android.view.View
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment


class HomeUserFragment : BaseFragment() {
    override fun setLayout(): Int {
       return R.layout.fragment_home_user
    }
    override fun BindView(savedInstanceState: Bundle?, rootview: View) {
    }
    companion object {
        fun newInstance(): HomeUserFragment {
            val fragment = HomeUserFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
