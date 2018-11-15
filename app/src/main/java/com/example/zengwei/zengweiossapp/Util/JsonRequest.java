package com.example.zengwei.zengweiossapp.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by zengwei on 2018/11/14.
 * 请求传入JSON  自己服务器做的恶  真他妈
 */

public class JsonRequest {
    private JsonRequest(){}
    public static JsonRequest jsonRequest=getJsonRequest();

    public static JsonRequest getJsonRequest() {
        if(jsonRequest==null){
            jsonRequest=new JsonRequest();
        }
        return jsonRequest;
    }
    public RequestBody getRequestBody(String key,String value){
        JSONObject requestData = new JSONObject();
        try {
            requestData.put(key,value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RequestBody.create(MediaType.parse("application/json"),requestData.toString());
    }
}
