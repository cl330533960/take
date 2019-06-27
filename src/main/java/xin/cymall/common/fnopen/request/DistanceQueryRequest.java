package xin.cymall.common.fnopen.request;



import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;


public class DistanceQueryRequest extends AbstractRequest {
    private DistanceQueryRequestData data;

    public String getData() throws IOException {
        return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
    }

    public void setData(DistanceQueryRequestData data) {
        this.data = data;
    }

    public static class DistanceQueryRequestData {
        private String chain_store_code;


        private Integer position_source;

        private String receiver_longitude;

        private String receiver_latitude;

        public String getChain_store_code() {
            return chain_store_code;
        }

        public void setChain_store_code(String chain_store_code) {
            this.chain_store_code = chain_store_code;
        }

        public Integer getPosition_source() {
            return position_source;
        }

        public void setPosition_source(Integer position_source) {
            this.position_source = position_source;
        }

        public String getReceiver_longitude() {
            return receiver_longitude;
        }

        public void setReceiver_longitude(String receiver_longitude) {
            this.receiver_longitude = receiver_longitude;
        }

        public String getReceiver_latitude() {
            return receiver_latitude;
        }

        public void setReceiver_latitude(String receiver_latitude) {
            this.receiver_latitude = receiver_latitude;
        }
    }
}
