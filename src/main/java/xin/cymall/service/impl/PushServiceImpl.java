package xin.cymall.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.cymall.common.fnopen.util.HttpClient;
import xin.cymall.common.utils.*;
import xin.cymall.service.PushService;

/**
 * @ClassName PushUtil
 * @Author cailei
 * @Description
 * @Date 2019/6/28 11:26
 **/
@Service
public class PushServiceImpl implements PushService {

    @Autowired
    private RedisService redisService;

    private Logger logger = Logger.getLogger(getClass());


    public void pushMsg(String title, String text, String cid) {
        cid = "faff30fc9e7c2f8e763ae04dfad57494";
        String url = "https://restapi.getui.com/v1/" + Constant.appId + "/push_single";
        String json = " {\n" +
                "            \"message\": {\n" +
                "            \"appkey\": \"" + Constant.appKey + "\",\n" +
                "                    \"is_offline\": true,\n" +
                "                    \"offline_expire_time\": 10000000,\n" +
                "                    \"msgtype\": \"notification\"\n" +
                "        },\n" +
                "            \"notification\": {\n" +
                "            \"style\": {\n" +
                "                        \"type\": 0,\n" +
                "                        \"text\": \"" + text + "\",\n" +
                "                        \"title\": \"" + title + "\",\n" +
                "                        \"is_ring\": true,\n" +
                "                        \"is_vibrate\": true,\n" +
                "                        \"is_clearable\": true" +

                "            },\n" +
                "            \"transmission_type\": true,\n" +
                "                    \"transmission_content\": \"透传内容\"\n" +
                "        },\n" +
                "            \"cid\": \"" + cid + "\",\n" +
                "                \"requestid\": \"" + UUID.generateId() + "\"\n" +
                "        }";

        String encoding = "UTF-8";
        String authtoken = getPushToken();
        if (!StringUtil.isEmpty(authtoken))
            logger.info(HttpClient.jsonPost(url, authtoken, json, encoding));

    }

    public String getPushToken() {
        String token = (String) redisService.get(Constant.GETUI_KEY);
        if (!StringUtil.isEmpty(token)) {
            return token;
        }
        String appKey = Constant.appKey;
        String masterSecret = Constant.masterSecret;
        String url = "https://restapi.getui.com/v1/" + Constant.appId + "/auth_sign";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String sign = appKey + timestamp + masterSecret;
        String json = "{\"sign\":\"" + Sha256.getSHA256(sign) + "\", \"timestamp\":\"" + timestamp + "\",\"appkey\":\"" + appKey + "\"}";
        String encoding = "UTF-8";
        com.alibaba.fastjson.JSONObject jsonObject = HttpClient.jsonPost(url, "", json, encoding);
        String result = jsonObject.getString("result");
        if (result.equals("ok")) {
            String authToken = jsonObject.getString("auth_token");
            redisService.set(Constant.GETUI_KEY, authToken, 1000L * 60 * 60 * 24);
            return authToken;
        } else {
            logger.error("获取授权失败");
            return "";
        }

    }
}
