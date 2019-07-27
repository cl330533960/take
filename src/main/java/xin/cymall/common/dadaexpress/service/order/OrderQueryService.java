package xin.cymall.common.dadaexpress.service.order;


import xin.cymall.common.dadaexpress.config.UrlConstant;
import xin.cymall.common.dadaexpress.service.BaseService;

/**@date 2019/07/15
 * 订单查询
 */
public class OrderQueryService extends BaseService {

    public OrderQueryService(String params){
        super(UrlConstant.ORDER_Query_URL, params);
    }
}
