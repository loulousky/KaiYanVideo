package kaiyan.lh.cn.kaiyanvideo.view.attationPage


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [NewEventsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewEventsFragment : BaseFragment() {
    override fun setLayout(): Int {
       return R.layout.fragment_new_events
    }

    override fun BindView(savedInstanceState: Bundle?, rootview: View) {
    }
    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewEventsFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(): NewEventsFragment {
            val fragment = NewEventsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
