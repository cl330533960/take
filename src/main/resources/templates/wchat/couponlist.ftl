<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>我的优惠券</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/template.js"></script>
</head>
<body>
<#--<h1>开发中，敬请期待</h1>-->

<!-- 容器 -->
<div class="weui-tab">
    <div class="weui-tab">
        <div class="weui-navbar">
            <a class="weui-navbar__item weui-bar__item--on" href="#myOrder">
                已使用
            <#--/wx/myOrderList?wxId=oQ3Fp6Rd0oGRUbtBaGv-sOekF5_E&status=6-->
            </a>
            <a id="waitItem" class="weui-navbar__item" href="#waitCommentOrder">
                未使用
            </a>
        </div>
        <div class="weui-tab__bd">
            <div id="myOrder" class="weui-tab__bd-item weui-tab__bd-item--active">
            </div>
            <div id="waitCommentOrder" class="weui-tab__bd-item">
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    $(function () {
        initOrderList("/wx/queryCoupon?wxId=${wxId}&isUse=1");
        $('.weui-navbar__item').on('click', function () {
            var clickId = jQuery(this).attr("id");
            if (clickId == "waitItem") {
                waitCommentOrderList("/wx/queryCoupon?wxId=${wxId}&isUse=0");
            } else {
                initOrderList("/wx/queryCoupon?wxId=${wxId}&isUse=1");
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
    <div class="weui-tab__bd">
        <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
            {{each data as value index}}
            <div class="weui-form-preview">
                <div class="weui-form-preview__bd">
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">红包金额:￥{{value.amount}}</label>
                    </div>
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">红包类型：{{value.type}}</label>
                    </div>
                </div>
            </div>
            {{/each}}
        </div>
    </div>
</script>


</body>
</html>