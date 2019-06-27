package xin.cymall.common.fnopen.request;



import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;

/**
 * 取消订单对应的 字段
 */
public class OrderComplaintRequest extends AbstractRequest {
	private OrderComplaintRequestData data;

	public static class OrderComplaintRequestData {
		private String partner_order_code;
		private Integer order_complaint_code;
		private String order_complaint_desc;
		private Long order_complaint_time;

		public String getPartner_order_code() {
			return partner_order_code;
		}

		public void setPartner_order_code(String partner_order_code) {
			this.partner_order_code = partner_order_code;
		}

		public Integer getOrder_complaint_code() {
			return order_complaint_code;
		}

		public void setOrder_complaint_code(Integer order_complaint_code) {
			this.order_complaint_code = order_complaint_code;
		}

		public String getOrder_complaint_desc() {
			return order_complaint_desc;
		}

		public void setOrder_complaint_desc(String order_complaint_desc) {
			this.order_complaint_desc = order_complaint_desc;
		}

		public Long getOrder_complaint_time() {
			return order_complaint_time;
		}

		public void setOrder_complaint_time(Long order_complaint_time) {
			this.order_complaint_time = order_complaint_time;
		}

		@Override
		public String toString() {
			return "CancelOrderRequestData [partner_order_code=" + partner_order_code + ", order_complaint_code="
					+ order_complaint_code + ", order_complaint_desc=" + order_complaint_desc
					+ ", order_complaint_time=" + order_complaint_time + "]";
		}

	}

	public String getData() throws IOException {
		return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
	}

	public void setData(OrderComplaintRequestData data) {
		this.data = data;
	}
}
