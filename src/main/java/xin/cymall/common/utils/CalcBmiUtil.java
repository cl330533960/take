package xin.cymall.common.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/7/7.
 */
public class CalcBmiUtil {
    public static Boolean calcBmi(String expression,String repalce,Double value) throws ScriptException {
        if(expression.startsWith(repalce) || expression.endsWith(repalce)) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            engine.put(repalce, value);
            Object result = engine.eval(expression);
            return (Boolean) result;
        }else{
            expression = expression.replace("BMI","BMI && BMI");
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            engine.put(repalce, value);
            Object result = engine.eval(expression);
            return (Boolean) result;
        }
    }

    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
