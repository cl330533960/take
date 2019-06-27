package xin.cymall.common.fnopen.request;



import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;

public class DeliveryAreaQueryRequest extends AbstractRequest {
    private DeliveryAreaQuery data;

    public String getData() throws IOException {
        return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
    }

    public void setData(DeliveryAreaQuery data) {
        this.data = data;
    }

    public static class DeliveryAreaQuery {
        private String app_id;
        private String chain_store_code;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getChain_store_code() {
            return chain_store_code;
        }

        public void setChain_store_code(String chain_store_code) {
            this.chain_store_code = chain_store_code;
        }
    }
}
