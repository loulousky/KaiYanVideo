package kaiyan.lh.cn.kaiyanvideo.view.attationPage


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [PublicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PublicFragment : BaseFragment() {
    override fun setLayout(): Int {
       return R.layout.fragment_public
    }
    override fun BindView(savedInstanceState: Bundle?, rootview: View) {
    }

    companion object {
        fun newInstance(): PublicFragment {
            val fragment = PublicFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
