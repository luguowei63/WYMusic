package cns.com.wymusicdemo.internet.okhttp;

/**
 * Created by luguowei on 2018/6/26.
 * 本类是用来区分是哪个位置发起的请求，会通过IRequest实现类传给OnSuccess 中，在OnSuccess中进行判断区分。
 */

public enum RequestType {
    MAINPAGE(new RequestContent());
    RequestContent requestContent;

    RequestType(RequestContent requestContent) {
        this.requestContent = requestContent;
    }
}
