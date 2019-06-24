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

import xin.cymall.entity.SrvMerchanopinion;
import xin.cymall.service.SrvMerchanopinionService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-24 11:52:55
 */
@Controller
@RequestMapping("srvmerchanopinion")
public class SrvMerchanopinionController {
	@Autowired
	private SrvMerchanopinionService srvMerchanopinionService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvmerchanopinion:list")
    public String list() {
        return "srvmerchanopinion/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvmerchanopinion:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvMerchanopinion> srvMerchanopinionList = srvMerchanopinionService.getList(query);
		int total = srvMerchanopinionService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvMerchanopinionList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvmerchanopinion:save")
    public String add(){
        return "srvmerchanopinion/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvmerchanopinion:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvMerchanopinion srvMerchanopinion = srvMerchanopinionService.get(id);
        model.addAttribute("model",srvMerchanopinion);
        return "srvmerchanopinion/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvmerchanopinion:info")
    public R info(@PathVariable("id") String id){
        SrvMerchanopinion srvMerchanopinion = srvMerchanopinionService.get(id);
        return R.ok().put("srvMerchanopinion", srvMerchanopinion);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvmerchanopinion:save")
	public R save(@RequestBody SrvMerchanopinion srvMerchanopinion){
		srvMerchanopinionService.save(srvMerchanopinion);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvmerchanopinion:update")
	public R update(@RequestBody SrvMerchanopinion srvMerchanopinion){
		srvMerchanopinionService.update(srvMerchanopinion);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvmerchanopinion:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvMerchanopinionService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvmerchanopinion:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvMerchanopinionService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvmerchanopinion:delete")
	public R delete(@RequestBody String[] ids){
		srvMerchanopinionService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
