<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>我的订单</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/template.js"></script>
</head>
<body>

<!-- 容器 -->
<div class="weui-tab">
    <div class="weui-navbar">
        <a class="weui-navbar__item weui-bar__item--on" href="#myOrder">
            全部
        <#--/wx/myOrderList?wxId=oQ3Fp6Rd0oGRUbtBaGv-sOekF5_E&status=6-->
        </a>
        <a id="waitItem" class="weui-navbar__item" href="#waitCommentOrder">
            待评价
        </a>
    </div>
    <div class="weui-tab__bd">
        <div id="myOrder" class="weui-tab__bd-item weui-tab__bd-item--active">
        </div>
        <div id="waitCommentOrder" class="weui-tab__bd-item">
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        initOrderList("/wx/myOrderList?wxId=${wxId}");
        $('.weui-navbar__item').on('click', function () {
            var clickId = jQuery(this).attr("id");
            if (clickId == "waitItem") {
                waitCommentOrderList("/wx/myOrderList?wxId=${wxId}" + "&status=6");
            }else{
                initOrderList("/wx/myOrderList?wxId=${wxId}");
            }
        });
    });

    function initOrderList(url) {
        $.ajax({
            //请求方式
            type: "POST",
            //请求的媒体类型
            //请求地址
            url: url,
            //数据，json字符串
            //请求成功
            success: function (result) {
                var html = template("orderHtml", {data: result.data});
                $("#myOrder").html(html);
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                $.toast("获取数据失败", "cancel");
            }
        });
    }

    function waitCommentOrderList(url) {
        $.ajax({
            //请求方式
            type: "POST",
            //请求的媒体类型
            //请求地址
            url: url,
            //数据，json字符串
            //请求成功
            success: function (result) {
                var html = template("orderHtml", {data: result.data});
                $("#waitCommentOrder").html(html);
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                $.toast("操作失败", "cancel");
            }
        });
    }

    //
</script>

<script type="text/html" id="orderHtml">
    <div class="weui-panel weui-panel_access">
        <div class="weui-panel__bd">
            {{each data as value index}}
            <a href="/wx/orderInfo?orderId={{value.id}}" class="weui-media-box weui-media-box_appmsg">
                <div class="weui-media-box__hd">
                    <img class="weui-media-box__thumb"
                         style="border-radius: 15px" width="50px" height="50px"
                         src="/getData/showImage?imagePath={{value.logoPath}}">
                </div>
                <div class="weui-media-box__bd">
                    <h4 class="weui-media-box__title">门店:{{value.restaurantName}}</h4>
                    <p class="weui-media-box__desc">下单时间:{{value.orderTime}}</p>
                    <p class="weui-media-box__desc">总价:<span style="color: red">￥{{value.orderTotal}}</span></p>
                </div>
                <div class="weui-media-box__fd">
                    <h4 class="weui-media-box__title">{{value.statusText}}</h4>
                </div>
            </a>
            {{/each}}
        </div>
    </div>
</script>
</body>
</html>