<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>订单详情</title>
<#include "../wx.ftl"/>


</head>
<body>
<#--<div class="weui-cell weui-cell_swiped">-->
<#--<div class="weui-cell__bd" style="transform: translate3d(0px, 0px, 0px);">-->
<#--<div class="weui-cell">-->
<#--<div class="weui-cell__hd"><span class="price">西南桦</span></div>-->
<#--<div class="weui-cell__bd">-->
<#--<span class="price">1元</span>-->
<#--</div>-->
<#--<div class="weui-cell__ft">-->
<#--<span class="price">1</span>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<div class="weui-cell__ft">-->
<#--<a class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" href="javascript:">删除</a>-->
<#--<a class="weui-swiped-btn weui-swiped-btn_default close-swipeout" href="javascript:">关闭</a>-->
<#--</div>-->
<#--</div>-->
<div class="weui-cell" style="display:flex;flex-direction: row;height: 30px;align-items: center">
    <div style="background-color: #ff5740 ;width: 3px ;height: 12px;margin-left: 15px"></div>
    <#--<div class="weui-cells__title">订单详情</div>-->
    <div style="margin-left: 20px;font-size: 16px">餐品详情</div>
</div>

<div class="weui-cells weui-cells_form">
<#list order.foodList! as food>
    <div class="weui-cell weui-cell_swiped">
        <div class="weui-cell__bd" style="transform: translate3d(0px, 0px, 0px);">
            <div class="weui-cell">
                <div class="weui-cell__hd"><img
                        style="border-radius: 15px" width="50px" height="50px"
                        src="/getData/showImage?imagePath=${food.imagePath!}"  alt="" style="margin-right:5px;display:block"></div>
                <div class="weui-cell__bd">
                    <p>${food.name!}</p>

                    <p>数量:${food.number!}</p>

                    <p>单价:${food.price!}</p>
                </div>
                <div class="weui-count">
                    合计:<span style="color: red">${food.totalPrice!}</span>
                </div>
            </div>
        </div>
    </div>
</#list>
<#--<#if foodList?size<=0>-->
<#--<div class="weui-cell">-->
<#--<div class="weui-cell__bd">-->
<#--暂无推荐餐品-->
<#--</div>-->
<#--</div>-->
<#--</#if>-->
    <div class="weui-cell">
        <div class="weui-cell__bd">

            <p>包装费 <span style="color: red">${order.packFee!0}</span>元</p>

            <p>配送费  <span style="color: red">${order.wayFee!0}</span>元</p>

        <#--<p>商家联系电话：010-3334444</p>-->
        </div>
    </div>
</div>
<div class="weui-cell" style="display:flex;flex-direction: row;height: 30px;align-items: center">
    <div style="background-color: #ff5740 ;width: 3px ;height: 12px;margin-left: 15px"></div>
    <#--<div class="weui-cells__title"></div>-->
    <div style="margin-left: 20px;font-size: 16px">订单信息</div>
</div>

<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>订单状态： ${order.statusText!}</p>

            <p>订单编号：${order.orderNo!}</p>

            <p>订单价格：${order.orderTotal!}</p>

            <p>下单时间：${order.orderTime?string('yyyy-MM-dd HH:mm:ss')}</p>

            <p>备注：${order.remark!}</p>
        </div>
    </div>
</div>
<div class="weui-cell" style="display:flex;flex-direction: row;height: 30px;align-items: center">
    <div style="background-color: #ff5740 ;width: 3px ;height: 12px;margin-left: 15px"></div>
    <#--<div class="weui-cells__title">配送信息</div>-->
    <div style="margin-left: 20px;font-size: 16px">配送信息</div>
</div>

<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>配送服务：达达配送</p>

            <p>配送时间：${(order.expressTime?string('yyyy-MM-dd HH:mm:ss'))!""}</p>

            <p>收件地址：${location.receiveAddr!}</p>

            <p>收件人：${location.receiveName!}</p>

            <p>收件人电话：${location.receivePhone!}</p>

            <p>骑手：${order.expressName!}</p>

            <p>骑手电话：${order.expressPhone!}</p>
        </div>
    </div>
</div>

</div>
</body>

</html>