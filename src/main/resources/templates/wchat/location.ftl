<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
</body>
<script>
    $(function () {
        $("#locSubmit").click(submit);
        getLoaction("盐亭县");
    })


    //根据地址获取经纬度
    function getLoaction(add) {
        var myGeo = new BMap.Geocoder();
        myGeo.getPoint(add, function(point){
            if (point) {
                console.log("->"+point.lng) //经度
                console.log("->"+point.lat) //纬度
                alert(add+".lng:"+ point.lng);
            }else{
                alert("您输入的地址有误请检查后重新输入");
            }
        }, "北京市")

    }




    function submit() {

        initPay(1,1);
        // $.ajax({
        //     //请求方式
        //     type: "POST",
        //     //请求的媒体类型
        //     //请求地址
        //     url: "/wx/modifyLocation",
        //     //数据，json字符串
        //     data: {wxId:"oQ3Fp6Rd0oGRUbtBaGv-sOekF5_E",receiveName:$("#receiveName").val(),receiveAddr:$("#receiveAddr").val(),receivePhone:$("#receivePhone").val()},
        //     //请求成功
        //     success: function (result) {
        //         $.toast("操作成功");
        //         setTimeout( window.location.href="/wx/locationManage",1000);
        //
        //     },
        //     //请求失败，包含具体的错误信息
        //     error: function (e) {
        //         $.toast("操作失败", "cancel");
        //     }
        // });
    }

</script>
</html>