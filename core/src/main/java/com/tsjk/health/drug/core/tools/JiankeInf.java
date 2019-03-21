package com.tsjk.health.drug.core.tools;

import com.alibaba.fastjson.JSONObject;
import com.ning.http.client.AsyncHttpClient;
import lombok.Data;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.tsjk.drug.api.entity.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang.RandomStringUtils;
import com.tsjk.health.drug.core.config.CustomsParamsConfig;
import org.springframework.stereotype.Service;
@Data
@Service
public class JiankeInf {

    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    AsyncHttpClient asyncHttpClient;

    @Autowired
    CustomsParamsConfig customParams;


    public void runAsync(JSONObject jsonObject) {

        //创建/Call
        Call call = okHttpClient.newCall(getRequest(jsonObject));
        //加入队列 异步操作
        call.enqueue(new Callback() {
            //请求错误回调方法
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("连接失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("请求成功：" + response.body().string());
            }
        });
    }


    public String runSync(JSONObject jsonObject) throws IOException {
        Response response = okHttpClient.newCall(getRequest(jsonObject)).execute();
        return  response.body().string();
    }

    private Request getRequest(JSONObject jsonObject){
        CustomKey params = customParams.getcustomParams();
        jsonObject.put("cid",params.getCid());
        jsonObject.put("randomStr",RandomStringUtils.randomAlphanumeric(10));
        String sign = getSign(jsonObject);
        String signValue = DigestUtils.md5Hex(sign).toUpperCase();
        jsonObject.put("sign", signValue);
        //MediaType  设置Content-Type 标头中包含的媒体类型值
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , jsonObject.toJSONString());

        Request request = new Request.Builder()
                .url(params.getUrl())//请求的url
                .post(requestBody)
                .build();
        return request;
    }

    private String getSign(JSONObject jsonObj) {
        CustomKey params = customParams.getcustomParams();
        ArrayList<String> array = new ArrayList<String>();
        jsonObj.forEach((k, v) -> {
            if (v != null) {
                array.add(k + "=" + v);
            }
        });
        String[] strArray = {};
        strArray = array.toArray(strArray);
        Arrays.sort(strArray);

        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str).append("&");
        }
        sb.append("key=");
        sb.append(params.getKey());
        return sb.toString();
    }
}
