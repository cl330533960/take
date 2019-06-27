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

import xin.cymall.entity.SrvCoupon;
import xin.cymall.service.SrvCouponService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-27 13:47:41
 * 优惠券管理
 */
@Controller
@RequestMapping("srvcoupon")
public class SrvCouponController {
	@Autowired
	private SrvCouponService srvCouponService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvcoupon:list")
    public String list() {
        return "srvcoupon/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvcoupon:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvCoupon> srvCouponList = srvCouponService.getList(query);
		int total = srvCouponService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvCouponList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvcoupon:save")
    public String add(){
        return "srvcoupon/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvcoupon:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvCoupon srvCoupon = srvCouponService.get(id);
        model.addAttribute("model",srvCoupon);
        return "srvcoupon/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvcoupon:info")
    public R info(@PathVariable("id") String id){
        SrvCoupon srvCoupon = srvCouponService.get(id);
        return R.ok().put("srvCoupon", srvCoupon);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvcoupon:save")
	public R save(@RequestBody SrvCoupon srvCoupon){
		srvCouponService.save(srvCoupon);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvcoupon:update")
	public R update(@RequestBody SrvCoupon srvCoupon){
		srvCouponService.update(srvCoupon);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvcoupon:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvCouponService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvcoupon:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvCouponService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvcoupon:delete")
	public R delete(@RequestBody String[] ids){
		srvCouponService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
