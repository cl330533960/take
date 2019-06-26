package xin.cymall.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;
import xin.cymall.entity.SrvFood;
import xin.cymall.service.SrvFoodService;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-25 17:47:38
 */
@Controller
@RequestMapping("srvfood")
public class SrvFoodController {
	@Autowired
	private SrvFoodService srvFoodService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvfood:list")
    public String list() {
        return "srvfood/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvfood:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvFood> srvFoodList = srvFoodService.getList(query);
		int total = srvFoodService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvFoodList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvfood:save")
    public String add(){
        return "srvfood/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvfood:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvFood srvFood = srvFoodService.get(id);
        model.addAttribute("model",srvFood);
        return "srvfood/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvfood:info")
    public R info(@PathVariable("id") String id){
        SrvFood srvFood = srvFoodService.get(id);
        return R.ok().put("srvFood", srvFood);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvfood:save")
	public R save(@RequestBody SrvFood srvFood){
        srvFood.setImagePath(String.join(",", srvFood.getImagePaths()));
        srvFood.setUseScope(String.join(",", srvFood.getUseScopes()));
        srvFoodService.save(srvFood);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvfood:update")
	public R update(@RequestBody SrvFood srvFood){
        if (srvFood.getImagePaths().length > 0 )
            srvFood.setImagePath(String.join(",", srvFood.getImagePaths()));
        if (srvFood.getUseScopes().length > 0 )
            srvFood.setUseScope(String.join(",", srvFood.getUseScopes()));
		srvFoodService.update(srvFood);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvfood:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvFoodService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvfood:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvFoodService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvfood:delete")
	public R delete(@RequestBody String[] ids){
		srvFoodService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
