package kaiyan.lh.cn.kaiyanvideo.view.nofiyPage


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.andview.refreshview.XRefreshView
import kaiyan.lh.cn.kaiyanvideo.Data.GovNews
import kaiyan.lh.cn.kaiyanvideo.R
import kaiyan.lh.cn.kaiyanvideo.mvp.nofiyPage.GovPagerConn
import kaiyan.lh.cn.kaiyanvideo.mvp.nofiyPage.GovPagerPresenter
import kaiyan.lh.cn.kaiyanvideo.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_gov.*


/**
 * A simple [Fragment] subclass.
 * Use the [GovFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GovFragment : BaseFragment(),
        GovPagerConn.Companion.View {
    lateinit var presenter:GovPagerPresenter<GovFragment>
    override fun ConnectPresenter() {
        presenter=GovPagerPresenter<GovFragment>()
    }

    override fun loadmoreSuccess(data: List<GovNews>) {

        refreshView.setLoadComplete(true)
        refreshView.stopLoadMore()

    }

    override fun loadmoreError() {
        refreshView.setLoadComplete(true)
        refreshView.stopLoadMore()
    }

    override fun refreshSuccess(data: List<GovNews>) {
        refreshView.stopRefresh();

    }

    override fun refreshError() {
        refreshView.stopRefresh();
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        ConnectPresenter()
        presenter.attachView(this)
    }

    override fun onDetach() {
        super.onDetach()
        presenter.detachView(this)
    }

    override fun setLayout(): Int {
       return R.layout.fragment_gov
    }

    override fun BindView(savedInstanceState: Bundle?, rootview: View) {
           myrecyclerview.setHasFixedSize(true)
        //设置刷新完成以后，headerview固定的时间
        refreshView.setPinnedTime(1000);
        refreshView.setMoveForHorizontal(true);
        refreshView.setPullLoadEnable(true);
        refreshView.setAutoLoadMore(true);
        //adapter.setCustomLoadMoreView( XRefreshViewFooter(context));
        refreshView.enableReleaseToLoadMore(true);
        refreshView.enableRecyclerViewPullUp(true);
        refreshView.enablePullUpWhenLoadCompleted(true);
        refreshView.setXRefreshViewListener(object : XRefreshView.SimpleXRefreshListener() {
            override fun onRefresh(isPullDown: Boolean) {
                super.onRefresh(isPullDown)
                presenter.refreshData()
            }

            override fun onLoadMore(isSilence: Boolean) {
                super.onLoadMore(isSilence)

                presenter.loadData()

            }


        })

    }

    /**
     * 懒加载实现
     */
    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        presenter.refreshData()
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
