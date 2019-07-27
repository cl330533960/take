package xin.cymall.common.dadaexpress.client;

public class OrderRelease {


    Double distance	;	//是	配送距离(单位：米)
    Double  fee	;	//是	实际运费(单位：元)，运费减去优惠券费用
    Double  deliverFee;//		是	运费(单位：元)
//    couponFee	Double	否	优惠券费用(单位：元)
//    tips	Double	否	小费(单位：元)
//    insuranceFee	Double	否	保价费(单位：元)


    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
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
