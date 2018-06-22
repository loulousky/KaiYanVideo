package kaiyan.lh.cn.kaiyanvideo.view.nofiyPage


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [GovFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GovFragment : BaseFragment() {
    override fun setLayout(): Int {
       return R.layout.fragment_gov
    }

    override fun BindView(savedInstanceState: Bundle?, rootview: View) {


    }


    companion object {
        fun newInstance(): GovFragment {
            val fragment = GovFragment()
            val args = Bundle()

            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
