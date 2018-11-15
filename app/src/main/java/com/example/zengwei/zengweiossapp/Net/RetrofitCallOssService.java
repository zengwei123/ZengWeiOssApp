package com.example.zengwei.zengweiossapp.Net;

import android.app.Activity;

import com.example.zengwei.zengweiossapp.Base.BaseApplaction;
import com.example.zengwei.zengweiossapp.Net.ConvertersFractory.OutPutJsonConverterFactory;
import com.example.zengwei.zengweiossapp.Net.ConvertersFractory.StringConverterFactory;
import com.example.zengwei.zengweiossapp.Net.Interceptor.AddQueryParameterInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zengwei on 2018/11/12.
 * 请求的鸡鸡
 */

public class RetrofitCallOssService{
    private static RetrofitCallOssService retrofitCallOssService=null;
    public static RetrofitCallOssService getRetrofitCallOssService(){
        if (retrofitCallOssService==null){
            retrofitCallOssService=new RetrofitCallOssService();
        }
        return retrofitCallOssService;
    }
    public RetrofitRequestOssService getRetrofitRequestOssService(){
        retrofit2.Retrofit retrofit=new retrofit2.Retrofit.Builder()
                .baseUrl("http://www.zengwei123.top:8089/")
                .addConverterFactory(OutPutJsonConverterFactory.create())   //自定义的bean解析器
                .addConverterFactory(StringConverterFactory.create())       //字符串解析器
                .addConverterFactory(GsonConverterFactory.create())        //gson解析器
                .client(getOkHttpClient())
                .build();
        RetrofitRequestOssService retrofitRequestOssService=retrofit.create(RetrofitRequestOssService.class);
        return retrofitRequestOssService;
    }
    private OkHttpClient getOkHttpClient() {
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.retryOnConnectionFailure(true);  //重试一次
        httpClientBuilder.addInterceptor(new AddQueryParameterInterceptor()); //拦截器  添加请求头
        httpClientBuilder .connectTimeout(10, TimeUnit.SECONDS);  //连接超时时间
        httpClientBuilder .readTimeout(20, TimeUnit.SECONDS);     //读取超时时间
        httpClientBuilder .writeTimeout(20, TimeUnit.SECONDS);    //写超时时间
        return httpClientBuilder.build();
    }
}
