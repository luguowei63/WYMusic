package cns.com.wymusicdemo.internet.okhttp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by luguowei on 2018/6/26.
 * 本类是负责发起网络请求的
 */

public class RequestInternet implements IRequest {


    private static InternetResult internetResult;
    private static RequestInternet requestInternet;
    private static OkHttpClient okHttpClient;

    public RequestInternet(InternetResult val) {
        internetResult = val;
    }


    public static RequestInternet create(InternetResult internetResult) {
        if (requestInternet == null) {
            requestInternet = new RequestInternet(internetResult);
        }
        createOkHttpClient();
        return requestInternet;
    }


    public static void createOkHttpClient() {
        if (okHttpClient == null) {
            Interceptor interceptor = new LoggingIntercept();
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(interceptor)
                    .connectTimeout(DEFAULT_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                    .build();
        }
    }

    @Override
    public void sendGetRequest(final RequestType requestType) {
        RequestContent requestContent = requestType.requestContent;
        Request request = new Request.Builder().url(requestContent.getUrl()).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                internetResult.onFailure(requestType, call);
                internetResult.onFinish();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                internetResult.onSuccess(requestType, call, response);
                internetResult.onFinish();
            }
        });


    }

    @Override
    public void sendPostRequest(final RequestType requestType) {
        RequestContent requestContent = requestType.requestContent;
        FormBody formBody = requestContent.getParamsBody();
        Request request = new Request.Builder().url(requestContent.getUrl()).post(formBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                internetResult.onFailure(requestType, call);
                internetResult.onFinish();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                internetResult.onSuccess(requestType, call, response);
                internetResult.onFinish();
            }
        });
    }

    @Override
    public void cancelALLRequests(boolean mayInterruptIfRunning) {

    }

    @Override
    public void setTimeOut(int value) {

    }

    @Override
    public void downloadFile(String url) {

    }


}
