package xin.cymall.common.fnopen.request;



import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;

/**
 * 查询订单对应字段
 */
public class ElemeQueryTimeQuery extends AbstractRequest {

    private ElemeQueryRequestData data;

    public String getData() throws IOException {
        return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
    }

    public void setData(ElemeQueryRequestData data) {
        this.data = data;
    }

    public static class ElemeQueryRequestData {
        private String uuid;
        private String food_quantity;
        private String food_amount;
        private Double transport_latitude;
        private Double transport_longitude;
        private Double receiver_latitude;
        private Double receiver_longitude;
        private Integer position_source;
        private Integer merchant_promise_cooking_time;
        private Integer boxes_total_price;
        private Integer boxes_total_num;
        private String customer_address;
        private String chain_store_code;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getFood_quantity() {
            return food_quantity;
        }

        public void setFood_quantity(String food_quantity) {
            this.food_quantity = food_quantity;
        }

        public String getFood_amount() {
            return food_amount;
        }

        public void setFood_amount(String food_amount) {
            this.food_amount = food_amount;
        }

        public Double getTransport_latitude() {
            return transport_latitude;
        }

        public void setTransport_latitude(Double transport_latitude) {
            this.transport_latitude = transport_latitude;
        }

        public Double getTransport_longitude() {
            return transport_longitude;
        }

        public void setTransport_longitude(Double transport_longitude) {
            this.transport_longitude = transport_longitude;
        }

        public Double getReceiver_latitude() {
            return receiver_latitude;
        }

        public void setReceiver_latitude(Double receiver_latitude) {
            this.receiver_latitude = receiver_latitude;
        }

        public Double getReceiver_longitude() {
            return receiver_longitude;
        }

        public void setReceiver_longitude(Double receiver_longitude) {
            this.receiver_longitude = receiver_longitude;
        }

        public Integer getPosition_source() {
            return position_source;
        }

        public void setPosition_source(Integer position_source) {
            this.position_source = position_source;
        }

        public Integer getMerchant_promise_cooking_time() {
            return merchant_promise_cooking_time;
        }

        public void setMerchant_promise_cooking_time(Integer merchant_promise_cooking_time) {
            this.merchant_promise_cooking_time = merchant_promise_cooking_time;
        }

        public Integer getBoxes_total_price() {
            return boxes_total_price;
        }

        public void setBoxes_total_price(Integer boxes_total_price) {
            this.boxes_total_price = boxes_total_price;
        }

        public Integer getBoxes_total_num() {
            return boxes_total_num;
        }

        public void setBoxes_total_num(Integer boxes_total_num) {
            this.boxes_total_num = boxes_total_num;
        }

        public String getCustomer_address() {
            return customer_address;
        }

        public void setCustomer_address(String customer_address) {
            this.customer_address = customer_address;
        }

        public String getChain_store_code() {
            return chain_store_code;
        }

        public void setChain_store_code(String chain_store_code) {
            this.chain_store_code = chain_store_code;
        }
    }
}
