package com.example.zengwei.zengweiossapp.Net.Interceptor;

import android.util.Log;

import com.example.zengwei.zengweiossapp.Base.BaseApplaction;
import com.example.zengwei.zengweiossapp.Util.SharedPreferencesHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zengwei on 2018/11/13.
 * 拦截器 用来添加请求头等东西
 */

public class AddQueryParameterInterceptor implements Interceptor{
    private Request.Builder builder;
    private Request originalRequest;
    private Request.Builder requestBuilder;
    private Request request;
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        //获取保存的Token,添加请求头
        String token=new SharedPreferencesHelper(new BaseApplaction().getBaseApplaction(),"Oss").getSharedPreference("Token","null")+"";
        originalRequest = chain.request();
        builder = originalRequest.newBuilder();
        builder.header("zwToken", token);
        requestBuilder =builder.method(originalRequest.method(), originalRequest.body());
        request = requestBuilder.build();
        return chain.proceed(request);
    }

}
