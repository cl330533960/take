package xin.cymall.common.dadaexpress.service.order;

import xin.cymall.common.dadaexpress.config.UrlConstant;
import xin.cymall.common.dadaexpress.service.BaseService;

/**
 * Created by Administrator on 2019/7/27.
 */
public class QueryShopDetailService extends BaseService {
    public QueryShopDetailService(String params) {
        super(UrlConstant.SHOP_DETAIL_URL, params);
    }
}
