package xin.cymall.common.utils;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.gexin.rp.sdk.template.style.Style0;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AppPush
 * @Author cailei
 * @Description
 * @Date 2019/6/28 16:23
 **/
public class AppPush {

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = Constant.appId;
    private static String appKey = Constant.appKey;
    private static String masterSecret = Constant.masterSecret;
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    // 设置通知消息模板
	/*
	 * 1. appId
	 * 2. appKey
	 * 3. 要传送到客户端的 msg
	 * 3.1 标题栏：key = title,
	 * 3.2 通知栏内容： key = titleText,
	 * 3.3 穿透内容：key = transText
	 */
    private static NotificationTemplate getNotifacationTemplate(String appId, String appKey, Map<String, String> msg){
        // 在通知栏显示一条含图标、标题等的通知，用户点击后激活您的
        NotificationTemplate template = new NotificationTemplate();
        // 设置appid，appkey
        template.setAppId(appId);
        template.setAppkey(appKey);
        // 穿透消息设置为，1 强制启动应用
        template.setTransmissionType(1);
        // 设置穿透内容
        System.out.println(msg.get("title") + "::" + msg.get("titleText") + "::" + msg.get("transText"));
        template.setTransmissionContent(msg.get("transText"));
        // 设置style
        Style0 style = new Style0();
        // 设置通知栏标题和内容
        style.setTitle(msg.get("title"));
        style.setText(msg.get("titleText"));
        // 设置通知，响铃、震动、可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        // 设置
        template.setStyle(style);
        return template;
    }

    // 设置通知消息模板
	/*
	 * 1. appId
	 * 2. appKey
	 * 3. 要传送到客户端的 msg
	 * 3.1 标题栏：key = title,
	 * 3.2 通知栏内容： key = titleText,
	 * 3.3 穿透内容：key = transText
	 */
    private static TransmissionTemplate getTransmissionTemplatee(String appId, String appKey, Map<String, String> msg){
        // 在通知栏显示一条含图标、标题等的通知，用户点击后激活您的
        TransmissionTemplate template = new TransmissionTemplate();
        // 设置appid，appkey
        template.setAppId(appId);
        template.setAppkey(appKey);
        // 穿透消息设置为，1 强制启动应用
        // 设置穿透内容
        System.out.println(msg.get("title") + "::" + msg.get("titleText") + "::" + msg.get("transText"));
        template.setTransmissionContent(msg.get("transText"));
        template.setTransmissionType(2); // 这个Type为int型，填写1则自动启动app

        APNPayload payload = new APNPayload();
        //在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
        payload.setAutoBadge("+1");
        payload.setContentAvailable(1);
        payload.setSound("default");
        payload.setAlertMsg(getDictionaryAlertMsg());
        template.setAPNInfo(payload);
        return template;

    }
    /**
     *  消息设置
     */
    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg() {
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        alertMsg.setTitle("透传提醒");
        alertMsg.setBody("我是透传信息2");
        return alertMsg;
    }

    // 对单个用户推送消息
	/*
	 * 1. cid
	 * 2. 要传到客户端的 msg
	 * 2.1 标题栏：key = title,
	 * 2.2 通知栏内容： key = titleText,
	 * 2.3 穿透内容：key = transText
	 */
    public IPushResult pushMsgToSingle(String cid, Map<String, String> msg) {
        // 代表在个推注册的一个 app，调用该类实例的方法来执行对个推的请求
        IGtPush push = new IGtPush(appKey, masterSecret);
        // 创建信息模板
        NotificationTemplate template = getNotifacationTemplate(appId, appKey, msg);
        //定义消息推送方式为，单推
        SingleMessage message = new SingleMessage();
        // 设置推送消息的内容
        message.setData(template);
        // 设置推送目标
        Target target = new Target();
        target.setAppId(appId);
        // 设置cid
        target.setClientId(cid);
        // 获得推送结果
        IPushResult result = push.pushMessageToSingle(message, target);
		/*
		 * 1. 失败：{result=sign_error}
		 * 2. 成功：{result=ok, taskId=OSS-0212_1b7578259b74972b2bba556bb12a9f9a, status=successed_online}
		 * 3. 异常
		 */
        return result;
    }

    public static void main(String[] args) {
        AppPush appPush = new AppPush();
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("title","顶");
        hashMap.put("titleText","顶你");
        hashMap.put("transText","顶你个肺");
        appPush.pushMsgToSingle("faff30fc9e7c2f8e763ae04dfad57494", hashMap);
    }
}
