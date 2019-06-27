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

import xin.cymall.entity.SrvCouponSet;
import xin.cymall.service.SrvCouponSetService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-27 22:18:33
 */
@Controller
@RequestMapping("srvcouponset")
public class SrvCouponSetController {
	@Autowired
	private SrvCouponSetService srvCouponSetService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvcouponset:list")
    public String list() {
        return "srvcouponset/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvcouponset:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvCouponSet> srvCouponSetList = srvCouponSetService.getList(query);
		int total = srvCouponSetService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvCouponSetList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvcouponset:save")
    public String add(){
        return "srvcouponset/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvcouponset:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvCouponSet srvCouponSet = srvCouponSetService.get(id);
        model.addAttribute("model",srvCouponSet);
        return "srvcouponset/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvcouponset:info")
    public R info(@PathVariable("id") String id){
        SrvCouponSet srvCouponSet = srvCouponSetService.get(id);
        return R.ok().put("srvCouponSet", srvCouponSet);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvcouponset:save")
	public R save(@RequestBody SrvCouponSet srvCouponSet){
		srvCouponSetService.save(srvCouponSet);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvcouponset:update")
	public R update(@RequestBody SrvCouponSet srvCouponSet){
		srvCouponSetService.update(srvCouponSet);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvcouponset:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvCouponSetService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvcouponset:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvCouponSetService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvcouponset:delete")
	public R delete(@RequestBody String[] ids){
		srvCouponSetService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
