package xin.cymall.common.dadaexpress.domain;


import xin.cymall.common.dadaexpress.utils.JSONUtil;

/**@date 2019/07/15
 */
public class BaseModel {

    public String toJson() {
        return JSONUtil.toJson(this);
    }
}
