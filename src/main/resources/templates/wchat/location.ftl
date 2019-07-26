<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script type="text/javascript" src="http://api.map.baidu.com/getscript?v=2.0&ak=MBGPZFWMZivzdW1ZVKPkUGsPIvvTRxgj"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <title>收件地址详细</title>
    <#include "../wx.ftl"/>

    <script type="text/javascript" src="/wchat/js/index.js"></script>
    <script type="text/javascript" src="/wchat/js/order.js"></script>
    <style type="text/css">
        .button {
            border-radius: 12px;
            margin-left: 5%;
            margin-right: 5%;
            height: 90px;
            display: block;
            border: 14px solid #06CB06;
            background: #06CB06;
            margin-top: 15%;
            text-align: center
        }
    </style>
</head>
<body>
<div class="weui-cells weui-cells_form">
    <input type="hidden" value="${(model.id)!""}"/>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">联系人</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" name="receiveName" id="receiveName" value="${(model.receiveName)!""}" placeholder="请输入联系人">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">联系电话</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" name="receivePhone" id="receivePhone" value="${(model.receivePhone)!""}" type="tel" placeholder="请输入联系电话">
        </div>
    </div>
    <#--<div class="weui-cell">-->
        <#--<div class="weui-cell__hd"><label class="weui-label">小区/大厦/学校</label></div>-->
        <#--<div class="weui-cell__bd">-->
                <#--<a class="weui-cell weui-cell_access" href="javascript:;">-->
                    <#--<div class="weui-cell__bd">-->
                        <#--<input class="weui-input" placeholder="请选择小区/大厦/学校">-->
                    <#--</div>-->
                    <#--<div class="weui-cell__ft">编辑</div>-->
                <#--</a>-->
        <#--</div>-->
    <#--</div>-->


    <div class="weui-cell">

        <div class="weui-cell__hd"><label class="weui-label">详细地址</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" name="receiveAddr" id="receiveAddr" value="${(model.receiveAddr)!""}" placeholder="请输入详细地址">
        </div>
    </div>

</div>
<a href="javascript:;" id="locSubmit" class="weui-btn weui-btn_primary" style="margin-top: 10px;">保存</a>

<script>
    getLoaction("成都市武侯区九康六路299号");

    //根据地址获取经纬度
    function getLoaction(add) {
        var myGeo = new BMap.Geocoder();
        myGeo.getPoint(add, function(point){
            if (point) {
                var lng = point.lng;
                var lat = point.lat;
                const pointBak = new BMap.Point(lng, lat);
                const convertor = new BMap.Convertor();
                convertor.translate([pointBak], 1, 5,function(resPoint) {
                    if(resPoint && resPoint.points && resPoint.points.length>0){
                        lng = resPoint.points[0].lng;
                        lat = resPoint.points[0].lat;
                    }
                    const point = new BMap.Point(lng, lat);
                    const geo = new BMap.Geocoder();
                    geo.getLocation(point, (res) => {
                        alert("lng:"+ point.lng+"lat:"+point.lat);
                    });
                });

            }else{
                alert("您输入的地址有误请检查后重新输入");
            }
        }, "北京市")

    }



</script>





</html>