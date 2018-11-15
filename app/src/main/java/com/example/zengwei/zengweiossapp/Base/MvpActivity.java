package com.example.zengwei.zengweiossapp.Base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

/**
 * Created by zengwei on 2018/11/12.
 */

public abstract class MvpActivity<P extends BasePresenter>  extends BaseActivity {
    protected P mvpPresenter;
    protected abstract P createPresenter();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        mvpPresenter=createPresenter();
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter!=null){
            mvpPresenter.detachView();
            mvpPresenter=null;
        }
    }
}
