<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <title>收件地址</title>
<#include "../wx.ftl"/>
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
<div class="weui-cells weui-cells_radio">

<#list model! as emp>
    <label class="weui-cell weui-check__label" for="${emp.id!}">
        <div class="weui-cell__bd">
            <#--<a class="weui-cell weui-cell_access" href="/wx/editLocation?addrId=${emp.id!}">-->
                <div class="weui-cell__bd">
                    <p>${emp.receiveName!}${emp.receivePhone!}</p>
                    <p>${emp.receiveAddr!}</p>
                </div>
            <#--</a>-->
        </div>
        <div class="weui-cell__ft">
            <input type="radio" class="weui-check" name="radio1" id="${emp.id!}">
            <span class="weui-icon-checked"></span>
        </div>
    </label>
</#list>
</div>
<a href="/wx/editLocation" class="weui-btn weui-btn_primary" style="margin-top: 10px;">添加收货地址</a>
</body>
</html>