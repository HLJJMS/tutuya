package com.tutuya.tck.base.test;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @version 1.0
 * @author  tyh
 * @功能：解析基础类
 * @date 创建时间：2019/4/12
 */
final class CustomResponseConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private TypeAdapter<T> adapter;
    private Type mType;

    CustomResponseConverter(Gson gson, TypeAdapter<T> mAdapter, Type mType) {
        this.gson = gson;
        this.adapter = mAdapter;
        this.mType = mType;
    }
    @Override
    public T convert(ResponseBody value) throws IOException {


        try {
            String body = value.string();
            JSONObject json = new JSONObject(body);
            Log.e("我是body", "convert: "+body );
            String code = json.getString("errorcode");
            String message = json.getString("errormessage");
            if (code.equals("200")) {
                return gson.fromJson(body, mType);
            } else {
                StringBuffer stringBuffer =new StringBuffer();
                stringBuffer.append("{\"errorcode\":").append(code).append(",\"errormessage\":\"").append(message).append("\"}");
                Log.e("我是工厂拼接的字符串",stringBuffer.toString());
                return gson.fromJson(stringBuffer.toString(),mType);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            value.close();
        }

    }}
