package com.example.zengwei.zengweiossapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zengwei.zengweiossapp.Base.BaseApplaction;
import com.example.zengwei.zengweiossapp.Bean.OutPutJson;
import com.example.zengwei.zengweiossapp.Net.RetrofitCallOssService;
import com.example.zengwei.zengweiossapp.Util.JsonRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        retrofit2.Call<OutPutJson<String>> call=retrofitRequestOssService.SignIn(new User("zengwei","a123456"));
//        call.enqueue(new Callback<OutPutJson<String>>() {
//            @Override
//            public void onResponse(Call<OutPutJson<String>> call, Response<OutPutJson<String>> response) {
//                Log.d("zengwei","根目录"+response.body().getDate().toString());
//            }
//
//            @Override
//            public void onFailure(Call<OutPutJson<String>> call, Throwable t) {
//                Log.d("zengwei","根目录11");
//            }
//        });

//        Call<OutPutJson<List<String>>> call=RetrofitCallOssService.retrofitRequestOssService.FatherQueryFile();
//        call.enqueue(new Callback<OutPutJson<List<String>>>() {
//            @Override
//            public void onResponse(Call<OutPutJson<List<String>>> call, Response<OutPutJson<List<String>>> response) {
//                Log.d("zengwei","根目录"+response.body().getDate().toString());
//            }
//
//            @Override
//            public void onFailure(Call<OutPutJson<List<String>>> call, Throwable t) {
//                Log.d("zengwei","根目录获取失败");
//            }
//        });
        retrofit2.Call<OutPutJson<List<String>>> call1=RetrofitCallOssService.
                getRetrofitCallOssService().
                getRetrofitRequestOssService().
                SonQueryFile(JsonRequest.getJsonRequest().getRequestBody("name","https工具"));
        call1.enqueue(new Callback<OutPutJson<List<String>>>() {
            @Override
            public void onResponse(Call<OutPutJson<List<String>>> call, Response<OutPutJson<List<String>>> response) {
                Log.d("zengwei","根目录"+response.body().getDate().toString());
            }

            @Override
            public void onFailure(Call<OutPutJson<List<String>>> call, Throwable t) {
                    Log.d("zengwei","根目录获取失败");
            }
        });

    }
}
