package xin.cymall.common.dadaexpress.client;

//订单预发布 的查询运费价格 非必须返回的就没要
public class OrderPreRelease {



    Double distance;//	Double	是	配送距离(单位：米)
    String deliveryNo;//		是	平台订单号
    Double  fee;//	Double	是	实际运费(单位：元)，运费减去优惠券费用
    Double deliverFee;//	Double	是	运费(单位：元)
//    Double couponFee;//	Double	否	优惠券费用(单位：元)
//    tips	Double	否	小费(单位：元)
//    insuranceFee	Double	否	保价费(单位：元)


    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(Double deliverFee) {
        this.deliverFee = deliverFee;
    }


}
