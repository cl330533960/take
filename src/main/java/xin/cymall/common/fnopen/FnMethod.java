package xin.cymall.common.fnopen;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.message.BasicNameValuePair;
import xin.cymall.common.fnopen.config.ElemeOpenConfig;
import xin.cymall.common.fnopen.config.RequestConstant;
import xin.cymall.common.fnopen.request.*;
import xin.cymall.common.fnopen.response.TokenResponse;
import xin.cymall.common.fnopen.sign.OpenSignHelper;
import xin.cymall.common.fnopen.util.HttpClient;
import xin.cymall.common.fnopen.util.HttpClientRuntimeException;
import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.RandomUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class FnMethod {
    private static final Log logger = LogFactory.getLog(FnMethod.class);

    /**
     * 请求生成token
     * TODO token存入Redis
     */
    public static void GetToken() {

        try {

            String url = ElemeOpenConfig.API_URL + RequestConstant.OBTAIN_TOKEN;

            String salt = String.valueOf(RandomUtils.getInstance().generateValue(1000, 10000));
            String sig = OpenSignHelper.generateSign(ElemeOpenConfig.APP_ID, salt, ElemeOpenConfig.SECRET_KEY);

            // 请求token
            List<BasicNameValuePair> paramsToken = new ArrayList<>();
            paramsToken.add(new BasicNameValuePair("app_id", ElemeOpenConfig.APP_ID));
            paramsToken.add(new BasicNameValuePair("salt", salt));
            paramsToken.add(new BasicNameValuePair("signature", sig));

            String tokenRes = "";
            try {
                tokenRes = HttpClient.get(url, paramsToken);
            } catch (Exception e) {
                throw new HttpClientRuntimeException("请求token出现异常", e);
            }

            logger.info(String.format("Response is %s", tokenRes));

            /**
             * 生成token
             */
            String token = JsonUtils.getInstance().readValue(tokenRes, TokenResponse.class).getData().getAccess_token();

            logger.info(String.format("Generate token is: %s", token));

        } catch (Exception e) {
            logger.error("Generate token Exception: %s", e);
        }

    }


    /**
     * 推送一个订单
     * <p>
     * TODO 参数token 需要从Redis获取
     * TODO 参数 elemeCreateOrderRequest 需要自己封装 下面方法中的数据可以作为参考 在调用的时候就要封装好 然后直接传过来
     * TODO 到时候直接把下面get/set 的代码删了
     * TODO 下面方法做类似处理
     *
     * @param token
     * @param elemeCreateOrderRequest 数据对象全部都封装在里面
     */

    public void CreateOrder(String token, ElemeCreateOrderRequest elemeCreateOrderRequest) {

        try {


            /**
             * 将参数构造成一个json
             */
            ElemeCreateOrderRequest.ElemeCreateRequestData data = new ElemeCreateOrderRequest.ElemeCreateRequestData();
            data.setUuid("123456789-uuid");
            /**
             * transportInfo
             */
            ElemeCreateOrderRequest.TransportInfo transportInfo = new ElemeCreateOrderRequest.TransportInfo();
            // 配送点id
            transportInfo.setTransport_id("17409854");
            transportInfo.setTransport_name("m05"); // 花+专用门店名称
            transportInfo.setTransport_address("300弄亚都国际名园5号楼2003室");
            transportInfo.setTransport_tel("13900000000");
            data.setChain_store_code("68998");
            /**
             * 31.2461955,121.3847637;31.2441408,121.3766956;31.2306375,121.3718891;
             * 31.2243255,121.3770389;31.2226374,121.3869094;31.2261605,121.391201;
             * 31.2403249,121.3933467;31.2461955,121.3847637
             */
            transportInfo.setTransport_longitude(new BigDecimal(121.38164));
            transportInfo.setTransport_latitude(new BigDecimal(31.2328));
            transportInfo.setTransport_remark("备注");
            transportInfo.setPosition_source(3);

            /**
             * receiverInfo
             */
            ElemeCreateOrderRequest.ReceiverInfo receiverInfo = new ElemeCreateOrderRequest.ReceiverInfo();
            receiverInfo.setReceiver_address("上海近铁广场");
            receiverInfo.setReceiver_name("jiabuchong");
            receiverInfo.setReceiver_primary_phone("13900000000");
            receiverInfo.setReceiver_second_phone("13911111111");
            receiverInfo.setReceiver_longitude(new BigDecimal(121.38164));
            receiverInfo.setReceiver_latitude(new BigDecimal(31.2328));
            receiverInfo.setPosition_source(1);

            /**
             * itemsJson
             */
            // items array
            ElemeCreateOrderRequest.ItemsJson[] itemsJsons = new ElemeCreateOrderRequest.ItemsJson[2];
            ElemeCreateOrderRequest.ItemsJson item = new ElemeCreateOrderRequest.ItemsJson();
            item.setItem_name("香蕉");
            item.setItem_quantity(5);
            item.setItem_actual_price(new BigDecimal(9.50));
            item.setItem_price(new BigDecimal(10.00));
            item.setIs_agent_purchase(0);
            item.setIs_need_package(0);
            item.setCold_chain(1);
            item.setWeight(100);

            ElemeCreateOrderRequest.ItemsJson item1 = new ElemeCreateOrderRequest.ItemsJson();
            item1.setItem_name("苹果");
            item1.setItem_quantity(5);
            item1.setItem_actual_price(new BigDecimal(9.50));
            item1.setItem_price(new BigDecimal(10.00));
            item1.setIs_agent_purchase(0);
            item1.setIs_need_package(0);
            item.setCold_chain(0);
            item.setWeight(101);

            itemsJsons[0] = item;
            itemsJsons[1] = item1;

            data.setTransport_info(transportInfo);
            data.setReceiver_info(receiverInfo);
            data.setItems_json(itemsJsons);

            data.setPartner_remark("hi, 咱们好好合作哦, 嘿嘿");
            String str = "test" + System.currentTimeMillis();
            System.out.println(str);
            data.setPartner_order_code(str);
            data.setNotify_url("http://192.168.104.133:5000");

            /**
             * 1: 蜂鸟配送, 未向饿了么物流平台查询过站点的订单，支持两小时送达,
             * 提前向饿了么物流平台查询过配送站点的订单，支持次日送达
             */
            data.setOrder_type(1); // 1、普通商户即时送；2、花+商户 定点送
            data.setOrder_total_amount(new BigDecimal(50.00));
            data.setOrder_actual_amount(new BigDecimal(48.00));
            data.setOrder_weight(new BigDecimal(3));
            data.setOrder_remark("一定送到哦");
            data.setIs_invoiced(0); // 是否需要发票0：不需要；1：需要
            data.setInvoice("伟大的公司");
            data.setOrder_payment_status(1);
            data.setOrder_payment_method(1);
            data.setIs_agent_payment(0); // 是否需要承运商代收货款 0：否
            data.setRequire_payment_pay(new BigDecimal(50.00));
            data.setGoods_count(4);

            //data.setRequire_receive_time(LocalDateTime.now().plusHours(48).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()); // 预计送达时间

            LocalDateTime time = LocalDateTime.now().plusDays(3).withHour(0).withMinute(0).withSecond(0).withNano(0);
//		data.setRequire_receive_time(Timestamp.valueOf(time).getTime());

            // data.setOrder_add_time(new Date().getTime());

            ElemeCreateOrderRequest request = new ElemeCreateOrderRequest();
            request.setData(data);
            logger.info(String.format("urlencode string is %s", request.getData()));

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);
            request.setApp_id(ElemeOpenConfig.APP_ID);
            request.setSalt(salt);

            /**
             * 生成签名
             */
            Map<String, Object> sigStr = new LinkedHashMap<>(); // 注意添加的顺序,
            // 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", ElemeOpenConfig.APP_ID);
            sigStr.put("access_token", token); // 需要使用前面请求生成的token
            sigStr.put("data", request.getData());
            sigStr.put("salt", salt);
            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            request.setSignature(sig);

            String requestJson = JsonUtils.getInstance().objectToJson(request);
            logger.info(String.format("request json is %s", requestJson));

            String url = ElemeOpenConfig.API_URL + RequestConstant.ORDER_CREATE;
            String postRespone = HttpClient.postBody(url, requestJson);
            logger.info("creating order request postRespone:" + postRespone);

        } catch (Exception e) {
            logger.error("creating order exception:" + e);
        }
    }

    /**
     * 取消订单
     *
     * @param partner_order_code 推单时 第三方订单号
     * @param token
     ***/
    public static void CancelOrder(String partner_order_code, String token) {

        try {

            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;
            //String partner_order_code = "44451479289481540";  //推单时 第三方订单号
            //String token = "bdc94751-c82a-4cb8-b09a-e438ea062a71";

            CancelOrderRequest.CancelOrderRequestData data = new CancelOrderRequest.CancelOrderRequestData();
            data.setOrder_cancel_description("货品不新鲜");
            data.setOrder_cancel_reason_code(2);
            //data.setOrder_cancel_code(0);
            data.setPartner_order_code(partner_order_code);
            data.setOrder_cancel_time(new Date().getTime());

            CancelOrderRequest cancelOrderRequest = new CancelOrderRequest();
            cancelOrderRequest.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);

            Map<String, Object> sigStr = new LinkedHashMap<>();      // 注意添加的顺序, 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token);        // 需要使用前面请求生成的token
            sigStr.put("data", cancelOrderRequest.getData());
            sigStr.put("salt", salt);

            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            cancelOrderRequest.setSignature(sig);

            cancelOrderRequest.setApp_id(appId);
            cancelOrderRequest.setSalt(salt);

            String requestJson = JsonUtils.getInstance().objectToJson(cancelOrderRequest);
            url = url + RequestConstant.ORDER_CANCEL;

            String res = HttpClient.postBody(url, requestJson);
            logger.info(String.format("^_^, reponse data: %s", res));

        } catch (Exception e) {
            logger.error("取消订单出现异常", e);
        }
    }

    /**
     * 配送距离查询
     **/
    public static void testDistanceQuery(String token) {
        try {


            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;
//        String token = "85af163d-3af9-4f40-808e-5a1a4bf7d508";

            DistanceQueryRequest.DistanceQueryRequestData data = new DistanceQueryRequest.DistanceQueryRequestData();
  /*      data.setChain_store_code("A001");
        //data.setChain_store_name("优送测试");
        data.setPosition_source(3);
        data.setReceiver_latitude("39.810772");
        data.setReceiver_longitude("116.0957051");*/
            data.setChain_store_code("1");
            data.setPosition_source(3);
            data.setReceiver_latitude("40.03841");
            data.setReceiver_longitude("116.308406");
            DistanceQueryRequest distanceQueryRequest = new DistanceQueryRequest();
            distanceQueryRequest.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);

            Map<String, Object> sigStr = new LinkedHashMap<>();      // 注意添加的顺序, 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token);        // 需要使用前面请求生成的token
            sigStr.put("data", distanceQueryRequest.getData());
            sigStr.put("salt", salt);

            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            distanceQueryRequest.setSignature(sig);

            distanceQueryRequest.setApp_id(appId);
            distanceQueryRequest.setSalt(salt);

            String requestJson = JsonUtils.getInstance().objectToJson(distanceQueryRequest);
            url = url + RequestConstant.DISTANCE_QUERY;

            String res = HttpClient.postBody(url, requestJson);
            logger.info(String.format("^_^, reponse data: %s", res));

        } catch (Exception e) {

            logger.error("查询订单超距异常", e);
        }
    }

    /**
     * g更新门店信息
     *
     * @param token
     **/
    public static void updateChainStore(String token) {

        try {

            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;
//        String token = "934577b2-5a12-4e3e-8b4b-2cb6ba0106ec";
            UpdateChainStoreRequest.UpdateChainStoreRequestData data = new UpdateChainStoreRequest.UpdateChainStoreRequestData();

            data.setChain_store_code("A001");
//        data.setChain_store_name("优送测试");
//        data.setPosition_source(3);
            data.setAddress("优送测试地址更新");
//        data.setLongitude("116.1653137000");
//        data.setLatitude("39.8103104000");
//        data.setContact_phone("13810698499");
//        data.setService_code();
            UpdateChainStoreRequest request = new UpdateChainStoreRequest();
            request.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);

            Map<String, Object> sigStr = new LinkedHashMap<>();      // 注意添加的顺序, 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token);        // 需要使用前面请求生成的token
            sigStr.put("data", request.getData());
            sigStr.put("salt", salt);

            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            request.setSignature(sig);

            request.setApp_id(appId);
            request.setSalt(salt);

            String requestJson = JsonUtils.getInstance().objectToJson(request);
            url = url + RequestConstant.CHAIN_STORE_UPDATE;

            String res = HttpClient.postBody(url, requestJson);
            logger.info(String.format("^_^, reponse data: %s", res));

        } catch (Exception e) {
            logger.error("查询订单超距异常", e);
        }
    }

    /**
     * 订单查询
     *
     * @param partner_order_code 推单时 第三方订单号
     * @param token
     **/
    public static void testQueryOrder(String partner_order_code, String token) {
        try {
            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;
//            String partner_order_code = "test1532442182843";  //推单时 第三方订单号
//            String token = "68268c14-bc20-4660-b944-c1c92a70e9f5";

            ElemeQueryOrderRequest request = new ElemeQueryOrderRequest();
            ElemeQueryOrderRequest.ElemeQueryRequestData data = new ElemeQueryOrderRequest.ElemeQueryRequestData();
            data.setPartner_order_code(partner_order_code);
            request.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);
            request.setApp_id(ElemeOpenConfig.APP_ID);
            request.setSalt(salt);

            /**
             * 生成签名
             */
            Map<String, Object> sigStr = new LinkedHashMap<>();      // 注意添加的顺序, 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token);        // 需要使用前面请求生成的token
            sigStr.put("data", request.getData());
            sigStr.put("salt", salt);
            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            request.setSignature(sig);

            String requestJson = JsonUtils.getInstance().objectToJson(request);

            url = url + RequestConstant.ORDER_QUERY;
            String postRespone = HttpClient.postBody(url, requestJson);
            logger.info("get order info :" + postRespone);

        } catch (Exception e) {
            throw new HttpClientRuntimeException("get order info exception:", e);
        }
    }

    /**
     * 查询
     * 配送费
     *
     * @param token
     **/
    public static void QueryPrice(String token) {
        try {


            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;
//        String token = "68268c14-bc20-4660-b944-c1c92a70e9f5";

            ElemeQueryPriceQuery request = new ElemeQueryPriceQuery();
            ElemeQueryPriceQuery.ElemeQueryRequestData data = new ElemeQueryPriceQuery.ElemeQueryRequestData();
            data.setOrder_price(122.3);
            data.setReceiver_latitude(31.233676);
            data.setReceiver_longitude(121.38214);
            data.setTransport_latitude(31.233676);
            data.setTransport_longitude(121.38214);
            request.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);
            request.setApp_id(ElemeOpenConfig.APP_ID);
            request.setSalt(salt);

            /**
             * 生成签名
             */
            Map<String, Object> sigStr = new LinkedHashMap<>();      // 注意添加的顺序, 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token);        // 需要使用前面请求生成的token
            sigStr.put("data", request.getData());
            sigStr.put("salt", salt);
            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            request.setSignature(sig);

            String requestJson = JsonUtils.getInstance().objectToJson(request);

            url = url + RequestConstant.PREDICT_PRICE;
            String responce = HttpClient.postBody(url, requestJson);
            logger.info("QueryPrice：" + responce);

        } catch (Exception e) {
            logger.error("QueryPrice exception", e);
        }
    }

    /**
     * 查询骑手信息
     *
     * @param partner_order_code
     **/
    public static void QueryCarrier(String partner_order_code, String token) {
        try {
            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;
//        String partner_order_code = "DO6404104";  //推单时 第三方订单号
//        String token = "9a033f4c-8e62-42dd-a989-230b8c7200dc";

            ElemeQueryCarrierRequest request = new ElemeQueryCarrierRequest();
            ElemeQueryCarrierRequest.ElemeQueryRequestData data = new ElemeQueryCarrierRequest.ElemeQueryRequestData();
            data.setPartner_order_code(partner_order_code);
            request.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);
            request.setApp_id(ElemeOpenConfig.APP_ID);
            request.setSalt(salt);

            /**
             * 生成签名
             */
            Map<String, Object> sigStr = new LinkedHashMap<>();      // 注意添加的顺序, 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token);        // 需要使用前面请求生成的token
            sigStr.put("data", request.getData());
            sigStr.put("salt", salt);
            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            request.setSignature(sig);

            String requestJson = JsonUtils.getInstance().objectToJson(request);

            url = url + RequestConstant.QUERY_CARRIER;

            String responce = HttpClient.postBody(url, requestJson);
            logger.info("get QueryCarrier: " + responce);
        } catch (Exception e) {
            logger.info("get QueryCarrier exception:", e);
        }
    }


    /**
     * 查询骑手位置信息
     **/
    public static void QueryCarrierTrace(String partner_order_code, String token) {
        try {

            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;
//        String partner_order_code = "test1532418937335";  //推单时 第三方订单号
//        String token = "c8cab349-ab4f-4493-9fcc-afb0090d7224";

            ElemeQueryCarrierRequest request = new ElemeQueryCarrierRequest();
            ElemeQueryCarrierRequest.ElemeQueryRequestData data = new ElemeQueryCarrierRequest.ElemeQueryRequestData();
            data.setPartner_order_code(partner_order_code);
            request.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);
            request.setApp_id(ElemeOpenConfig.APP_ID);
            request.setSalt(salt);

            /**
             * 生成签名
             */
            Map<String, Object> sigStr = new LinkedHashMap<>();      // 注意添加的顺序, 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token);        // 需要使用前面请求生成的token
            sigStr.put("data", request.getData());
            sigStr.put("salt", salt);
            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            request.setSignature(sig);

            String requestJson = JsonUtils.getInstance().objectToJson(request);

            url = url + RequestConstant.QUERY_TRACE;

            String response = HttpClient.postBody(url, requestJson);
            logger.info("QUERY_TRACE :" + response);
        } catch (Exception e) {
            logger.error("查询订单出现异常", e);
        }
    }

    /**
     * 投诉订单
     **/
    public void ComplaintOrder(String partner_order_code, String token) {
        try {
            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;
//        String partner_order_code = "44451479289481540";  //推单时 第三方订单号
//        String token = "bdc94751-c82a-4cb8-b09a-e438ea062a71";

            OrderComplaintRequest.OrderComplaintRequestData data = new OrderComplaintRequest.OrderComplaintRequestData();
            data.setPartner_order_code(partner_order_code);
            data.setOrder_complaint_code(150);
            //data.setOrder_complaint_desc("");
            data.setOrder_complaint_time(new Date().getTime());

            OrderComplaintRequest orderComplaintRequest = new OrderComplaintRequest();
            orderComplaintRequest.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);

            Map<String, Object> sigStr = new LinkedHashMap<>();      // 注意添加的顺序, 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token);        // 需要使用前面请求生成的token
            sigStr.put("data", orderComplaintRequest.getData());
            sigStr.put("salt", salt);

            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            orderComplaintRequest.setSignature(sig);

            orderComplaintRequest.setApp_id(appId);
            orderComplaintRequest.setSalt(salt);

            String requestJson = JsonUtils.getInstance().objectToJson(orderComplaintRequest);
            url = url + RequestConstant.ORDER_COMPLAINT;
            String res = HttpClient.postBody(url, requestJson);
            logger.info(String.format("^_^, reponse data: %s", res));
        } catch (Exception e) {
            throw new HttpClientRuntimeException("投诉订单出现异常", e);
        }
    }

    /**
     * 查询门店配送范围
     *
     * @param store_code 门店code
     **/
    public static void GetChainStoreRange(String token, String store_code) {
        try {

            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;
//        String token = "d64e8a79-65f7-4523-b041-54d0d6458a40";

            ChainStoreRangeRequest.ChainStoreRangeData data = new ChainStoreRangeRequest.ChainStoreRangeData();
            data.setChain_store_code(store_code);

            ChainStoreRangeRequest copyChainStoreRequest = new ChainStoreRangeRequest();
            copyChainStoreRequest.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);

            Map<String, Object> sigStr = new LinkedHashMap<>(); // 注意添加的顺序,
            // 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token); // 需要使用前面请求生成的token
            sigStr.put("data", copyChainStoreRequest.getData());
            sigStr.put("salt", salt);

            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            copyChainStoreRequest.setSignature(sig);

            copyChainStoreRequest.setApp_id(appId);
            copyChainStoreRequest.setSalt(salt);

            String requestJson = JsonUtils.getInstance().objectToJson(copyChainStoreRequest);
            url = url + RequestConstant.CHAIN_STORE_RANGE;
            String res = HttpClient.postBody(url, requestJson);
            logger.info(String.format("^_^, reponse data: %s", res));
        } catch (Exception e) {
            throw new HttpClientRuntimeException("添加门店信息出现异常", e);
        }
    }


    /**
     * 添加门店信息
     **/
    public void AddChainStore(String token) {
        try {
            String appId = ElemeOpenConfig.APP_ID;
            String url = ElemeOpenConfig.API_URL;

            AddChainStoreRequest.AddChainStoreData data = new AddChainStoreRequest.AddChainStoreData();
            data.setChain_store_code("A001");
            data.setChain_store_name("web-base-test");
            data.setChain_store_type(1);
            //data.setMerchant_code();
            data.setContact_phone("12345678");
            data.setAddress("300弄亚都国际名园5号楼2003室");
            data.setLongitude("121.3718891000");
            data.setLatitude("31.2306375000");
            data.setPosition_source(3);
            data.setService_code("1");

            AddChainStoreRequest addChainStoreRequest = new AddChainStoreRequest();
            addChainStoreRequest.setData(data);

            int salt = RandomUtils.getInstance().generateValue(1000, 10000);

            Map<String, Object> sigStr = new LinkedHashMap<>(); // 注意添加的顺序,
            // 应该如下面一样各个key值顺序一致
            sigStr.put("app_id", appId);
            sigStr.put("access_token", token); // 需要使用前面请求生成的token
            sigStr.put("data", addChainStoreRequest.getData());
            sigStr.put("salt", salt);

            // 生成签名
            String sig = OpenSignHelper.generateBusinessSign(sigStr);
            addChainStoreRequest.setSignature(sig);

            addChainStoreRequest.setApp_id(appId);
            addChainStoreRequest.setSalt(salt);

            String requestJson = JsonUtils.getInstance().objectToJson(addChainStoreRequest);
            url = url + RequestConstant.ADD_CHAIN_STORE;
            String res = HttpClient.postBody(url, requestJson);
            logger.info(String.format("^_^, reponse data: %s", res));
        } catch (Exception e) {
            throw new HttpClientRuntimeException("添加门店信息出现异常", e);
        }
    }
      /**
       *查询门店信息
       * @param  list 门店编号集合
       **/
    public void  QueryOrder(List<String> list,String token )   {
        try {

        String appId = ElemeOpenConfig.APP_ID;
        String url = ElemeOpenConfig.API_URL;
        List<String> chain_store_code =list;
//        List<String> chain_store_code = Arrays.asList("10000", "10001");// 门店编号集合
//        String token = "020c8d6d-9ed1-49bd-940d-e579798e27ca";

        ElemeQueryChainStoreRequest request = new ElemeQueryChainStoreRequest();
        ElemeQueryChainStoreRequest.ElemeQueryRequestData data = new ElemeQueryChainStoreRequest.ElemeQueryRequestData();
        data.setChain_store_code(chain_store_code);
        request.setData(data);

        int salt = RandomUtils.getInstance().generateValue(1000, 10000);
        request.setApp_id(ElemeOpenConfig.APP_ID);
        request.setSalt(salt);

        /**
         * 生成签名
         */
        Map<String, Object> sigStr = new LinkedHashMap<>(); // 注意添加的顺序,
        // 应该如下面一样各个key值顺序一致
        sigStr.put("app_id", appId);
        sigStr.put("access_token", token); // 需要使用前面请求生成的token
        sigStr.put("data", request.getData());
        sigStr.put("salt", salt);
        // 生成签名
        String sig = OpenSignHelper.generateBusinessSign(sigStr);
        request.setSignature(sig);

        String requestJson = JsonUtils.getInstance().objectToJson(request);

        url = url + RequestConstant.QUERY_CHAIN_STORE;
          String response =   HttpClient.postBody(url, requestJson);
          logger.info("QUERY_CHAIN_STORE:"+response);
        } catch (Exception e) {
            throw new HttpClientRuntimeException("查询门店出现异常", e);
        }
    }

}
