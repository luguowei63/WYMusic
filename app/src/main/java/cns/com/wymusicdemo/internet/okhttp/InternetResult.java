package cns.com.wymusicdemo.internet.okhttp;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by luguowei on 2018/6/26.
 *本接口是网络请求的返回数据的接口。
 *
 */

public interface InternetResult {
    /**
     * 成功返回数据
     * @param requestType 利用requestType来区分是哪个界面发起的网络请求，以方便在onSuccess中进行判断
     */
    void onSuccess(RequestType requestType, Call call, Response response);

    /**
     *请求数据失败
     * @param requestType 利用requestType来区分是哪个界面发起的网络请求，以方便在onFailure中进行判断
     */
    void onFailure(RequestType requestType, Call call);

    /**
     *请求数据技术
     */
    void  onFinish();

}
