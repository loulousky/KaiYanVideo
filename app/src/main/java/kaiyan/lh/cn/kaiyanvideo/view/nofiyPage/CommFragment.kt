package kaiyan.lh.cn.kaiyanvideo.view.nofiyPage

import android.os.Bundle
import android.view.View
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment

class CommFragment : BaseFragment() {
    override fun setLayout(): Int {
        return R.layout.fragment_gyt
    }
    override fun BindView(savedInstanceState: Bundle?, rootview: View) {
    }

    companion object {

        fun newInstance(): CommFragment {
            val fragment = CommFragment()
            val args = Bundle()

            fragment.arguments = args
            return fragment
        }
    }
}