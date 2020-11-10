package xin.cymall.common.utils;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.cymall.CyFastApplication;
import xin.cymall.common.config.WxConfig;
import xin.cymall.service.PushService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CyFastApplication.class)
public class PushServiceTest  {
    @Autowired
    private PushService pushService;

    @Autowired
    private WxConfig wxConfig;

    @Test
    public void testPush() throws Exception {
//        pushService.pushMsg("丢你老母", "丢你老母","");
//        Thread.sleep(1000 * 10);
//        pushService.pushMsg("我在丢你老母", "我在丢你老母", "");
//        System.out.println("end");
        System.out.println(wxConfig.wxMpConfigStorage().getAccessToken());

    }



}