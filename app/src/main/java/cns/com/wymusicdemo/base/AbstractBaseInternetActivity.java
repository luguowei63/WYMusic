package cns.com.wymusicdemo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import cns.com.wymusicdemo.internet.okhttp.InternetResult;
import cns.com.wymusicdemo.internet.okhttp.RequestInternet;
import cns.com.wymusicdemo.internet.okhttp.RequestType;
import okhttp3.Call;


/**
 * Created by luguowei on 2018/6/25.
 * 该类负责处理子类存在存在网络请求情况下
 */

public  abstract  class AbstractBaseInternetActivity extends AbstractBaseViewActivity implements InternetResult {

    protected RequestInternet requestInternet;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        requestInternet=new RequestInternet(this);
        loadData();
    }

    @Override
    protected void initVariables() {

    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        setContentView(setLayoutId());
    }

    @Override
    protected void initViewEvent() {

    }

    /**
     * 发起网络请求
     */
    protected abstract void loadData();

    @Override
    public void onFailure(RequestType requestType, Call call) {

    }

    @Override
    public void onFinish() {

    }
}
