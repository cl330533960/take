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

import xin.cymall.entity.SrvDiscounreserve;
import xin.cymall.service.SrvDiscounreserveService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-25 17:24:03
 * dazhe预定chen
 */
@Controller
@RequestMapping("srvdiscounreserve")
public class SrvDiscounreserveController {
	@Autowired
	private SrvDiscounreserveService srvDiscounreserveService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvdiscounreserve:list")
    public String list() {
        return "srvdiscounreserve/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvdiscounreserve:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvDiscounreserve> srvDiscounreserveList = srvDiscounreserveService.getList(query);
		int total = srvDiscounreserveService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvDiscounreserveList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvdiscounreserve:save")
    public String add(){
        return "srvdiscounreserve/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvdiscounreserve:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvDiscounreserve srvDiscounreserve = srvDiscounreserveService.get(id);
        model.addAttribute("model",srvDiscounreserve);
        return "srvdiscounreserve/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvdiscounreserve:info")
    public R info(@PathVariable("id") String id){
        SrvDiscounreserve srvDiscounreserve = srvDiscounreserveService.get(id);
        return R.ok().put("srvDiscounreserve", srvDiscounreserve);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvdiscounreserve:save")
	public R save(@RequestBody SrvDiscounreserve srvDiscounreserve){
		srvDiscounreserveService.save(srvDiscounreserve);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvdiscounreserve:update")
	public R update(@RequestBody SrvDiscounreserve srvDiscounreserve){
		srvDiscounreserveService.update(srvDiscounreserve);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvdiscounreserve:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvDiscounreserveService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvdiscounreserve:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvDiscounreserveService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvdiscounreserve:delete")
	public R delete(@RequestBody String[] ids){
		srvDiscounreserveService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
