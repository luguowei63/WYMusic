package cns.com.wymusicdemo.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

/**
 * 基类
 * Created by luguowei on 2018/6/25.
 */

public abstract class AbstractBaseViewActivity extends AbstractBaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
        initView(savedInstanceState);
        initViewEvent();

    }

    /**
     * 初始化接收到的参数
     */
    protected abstract void initVariables();


    /**
     * 初始化加载布局
     *
     * @param savedInstanceState
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);


    /**
     * 给@Link initView 中获得的View设置相应的事件。
     */
    protected abstract void initViewEvent();

    /**
     * @return
     */

    @Override
    protected int setLayoutId() {
        return 0;
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

}
