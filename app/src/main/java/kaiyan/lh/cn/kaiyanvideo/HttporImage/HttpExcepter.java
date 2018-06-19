package kaiyan.lh.cn.kaiyanvideo.HttporImage;

/**
 * Created by admin on 2018/6/15.
 * Http类型报错类
 *
 */

public class HttpExcepter extends Exception{
    private String name;
    public HttpExcepter(String name){
        super(name);

    }
}
