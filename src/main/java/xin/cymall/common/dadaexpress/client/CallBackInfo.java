package xin.cymall.common.dadaexpress.client;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/7/27.
 */
public class CallBackInfo implements Serializable {
    private String client_id;
    private String order_id;
    private Integer order_status; //订单状态(待接单＝1,待取货＝2,配送中＝3,已完成＝4,已取消＝5, 已过期＝7,指派单=8,妥投异常之物品返回中=9, 妥投异常之物品返回完成=10,骑士到店=100,创建达达运单失败=1000 可参考文末的状态说明）
    private String cancel_reason;
    private Integer cancel_from;
    private Integer update_time;
    private String signature;
    private Integer dm_id;
    private String dm_name;
    private String dm_mobile;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }

    public Integer getCancel_from() {
        return cancel_from;
    }

    public void setCancel_from(Integer cancel_from) {
        this.cancel_from = cancel_from;
    }

    public Integer getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Integer update_time) {
        this.update_time = update_time;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getDm_id() {
        return dm_id;
    }

    public void setDm_id(Integer dm_id) {
        this.dm_id = dm_id;
    }

    public String getDm_name() {
        return dm_name;
    }

    public void setDm_name(String dm_name) {
        this.dm_name = dm_name;
    }

    public String getDm_mobile() {
        return dm_mobile;
    }

    public void setDm_mobile(String dm_mobile) {
        this.dm_mobile = dm_mobile;
    }
}
