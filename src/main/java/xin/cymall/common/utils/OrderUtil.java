package xin.cymall.common.utils;

/**
 * Created by Administrator on 2019/7/10.
 */
public class OrderUtil {
    public static String generateOrderNo(String userId,String orderType){
        return orderType+userId+DateUtil.getYmdhmssFName();
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getYmdhmssFName());
    }
}
