package com.example.zengwei.zengweiossapp.Net.Converters;

import com.example.zengwei.zengweiossapp.Bean.OutPutJson;
import com.example.zengwei.zengweiossapp.Util.ZwGson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by zengwei on 2018/11/12.
 */

public class OutPutJsonConverter<T> implements Converter<ResponseBody,OutPutJson<T>> {
    public static final OutPutJsonConverter INSTANCE = new OutPutJsonConverter();
    @Override
    public OutPutJson<T> convert(ResponseBody value) throws IOException {
        return ZwGson.GsonToBean(value.string(), OutPutJson.class);
    }
}
