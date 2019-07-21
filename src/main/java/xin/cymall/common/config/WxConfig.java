package xin.cymall.common.config;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.http.HttpType;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.api.impl.BaseWxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceHttpClientImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/7/13.
 */
@Component
public class WxConfig {

    @Autowired
    private Environment env;

    public WxMpService wxMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    public WxMpService wxMpServiceHttpClientImpl(){
        WxMpService wxMpService = new WxMpServiceHttpClientImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }


    public WxMpUserService wxMpUserService(){
        WxMpUserService wxMpService = new WxMpUserServiceImpl(wxMpService());
        return wxMpService;
    }



    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage wxMpConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpConfigStorage.setAppId(env.getProperty("wx.appId"));
        wxMpConfigStorage.setSecret(env.getProperty("wx.appsecret"));
        return wxMpConfigStorage;
    }


}
