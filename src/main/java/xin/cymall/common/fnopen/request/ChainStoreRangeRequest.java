package xin.cymall.common.fnopen.request;



import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;


public class ChainStoreRangeRequest extends AbstractRequest {

	private ChainStoreRangeData data = new ChainStoreRangeData();

	public String getData() throws IOException {
		return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
	}

	public void setData(ChainStoreRangeData data) {
		this.data = data;
	}

	public static class ChainStoreRangeData {

		private String chain_store_code;

		public String getChain_store_code() {
			return chain_store_code;
		}

		public void setChain_store_code(String chain_store_code) {
			this.chain_store_code = chain_store_code;
		}

		@Override
		public String toString() {
			return "CopyChainStoreData{" +
					"chain_store_code='" + chain_store_code + '\'' +
					'}';
		}
	}

}
