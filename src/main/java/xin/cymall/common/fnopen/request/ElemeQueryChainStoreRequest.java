package xin.cymall.common.fnopen.request;



import xin.cymall.common.fnopen.util.JsonUtils;
import xin.cymall.common.fnopen.util.URLUtils;

import java.io.IOException;
import java.util.List;

/**
 * 查询门店对应字段
 */
public class ElemeQueryChainStoreRequest extends AbstractRequest {

	private ElemeQueryRequestData data;

	public String getData() throws IOException {
		return URLUtils.getInstance().urlEncode(JsonUtils.getInstance().objectToJson(data));
	}

	public void setData(ElemeQueryRequestData data) {
		this.data = data;
	}

	public static class ElemeQueryRequestData {
		private List<String> chain_store_code;

		public List<String> getChain_store_code() {
			return chain_store_code;
		}

		public void setChain_store_code(List<String> chain_store_code) {
			this.chain_store_code = chain_store_code;
		}

	}
}
