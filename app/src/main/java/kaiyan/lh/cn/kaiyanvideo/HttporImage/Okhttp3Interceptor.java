package kaiyan.lh.cn.kaiyanvideo.HttporImage;

import com.shuyu.gsyvideoplayer.utils.NetworkUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import kaiyan.lh.cn.kaiyanvideo.MainApplication;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2018/6/15.
 */

public class Okhttp3Interceptor {

    public static final Interceptor interceptorcache = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();
            Request request = chain.request();
            if (!NetworkUtils.isAvailable(MainApplication.myapp)) {
                request = request.newBuilder().cacheControl(cacheControl).build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetworkUtils.isAvailable(MainApplication.myapp)) {
                int maxAge = 0;
                return originalResponse.newBuilder().removeHeader("Pragma").header("Cache-Control", "public ,max-age=" + maxAge).build();

            } else {
                int maxStale = 60 * 60 * 24 * 28;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }


        }
    };

}
