package xin.cymall.common.log;

import com.alibaba.fastjson.JSON;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *luoxiaojiang
 * 2018年12月13日
 */
public class LogUtil {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogUtil.class);

	public static void trace(String msg) {
		log.trace(msg );
    }

    public static void debug(String msg) {
    	log.debug(msg);
    }

    public static void info(String msg) {
    	log.info(msg);
    }
    public static void info(Object msgObj) {
    	try {
    		log.info(JSON.toJSONString(msgObj));
		} catch (Exception e) {
			LogUtil.error(e);
			error("打印info日志报错");
		}
    }

    public static void warn(String msg) {
    	log.warn(msg);
    }

    public static void error(String msg) {
    	log.error(msg);
    }
    
    public static void error(Exception ex) {
    	StringWriter sw = null;
		PrintWriter pw = null;
    	try {
    		sw = new StringWriter();
    		pw = new PrintWriter(sw, true);
    		ex.printStackTrace(pw);  
            error(sw.toString());  
		} catch (Exception e) {
			LogUtil.error(e);
			error("打印error日志报错");
		}finally {
			if(pw != null) {
				pw.close();
			}
			if(sw != null) {
				pw.close();
			}
		}
    }

    public static void error(String msg,Throwable t) {
		log.error(msg,t);
    }

}
