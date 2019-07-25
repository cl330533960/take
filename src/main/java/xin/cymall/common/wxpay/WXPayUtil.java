package xin.cymall.common.wxpay;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.security.MessageDigest;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import xin.cymall.common.wxpay.WXPayConstants.SignType;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * 支付工具类
 * @author lh
 */
public class WXPayUtil {
	private static Logger log = LoggerFactory.getLogger(WXPayUtil.class);
	
	/**
	 * 生成订单对象信息
	 *  orderId 订单号
	 *  appId 微信appId
	 *  mch_id 微信分配的商户ID
	 *  body  支付介绍主体
	 *  price 支付价格（放大100倍）
	 *  spbill_create_ip 终端IP
	 *  notify_url  异步直接结果通知接口地址
	 *  noncestr
	 * @return
	 */
	public static Map<String,Object> createOrderInfo(Map<String, String> requestMap) {  
	    //生成订单对象  
	    UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();  
	    unifiedOrderRequest.setAppid(requestMap.get("appId"));//公众账号ID  
	    unifiedOrderRequest.setBody(requestMap.get("body"));//商品描述  
	    unifiedOrderRequest.setMch_id(requestMap.get("mch_id"));//商户号  
	    unifiedOrderRequest.setNonce_str(requestMap.get("noncestr"));//随机字符串    
	    unifiedOrderRequest.setNotify_url(requestMap.get("notify_url"));//通知地址  
	    unifiedOrderRequest.setOpenid(requestMap.get("userWeixinOpenId"));
	    unifiedOrderRequest.setDetail(requestMap.get("detail"));//详情
	    unifiedOrderRequest.setOut_trade_no(requestMap.get("out_trade_no"));//商户订单号  
	    unifiedOrderRequest.setSpbill_create_ip(requestMap.get("spbill_create_ip"));//终端IP  
	    unifiedOrderRequest.setTotal_fee(requestMap.get("payMoney"));  //金额需要扩大100倍:1代表支付时是0.01  
	    unifiedOrderRequest.setTrade_type("JSAPI");//JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付
	    SortedMap<String, String> packageParams = new TreeMap<String, String>();  
	    packageParams.put("appid", unifiedOrderRequest.getAppid());  
	    packageParams.put("body", unifiedOrderRequest.getBody());  
	    packageParams.put("mch_id", unifiedOrderRequest.getMch_id());  
	    packageParams.put("nonce_str", unifiedOrderRequest.getNonce_str());  
	    packageParams.put("notify_url", unifiedOrderRequest.getNotify_url());
	    packageParams.put("openid", unifiedOrderRequest.getOpenid());
	    packageParams.put("detail", unifiedOrderRequest.getDetail());
	    packageParams.put("out_trade_no", unifiedOrderRequest.getOut_trade_no());  
	    packageParams.put("spbill_create_ip", unifiedOrderRequest.getSpbill_create_ip());  
	    packageParams.put("total_fee", unifiedOrderRequest.getTotal_fee());  
	    packageParams.put("trade_type", unifiedOrderRequest.getTrade_type());  
	    try {
			unifiedOrderRequest.setSign(generateSignature(packageParams,"sFG45KywyyiLsREWYZ3FRyWq84BG5z9b"));//签名
		} catch (Exception e) {
			e.printStackTrace();
		}
	    //将订单对象转为xml格式  
        xstream.alias("xml", UnifiedOrderRequest.class);//根元素名需要是xml
	    System.out.println("封装好的统一下单请求数据："+xstream.toXML(unifiedOrderRequest).replace("__", "_"));
	    Map<String,Object> responseMap = new HashMap<String,Object>();
	    responseMap.put("orderInfo_toString", xstream.toXML(unifiedOrderRequest).replace("__", "_"));
	    responseMap.put("unifiedOrderRequest",unifiedOrderRequest);
	    return responseMap;  
	} 
	
	/** 
	 * 生成签名 
	 * @  appid_value
	 * @  mch_id_value
	 * @  productId
	 * @  nonce_str_value
	 * @  trade_type
	 * @  notify_url
	 * @  spbill_create_ip
	 * @  total_fee
	 * @  out_trade_no
	 * @return 
	 */  
	private static String createSign(UnifiedOrderRequest unifiedOrderRequest) {  
	    //根据规则创建可排序的map集合  
	    SortedMap<String, String> packageParams = new TreeMap<String, String>();  
	    packageParams.put("appid", unifiedOrderRequest.getAppid());  
	    packageParams.put("body", unifiedOrderRequest.getBody());  
	    packageParams.put("mch_id", unifiedOrderRequest.getMch_id());  
	    packageParams.put("nonce_str", unifiedOrderRequest.getNonce_str());  
	    packageParams.put("notify_url", unifiedOrderRequest.getNotify_url());  
	    packageParams.put("out_trade_no", unifiedOrderRequest.getOut_trade_no());  
	    packageParams.put("spbill_create_ip", unifiedOrderRequest.getSpbill_create_ip());  
	    packageParams.put("trade_type", unifiedOrderRequest.getTrade_type());  
	    packageParams.put("total_fee", unifiedOrderRequest.getTotal_fee());  
	    StringBuffer sb = new StringBuffer();  
	    Set es = packageParams.entrySet();//字典序  
	    Iterator it = es.iterator();  
	    while (it.hasNext()) {  
	        Map.Entry entry = (Map.Entry) it.next();  
	        String k = (String) entry.getKey();  
	        String v = (String) entry.getValue();  
	        //为空不参与签名、参数名区分大小写  
	        if (null != v && !"".equals(v) && !"sign".equals(k)  && !"key".equals(k)) {  
	            sb.append(k + "=" + v + "&");  
	        }  
	    }  
	    //第二步拼接key，key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置  
	    sb.append("key="+"你的密匙");  
	    String sign = MD5Util.MD5(sb.toString()).toUpperCase();//MD5加密  
	    log.error("方式一生成的签名=" + sign);
	    return sign;  
	}


    public static XStream xstream = new XStream(new XppDriver() {
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    // 对所有xml节点的转换都增加CDATA标记
                    boolean cdata = true;
                    String NodeName = "";

                    @SuppressWarnings("unchecked")
                    public void startNode(String name, Class clazz) {
                        NodeName = name;
                        super.startNode(name, clazz);
                    }

                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            if (!NodeName.equals("detail")) {
                                writer.write(text);
                            } else {
                                writer.write("<![CDATA[");
                                writer.write(text);
                                writer.write("]]>");
                            }
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });





	
	//xml解析    
    public static SortedMap<String, String> doXMLParseWithSorted(String strxml) throws Exception {    
          strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");    
          if(null == strxml || "".equals(strxml)) {    
              return null;    
          }    
          SortedMap<String,String> m = new TreeMap<String,String>();     
          InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));    
          SAXBuilder builder = new SAXBuilder();    
          Document doc = builder.build(in);    
          Element root = doc.getRootElement();    
          List list = root.getChildren();    
          Iterator it = list.iterator();    
          while(it.hasNext()) {    
              Element e = (Element) it.next();    
              String k = e.getName();    
              String v = "";    
              List children = e.getChildren();    
              if(children.isEmpty()) {    
                  v = e.getTextNormalize();    
              } else {    
                  v = getChildrenText(children);    
              }    
              m.put(k, v);    
          }    
          //关闭流    
          in.close();     
          return m;    
    }   
    
    public static String getChildrenText(List children) {    
        StringBuffer sb = new StringBuffer();    
        if(!children.isEmpty()) {    
            Iterator it = children.iterator();    
            while(it.hasNext()) {    
                Element e = (Element) it.next();    
                String name = e.getName();    
                String value = e.getTextNormalize();    
                List list = e.getChildren();    
                sb.append("<" + name + ">");    
                if(!list.isEmpty()) {    
                    sb.append(getChildrenText(list));    
                }    
                sb.append(value);    
                sb.append("</" + name + ">");    
            }    
        }     
        return sb.toString();    
	} 
	/** 
	 * 调统一下单API 
	 * @param orderInfo 
	 * @return 
	 */  
	public static UnifiedOrderRespose httpOrder(String orderInfo) {
	    String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";  
	    try {  
	        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();  
	        //加入数据    
			conn.setRequestMethod("POST");    
			conn.setDoOutput(true);    
			BufferedOutputStream buffOutStr = new BufferedOutputStream(conn.getOutputStream());    
			buffOutStr.write(orderInfo.getBytes("UTF-8"));  
			buffOutStr.flush();    
			buffOutStr.close();    
			//获取输入流    
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));    
			String line = null;    
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine())!= null){    
				sb.append(line);
            }
            System.out.println(sb);
            String result = sb.toString();
            //将请求返回的内容通过xStream转换为UnifiedOrderRespose对象
			return (UnifiedOrderRespose) convertXmlStrToObject(UnifiedOrderRespose.class, result);

        } catch (Exception e) {
	        e.printStackTrace();  
	    }  
	    return null;  
	}  
    /**
     * XML格式字符串转换为Map
     *
     * @param strXML XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap<String, String>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            try {
                stream.close();
            } catch (Exception ex) {
                // do nothing
            }
            return data;
        } catch (Exception ex) {
            WXPayUtil.getLogger().warn("Invalid XML, can not convert to map. Error message: {}. XML content: {}", ex.getMessage(), strXML);
            throw ex;
        }
 
    }
 
    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     * @throws Exception
     */
    public static String mapToXml(Map<String, String> data) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key: data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
        try {
            writer.close();
        }
        catch (Exception ex) {
        }
        return output;
    }
 
 
    /**
     * 生成带有 sign 的 XML 格式字符串
     *
     * @param data Map类型数据
     * @param key API密钥
     * @return 含有sign字段的XML
     */
    public static String generateSignedXml(final Map<String, String> data, String key) throws Exception {
        return generateSignedXml(data, key, SignType.MD5);
    }
 
    /**
     * 生成带有 sign 的 XML 格式字符串
     *
     * @param data Map类型数据
     * @param key API密钥
     * @param signType 签名类型
     * @return 含有sign字段的XML
     */
    public static String generateSignedXml(final Map<String, String> data, String key, SignType signType) throws Exception {
        String sign = generateSignature(data, key, signType);
        data.put(WXPayConstants.FIELD_SIGN, sign);
        return mapToXml(data);
    }
 
 
    /**
     * 判断签名是否正确
     *
     * @param xmlStr XML格式数据
     * @param key API密钥
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean isSignatureValid(String xmlStr, String key) throws Exception {
        Map<String, String> data = xmlToMap(xmlStr);
        if (!data.containsKey(WXPayConstants.FIELD_SIGN) ) {
            return false;
        }
        String sign = data.get(WXPayConstants.FIELD_SIGN);
        return generateSignature(data, key).equals(sign);
    }
 
    /**
     * 判断签名是否正确，必须包含sign字段，否则返回false。使用MD5签名。
     *
     * @param data Map类型数据
     * @param key API密钥
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean isSignatureValid(Map<String, String> data, String key) throws Exception {
        return isSignatureValid(data, key, SignType.MD5);
    }
 
    /**
     * 判断签名是否正确，必须包含sign字段，否则返回false。
     *
     * @param data Map类型数据
     * @param key API密钥
     * @param signType 签名方式
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean isSignatureValid(Map<String, String> data, String key, SignType signType) throws Exception {
        if (!data.containsKey(WXPayConstants.FIELD_SIGN) ) {
            return false;
        }
        String sign = data.get(WXPayConstants.FIELD_SIGN);
        return generateSignature(data, key, signType).equals(sign);
    }
 
    /**
     * 生成签名
     *
     * @param data 待签名数据
     * @param key API密钥
     * @return 签名
     */
    public static String generateSignature(final Map<String, String> data, String key) throws Exception {
        return generateSignature(data, key, SignType.MD5);
    }
 
    /**
     * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
     *
     * @param data 待签名数据
     * @param key API密钥
     * @param signType 签名方式
     * @return 签名
     */
    public static String generateSignature(final Map<String, String> data, String key, SignType signType) throws Exception {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals(WXPayConstants.FIELD_SIGN)) {
                continue;
            }
            if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
        }
        sb.append("key=").append(key);
        if (SignType.MD5.equals(signType)) {
            return MD5(sb.toString()).toUpperCase();
        }
        else if (SignType.HMACSHA256.equals(signType)) {
            return HMACSHA256(sb.toString(), key);
        }
        else {
        	log.error("获取签名失败，失败原因："+String.format("Invalid sign_type: %s", signType));
            throw new Exception(String.format("Invalid sign_type: %s", signType));
        }
    }
 
 
    /**
     * 获取随机字符串 Nonce Str
     * @return String 随机字符串
     */
    public static String generateNonceStr() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }
    /** 
     * Map转xml数据 
     */  
    public static String GetMapToXML(Map<String,String> param){  
        StringBuffer sb = new StringBuffer();  
        sb.append("<xml>");  
        for (Map.Entry<String,String> entry : param.entrySet()) {   
        	sb.append("<"+ entry.getKey() +">");  
        	sb.append(entry.getValue());  
        	sb.append("</"+ entry.getKey() +">");  
        }    
        sb.append("</xml>");  
        return sb.toString();  
    }  
 
    /**
     * 生成 MD5
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        java.security.MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
 
    /**
     * 生成 HMACSHA256
     * @param data 待处理数据
     * @param key 密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
 
    /**
     * 日志
     * @return
     */
    public static Logger getLogger() {
        Logger logger = LoggerFactory.getLogger("wxpay java sdk");
        return logger;
    }
 
    /**
     * 获取当前时间戳，单位秒
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis()/1000;
    }
 
    /**
     * 获取当前时间戳，单位毫秒
     * @return
     */
    public static long getCurrentTimestampMs() {
        return System.currentTimeMillis();
    }
 
    /**
     * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }
 
    /** 
     * 支付签名 
     * @param timestamp 
     * @param noncestr 
     * @param packages 
     * @return 
     * @throws UnsupportedEncodingException  
     */  
    public static String paySign(String timestamp, String noncestr,String packages,String appId){  
        Map<String, String> paras = new HashMap<String, String>();  
        paras.put("appid", appId);  
        paras.put("timestamp", timestamp);  
        paras.put("noncestr", noncestr);  
        paras.put("package", packages);  
        paras.put("signType", "MD5");  
	    StringBuffer sb = new StringBuffer();  
	    Set es = paras.entrySet();//字典序  
	    Iterator it = es.iterator();  
	    while (it.hasNext()) {  
	        Map.Entry entry = (Map.Entry) it.next();  
	        String k = (String) entry.getKey();  
	        String v = (String) entry.getValue();  
	        //为空不参与签名、参数名区分大小写  
	        if (null != v && !"".equals(v) && !"sign".equals(k)  && !"key".equals(k)) {  
	            sb.append(k + "=" + v + "&");  
	        }  
	    }  
	    String sign = MD5Util.MD5(sb.toString()).toUpperCase();//MD5加密  
        return sign;
    }


    @SuppressWarnings("unchecked")
    /**
     * 将String类型的xml转换成对象
     */
    public static Object convertXmlStrToObject(Class clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    public static void main(String[] args) throws Exception {
//        String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><appid><![CDATA[wx688906a5f5df8b37]]></appid><mch_id><![CDATA[1542729801]]></mch_id><nonce_str><![CDATA[jNYAgdXwOdNy7WkK]]></nonce_str><sign><![CDATA[D53543056EDD0EEDB991B8DB6778E245]]></sign><result_code><![CDATA[SUCCESS]]></result_code><prepay_id><![CDATA[wx25155111737201fd372e72a21929010200]]></prepay_id><trade_type><![CDATA[JSAPI]]></trade_type></xml>";
//        UnifiedOrderRespose unifiedOrderRespose = (UnifiedOrderRespose) convertXmlStrToObject(UnifiedOrderRespose.class, xml);
//        System.out.println(unifiedOrderRespose.getPrepay_id());

        Map map = new HashMap<String,String>();
        map.put("appId","wx688906a5f5df8b37");//你的appId
        map.put("timeStamp", "1564047442");
        map.put("nonceStr",  "8bae90e87e4e4f818b5980ba54cec961");
        String packages = "prepay_id=wx25173724315426f1197dbdd01260384600";
        map.put("package",packages);
        System.out.println(WXPayUtil.generateSignature(map, "sFG45KywyyiLsREWYZ3FRyWq84BG5z9b",SignType.MD5));
    }


}
