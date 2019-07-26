package xin.cymall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import xin.cymall.common.dadaexpress.DaDaExpressUtil;
import xin.cymall.common.enumresource.DefaultEnum;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

import xin.cymall.common.utils.*;
import xin.cymall.entity.SrvRestaurant;
import xin.cymall.entity.SysUser;
import xin.cymall.service.AreaService;
import xin.cymall.service.SrvRestaurantService;
import xin.cymall.service.SysUserService;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-21 18:55:54
 */
@Controller
@RequestMapping("srvrestaurant")
public class SrvRestaurantController extends  AbstractController{
	@Autowired
	private SrvRestaurantService srvRestaurantService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private AreaService areaService;
	
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvrestaurant:list")
    public String list() {
        return "srvrestaurant/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvrestaurant:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvRestaurant> srvRestaurantList = srvRestaurantService.getList(query);
        for(SrvRestaurant restaurant : srvRestaurantList){
            restaurant.setArea(srvRestaurantService.getArea(restaurant.getArea()));
        }

		int total = srvRestaurantService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvRestaurantList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvrestaurant:save")
    public String add(){
        return "srvrestaurant/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvrestaurant:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvRestaurant srvRestaurant = srvRestaurantService.get(id);
        model.addAttribute("model",srvRestaurant);
        return "srvrestaurant/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvrestaurant:info")
    public R info(@PathVariable("id") String id){
        SrvRestaurant srvRestaurant = srvRestaurantService.get(id);
        return R.ok().put("srvRestaurant", srvRestaurant);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存")
	@RequestMapping("/save")
	@RequiresPermissions("srvrestaurant:save")
	public R save(@RequestBody SrvRestaurant srvRestaurant) throws IOException {
        String[] parentids = srvRestaurant.getParentAreaIds();
        if(parentids.length > 0)
            srvRestaurant.setArea(String.join(",", parentids));

        SysUser existUser = sysUserService.queryByUserName(srvRestaurant.getUsername());
        if(existUser!=null){
            return R.error("用户名已存在!");
        }
        String[] location = BaiduMapUtil.getPoint(srvRestaurant.getAddr());
        if(location.length == 0){
            return R.error("请输入正确的地址!");
        }
        srvRestaurant.setLng(location[0]);
        srvRestaurant.setLat(location[1]);
        SysUser user = new SysUser();
        user.setPassword(DefaultEnum.PASSWORD.getCode());
        user.setCreateUserId(getUserId());
        user.setStatus(Integer.parseInt(StateEnum.ENABLE.getCode()));
		srvRestaurantService.save(srvRestaurant, user);
        String areaStr = areaService.getAreaNameStr(srvRestaurant.getArea());
        String[] areas = areaStr.split(",");
        if (areas.length == 3) {
            DaDaExpressUtil.addShop(srvRestaurant, areas[1], areas[2]);
        }
        return R.ok();
    }
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvrestaurant:update")
	public R update(@RequestBody SrvRestaurant srvRestaurant){
        String[] parentids = srvRestaurant.getParentAreaIds();
        srvRestaurant.setArea(String.join(",", parentids));
		srvRestaurantService.update(srvRestaurant);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvrestaurant:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvRestaurantService.updateState(ids, stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvrestaurant:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvRestaurantService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvrestaurant:delete")
	public R delete(@RequestBody String[] ids){
		srvRestaurantService.deleteBatch(ids);
		
		return R.ok();
	}

    /**
     * 获取下级地区
     */
    @ResponseBody
    @RequiresPermissions("srvrestaurant:list")
    @RequestMapping("normalList")
    public R normalList() {
        List<SrvRestaurant> areaList = srvRestaurantService.getList(null);
        List<EnumBean> list = new ArrayList<>();
        if (areaList != null && areaList.size() > 0) {
            for (int i = 0; i < areaList.size(); i++) {
                EnumBean bean = new EnumBean();
                bean.setCode(areaList.get(i).getId());
                bean.setValue(areaList.get(i).getName());
                list.add(bean);
            }
        }
        return R.ok().put("data", list);
    }

}
