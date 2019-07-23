package xin.cymall.common.dadaexpress.service.order;


import xin.cymall.common.dadaexpress.config.UrlConstant;
import xin.cymall.common.dadaexpress.service.BaseService;

/**@date 2019/07/15
 */
public class QueryDeliverFeeService extends BaseService {

    public QueryDeliverFeeService(String params){
        super(UrlConstant.Query_DeliverFee_URL, params);
    }
}
