package cns.com.wymusicdemo.internet.okhttp;

/**
 * Created by luguowei on 2018/6/26.
 * 本接口规定网络请求具体实现执行的方法和常量
 */

public interface IRequest {
    /**
     * 状态码
     */
    String TAG_STATTUS_CODE = "statusCode";
    /**
     * 请求失败后失败的内容的KEY
     */
    String TAG_MESSAGE = "message";

    /**
     * 成功后json的KEY值
     */
    String TAG_OBJECTS = "objects";
    /**
     * 默认连接超时时间
     */

    int DEFAULT_CONNECT_TIME_OUT = 10 * 1000;

    /**
     * 默认读数据超时时间
     */
    int DEFAULT_READ_TIME_OUT=10*1000;
    /**
     * 默认写数据超时时间
     */
    int DEFAULT_WRITE_TIME_OUT=10*1000;



    /**
     * 发送get请求
     */
    void sendGetRequest(RequestType requestType);

    /**
     * 发送post请求
     */
    void sendPostRequest(RequestType requestType);

    /**
     * 取消所有请求，可能中断请求
     */
    void cancelALLRequests(boolean mayInterruptIfRunning);

    /**
     * 重新设置请求时间
     */
    void setTimeOut(int value);

    /**
     * 下载文件
     */
    void downloadFile(String url);


}