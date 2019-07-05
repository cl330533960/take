package xin.cymall.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.cymall.common.utils.R;
import xin.cymall.common.utils.StringUtil;
import xin.cymall.entity.SysUser;
import xin.cymall.service.SysUserService;

/**
 * @ClassName SysApiController
 * @Author cailei
 * @Description
 * @Date 2019/7/5 11:06
 **/
@RestController
@RequestMapping("api")
public class SysApiController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("/login")
    public R login(String username, String password){
        password = new Sha256Hash(password).toHex();
        SysUser user = sysUserService.queryByUserName(username);
        //账号不存在
        String errorMsg = "";
        if(user == null) {
            errorMsg = "账号或密码不正确";
        }

        //密码错误
        if(!password.equals(user.getPassword())) {
            errorMsg = "账号或密码不正确";
        }

        //账号锁定
        if(user.getStatus() == 0){
            errorMsg = "账号已被锁定,请联系管理员";
        }
        if(StringUtil.isEmpty(errorMsg))
            return R.ok().put("data",null);
        else
            return R.error(errorMsg);
    }
}
