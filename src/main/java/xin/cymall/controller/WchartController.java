package xin.cymall.controller;

import com.alibaba.fastjson.JSONArray;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.cymall.common.utils.MessageUtil;
import xin.cymall.common.utils.TextMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/wx")
public class WchartController {


    @RequestMapping("/auth")
    @ResponseBody
    public String auth(@RequestParam(value ="signature" ,required = false)  String signature,
                      @RequestParam(value ="timestamp" ,required = false)  String timestamp,
                      @RequestParam(value ="nonce" ,required = false)  String nonce,
                      @RequestParam(value ="echostr" ,required = false)  String echostr,
                      HttpServletRequest request) {
//        signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
//        timestamp	时间戳
//        nonce	随机数
//        echostr
//        String respMessage = null;
//        try {
//            // 默认返回的文本消息内容
//            String respContent = "请求处理异常，请稍候尝试！";
//
//            // xml请求解析
//            Map<String, String> requestMap = MessageUtil.parseXml(request);
//
//            // 发送方帐号（open_id）
//            String fromUserName = requestMap.get("FromUserName");
//            // 公众帐号
//            String toUserName = requestMap.get("ToUserName");
//            // 消息类型
//            String msgType = requestMap.get("MsgType");
//
//            // 回复文本消息
//            TextMessage textMessage = new TextMessage();
//            textMessage.setToUserName(fromUserName);
//            textMessage.setFromUserName(toUserName);
//            textMessage.setCreateTime(new Date().getTime());
//            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//            textMessage.setFuncFlag(0);
//
//            // 文本消息
//            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//                respContent = "您发送的是文本消息！";
//            }
//            // 图片消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
//                respContent = "您发送的是图片消息！";
//            }
//            // 地理位置消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
//                respContent = "您发送的是地理位置消息！";
//            }
//            // 链接消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
//                respContent = "您发送的是链接消息！";
//            }
//            // 音频消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//                respContent = "您发送的是音频消息！";
//            }
//            // 事件推送
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
//                // 事件类型
//                String eventType = requestMap.get("Event");
//                // 订阅
//                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
//                    respContent = "谢谢您的关注！";
//                }
//                // 取消订阅
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
//                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
//                }
//                // 自定义菜单点击事件
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
//                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应
//                    String eventKey = requestMap.get("EventKey");
//
//                    if (eventKey.equals("11")) {
//                        respContent = "天气预报菜单项被点击！";
//                    } else if (eventKey.equals("12")) {
//                        respContent = "公交查询菜单项被点击！";
//                    } else if (eventKey.equals("13")) {
//                        respContent = "周边搜索菜单项被点击！";
//                    } else if (eventKey.equals("14")) {
//                        respContent = "历史上的今天菜单项被点击！";
//                    } else if (eventKey.equals("21")) {
//                        respContent = "歌曲点播菜单项被点击！";
//                    } else if (eventKey.equals("22")) {
//                        respContent = "经典游戏菜单项被点击！";
//                    } else if (eventKey.equals("23")) {
//                        respContent = "美女电台菜单项被点击！";
//                    } else if (eventKey.equals("24")) {
//                        respContent = "人脸识别菜单项被点击！";
//                    } else if (eventKey.equals("25")) {
//                        respContent = "聊天唠嗑菜单项被点击！";
//                    } else if (eventKey.equals("31")) {
//                        respContent = "Q友圈菜单项被点击！";
//                    } else if (eventKey.equals("32")) {
//                        respContent = "电影排行榜菜单项被点击！";
//                    } else if (eventKey.equals("33")) {
//                        respContent = "幽默笑话菜单项被点击！";
//                    }
//                }
//            }
//
//            textMessage.setContent(respContent);
//            respMessage = MessageUtil.textMessageToXml(textMessage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return respMessage;
//    }


        System.out.println("Hello springboot" + signature + "echostr:" + echostr);
        if (echostr!=null) {

            return echostr;
        }else {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";
            try {


                // xml请求解析
                Map<String, String> requestMap = MessageUtil.parseXml(request);

                // 发送方帐号（open_id）
                String fromUserName = requestMap.get("FromUserName");
                // 公众帐号
                String toUserName = requestMap.get("ToUserName");
                // 消息类型
                String msgType = requestMap.get("MsgType");
                String eventKey = requestMap.get("EventKey");

                System.out.println("msgType:"+msgType);
//                HT-aS_4X7I6BUyEzIx11W1suJM8wR8ZKqEbSUQnWKzRHfad5UYlAdfw5XXwIX0jh
                TextMessage textMessage = new TextMessage();
                switch (eventKey){
                    case "cz001":
                        textMessage.setContent("来了老弟\n没事别乱点击我\n我很忙的还有那个赵兰p你在搞啥");
                        break;
                    case "cz002":
                        textMessage.setContent("你真的就是瓜皮\n没事别乱点击我\n瓜皮其实不是骂人的意思");
                        break;
                    case "czgood":
                        textMessage.setContent("商务请联系110120119");
                        break;
                    case "czgetmz":
//                        1 主动向微信服务器发一个消息
//                        https://api.weixin.qq.com/cgi-bin/message/custom/send?
// access_token=22_jnqDuJVgTA7_UGDxfYKj0N-IFJDAtBfa2w_UDNaL8D_4jaj2Buvk
// KSID4Av-BJAdDAttkoehh8WOf5mHcScfIKOo_gimSipAIcXLc-_yCgInJaYSiMFLpipW9nPxowRBbj13EoE893WWM1wlJFUeADASOD
//                        2 微信回回调到这里再发一个图片消息




//                        PicMessage picMessage = new PicMessage();
//                        picMessage.setFromUserName(toUserName);
//                        picMessage.setToUserName(fromUserName);
//                        picMessage.setMsgType("image");
//                        picMessage.setCreateTime(new Date().getTime());
//                        picMessage.setMediaId("M0rNBA3gTVa9q_NkD_V8EQrCx2qGO3OE-ZVgFJAuX4FT5TTrOCzVHJ1jBNmxzMq8");
//
//
//                        Object json = JSONArray.toJSON(picMessage);
//
//                        String result =  HttpClientTest.doPost("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=22_oyrUO849B4ZTrCDBVYLY9XrSa32NZO0AyeSjRFqof4m6vqRGFrpIIfz3Ir7Lg05aiOxBOSJ3IwgZMzzuwp-8UkfzPllPpZP8I-1_Nf9oH9UsmlE5TMDQgFgQoGa8VNXwM75bglD5WZGJ8E3iYGSbAAARZL",json.toString());
//                        System.out.println("pames:"+json.toString()+" result:"+result);
//
//
//                        String  returnmsg = MessageUtil.picmessageToXml(picMessage);
//                        System.out.println("huoqumeizhao:"+returnmsg);
                        return "";

                }

                textMessage.setFromUserName(toUserName);
                textMessage.setToUserName(fromUserName);
                textMessage.setMsgType("text");
                textMessage.setCreateTime(new Date().getTime());
                String  respMessage = MessageUtil.messageToXml(textMessage);
                System.out.println("respMessage" + respMessage+"\n    ");
//                return MessageUtil.getXml(fromUserName,toUserName );
                return respMessage;
            }catch (Exception e){
                System.out.println("Exception:"+e.toString());
            }
            return MessageUtil.messageToXml(new TextMessage());
        }
    }


}
