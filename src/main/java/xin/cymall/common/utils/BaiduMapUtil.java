package xin.cymall.common.utils;

import com.google.gson.JsonArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2019/7/26.
 */
public class BaiduMapUtil {

    public static String get_point_url = "http://api.map.baidu.com/geocoding/v3";
    public static String ak = "MBGPZFWMZivzdW1ZVKPkUGsPIvvTRxgj";

    public static String[] getPoint(String addr) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String url = get_point_url + "?address="+addr+"&ak="+ak+"&output=json";
        HttpGet get = new HttpGet(url);
        //3 请求+接受响应结果
        CloseableHttpResponse response = client.execute(get);
        //4 解析结果
        int code = response.getStatusLine().getStatusCode();
        System.out.println(code);
        String[] location = new String[]{};
        if(code == 200) {
            HttpEntity entity = response.getEntity();
            String locationJsonStr = EntityUtils.toString(entity);
            System.out.println(locationJsonStr);
            JSONObject returnJson = JSONObject.fromObject(locationJsonStr);
            location[0] =  returnJson.getJSONObject("result").getJSONObject("location").getString("lng");
            location[1] =  returnJson.getJSONObject("result").getJSONObject("location").getString("lat");
            response.close();
            client.close();
        }
        response.close();
        client.close();
        return location;
    }

}
