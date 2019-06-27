package xin.cymall.common.fnopen.request;


import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;

/**
 * 查询订单对应字段
 */
public class ElemeQueryPriceQuery extends AbstractRequest {

    private ElemeQueryRequestData data;

    public String getData() throws IOException {
        return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
    }

    public void setData(ElemeQueryRequestData data) {
        this.data = data;
    }

    public static class ElemeQueryRequestData {
        private Double transport_longitude;
        private Double transport_latitude;
        private Double receiver_longitude;
        private Double receiver_latitude;
        private Double order_price;
        private String uuid;

        public Double getTransport_longitude() {
            return transport_longitude;
        }

        public void setTransport_longitude(Double transport_longitude) {
            this.transport_longitude = transport_longitude;
        }

        public Double getTransport_latitude() {
            return transport_latitude;
        }

        public void setTransport_latitude(Double transport_latitude) {
            this.transport_latitude = transport_latitude;
        }

        public Double getReceiver_longitude() {
            return receiver_longitude;
        }

        public void setReceiver_longitude(Double receiver_longitude) {
            this.receiver_longitude = receiver_longitude;
        }

        public Double getReceiver_latitude() {
            return receiver_latitude;
        }

        public void setReceiver_latitude(Double receiver_latitude) {
            this.receiver_latitude = receiver_latitude;
        }

        public Double getOrder_price() {
            return order_price;
        }

        public void setOrder_price(Double order_price) {
            this.order_price = order_price;
        }
    }
}
