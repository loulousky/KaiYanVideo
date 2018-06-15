package kaiyan.lh.cn.kaiyanvideo.HttporImage;

/**
 * Created by admin on 2018/6/15.
 * 通用网络状态回调
 */

public interface HttpResultCallBack<T> {

    /*
     *成功
     *
     */
    public void success(T t2);

    /**
     * 失败回调
     */
    public void error();



}
