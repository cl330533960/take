package xin.cymall.common.fnopen.request;



import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;


public class AddChainStoreRequest extends AbstractRequest {

	private AddChainStoreData data = new AddChainStoreData();

	public String getData() throws IOException {
		return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
	}

	public void setData(AddChainStoreData data) {
		this.data = data;
	}

	public static class AddChainStoreData {
		private String chain_store_code;
		private String chain_store_name;
		private Integer chain_store_type;
		private String merchant_code;
		private String contact_phone;
		private String address;
		private String longitude;
		private String latitude;
		private Integer position_source;
		private String service_code;

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

		public Integer getChain_store_type() {
			return chain_store_type;
		}

		public void setChain_store_type(Integer chain_store_type) {
			this.chain_store_type = chain_store_type;
		}

		public String getMerchant_code() {
			return merchant_code;
		}

		public void setMerchant_code(String merchant_code) {
			this.merchant_code = merchant_code;
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

		public Integer getPosition_source() {
			return position_source;
		}

		public void setPosition_source(Integer position_source) {
			this.position_source = position_source;
		}

		public String getService_code() {
			return service_code;
		}

		public void setService_code(String service_code) {
			this.service_code = service_code;
		}

		@Override
		public String toString() {
			return "AddChainStoreData{" + "chain_store_code='" + chain_store_code + '\'' + ", chain_store_name='" + chain_store_name + '\'' + ", chain_store_type=" + chain_store_type + ", merchant_code='" + merchant_code + '\'' + ", contact_phone='" + contact_phone + '\'' + ", address='" + address + '\'' + ", longitude='" + longitude + '\'' + ", latitude='" + latitude + '\'' + ", position_source=" + position_source + ", service_code='" + service_code + '\'' + '}';
		}
	}

}
