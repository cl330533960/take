package xin.cymall.common.dadaexpress.client;

public class OrderDetial {

    String orderId;//第三方订单编号
    Integer statusCode;//订单状态(待接单＝1 待取货＝2 配送中＝3 已完成＝4 已取消＝5 已过期＝7 指派单=8 妥投异常之物品返回中=9 妥投异常之物品返回完成=10 系统故障订单发布失败=1000 可参考文末的状态说明）
    String statusMsg;//订单状态
    String transporterName;//骑手姓名
    String transporterPhone;//骑手电话
    String transporterLng;//骑手经度
    String transporterLat;//骑手纬度
    Double deliveryFee;//配送费,单位为元
    Double tips;//小费,单位为元
    Double couponFee;//优惠券费用,单位为元
    Double insuranceFee;//保价费,单位为元
    Double actualFee;//实际支付费用,单位为元
    Double distance;//配送距离,单位为米
    String createTime;//发单时间
    String acceptTime;//接单时间,若未接单,则为空
    String fetchTime;//取货时间,若未取货,则为空
    String finishTime;//送达时间,若未送达,则为空
    String cancelTime;//取消时间,若未取消,则为空
    String orderFinishCode;//收货码
//  deductFee	BigDecimal	违约金


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }

    public String getTransporterPhone() {
        return transporterPhone;
    }

    public void setTransporterPhone(String transporterPhone) {
        this.transporterPhone = transporterPhone;
    }

    public String getTransporterLng() {
        return transporterLng;
    }

    public void setTransporterLng(String transporterLng) {
        this.transporterLng = transporterLng;
    }

    public String getTransporterLat() {
        return transporterLat;
    }

    public void setTransporterLat(String transporterLat) {
        this.transporterLat = transporterLat;
    }

    public Double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Double getTips() {
        return tips;
    }

    public void setTips(Double tips) {
        this.tips = tips;
    }

    public Double getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Double couponFee) {
        this.couponFee = couponFee;
    }

    public Double getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(Double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public Double getActualFee() {
        return actualFee;
    }

    public void setActualFee(Double actualFee) {
        this.actualFee = actualFee;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(String fetchTime) {
        this.fetchTime = fetchTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getOrderFinishCode() {
        return orderFinishCode;
    }

    public void setOrderFinishCode(String orderFinishCode) {
        this.orderFinishCode = orderFinishCode;
    }
}
