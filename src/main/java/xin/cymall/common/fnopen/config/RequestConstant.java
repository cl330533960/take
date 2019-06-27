package xin.cymall.common.fnopen.config;

/**
 * 请求常量
 */
public class RequestConstant {
    /**
     * 获取token
     */
    public static final String OBTAIN_TOKEN = "/get_access_token";

    /**
     * 创建订单
     */
    public static final String ORDER_CREATE = "/v2/order";

    /**
     * 取消 订单
     */
    public static final String ORDER_CANCEL = "/v2/order/cancel";


    /**
     * 订单超距离
     */
    public static final String DISTANCE_QUERY = "/v2/chain_store/delivery/query";

    /**
     * 更新门店
     */
    public static final String CHAIN_STORE_UPDATE = "/v2/chain_store/update";
    /**
     * 订单查询
     */
    public static final String ORDER_QUERY = "/v2/order/query";

    /**
     * 查询T时效
     */
    public static final String PREDICT_TIME = "/v2/predict_time";

    /**
     * 查询配送费
     */
    public static final String PREDICT_PRICE = "/v2/predict_price";

    /**
     * 查询骑手信息
     */
    public static final String QUERY_CARRIER = "/v2/order/carrier_v2";

    /**
     * 查询骑手信息
     */
    public static final String QUERY_TRACE = "/v2/order/carrier_route";
    
    /**
     * 订单查询
     */
    public static final String ORDER_COMPLAINT = "/v2/order/complaint";

    /**
     * 添加门店信息
     */
    public static final String ADD_CHAIN_STORE = "/v2/chain_store";
    
    /**
     * 查询门店信息
     */
    public static final String QUERY_CHAIN_STORE = "/v2/chain_store/query";

    /**
     * 复制门店信息
     */
    public static final String COPY_CHAIN_STORE = "/v2/chain_store/shop_copy";

    /**
     * 查询门店配送范围
     */
    public static final String CHAIN_STORE_RANGE = "/v2/store/range";

    /**
     * 门店正在使用的配送范围查询
     */
    public static final String DELIVERY_AREA_QUERY = "/v2/chain_store/delivery_area";
    public static final String RANGE_QUERY = "/v2/store/range";

    private RequestConstant(){}
}
