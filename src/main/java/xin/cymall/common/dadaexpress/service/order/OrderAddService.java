package xin.cymall.common.dadaexpress.service.order;


import xin.cymall.common.dadaexpress.config.UrlConstant;
import xin.cymall.common.dadaexpress.service.BaseService;

/**@date 2019/07/15
 */
public class OrderAddService extends BaseService {

    public OrderAddService(String params){
        super(UrlConstant.ORDER_ADD_URL, params);
    }
}
