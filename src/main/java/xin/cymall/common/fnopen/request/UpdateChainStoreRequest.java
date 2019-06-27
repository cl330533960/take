package xin.cymall.common.fnopen.request;


import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;


public class UpdateChainStoreRequest extends AbstractRequest {

    private UpdateChainStoreRequestData data;

    public String getData() throws IOException {
        return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
    }

    public void setData(UpdateChainStoreRequestData data) {
        this.data = data;
    }

    public static class UpdateChainStoreRequestData {
        private String app_id;

        private String chain_store_code;

        private String chain_store_name;

        private String contact_phone;

        private String address;

        private Integer position_source;

        private String longitude;

        private String latitude;

        private String service_code;

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

        public String getChain_store_name() {
            return chain_store_name;
        }

        public void setChain_store_name(String chain_store_name) {
            this.chain_store_name = chain_store_name;
        }

        public String getContact_phone() {
            return contact_phone;
        }

        public void setContact_phone(String contact_phone) {
            this.contact_phone = contact_phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getPosition_source() {
            return position_source;
        }

        public void setPosition_source(Integer position_source) {
            this.position_source = position_source;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getService_code() {
            return service_code;
        }

        public void setService_code(String service_code) {
            this.service_code = service_code;
        }

        @Override
        public String toString() {
            return "ChainStoreReq [app_id=" + app_id + ", chain_store_code=" + chain_store_code + ", chain_store_name="
                    + chain_store_name + ", contact_phone=" + contact_phone + ", address=" + address + ", position_source="
                    + position_source + ", longitude=" + longitude + ", latitude=" + latitude + ", service_code="
                    + service_code + "]";
        }
    }
}
