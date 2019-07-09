package xin.cymall.common.utils;

import org.apache.el.lang.ExpressionBuilder;

import javax.el.Expression;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/7/7.
 */
public class CalcBmiUtil {
    public static Boolean calcBmi(String expression, String repalce, Double value) throws ScriptException {
        if (expression.startsWith(repalce) || expression.endsWith(repalce)) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            engine.put(repalce, value);
            Object result = engine.eval(expression);
            return (Boolean) result;
        } else {
            expression = expression.replace("BMI", "BMI && BMI");
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            engine.put(repalce, value);
            Object result = engine.eval(expression);
            return (Boolean) result;
        }
    }

    public static double round(Double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double calcRes(String expression,Double[] values,String[] repalces) throws ScriptException{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        for(int i = 0; i<repalces.length;i++){
            engine.put(repalces[i], values[i]);
        }
        Object result = engine.eval(expression);
        return  (Double)result;
    }

    public static void main(String[] args) throws ScriptException {
        System.out.println(calcRes("23.5*H*H",new Double[]{1.78,1.78},new String[]{"H","H"}));
        Double NormalWeightUp = CalcBmiUtil.round(74.45739999999999,0);
        System.out.println(NormalWeightUp);

    }




}
