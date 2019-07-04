package xin.cymall.common.utils;

public class TextMessage {
//   返回微信的消息类
//    / 发送方帐号（open_id）
//    String fromUserName = requestMap.get("FromUserName");
//    // 公众帐号
//    String toUserName = requestMap.get("ToUserName");
//    // 消息类型
//    String msgType = requestMap.get("MsgType");
//
//    // 回复文本消息
//    TextMessage textMessage = new TextMessage();
//            textMessage.setToUserName(fromUserName);
//            textMessage.setFromUserName(toUserName);
//            textMessage.setCreateTime(new Date().getTime());
//            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//            textMessage.setFuncFlag(0);

    String  ToUserName  ;  // 是     接收方帐号（收到的OpenID）
    String  FromUserName;   //  是     开发者微信号
    Long    CreateTime ;  //  是     消息创建时间 （整型）
    String    MsgType ;  //  是     text
    String    Content ; //   是     回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
