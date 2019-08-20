package xin.cymall.controller;

import com.aliyun.oss.common.utils.LogUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.api.impl.WxMpUserServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.config.WxConfig;
import xin.cymall.common.dadaexpress.DaDaExpressUtil;
import xin.cymall.common.dadaexpress.client.CallBackInfo;
import xin.cymall.common.dadaexpress.client.DadaApiResponse;
import xin.cymall.common.dadaexpress.domain.merchant.ShopAddModel;
import xin.cymall.common.dadaexpress.utils.JSONUtil;
import xin.cymall.common.enumresource.CouponTypeEnum;
import xin.cymall.common.enumresource.OrderStatusEnum;
import xin.cymall.common.utils.*;
import xin.cymall.common.utils.UUID;
import xin.cymall.common.wxpay.UnifiedOrderRequest;
import xin.cymall.common.wxpay.UnifiedOrderRespose;
import xin.cymall.common.wxpay.WXPayConstants;
import xin.cymall.common.wxpay.WXPayUtil;
import xin.cymall.entity.*;
import xin.cymall.entity.wchart.*;
import xin.cymall.service.*;

import javax.script.ScriptException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wx")
public class WchartController {
    private static Logger log = LoggerFactory.getLogger(WchartController.class);
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
    @Autowired
    private SrvRestaurantService srvRestaurantService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private SrvMerchanopinionService srvMerchanopinionService;


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
    @RequestMapping(value = "calcAssess")
    public String calcAssess(Model model,String code) throws WxErrorException {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxConfig.wxMpServiceHttpClientImpl().oauth2getAccessToken(code);
        model.addAttribute("wxId", wxMpOAuth2AccessToken.getOpenId());
        return "wchat/calcassess";
    }

    /**
     * 跳转到新增页面
     **/
    @RequestMapping(value = "getTxt")
    public String getTxt(){
        return "wchat/MP_verify_WJQPqHT0Gtmm3CO2.txt";
    }

    /**
     * 开始评估
     **/
    @RequestMapping(value = "calcPage")
    public String calcPage(String type){
        if (type.equals("1")) {
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

    /**
     *
     * 功能描述: 餐品详情
     *
     * @param:
     * @return:
     * @auther:
     * @date: 2019/8/2 9:41
     */
    @RequestMapping(value = "/foodInfo",method = { RequestMethod.GET, RequestMethod.POST })
    public String foodInfo(Model model,String restaurantId,String foodId){
        Map<String,Object> foodMap = srvFoodService.queryfoodInfo(foodId, restaurantId);
        Map<String, Object> params = new HashMap<>();
        params.put("restaurantId", restaurantId);
        List<SrvMerchanopinion> list = srvMerchanopinionService.getList(params);
        String imagePath = String.valueOf(foodMap.get("image_path"));
        String[] imgs = imagePath.split(",");
        foodMap.put("commentList", list);
        foodMap.put("imageList", imgs);
        model.addAttribute("model", foodMap);
        return "wchat/healthyfooddetil";
    }

    @RequestMapping(value = "/saveComment",method = { RequestMethod.GET, RequestMethod.POST })
    public R saveComment(@RequestParam String wxId,@RequestParam String restaurantId,@RequestParam String content) {
        SrvWxUser srvWxUser = srvWxUserService.getByOpenId(wxId);
        SrvMerchanopinion srvMerchanopinion = new SrvMerchanopinion();
        srvMerchanopinion.setName(srvWxUser.getWxName());
        srvMerchanopinion.setCommentTime(new Date());
        srvMerchanopinion.setContent(content);
        srvMerchanopinion.setStatus("0");
        srvMerchanopinionService.save(srvMerchanopinion);
        return R.ok();
    }





    @RequestMapping(value = "/rationorderFood",method = { RequestMethod.GET, RequestMethod.POST })
    public String rationorderFood(Model model,String code) throws WxErrorException {
        Map<String,Object> map = new HashMap<>();
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxConfig.wxMpServiceHttpClientImpl().oauth2getAccessToken(code);
        SrvWxUser srvWxUser = srvWxUserService.getByOpenId(wxMpOAuth2AccessToken.getOpenId());
        map.put("userId", srvWxUser.getId());
        List<SrvUserAddr> list = srvUserAddrService.getList(map);
        if(list.size()>0){
            SrvUserAddr srvUserAddr = list.get(0);
            model.addAttribute("model",srvUserAddr);
            model.addAttribute("locs",list);
        }
        model.addAttribute("wxId", wxMpOAuth2AccessToken.getOpenId());
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


    @RequestMapping(value = "/wchart",method = { RequestMethod.GET, RequestMethod.POST })
    public String wchart(Model model,String state,String code) throws WxErrorException {
        model.addAttribute("state", state);
        model.addAttribute("code", code);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxConfig.wxMpServiceHttpClientImpl().oauth2getAccessToken(code);
        System.out.println(wxMpOAuth2AccessToken.getOpenId());
        return "wchat/wchart";
    }

    @RequestMapping(value = "/orderInfo",method = { RequestMethod.GET, RequestMethod.POST })
    public String orderInfo(Model model,@RequestParam String orderId){
        SrvOrder srvOrder = srvOrderService.get(orderId);
        if(srvOrder != null) {
            srvOrder.setStatusText(OrderStatusEnum.getValue(srvOrder.getStatus()));
            Map<String, Object> params = new HashMap<>();
            params.put("orderId", srvOrder.getId());
            List<SrvOrderFood> list = srvOrderFoodService.getList(params);
            for(SrvOrderFood srvOrderFood : list){
                if(!StringUtil.isEmpty(srvOrderFood.getImagePath())) {
                    srvOrderFood.setImagePath(srvOrderFood.getImagePath().split(",")[0]);
                }
            }
            srvOrder.setFoodList(list);
            SrvUserAddr userAddr = srvUserAddrService.get(srvOrder.getUserAddrId());
            model.addAttribute("order", srvOrder);
            model.addAttribute("location", userAddr);
        }
        return "wchat/orderinfo";
    }

    @RequestMapping(value = "/healthyFood",method = { RequestMethod.GET, RequestMethod.POST })
    public String healthyFood(Model model,HealthOrderRequest healthOrderRequest){
        SrvUserAddr srvUserAddr = srvUserAddrService.get(healthOrderRequest.getUserAddrId());
        model.addAttribute("model", srvUserAddr);
        model.addAttribute("wxId", healthOrderRequest.getWxId());
        model.addAttribute("orderType", healthOrderRequest.getOrderType());
        List<SrvFood> list = srvFoodService.findHealthFood( healthOrderRequest.getCal());
        for(SrvFood srvFood : list){
            if(!StringUtil.isEmpty(srvFood.getImagePath())) {
                srvFood.setImagePath(srvFood.getImagePath().split(",")[0]);
            }
        }
        model.addAttribute("foodList", list);
        return "wchat/healthyfood";
    }




    @RequestMapping(value = "/couponList",method = { RequestMethod.GET, RequestMethod.POST })
    public String couponList(Model model) {
        return "wchat/couponlist";
    }

    @RequestMapping(value = "/orderList")
    public String orderList(Model model,String code) throws WxErrorException {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxConfig.wxMpServiceHttpClientImpl().oauth2getAccessToken(code);
        model.addAttribute("wxId", wxMpOAuth2AccessToken.getOpenId());
        return "wchat/orderlist";
    }

    /**
     *优惠预订
     **/
    @RequestMapping(value = "/discounreserve")
    public String discounreserve(Model model,String code) throws WxErrorException {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxConfig.wxMpServiceHttpClientImpl().oauth2getAccessToken(code);
        model.addAttribute("wxId", wxMpOAuth2AccessToken.getOpenId());
        return "wchat/discounreserve";
    }


    @RequestMapping(value = "modifyLocation")
    @ResponseBody
    public R modifyLocation(SrvUserAddr srvUserAddr) throws IOException {
        String[] location = BaiduMapUtil.getPoint(srvUserAddr.getReceiveAddr());
        if(location.length == 0){
            return R.error("请输入正确的收获地址!");
        }
        srvUserAddr.setLng(location[0]);
        srvUserAddr.setLat(location[1]);
        srvUserAddrService.modifyLocation(srvUserAddr);
        return R.ok().put("data",srvUserAddr);

    }

    @RequestMapping(value = "assessOne")
    public String assessOne(Model model,AssessOne assessOne) throws ScriptException {
        String repalce = "BMI";
        List<SrvBaseSet> list = srvBaseSetService.getList(null);
        SrvBaseSet srvBaseSet = list.get(0);
        double bmi = CalcBmiUtil.round(CalcBmiUtil.calcRes(srvBaseSet.getBmi(), new Double[]{assessOne.getWeight(), assessOne.getHeight() / 100, assessOne.getHeight() / 100}, new String[]{"W", "H", "H"}), 1);
        String bmiRes = calcBmi(bmi, srvBaseSet, repalce);
        String centerObesityRes = calcCenterObesity(assessOne.getSex(),assessOne.getWaistline());
        Double upRes = CalcBmiUtil.calcRes(srvBaseSet.getNormalWeightUp(), new Double[]{assessOne.getHeight() / 100, assessOne.getHeight() / 100}, new String[]{"H", "H"});
        Double normalWeightUp = CalcBmiUtil.round(upRes, 1);
        Double downRes = CalcBmiUtil.calcRes(srvBaseSet.getNormalWeightDown(), new Double[]{assessOne.getHeight() / 100, assessOne.getHeight() / 100}, new String[]{"H", "H"});
        Double normalWeightDown = CalcBmiUtil.round(downRes, 1);
        String overWeight = "0";
        if(assessOne.getWeight() - normalWeightUp  > 0){
            overWeight = String.valueOf(assessOne.getWeight() - normalWeightUp);
        }
        Double bee = calcBee(assessOne,srvBaseSet);
        Double zrl = bee * assessOne.getSportRatio();
        Double cal = 0d;
        if(bmiRes.equals("超重")){
            cal = CalcBmiUtil.calcRes(srvBaseSet.getObesityHeatUp(),new Double[]{zrl},new String[]{"ZRL"});
        }else  if(bmiRes.equals("肥胖")){
            cal = CalcBmiUtil.calcRes(srvBaseSet.getObesityHeatUp(),new Double[]{zrl},new String[]{"ZRL"});
        }else{
            srvBaseSet.getObesityHeatUp();
            cal = zrl;
        }
        Map<String,Object> assessMap = new HashMap<>();
        assessMap.put("bmi",bmi);
        assessMap.put("bmiRes",bmiRes);
        assessMap.put("centerObesityRes",centerObesityRes);
        assessMap.put("upRes",normalWeightUp);
        assessMap.put("downRes",normalWeightDown);
        assessMap.put("overWeight", overWeight);
        assessMap.put("cal",cal);
        model.addAttribute("model",assessMap);
        return "wchat/assessresult";
    }

    @RequestMapping(value = "assessTwo")
    public String assessTwo(Model model,AssessTwo assessTwo) throws ScriptException {
        String repalce = "BMI";
        String centerObesityRes = calcCenterObesity(assessTwo.getSex(), assessTwo.getWaistline());
        Map<String,Object> assessMap = new HashMap<>();
        assessMap.put("centerObesityRes", centerObesityRes);
        Double cal = (assessTwo.getWeight() * 21.6 + 370) * 1.2 - 500;
        assessMap.put("cal", cal);
        model.addAttribute("model", assessMap);
        return "wchat/assessresult2";
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
    public R getRecommendFood(HealthOrderRequest healthOrderRequest) {
        List<SrvFood> list = srvFoodService.findHealthFood(healthOrderRequest.getCal());
        return R.ok().put("data", list);
    }

    @RequestMapping(value = "/saveOrder")
    @ResponseBody
    public R saveOrder(WxOrder wxOrder) throws IOException {
        String orderNo = srvOrderService.save(wxOrder);
        return R.ok().put("orderNo", orderNo);
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
     * 查询订单列表
     * @param
     * @return
     */
    @RequestMapping("/myOrderList")
    @ResponseBody
    public R myOrderList(@RequestParam String wxId,String status){
        Map<String,Object> params = new HashMap<>();
        SrvWxUser srvWxUser = srvWxUserService.getByOpenId(wxId);
        params.put("userId",srvWxUser.getId());
        params.put("status",status);
        List<SrvOrder> orderList = srvOrderService.getList(params);
        for(SrvOrder srvOrder : orderList){
            srvOrder.setStatusText(OrderStatusEnum.getValue(srvOrder.getStatus()));
        }
        return R.ok().put("data", orderList);

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
        srvDiscounreserve.setId(UUID.generateId());
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

    public String calcCenterObesity(String sex,Double waistline ){
        // 中心型肥胖： 中心型肥胖前期，85	<=	男性腰围 <90 ，80	<=	 女性腰围 <85 ，中心型肥胖，男性腰围>=90，女性腰围>=85
        String centerObesityRes = "因您未填写腰围数据，未能判定是否为中心型肥胖";
        if(waistline == null){
            return centerObesityRes;
        }
        if("1".equals(sex) && waistline>0){
            if(waistline>=90){
                centerObesityRes = "中心型肥胖";
            }else if (waistline >= 85 && waistline < 90){
                centerObesityRes = "中心型肥胖前期";
            }else{
                centerObesityRes = "正常";
            }
        }else  if("2".equals(sex) && waistline > 0){
            if(waistline>=85){
                centerObesityRes = "中心型肥胖";
            }else if (waistline >= 80 && waistline < 85){
                centerObesityRes = "中心型肥胖前期";
            }
        }
        return centerObesityRes;
    }

    public Double calcBee(AssessOne assessOne,SrvBaseSet srvBaseSet) throws ScriptException {
        if(assessOne.getSex().equals("1")){
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








    /**
     * 获取终端IP
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request)  {
        String ip  =  request.getHeader( " x-forwarded-for " );
        if (ip == null || ip.length() == 0 || " unknown " .equalsIgnoreCase(ip))  {
            ip = request.getHeader( " Proxy-Client-IP " );
        }
        if (ip  == null || ip.length() == 0 || " unknown " .equalsIgnoreCase(ip))  {
            ip  =  request.getHeader( " WL-Proxy-Client-IP " );
        }
        if (ip  == null || ip.length() == 0 || " unknown " .equalsIgnoreCase(ip))  {
            ip  =  request.getRemoteAddr();
        }
        return  ip;
    }
    /**
     * 支付初始化
     * @param payMoney
     * @return
     */
    @RequestMapping("/toPayInit")
    @ResponseBody
    public SortedMap<String,String> toPay(HttpServletRequest request,
                                          @RequestParam(value="payMoney",required=true) String payMoney,
                                          @RequestParam(value="wxId",required=true) String wxId,
                                          @RequestParam(value="orderNo",required=true) String orderNo){
        Map<String,Object> map = new HashMap<>();
//        String orderId = String.valueOf(WXPayUtil.generateUUID());
        String noncestr = WXPayUtil.generateNonceStr();
        Map<String,String> requestMap = new HashMap<String, String>();
        requestMap.put("appId", "wx688906a5f5df8b37");
        requestMap.put("userWeixinOpenId",wxId);
        requestMap.put("out_trade_no",orderNo);
        requestMap.put("mch_id", "1542729801");//商家号
        requestMap.put("payMoney",payMoney);
        requestMap.put("spbill_create_ip", getIpAddr(request));
        requestMap.put("notify_url", "http://www.tastyfit.vip/wx/paymentNotice");// 这个回调url
        requestMap.put("noncestr", noncestr);
        requestMap.put("body","tt");
        requestMap.put("detail","te");
        Map<String,Object> requestInfo = WXPayUtil.createOrderInfo(requestMap);
        String orderInfo_toString = (String) requestInfo.get("orderInfo_toString");

        //判断返回码
        UnifiedOrderRespose orderResponse = WXPayUtil.httpOrder(orderInfo_toString);// 调用统一下单接口
        //根据微信文档return_code 和result_code都为SUCCESS的时候才会返回code_url
        if(null!=orderResponse  && "SUCCESS".equals(orderResponse.getReturn_code()) && "SUCCESS".equals(orderResponse.getResult_code())){
            String timestamp = String.valueOf(WXPayUtil.getCurrentTimestamp());
            SortedMap<String, String> packageParams = new TreeMap<String, String>();
            packageParams.put("appId","wx688906a5f5df8b37");//你的appId
            packageParams.put("timeStamp", timestamp);
            packageParams.put("nonceStr",  WXPayUtil.generateNonceStr());
            String packages = "prepay_id="+orderResponse.getPrepay_id();
            packageParams.put("package",packages);
            packageParams.put("signType",WXPayConstants.MD5);
            String sign = null;//这个梗，就是开头说的，弄了半天才弄出来的
            try {
                sign = WXPayUtil.generateSignature(packageParams,"QlP1QiBYOEfeck4MFJC5OrZPQRe1uFBQ");//秘钥
            } catch (Exception e) {
                map.put("result",-1);
                e.printStackTrace();
            }
            if(sign!=null && !"".equals(sign)){
                packageParams.put("paySign",sign);
            }
            return packageParams;
        }else{ //不成功
            String text = "调用微信支付出错，返回状态码："+orderResponse.getReturn_code()+"，返回信息："+orderResponse.getReturn_msg();
            if(orderResponse.getErr_code()!=null && !"".equals(orderResponse.getErr_code())){
                text = text +"，错误码："+orderResponse.getErr_code()+"，错误描述："+orderResponse.getErr_code_des();
            }
            log.error(text);
            return null;
        }
    }


    /**
     *业务代码保存准备支付的信息
     *toSavePayInfo
     ***/
    @RequestMapping(value="/toSavePayInfo",produces="text/html;charset=utf-8")
    @ResponseBody
    public String WeixinParentNotifyPage(){

        //		TODO  做我们自己的
        return "";
    }

    /**
     * 异步回调接口
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/paymentNotice")
    public void WeixinParentNotifyPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("application/xml");
        ServletInputStream instream = request.getInputStream();
        StringBuffer sb = new StringBuffer();
        int len = -1;
        byte[] buffer = new byte[1024];
        while((len = instream.read(buffer)) != -1){
            sb.append(new String(buffer,0,len));
        }
        instream.close();
//		log.error("支付通知回调信息："+sb.toString());
//		Map<String,String> map = WXPayUtil.doXMLParseWithSorted(sb.toString());//接受微信的通知参数
        Map<String,String> map = WXPayUtil.xmlToMap(sb.toString());//接受微信的回调的通知参数
        Map<String,String> return_data = new HashMap<String,String>();
        //判断签名是否正确
        if(WXPayUtil.isSignatureValid(map, "QlP1QiBYOEfeck4MFJC5OrZPQRe1uFBQ")){
            if(map.get("return_code").toString().equals("FAIL")){
                return_data.put("return_code", "FAIL");
                return_data.put("return_msg", map.get("return_msg"));
            }else if(map.get("return_code").toString().equals("SUCCESS")){
                String out_trade_no = map.get("out_trade_no").toString();
                return_data.put("return_code", "SUCCESS");
                return_data.put("return_msg", "OK");
                LogUtils.getLog().debug("订单号："+out_trade_no+"支付成功");
                srvOrderService.updateOrderSuccessCallback(out_trade_no);
            }
        }else{
            return_data.put("return_code", "FAIL");
            return_data.put("return_msg", "签名错误");
        }
        String xml = WXPayUtil.GetMapToXML(return_data);
        log.info("支付通知回调结果："+xml);
        response.getWriter().print(xml);
    }

    @RequestMapping(value="/queryWayFee")
    @ResponseBody
    public R queryWayFee(String restaurantId,String userAddrId,String dadaOrder,Double totalAmount){
        SrvRestaurant srvRestaurant = srvRestaurantService.get(restaurantId);
        SrvUserAddr srvUserAddr = srvUserAddrService.get(userAddrId);
        String areaStr = areaService.getAreaNameStr(srvRestaurant.getArea());
        String[] areas = areaStr.split(",");
        Map<String,Object> orderedMap = new HashMap<>();
        if (areas.length == 3) {
            orderedMap =  DaDaExpressUtil.querydeliverfee(srvRestaurant,srvUserAddr,areas[1],totalAmount);
        }
        return R.ok().put("data",orderedMap);

    }

    @RequestMapping(value="/orderCallBack",produces = "application/json;charset=UTF-8")
    public void orderCallBack(@RequestBody CallBackInfo callBackInfo){
        //达达返回运单号
        String expressNum = callBackInfo.getClient_id();
        //提交给运单号
        String dadaOrder = callBackInfo.getOrder_id();

        Integer orderStatus = callBackInfo.getOrder_status();
        if(orderStatus == 1){
            //待接单
        }else if(orderStatus == 2){
            //待取货
            String expressName = callBackInfo.getDm_name();
            String expressPhone = callBackInfo.getDm_mobile();
            srvOrderService.updateOrderDada(dadaOrder,OrderStatusEnum.ORDRT_STATUS5.getCode(),expressName,expressPhone);
            LogUtils.getLog().info(expressNum+":已接单,待取货");

        }else if(orderStatus == 3){
            //配送中
            srvOrderService.updateOrderDada(dadaOrder,OrderStatusEnum.ORDRT_STATUS6.getCode(),"","");
            LogUtils.getLog().info(expressNum + ":配送中");

        } else if(orderStatus == 4){
            //已完成
            srvOrderService.updateOrderDada(dadaOrder,OrderStatusEnum.ORDRT_STATUS7.getCode(),"","");
            LogUtils.getLog().info(expressNum + ":已完成");

        }else if(orderStatus == 5){
            //已取消
            String cancelReason = callBackInfo.getCancel_reason();
            LogUtils.getLog().info(expressNum + ":已取消,"+"取消原因:"+cancelReason);

        }else if(orderStatus == 7){
            //已过期
            LogUtils.getLog().info(expressNum + ":已过期");
        }else if(orderStatus == 8){
            //指派单
        }else if(orderStatus == 9){
            //妥投异常之物品返回中 配送员在收货地，无法正常送到用户手中（包括用户电话打不通、客户暂时不方便收件、客户拒收、货物有问题等等）
            LogUtils.getLog().info(expressNum + ":妥投异常之物品返回中 配送员在收货地，无法正常送到用户手中（包括用户电话打不通、客户暂时不方便收件、客户拒收、货物有问题等等）");

        }else if(orderStatus == 100){
            //骑士到店
            LogUtils.getLog().info(expressNum + ":骑士到店");

        }else if(orderStatus == 1000){
            //创建达达运单失败=
        }



    }
    /**
     * 跳转到详情
     **/
    @RequestMapping(value = "gotodetail")
    public String gotodetail(Model model, String foodid){
        System.out.println("----->"+foodid);
        return "wchat/healthyfooddetil";
    }


    /**
     * 跳转到新增页面
     **/
    @RequestMapping(value = "getindex")
    public String getIndex(){
        return "wchat/assess1";
    }





}
