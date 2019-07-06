package xin.cymall.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.cymall.common.enumresource.OrderStatusEnum;
import xin.cymall.common.utils.*;
import xin.cymall.common.utils.UUID;
import xin.cymall.entity.*;
import xin.cymall.service.*;

import java.util.*;

/**
 * @ClassName SysApiController
 * @Author cailei
 * @Description
 * @Date 2019/7/5 11:06
 **/
@RestController
@RequestMapping("api")
public class SysApiController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SrvRestaurantService srvRestaurantService;
    @Autowired
    private SrvFoodService srvFoodService;
    @Autowired
    private SrvFoodUpDownService srvFoodUpDownService;
    @Autowired
    private SrvMerchanopinionService srvMerchanopinionService;
    @Autowired
    private SrvOrderService srvOrderService;
    @Autowired
    private SrvOrderFoodService srvOrderFoodService;

    @RequestMapping("/login")
    public R login(@RequestParam String username,@RequestParam String password){
        password = new Sha256Hash(password).toHex();
        SysUser user = sysUserService.queryByUserName(username);
        //账号不存在
        String errorMsg = "";
        if(user == null) {
            errorMsg = "账号或密码不正确";
        }

        //密码错误
        if(!password.equals(user.getPassword())) {
            errorMsg = "账号或密码不正确";
        }

        //账号锁定
        if(user.getStatus() == 0){
            errorMsg = "账号已被锁定,请联系管理员";
        }
        if(StringUtil.isEmpty(errorMsg)) {
            SrvRestaurant srvRestaurant = srvRestaurantService.getByUserId(String.valueOf(user.getUserId()));
            return R.ok().put("data", srvRestaurant);
        }
        else
            return R.error(errorMsg);
    }

    @RequestMapping("/setRestaurant")
      public R setRestaurant(@RequestBody SrvRestaurant srvRestaurant){
        srvRestaurantService.update(srvRestaurant);
        return R.ok();
    }

    @RequestMapping("/queryFood")
    public R queryFood(@RequestParam String restaurantId){
        List<SrvFood> list = srvFoodService.queryFoodByRestaurantId(restaurantId);
        for(SrvFood srvFood : list){
            if(!StringUtil.isEmpty(srvFood.getImagePath()))
                srvFood.setImagePath(srvFood.getImagePath().split(",")[0]);
        }
        return R.ok().put("data", list);
    }

    @RequestMapping("/foodUpOrDown")
    public R foodUpOrDown(@RequestParam String restaurantId,@RequestParam String[] foodIds,@RequestParam Integer status){
        List<SrvFoodUpDown> list = new ArrayList<>();
        for(String foodId : foodIds){
            SrvFoodUpDown srvFoodUpDown = new SrvFoodUpDown();
            srvFoodUpDown.setId(UUID.generateId());
            srvFoodUpDown.setRestaurantId(restaurantId);
            srvFoodUpDown.setFoodId(foodId);
            list.add(srvFoodUpDown);
        }
        srvFoodUpDownService.batchUporDown(list, status);
        return R.ok().put("data", list);
    }

    @RequestMapping("/saveOpinion")
    public R foodUpOrDown(SrvMerchanopinion srvMerchanopinion){
        srvMerchanopinion.setId(UUID.generateId());
        srvMerchanopinion.setStatus("2"); //待审核
        srvMerchanopinionService.save(srvMerchanopinion);
        return R.ok();
    }

    /**
     * 查询订单详细
     * @param srvOrder
     * @return
     */
    @RequestMapping("/receiptOrder")
    public R receiptOrder(SrvOrder srvOrder){
        SrvOrder returnOrder = srvOrderService.receiptOrder(srvOrder);
        Map<String,Object> map = new HashMap<>();
        map.put("orderId", returnOrder.getId());
        List<SrvOrderFood> list = srvOrderFoodService.getList(map);
        returnOrder.setFoodList(list);
        return R.ok().put("data", returnOrder);
    }

    /**
     * 查询订单列表
     * @param params
     * @return
     */
    @RequestMapping("/queryOrderList")
    public R queryOrderList(@RequestParam String restaurantId,@RequestParam Integer page,@RequestParam Integer limit,String status){
        Map<String,Object> params = new HashMap<>();
        params.put("restaurantId",restaurantId);
        params.put("status","status");
        params.put("page",page);
        params.put("limit",limit);
        params.put("sidx","orderTime");
        params.put("order","asc");
        Query query = new Query(params);
        List<SrvOrder> orderList = srvOrderService.getList(query);
        for(SrvOrder srvOrder : orderList){
            srvOrder.setStatusText(OrderStatusEnum.getValue(srvOrder.getStatus()));
        }
        int total = srvOrderService.getCount(query);
        PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    /**
     * 更新订单状态
     * @param srvOrder
     * @return
     */
    @RequestMapping("/updateOrder")
    public R updateOrder(SrvOrder srvOrder){
        if(OrderStatusEnum.ORDRT_STATUS3.getCode().equals(srvOrder.getStatus())){
            srvOrder.setReceiptTime(new Date());
            //通知骑手
        }else{
            srvOrder.setStatus(OrderStatusEnum.ORDRT_STATUS8.getCode());
        }
        srvOrderService.update(srvOrder);
        return R.ok();
    }
}
