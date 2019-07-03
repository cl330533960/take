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

import xin.cymall.entity.SrvOrderFood;
import xin.cymall.service.SrvOrderFoodService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-28 14:55:15
 */
@Controller
@RequestMapping("srvorderfood")
public class SrvOrderFoodController {
	@Autowired
	private SrvOrderFoodService srvOrderFoodService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvorderfood:list")
    public String list() {
        return "srvorderfood/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvorderfood:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvOrderFood> srvOrderFoodList = srvOrderFoodService.getList(query);
		int total = srvOrderFoodService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvOrderFoodList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvorderfood:save")
    public String add(){
        return "srvorderfood/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvorderfood:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvOrderFood srvOrderFood = srvOrderFoodService.get(id);
        model.addAttribute("model",srvOrderFood);
        return "srvorderfood/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvorderfood:info")
    public R info(@PathVariable("id") String id){
        SrvOrderFood srvOrderFood = srvOrderFoodService.get(id);
        return R.ok().put("srvOrderFood", srvOrderFood);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvorderfood:save")
	public R save(@RequestBody SrvOrderFood srvOrderFood){
		srvOrderFoodService.save(srvOrderFood);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvorderfood:update")
	public R update(@RequestBody SrvOrderFood srvOrderFood){
		srvOrderFoodService.update(srvOrderFood);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvorderfood:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvOrderFoodService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvorderfood:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvOrderFoodService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvorderfood:delete")
	public R delete(@RequestBody String[] ids){
		srvOrderFoodService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
