package xin.cymall.controller;

import java.util.List;
import java.util.Map;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

import xin.cymall.entity.SrvBaseSet;
import xin.cymall.service.SrvBaseSetService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-01 21:09:34
 */
@Controller
@RequestMapping("srvbaseset")
public class SrvBaseSetController {
	@Autowired
	private SrvBaseSetService srvBaseSetService;

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit")
    @RequiresPermissions("srvbaseset:update")
    public String edit(Model model){
		SrvBaseSet srvBaseSet = null;
        List<SrvBaseSet> list = srvBaseSetService.getList(null);
        if(list.size()>0){
            srvBaseSet = list.get(0);
        }
        model.addAttribute("model", srvBaseSet);
        return "srvbaseset/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvbaseset:info")
    public R info(@PathVariable("id") String id){
        SrvBaseSet srvBaseSet = srvBaseSetService.get(id);
        return R.ok().put("srvBaseSet", srvBaseSet);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvbaseset:save")
	public R save(@RequestBody SrvBaseSet srvBaseSet){
		srvBaseSetService.save(srvBaseSet);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvbaseset:update")
	public R update(@RequestBody SrvBaseSet srvBaseSet){
		srvBaseSetService.update(srvBaseSet);
		
		return R.ok();
	}

	
}
