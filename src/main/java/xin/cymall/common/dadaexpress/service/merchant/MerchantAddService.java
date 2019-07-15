package xin.cymall.common.dadaexpress.service.merchant;


import xin.cymall.common.dadaexpress.config.UrlConstant;
import xin.cymall.common.dadaexpress.service.BaseService;

/**@date 2019/07/15
 */
public class MerchantAddService extends BaseService {

    public MerchantAddService(String params){
        super(UrlConstant.MERCHANT_ADD_URL, params);
    }
}
