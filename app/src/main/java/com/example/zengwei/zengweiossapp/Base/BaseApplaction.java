package com.example.zengwei.zengweiossapp.Base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.zengwei.zengweiossapp.Bean.OutPutJson;
import com.example.zengwei.zengweiossapp.Bean.User;
import com.example.zengwei.zengweiossapp.Net.Interceptor.AddQueryParameterInterceptor;
import com.example.zengwei.zengweiossapp.Net.RetrofitCallOssService;
import com.example.zengwei.zengweiossapp.Util.SharedPreferencesHelper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by zengwei on 2018/11/14.
 * 每次竟如程序，登陆，用来获取Token,并且保存起来
 */

public class BaseApplaction extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        final retrofit2.Call<OutPutJson<String>> call= RetrofitCallOssService.
                getRetrofitCallOssService().
                getRetrofitRequestOssService()
                .SignIn(new User("zengwei","a123456"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //同步请求获取token  执行完这个请求在执行其他的请求
                    new SharedPreferencesHelper(getApplicationContext(),"Oss").put("Token",call.execute().body().getDate());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public Context getBaseApplaction(){
        return context;
    }
}
