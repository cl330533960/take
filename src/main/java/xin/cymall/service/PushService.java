package xin.cymall.service;

public interface PushService {
    void pushMsg(String title,String text,String cid);
    String getPushToken();
}
