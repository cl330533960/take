package xin.cymall.common.fnopen.request;



import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;


public class CopyChainStoreRequest extends AbstractRequest {

	private CopyChainStoreData data = new CopyChainStoreData();

	public String getData() throws IOException {
		return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
	}

	public void setData(CopyChainStoreData data) {
		this.data = data;
	}

	public static class CopyChainStoreData {

		private String chain_store_code;
		private String shop_id;
		private Integer platform_type;

		public String getChain_store_code() {
			return chain_store_code;
		}

		public void setChain_store_code(String chain_store_code) {
			this.chain_store_code = chain_store_code;
		}

		public String getShop_id() {
			return shop_id;
		}

		public void setShop_id(String shop_id) {
			this.shop_id = shop_id;
		}

		public Integer getPlatform_type() {
			return platform_type;
		}

		public void setPlatform_type(Integer platform_type) {
			this.platform_type = platform_type;
		}

		@Override
		public String toString() {
			return "CopyChainStoreData{" +
					"chain_store_code='" + chain_store_code + '\'' +
					", shop_id='" + shop_id + '\'' +
					", platform_type=" + platform_type +
					'}';
		}
	}

}
