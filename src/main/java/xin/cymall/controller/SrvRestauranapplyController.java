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

import xin.cymall.entity.SrvRestauranapply;
import xin.cymall.service.SrvRestauranapplyService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-03 22:17:41
 */
@Controller
@RequestMapping("srvrestauranapply")
public class SrvRestauranapplyController {
	@Autowired
	private SrvRestauranapplyService srvRestauranapplyService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvrestauranapply:list")
    public String list() {
        return "srvrestauranapply/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvrestauranapply:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvRestauranapply> srvRestauranapplyList = srvRestauranapplyService.getList(query);
		int total = srvRestauranapplyService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvRestauranapplyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvrestauranapply:save")
    public String add(){
        return "srvrestauranapply/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvrestauranapply:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvRestauranapply srvRestauranapply = srvRestauranapplyService.get(id);
        model.addAttribute("model",srvRestauranapply);
        return "srvrestauranapply/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvrestauranapply:info")
    public R info(@PathVariable("id") String id){
        SrvRestauranapply srvRestauranapply = srvRestauranapplyService.get(id);
        return R.ok().put("srvRestauranapply", srvRestauranapply);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvrestauranapply:save")
	public R save(@RequestBody SrvRestauranapply srvRestauranapply){
		srvRestauranapplyService.save(srvRestauranapply);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvrestauranapply:update")
	public R update(@RequestBody SrvRestauranapply srvRestauranapply){
		srvRestauranapplyService.update(srvRestauranapply);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvrestauranapply:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvRestauranapplyService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvrestauranapply:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvRestauranapplyService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvrestauranapply:delete")
	public R delete(@RequestBody String[] ids){
		srvRestauranapplyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
