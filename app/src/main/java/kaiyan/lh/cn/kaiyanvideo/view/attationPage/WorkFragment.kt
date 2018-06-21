package kaiyan.lh.cn.kaiyanvideo.view.attationPage


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [WorkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkFragment : BaseFragment() {
    override fun setLayout(): Int {
       return R.layout.fragment_work
    }

    override fun BindView(savedInstanceState: Bundle?, rootview: View) {

    }




    companion object {
        fun newInstance(): WorkFragment {
            val fragment = WorkFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
