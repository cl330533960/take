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

import xin.cymall.entity.SrvMerchanclear;
import xin.cymall.service.SrvMerchanclearService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-26 18:38:42
 */
@Controller
@RequestMapping("srvmerchanclear")
public class SrvMerchanclearController {
	@Autowired
	private SrvMerchanclearService srvMerchanclearService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvmerchanclear:list")
    public String list() {
        return "srvmerchanclear/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvmerchanclear:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvMerchanclear> srvMerchanclearList = srvMerchanclearService.getList(query);
		int total = srvMerchanclearService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvMerchanclearList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvmerchanclear:save")
    public String add(){
        return "srvmerchanclear/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvmerchanclear:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvMerchanclear srvMerchanclear = srvMerchanclearService.get(id);
        model.addAttribute("model",srvMerchanclear);
        return "srvmerchanclear/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvmerchanclear:info")
    public R info(@PathVariable("id") String id){
        SrvMerchanclear srvMerchanclear = srvMerchanclearService.get(id);
        return R.ok().put("srvMerchanclear", srvMerchanclear);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvmerchanclear:save")
	public R save(@RequestBody SrvMerchanclear srvMerchanclear){
		srvMerchanclearService.save(srvMerchanclear);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvmerchanclear:update")
	public R update(@RequestBody SrvMerchanclear srvMerchanclear){
		srvMerchanclearService.update(srvMerchanclear);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvmerchanclear:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvMerchanclearService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvmerchanclear:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvMerchanclearService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvmerchanclear:delete")
	public R delete(@RequestBody String[] ids){
		srvMerchanclearService.deleteBatch(ids);
		
		return R.ok();
	}
	
}