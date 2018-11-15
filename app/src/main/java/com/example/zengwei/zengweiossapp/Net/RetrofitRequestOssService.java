package com.example.zengwei.zengweiossapp.Net;

import com.example.zengwei.zengweiossapp.Bean.OutPutJson;
import com.example.zengwei.zengweiossapp.Bean.User;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by zengwei on 2018/11/12.
 * 接口
 */

public interface RetrofitRequestOssService {
    @POST("SignIn")
    Call<OutPutJson<String>> SignIn(@Body User user);
    @POST("FatherQueryFile")
    Call<OutPutJson<List<String>>> FatherQueryFile();
    @POST("SonQueryFile")
    Call<OutPutJson<List<String>>> SonQueryFile(@Body RequestBody requestBody);
    @POST("PutFolder")
    Call<OutPutJson<List<String>>> PutFolder(@Body RequestBody requestBody);
    @POST("DeleteFile_1")
    Call<OutPutJson<List<String>>> DeleteFile_1(@Body RequestBody requestBody);
    @POST("DeleteFile_2")
    Call<OutPutJson<List<String>>> DeleteFile_2(@Body RequestBody requestBody);
    @POST("Share")
    Call<OutPutJson<List<String>>> Share(@Body RequestBody requestBody);
    @POST("Share1")
    Call<OutPutJson<List<String>>> Share1(@Body RequestBody requestBody);
}
