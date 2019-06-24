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

import xin.cymall.entity.SrvUserComment;
import xin.cymall.service.SrvUserCommentService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-24 17:30:19
 */
@Controller
@RequestMapping("srvusercomment")
public class SrvUserCommentController {
	@Autowired
	private SrvUserCommentService srvUserCommentService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvusercomment:list")
    public String list() {
        return "srvusercomment/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvusercomment:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvUserComment> srvUserCommentList = srvUserCommentService.getList(query);
		int total = srvUserCommentService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvUserCommentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvusercomment:save")
    public String add(){
        return "srvusercomment/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvusercomment:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvUserComment srvUserComment = srvUserCommentService.get(id);
        model.addAttribute("model",srvUserComment);
        return "srvusercomment/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvusercomment:info")
    public R info(@PathVariable("id") String id){
        SrvUserComment srvUserComment = srvUserCommentService.get(id);
        return R.ok().put("srvUserComment", srvUserComment);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvusercomment:save")
	public R save(@RequestBody SrvUserComment srvUserComment){
		srvUserCommentService.save(srvUserComment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvusercomment:update")
	public R update(@RequestBody SrvUserComment srvUserComment){
		srvUserCommentService.update(srvUserComment);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvusercomment:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvUserCommentService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvusercomment:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvUserCommentService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvusercomment:delete")
	public R delete(@RequestBody String[] ids){
		srvUserCommentService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
