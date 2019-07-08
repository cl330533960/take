<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>收件地址详细</title>
<#include "../resource.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
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
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">联系人</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input"  placeholder="请输入联系人">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">联系电话</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="tel" placeholder="请输入联系电话">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">详细地址</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input"  placeholder="请输入详细地址">
        </div>
    </div>
</div>
<a href="javascript:;" class="weui-btn weui-btn_primary" style="margin-top: 10px;">保存</a>
</body>
</html>