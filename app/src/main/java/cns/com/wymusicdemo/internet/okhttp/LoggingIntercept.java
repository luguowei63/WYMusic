package cns.com.wymusicdemo.internet.okhttp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by luguowei on 2018/6/27.
 *
 * 自定义拦截器，用来方便对上行的参数，或者吓行的返回值进行提前处理
 *
 *
 *
 *
 */

public class LoggingIntercept implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        return response;
    }
}
