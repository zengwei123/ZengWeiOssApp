package com.example.zengwei.zengweiossapp.Base;

/**
 * Created by zengwei on 2018/11/12.
 */

public class BasePresenter<V> {
    public V mvpView;
    public void attachView(V mvpView){
        this.mvpView=mvpView;
    }
    public void detachView(){
        this.mvpView=null;
    }
}
