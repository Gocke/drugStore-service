
import com.alibaba.fastjson.JSONObject;
import com.ning.http.client.AsyncHttpClient;
import com.tsjk.drug.api.entity.jianke.CancelOrderParams;
import com.tsjk.drug.api.entity.jianke.OrdersParams;
import com.tsjk.health.drug.core.DrugCoreApplication;
import lombok.ToString;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tsjk.drug.api.entity.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.tsjk.health.drug.core.tools.JiankeInf;
import com.tsjk.health.drug.core.sevice.*;

/**
 * @author Caine
 * @date 2019/3/2
 * @desc
 */
@SpringBootTest(classes = DrugCoreApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    AsyncHttpClient asyncHttpClient;


    @Autowired
    JiankeSearchSevice seviceTool;


    @Test
    public void entity(){
        /*OrdersParams ordersParams = new OrdersParams();
        ordersParams.setOrderNo("6619076493371078,");
        System.out.println(ordersParams);*/
        CancelOrderParams cancelOrderParams = new CancelOrderParams();
        System.out.println(cancelOrderParams);
    }

    @Test
    public void testService(){

        //订单号查询
//        seviceTool.findOrderByno("6619076493371078");
//        //订单批量查询
//        seviceTool.findBatchOrderByno("1234,456");
//        //
        /*PartnerOrderList partnerOrderList = seviceTool.findPartnerOrder("2018-12-15 00:00:00",10);
        System.out.println(partnerOrderList);*/
//        //产品查询
//        seviceTool.findProduct("28");
//        //产品批量查询
//        seviceTool.findBatchProduct("11692,28,19");
//        //同步产品查询
//        seviceTool.findSyncProduct(2,2);
//          //订单物流轨迹查询
//          seviceTool.findLogistics("3817110132838953");


        String myOrderNo = "a1b9925c";

        //订单推送
        ArrayList<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setActualPrice(10);
        orderProduct.setAmount(100);
        orderProduct.setPacking("2");
        orderProduct.setProductCode("10350");
        orderProduct.setProductName("测试产品1");
        orderProductList.add(orderProduct);
        OrderexternalResult orderPush = seviceTool.orderPush(myOrderNo,"1234567",
                "5478632",500,"2017-3-23 18:24:27",
                "111111","测试","","13749550796",
                "广东省","广州市","天河区","猎德大道","广东省广州市天河区猎德大道111号",
                1,"2",10,orderProductList);

        System.out.println(orderPush);

        try {
            //等待5s取消订单
            Thread.sleep(5 *  1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //取消未支付订单
        String result = seviceTool.cancelOrder(orderPush.getOrderNo(),myOrderNo);
        System.out.println(result);

    }


    @Test
    public void runAsync() {

        //创建/Call
        Call call = okHttpClient.newCall(getRequest());
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

        //纯粹做延迟等待，实际应用去掉
        try {
            Thread.sleep(2 * 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    @Test
    public void runSync() throws IOException {
        Response response = okHttpClient.newCall(getRequest()).execute();
        String result = response.body().string();
        System.out.println(result);
        //OrderList sync = JSONObject.parseObject(result,OrderList.class);
      //  System.out.println(sync);
    }

    private Request getRequest(){

        JSONObject jsonObject = new JSONObject();
        //jsonObject.put("method", "jianke.product.sync");
        jsonObject.put("method", "jianke.product.getBatchList");

        jsonObject.put("cid", "tsjk001");
        jsonObject.put("signMethod", "md5");
        jsonObject.put("productCode", "11692,28,119");
        jsonObject.put("randomStr", "l451m89l");
        jsonObject.put("page", 0);
        jsonObject.put("size", 10);

        String sign = getSign(jsonObject);
        System.out.println(sign);
        String signValue = DigestUtils.md5Hex(sign).toUpperCase();
        System.out.println(signValue);
        jsonObject.put("sign", signValue);

        System.out.println(jsonObject.toJSONString());

        //MediaType  设置Content-Type 标头中包含的媒体类型值
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , jsonObject.toJSONString());

        Request request = new Request.Builder()
                .url("http://openapi.tst.jianke.com/openApis/main")//请求的url
                .post(requestBody)
                .build();
        return request;
    }

    private String getSign(JSONObject jsonObject) {


        ArrayList<String> array = new ArrayList<String>();
        jsonObject.forEach((k, v) -> {
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

        sb.append("key=123456");

        return sb.toString();
    }

}
