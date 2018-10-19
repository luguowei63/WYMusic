package cns.com.wymusicdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by luguowei on 2018/6/25.
 * 本来负责处理子类只需接收参数，或者直接显示
 */

public class BaseViewActivity extends AbstractBaseViewActivity {
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


}
