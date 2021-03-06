package xin.cymall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import xin.cymall.common.dadaexpress.utils.JSONUtil;
import xin.cymall.common.enumresource.OrderStatusEnum;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

import xin.cymall.common.wxpay.UnifiedOrderRespose;
import xin.cymall.common.wxpay.WXPayUtil;
import xin.cymall.entity.SrvOrder;
import xin.cymall.service.SrvOrderFoodService;
import xin.cymall.service.SrvOrderService;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-26 14:01:40
 */
@Controller
@RequestMapping("srvorder")
public class SrvOrderController {
	@Autowired
	private SrvOrderService srvOrderService;

//add by  chenz 具体的菜单根据订单id来查询有哪些菜
    @Autowired
    private SrvOrderFoodService srvOrderFoodService;
    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("srvorder:list")
    public String list() {
        return "srvorder/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("srvorder:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SrvOrder> srvOrderList = srvOrderService.getList(query);
		int total = srvOrderService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(srvOrderList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("srvorder:save")
    public String add(){
        return "srvorder/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("srvorder:update")
    public String edit(Model model, @PathVariable("id") String id){
		SrvOrder srvOrder = srvOrderService.get(id);
        model.addAttribute("model",srvOrder);
        return "srvorder/edit";
    }







    /**
	 * 信息
	 */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("srvorder:info")
    public String info(Model model,@PathVariable("id") String id){
        SrvOrder srvOrder = srvOrderService.get(id);
        srvOrder.setStatus(OrderStatusEnum.getValue(srvOrder.getStatus()));
        model.addAttribute("model", srvOrder);
        return "srvorder/info";
    }


	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改")
	@RequestMapping("/update")
	@RequiresPermissions("srvorder:update")
	public R update(@RequestBody SrvOrder srvOrder){
		srvOrderService.update(srvOrder);
		
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用")
    @RequestMapping("/enable")
    @RequiresPermissions("srvorder:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		srvOrderService.updateState(ids, stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用")
    @RequestMapping("/limit")
    @RequiresPermissions("srvorder:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		srvOrderService.updateState(ids,stateValue);
        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @SysLog("退款")
    @RequestMapping("/refund")
    @RequiresPermissions("srvorder:update")
    public R refund(@RequestParam String orderId) throws Exception {
        SrvOrder srvOrder = srvOrderService.get(orderId);
        if(OrderStatusEnum.ORDRT_STATUS1.getCode().equals(srvOrder.getStatus()) || OrderStatusEnum.ORDRT_STATUS10.getCode().equals(srvOrder.getStatus())){
            return R.error("该订单不能退款");
        }
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appId","wx688906a5f5df8b37");
        requestMap.put("mch_id", "1542729801");
        requestMap.put("out_trade_no",srvOrder.getOrderNo());
        requestMap.put("out_refund_no", srvOrder.getOrderNo());
        requestMap.put("total_fee", "1");
        requestMap.put("refund_fee", "1");
        requestMap.put("nonce_str", WXPayUtil.generateNonceStr());
        Map<String,Object> requestInfo = WXPayUtil.createOrderRefund(requestMap);
        String refundData = (String) requestInfo.get("refund_toString");
        String returnData = WXPayUtil.doRefund(refundData);
        UnifiedOrderRespose unifiedOrderRespose = (UnifiedOrderRespose) WXPayUtil.convertXmlStrToObject(UnifiedOrderRespose.class, returnData);
//        Map<String,Object> map = new HashMap<>();
//        map.put("",jsonObject.get("return_code"));
//        map.put("",jsonObject.get("return_msg"));
        if("SUCCESS".equals(unifiedOrderRespose.getResult_code())) {
            return R.ok("退款成功");
        }else{
            return R.error(unifiedOrderRespose.getErr_code_des());
        }
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除")
	@RequestMapping("/delete")
	@RequiresPermissions("srvorder:delete")
	public R delete(@RequestBody String[] ids){
		srvOrderService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
