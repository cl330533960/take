package xin.cymall.controller;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.api.impl.WxMpUserServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.cymall.common.config.WxConfig;
import xin.cymall.common.enumresource.CouponTypeEnum;
import xin.cymall.common.enumresource.OrderStatusEnum;
import xin.cymall.common.utils.*;
import xin.cymall.entity.*;
import xin.cymall.entity.wchart.*;
import xin.cymall.service.*;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wx")
public class WchartController {

    @Autowired
    private SrvBaseSetService srvBaseSetService;
    @Autowired
    private SrvFoodService srvFoodService;
    @Autowired
    private SrvOrderService srvOrderService;
    @Autowired
    private SrvUserAddrService srvUserAddrService;
    @Autowired
    private SrvWxUserService srvWxUserService;
    @Autowired
    private SrvOrderFoodService srvOrderFoodService;
    @Autowired
    private SrvCouponService srvCouponService;
    @Autowired
    private SrvDiscounreserveService srvDiscounreserveService;
    @Autowired
    private WxConfig wxConfig;


    @RequestMapping("/auth")
    @ResponseBody
    public String auth(@RequestParam(value ="signature" ,required = false)  String signature,
                      @RequestParam(value ="timestamp" ,required = false)  String timestamp,
                      @RequestParam(value ="nonce" ,required = false)  String nonce,
                      @RequestParam(value ="echostr" ,required = false)  String echostr,
                      HttpServletRequest request) {

        System.out.println("Hello springboot" + signature + "echostr:" + echostr);
        if (echostr!=null) {

            return echostr;
        }else {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";
            try {


                // xml请求解析
                Map<String, String> requestMap = MessageUtil.parseXml(request);

                // 发送方帐号（open_id）
                String fromUserName = requestMap.get("FromUserName");
                // 公众帐号
                String toUserName = requestMap.get("ToUserName");

                String event = requestMap.get("Event");
                if(event.equals("subscribe")){
                    if(srvWxUserService.getByOpenId(fromUserName)==null) {
                        WxMpUser wxMpUser = wxConfig.wxMpUserService().userInfo(fromUserName);
                        SrvWxUser srvWxUser = new SrvWxUser();
                        srvWxUser.setId(UUID.generateId());
                        srvWxUser.setWxId(wxMpUser.getOpenId());
                        srvWxUser.setWxName(wxMpUser.getNickname());
                        srvWxUserService.save(srvWxUser);
                    }
                }


                // 消息类型
                String msgType = requestMap.get("MsgType");
                String eventKey = requestMap.get("EventKey");

                System.out.println("msgType:"+msgType);
//                HT-aS_4X7I6BUyEzIx11W1suJM8wR8ZKqEbSUQnWKzRHfad5UYlAdfw5XXwIX0jh
                TextMessage textMessage = new TextMessage();
                switch (eventKey){
                    case "cz001":
                        textMessage.setContent("来了老弟\n没事别乱点击我\n我很忙的还有那个赵兰p你在搞啥");
                        break;
                    case "cz002":
                        textMessage.setContent("你真的就是瓜皮\n没事别乱点击我\n瓜皮其实不是骂人的意思");
                        break;
                    case "czgood":
                        textMessage.setContent("商务请联系110120119");
                        break;
                    case "czgetmz":
//                        1 主动向微信服务器发一个消息
//                        https://api.weixin.qq.com/cgi-bin/message/custom/send?
// access_token=22_jnqDuJVgTA7_UGDxfYKj0N-IFJDAtBfa2w_UDNaL8D_4jaj2Buvk
// KSID4Av-BJAdDAttkoehh8WOf5mHcScfIKOo_gimSipAIcXLc-_yCgInJaYSiMFLpipW9nPxowRBbj13EoE893WWM1wlJFUeADASOD
//                        2 微信回回调到这里再发一个图片消息




//                        PicMessage picMessage = new PicMessage();
//                        picMessage.setFromUserName(toUserName);
//                        picMessage.setToUserName(fromUserName);
//                        picMessage.setMsgType("image");
//                        picMessage.setCreateTime(new Date().getTime());
//                        picMessage.setMediaId("M0rNBA3gTVa9q_NkD_V8EQrCx2qGO3OE-ZVgFJAuX4FT5TTrOCzVHJ1jBNmxzMq8");
//
//
//                        Object json = JSONArray.toJSON(picMessage);
//
//                        String result =  HttpClientTest.doPost("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=22_oyrUO849B4ZTrCDBVYLY9XrSa32NZO0AyeSjRFqof4m6vqRGFrpIIfz3Ir7Lg05aiOxBOSJ3IwgZMzzuwp-8UkfzPllPpZP8I-1_Nf9oH9UsmlE5TMDQgFgQoGa8VNXwM75bglD5WZGJ8E3iYGSbAAARZL",json.toString());
//                        System.out.println("pames:"+json.toString()+" result:"+result);
//
//
//                        String  returnmsg = MessageUtil.picmessageToXml(picMessage);
//                        System.out.println("huoqumeizhao:"+returnmsg);
                        return "";

                }

                textMessage.setFromUserName(toUserName);
                textMessage.setToUserName(fromUserName);
                textMessage.setMsgType("text");
                textMessage.setCreateTime(new Date().getTime());
                String  respMessage = MessageUtil.messageToXml(textMessage);
//                System.out.println("respMessage" + respMessage+"\n    ");
//                return MessageUtil.getXml(fromUserName,toUserName );
                return respMessage;
            }catch (Exception e){
                System.out.println("Exception:"+e.toString());
            }
            return MessageUtil.messageToXml(new TextMessage());
        }
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping(value = "/getindex",method = { RequestMethod.GET, RequestMethod.POST })
    public String getindex(){

        return "wchat/index";
    }

    /**
     * 开始评估
     **/
    @RequestMapping(value = "/start",method = { RequestMethod.GET, RequestMethod.POST })
    public String start(int type){

        if (type==1) {
            return "wchat/assess1";
        }else {
            return "wchat/assess2";
        }
    }

    /**
     * 跳转评估界面
     **/
    @RequestMapping(value = "/gotoassessresult",method = { RequestMethod.GET, RequestMethod.POST })
    public String gotoassessresult(int type){

        if (type==1) {
            return "wchat/assessresult";
        }else {
            return "wchat/assessresult2";
        }
    }
    @RequestMapping(value = "/gohome",method = { RequestMethod.GET, RequestMethod.POST })
    public String gohome(){

            return "wchat/home";
    }

    @RequestMapping(value = "/rationorderFood",method = { RequestMethod.GET, RequestMethod.POST })
    public String rationorderFood(Model model,@RequestParam String wxId,String userAddrId){
        Map<String,Object> map = new HashMap<>();
        map.put("userId", "ea0891f465c94367b7607ad1834e715b");
        List<SrvUserAddr> list = srvUserAddrService.getList(map);
        if(list.size()>0){
            SrvUserAddr srvUserAddr = list.get(0);
            model.addAttribute("model",srvUserAddr);
            model.addAttribute("locs",list);
        }
        return "wchat/rationorderfood";
    }

    @RequestMapping(value = "/locationManage",method = { RequestMethod.GET, RequestMethod.POST })
    public String locationManage(Model model,@RequestParam String wxId,@RequestParam String userAddrId){

        return "wchat/locationlist";
    }

    @RequestMapping(value = "/editLocation",method = { RequestMethod.GET, RequestMethod.POST })
    public String editLocation(){

        return "wchat/location";
    }


    @RequestMapping(value = "/orderInfo",method = { RequestMethod.GET, RequestMethod.POST })
    public String orderInfo(){

        return "wchat/orderinfo";
    }

    @RequestMapping(value = "/healthyFood",method = { RequestMethod.GET, RequestMethod.POST })
    public String healthyFood(Model model,HealthOrderRequest healthOrderRequest){

        SrvUserAddr srvUserAddr = srvUserAddrService.get(healthOrderRequest.getUserAddrId());
        model.addAttribute("model",srvUserAddr);
        model.addAttribute("orderType",healthOrderRequest.getOrderType());
        List<SrvFood> list = srvFoodService.findHealthFood(healthOrderRequest.getUserAddrId(),healthOrderRequest.getCal());
        model.addAttribute("foodList",list);
        return "wchat/healthyfood";
    }




    @RequestMapping(value = "/couponList",method = { RequestMethod.GET, RequestMethod.POST })
    public String couponList(Model model,@RequestParam String wxId,@RequestParam String isValid){
        Map<String,Object> map = new HashMap<>();
        map.put("userId", "ea0891f465c94367b7607ad1834e715b");
        map.put("isValid",isValid);
        map.put("sidx","start_time");

        List<SrvCoupon> list = srvCouponService.getList(map);
        for(SrvCoupon srvCoupon : list){
            srvCoupon.setType(CouponTypeEnum.getValue(srvCoupon.getType()));
        }
        model.addAttribute("model",list);
        return "wchat/couponlist";
    }



    @RequestMapping(value = "modifyLocation")
    @ResponseBody
    public R modifyLocation(SrvUserAddr srvUserAddr) {
        srvUserAddrService.modifyLocation(srvUserAddr);
        return R.ok();
    }

    public R assessOne(AssessOne assessOne) throws ScriptException {
        String repalce = "BMI";
        double bmi = CalcBmiUtil.round(assessOne.getWeight() / (assessOne.getHeight() * assessOne.getHeight()), 1);
        List<SrvBaseSet> list = srvBaseSetService.getList(null);
        SrvBaseSet srvBaseSet = list.get(0);
        String bmiRes = calcBmi(bmi, srvBaseSet, repalce);
        String centerObesityRes = calcCenterObesity(assessOne);
        Double upRes = CalcBmiUtil.calcRes(srvBaseSet.getNormalWeightUp(), new Double[]{assessOne.getHeight() / 100, assessOne.getHeight() / 100}, new String[]{"H", "H"});
        Double normalWeightUp = CalcBmiUtil.round(upRes, 0);
        Double downRes = CalcBmiUtil.calcRes(srvBaseSet.getNormalWeightDown(), new Double[]{assessOne.getHeight() / 100, assessOne.getHeight() / 100}, new String[]{"H", "H"});
        Double normalWeightDown = CalcBmiUtil.round(downRes, 0);
        String overWeight = "";
        if(assessOne.getWeight() - normalWeightUp  > 0){
            overWeight = String.valueOf(assessOne.getWeight() - normalWeightUp);
        }
        Double bee = calcBee(assessOne,srvBaseSet);
        String cal = "";
        if(bmiRes.equals("超重")){

        }else  if(bmiRes.equals("肥胖")){
            cal = String.valueOf(bee * 1.0) + "-";
        }else{
            cal = String.valueOf(bee * assessOne.getSportRatio());
        }

        return R.ok();
    }


    /**
     * 优惠预定
     * @param
     * @return
     */
    @RequestMapping("/saveWxUser")
    @ResponseBody
    public R saveWxUser(BaseWx baseWx){
        SrvWxUser srvWxUser = new SrvWxUser();
        srvWxUser.setWxId(baseWx.getWxId());
        srvWxUser.setWxName(baseWx.getWxName());
        srvWxUser.setId(UUID.generateId());
        srvWxUserService.save(srvWxUser);
        return R.ok();
    }

    @RequestMapping(value = "/getRecommendFood")
    @ResponseBody
    public R getRecommendFood(HealthOrderRequest healthOrderRequest){
        List<SrvFood> list = srvFoodService.findHealthFood(healthOrderRequest.getUserAddrId(),healthOrderRequest.getCal());
        return R.ok().put("data",list);
    }

    @RequestMapping(value = "/saveOrder")
    @ResponseBody
    public R saveOrder(WxOrder wxOrder){
        srvOrderService.save(wxOrder);
        return R.ok();
    }

    /**
     * 查询订单列表
     * @param
     * @return
     */
    @RequestMapping("/queryOrderList")
    @ResponseBody
    public R queryOrderList(@RequestParam String wxId,@RequestParam Integer page,@RequestParam Integer limit,String status){
        Map<String,Object> params = new HashMap<>();
        SrvWxUser srvWxUser = srvWxUserService.getByOpenId(wxId);
        String userId = srvWxUser != null ? srvWxUser.getId() : "userId";
        params.put("userId",userId);
        params.put("status",status);
        params.put("page",page);
        params.put("limit",limit);
        params.put("sidx","orderTime");
        params.put("order","asc");
        Query query = new Query(params);
        List<SrvOrder> orderList = srvOrderService.getList(query);
        Map<String,Object> map = new HashMap<>();
        for(SrvOrder srvOrder : orderList){
            map.put("orderId", srvOrder.getId());
            srvOrder.setStatusText(OrderStatusEnum.getValue(srvOrder.getStatus()));
            List<SrvOrderFood> list = srvOrderFoodService.getList(map);
            srvOrder.setFoodList(list);
        }
        int total = srvOrderService.getCount(query);
        PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    /**
     * 取消订单
     * @param
     * @return
     */
    @RequestMapping("/cancelOrder")
    @ResponseBody
    public R cancelOrder(@RequestParam String wxId,@RequestParam String orderId){
        SrvOrder srvOrder = srvOrderService.get(orderId);
        if(OrderStatusEnum.ORDRT_STATUS2.getCode().equals(srvOrder.getStatus())){
            srvOrder.setStatus(OrderStatusEnum.ORDRT_STATUS8.getCode());
            srvOrderService.update(srvOrder);
            return R.ok();
        }
        return R.error("该订单不能取消");
    }

    /**
     * 查询优惠券
     * @param
     * @return
     */
    @RequestMapping("/queryCoupon")
    @ResponseBody
    public R queryCoupon(@RequestParam String wxId,@RequestParam String orderId){
        Map<String,Object> params = new HashMap<>();
        SrvWxUser srvWxUser = srvWxUserService.getByOpenId(wxId);
        String userId = srvWxUser != null ? srvWxUser.getId() : "userId";
        params.put("userId", userId);
        List<SrvCoupon> list = srvCouponService.getList(params);
        for(SrvCoupon srvCoupon : list){
            Date now = new Date();
            Integer res1 = DateUtil.compareDate(now, srvCoupon.getStartTime());
            Integer res2 = DateUtil.compareDate(srvCoupon.getEndTime(), now);
            if(res1 == res2 && res1 == 1)
                srvCoupon.setIsValid("1");
            else
                srvCoupon.setIsValid("0");
        }
        return R.ok().put("data", list);
    }

    /**
     * 优惠预定
     * @param
     * @return
     */
    @RequestMapping("/discountReserve")
    @ResponseBody
    public R discountReserve(WxDiscounreserve wxDiscounreserve){
        SrvDiscounreserve srvDiscounreserve = new SrvDiscounreserve();
        SrvWxUser srvWxUser = srvWxUserService.getByOpenId(wxDiscounreserve.getWxId());
        srvDiscounreserve.setUserId(srvWxUser.getId());
        srvDiscounreserve.setDiscountStart(new Date());
        if(wxDiscounreserve.equals("1")){
            srvDiscounreserve.setDiscountEnd(DateUtil.getLaterWeek());
            srvDiscounreserve.setDiscount(0.9);

        }else if(wxDiscounreserve.equals("2")){
            srvDiscounreserve.setDiscountEnd(DateUtil.getLaterMonth());
            srvDiscounreserve.setDiscount(0.8);
        }
        srvDiscounreserve.setStatus("2");
        srvDiscounreserve.setRemark(wxDiscounreserve.getRemark());
        srvDiscounreserveService.save(srvDiscounreserve);
        return R.ok();
    }


    public String calcBmi(double bmi,SrvBaseSet srvBaseSet,String repalce) throws ScriptException{
        String thin = srvBaseSet.getThin();
        boolean flag1 = CalcBmiUtil.calcBmi(thin, repalce, bmi);
        String norma = srvBaseSet.getNormal();
        boolean flag2 = CalcBmiUtil.calcBmi(norma, repalce, bmi);
        String overWeight = srvBaseSet.getOverWeight();
        boolean flag3 = CalcBmiUtil.calcBmi(overWeight, repalce, bmi);
        String obesity = srvBaseSet.getObesity();
        boolean flag4 = CalcBmiUtil.calcBmi(obesity, repalce, bmi);
        String bmiRes = "";
        if(flag1){
            bmiRes = "偏瘦";
        }
        if(flag2){
            bmiRes = "正常";
        }
        if(flag3){
            bmiRes = "超重";
        }
        if(flag4){
            bmiRes = "肥胖";
        }
        return bmiRes;
    }

    public String calcCenterObesity(AssessOne assessOne){
        // 中心型肥胖： 中心型肥胖前期，85	<=	男性腰围 <90 ，80	<=	 女性腰围 <85 ，中心型肥胖，男性腰围>=90，女性腰围>=85
        String centerObesityRes = "";
        if(assessOne.getSex().equals("男")){
            if(assessOne.getWaistline()>=90){
                centerObesityRes = "中心型肥胖";
            }else if (assessOne.getWaistline()>= 85 && assessOne.getWaistline()<90){
                centerObesityRes = "中心型肥胖前期";
            }
        }else  if(assessOne.getSex().equals("女")){
            if(assessOne.getWaistline()>=85){
                centerObesityRes = "中心型肥胖";
            }else if (assessOne.getWaistline()>= 80 && assessOne.getWaistline()<85){
                centerObesityRes = "中心型肥胖前期";
            }
        }
        return centerObesityRes;
    }

    public Double calcBee(AssessOne assessOne,SrvBaseSet srvBaseSet) throws ScriptException {
        if(assessOne.getSex().equals("男")){
            Double beeRes = CalcBmiUtil.calcRes(srvBaseSet.getManBee(), new Double[]{assessOne.getWeight(), assessOne.getHeight() / 100, Double.valueOf(assessOne.getAge())}, new String[]{"W", "H", "A"});
            Double bee = CalcBmiUtil.round(beeRes, 0);
            return bee;
        }else{
            Double beeRes = CalcBmiUtil.calcRes(srvBaseSet.getWoman(), new Double[]{assessOne.getWeight(), assessOne.getHeight() / 100, Double.valueOf(assessOne.getAge())}, new String[]{"W", "H", "A"});
            Double bee = CalcBmiUtil.round(beeRes, 0);
            return bee;
        }
    }




    public R assessTwo(){

        return R.ok();
    }
}
