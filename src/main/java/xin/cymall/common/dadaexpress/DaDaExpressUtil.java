package xin.cymall.common.dadaexpress;



import xin.cymall.common.dadaexpress.client.DadaApiResponse;
import xin.cymall.common.dadaexpress.client.DadaRequestClient;
import xin.cymall.common.dadaexpress.config.AppConfig;
import xin.cymall.common.dadaexpress.domain.merchant.MerchantAddModel;
import xin.cymall.common.dadaexpress.domain.merchant.ShopAddModel;
import xin.cymall.common.dadaexpress.domain.order.AddAfterQueryModel;
import xin.cymall.common.dadaexpress.domain.order.OrderAddModel;
import xin.cymall.common.dadaexpress.domain.order.QueryDeliverFeeModel;
import xin.cymall.common.dadaexpress.service.CityCodeService;
import xin.cymall.common.dadaexpress.service.merchant.MerchantAddService;
import xin.cymall.common.dadaexpress.service.merchant.ShopAddService;
import xin.cymall.common.dadaexpress.service.order.AddAfterQueryService;
import xin.cymall.common.dadaexpress.service.order.OrderAddService;
import xin.cymall.common.dadaexpress.service.order.QueryDeliverFeeService;
import xin.cymall.common.dadaexpress.service.order.QueryShopDetailService;
import xin.cymall.common.dadaexpress.utils.JSONUtil;
import xin.cymall.entity.SrvRestaurant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2019/07/15
 */
public class DaDaExpressUtil {

/**达达文档
 *
 * url:  https://newopen.imdada.cn/
 * username：  youpinyouwei
 * password:
 * **/


    /**
     * 添加一个订单
     * 城市code 要先请求城市code代码
     * 上线的时候isonline 要改为true
     * 2019/07/15
     * <p>
     * 新增订单
     * 接口简介
     * 新增配送单接口
     * <p>
     * (1) 接口调用URL地址：/api/order/addOrder。
     * (2) 在测试环境，使用统一商户和门店进行发单。其中，商户id：73753，门店编号：11047059。
     **/
    private static DadaApiResponse addOrder() {
        // 1.初始化配置(isOnline表示是否测试环境)
        AppConfig appConfig = new AppConfig(false);

        // 2.初始化model
        OrderAddModel orderAddModel = new OrderAddModel();
        orderAddModel.setShopNo("11664071");
        orderAddModel.setOriginId(String.valueOf(System.currentTimeMillis()));
        orderAddModel.setCityCode("021");
        orderAddModel.setCargoPrice(BigDecimal.valueOf(111));
        orderAddModel.setIsPrepay(0);
        orderAddModel.setReceiverName("测试达达");
        orderAddModel.setReceiverAddress("隆宇大厦");
        orderAddModel.setReceiverLat(BigDecimal.valueOf(31.228623));
        orderAddModel.setReceiverLng(BigDecimal.valueOf(121.587172));
        orderAddModel.setReceiverPhone("13622219090");
        //TODO 需要设置我们自己的回调地址老铁
        //TODO 每次订单状态发生变化时，会对添加订单接口中callback的URL进行回调。
        //TODO 参数以application/json方式传递。若回调服务器响应失败（响应非200），会每隔1分钟重试一次，最多重试10次
        orderAddModel.setCallback("http://newopen.qa.imdada.cn");

        // 3.初始化service
        OrderAddService orderService = new OrderAddService(orderAddModel.toJson());

        // 4.初始化客户端
        DadaRequestClient dadaClient = new DadaRequestClient(orderService, appConfig);
        return dadaClient.callRpc();
    }


    /**
     * 新增门店
     * 接口简介
     * 批量新增门店接口,接口URL地址：/api/shop/add
     * <p>
     * 1. 门店编码可自定义，但必须唯一，若不填写，则系统自动生成。发单时用于确认发单门店
     * 2. 如果需要使用达达商家App发单，请设置登陆达达商家App的账号（必须手机号）和密码
     * 3. 该接口为批量接口,业务参数为数组
     **/

    public static DadaApiResponse addShop(SrvRestaurant srvRestaurant,String cityName,String areaName) {

        // 1.初始化配置(isOnline表示是否测试环境)
        AppConfig appConfig = new AppConfig(false);

        // 2.初始化model
        ShopAddModel shopAddModel = new ShopAddModel();
        shopAddModel.setOriginShopId(srvRestaurant.getId());
        shopAddModel.setStationName(srvRestaurant.getName());
        shopAddModel.setBusiness(1);
        shopAddModel.setCityName(cityName);
        shopAddModel.setAreaName(areaName);
        shopAddModel.setStationAddress(srvRestaurant.getAddr());
        shopAddModel.setLng(new BigDecimal(srvRestaurant.getLng()));
        shopAddModel.setLat(new BigDecimal(srvRestaurant.getLat()));
        shopAddModel.setContactName(srvRestaurant.getContact());
        shopAddModel.setPhone(srvRestaurant.getPhone());

        // 3.初始化service (门店新增比较特殊,是一个批量新增接口)
        List<ShopAddModel> shopAddList = new ArrayList<ShopAddModel>();
        shopAddList.add(shopAddModel);
        ShopAddService shopAddService = new ShopAddService(JSONUtil.toJson(shopAddList));


        // 4.初始化客户端
        DadaRequestClient dadaClient = new DadaRequestClient(shopAddService, appConfig);
        return dadaClient.callRpc();
    }

    /**
     * 注册商户
     * 接口简介
     * 商户注册接口,并完成与该商户的绑定.生成的初始化密码会以短信形式发送给注册手机号
     * <p>
     * 接口URL地址：/merchantApi/merchant/add
     **/
    private static DadaApiResponse addMerchant() {

        // 1.初始化配置(isOnline表示是否测试环境)
        AppConfig appConfig = new AppConfig(false);

        // 2.初始化model
        MerchantAddModel merchantAddModel = new MerchantAddModel();
        merchantAddModel.setCityName("");
        merchantAddModel.setContactName("");
        merchantAddModel.setContactPhone("");
        merchantAddModel.setEmail("");
        merchantAddModel.setEnterpriseAddress("");
        merchantAddModel.setMobile("");
        merchantAddModel.setMobile("");

        // 3.初始化service
        MerchantAddService merchantAddService = new MerchantAddService(merchantAddModel.toJson());


        // 4.初始化客户端
        DadaRequestClient dadaClient = new DadaRequestClient(merchantAddService, appConfig);
        return dadaClient.callRpc();
    }

    /**
     * 查询城市列表的
     **/
    private static DadaApiResponse queryCityCode() {
        // 1.初始化配置(isOnline表示是否测试环境)
        AppConfig appConfig = new AppConfig(true);

        // 2.初始化service
        CityCodeService cityCodeService = new CityCodeService("");

        // 3.初始化客户端
        DadaRequestClient dadaClient = new DadaRequestClient(cityCodeService, appConfig);
        return dadaClient.callRpc();
    }

    /**
     * 查询门店详情
     */

    public static DadaApiResponse queryShopDetail(String shopId){
        // 1.初始化配置(isOnline表示是否测试环境)
        AppConfig appConfig = new AppConfig(false);
        ShopAddModel shopAddModel = new ShopAddModel();
        shopAddModel.setOriginShopId(shopId);

        System.out.println(shopAddModel.toJson());
        // 3.初始化service
        QueryShopDetailService queryShopDetailService = new QueryShopDetailService(shopAddModel.toJson());

        // 4.初始化客户端
        DadaRequestClient dadaClient = new DadaRequestClient(queryShopDetailService, appConfig);
        return dadaClient.callRpc();

    }


    /**
     * 查询订单运费接口
     **/
    public static DadaApiResponse querydeliverfee() {

        // 1.初始化配置(isOnline表示是否测试环境)
        AppConfig appConfig = new AppConfig(false);

        // 2.初始化model
        QueryDeliverFeeModel queryDeliverFeeModel = new QueryDeliverFeeModel();
        queryDeliverFeeModel.setShopNo("11047059");
        queryDeliverFeeModel.setOriginId(String.valueOf(System.currentTimeMillis()));
        queryDeliverFeeModel.setCityCode("021");
        queryDeliverFeeModel.setCargoPrice(BigDecimal.valueOf(111));
        queryDeliverFeeModel.setIsPrepay(0);
        queryDeliverFeeModel.setReceiverName("测试达达");
        queryDeliverFeeModel.setReceiverAddress("隆宇大厦");
        queryDeliverFeeModel.setReceiverLat(BigDecimal.valueOf(31.228623));
        queryDeliverFeeModel.setReceiverLng(BigDecimal.valueOf(121.587172));
        queryDeliverFeeModel.setReceiverPhone("13622219090");
        queryDeliverFeeModel.setCallback("http://newopen.qa.imdada.cn");

        // 3.初始化service
        QueryDeliverFeeService queryDeliverFeeService = new QueryDeliverFeeService(queryDeliverFeeModel.toJson());


        // 4.初始化客户端
        DadaRequestClient dadaClient = new DadaRequestClient(queryDeliverFeeService, appConfig);
        return dadaClient.callRpc();

//         返回示例
//        {
//            "status": "success",
//            "result": {
//                       "distance": 53459.98,
//                       "fee": 51.0
//                       "deliverFee": 51.0
//                        "deliveryNo":"Ddada27000000001654"
//            },
//            "code": 0,
//                "msg": "成功"
//        }
    }

    /**
     *预下单运费接口
     **/
    public static DadaApiResponse addAfterQuery() {

        // 1.初始化配置(isOnline表示是否测试环境)
        AppConfig appConfig = new AppConfig(false);

        // 2.初始化model
        AddAfterQueryModel addAfterQueryModel = new AddAfterQueryModel();
        addAfterQueryModel.setDeliveryNo("");//上个接口返回的订单号

        // 3.初始化service
        AddAfterQueryService addAfterQueryService = new AddAfterQueryService(addAfterQueryModel.toJson());


        // 4.初始化客户端
        DadaRequestClient dadaClient = new DadaRequestClient(addAfterQueryService, appConfig);
        return dadaClient.callRpc();
    }

    public static void main(String[] args) {
//        DadaApiResponse resp = queryShopDetail("shop001");
        DadaApiResponse resp = queryCityCode();

        System.out.println(JSONUtil.toJson(resp));

        querydeliverfee();
    }

}
