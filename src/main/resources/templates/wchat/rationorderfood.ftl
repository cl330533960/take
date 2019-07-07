<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>定量点餐</title>
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
<div class="weui-cells weui-cells_radio">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">热量（K）:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入热量">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell weui-cell_switch">
            <div class="weui-cell__bd">用餐方式:</div>
        </div>
        <div class="weui-cell__bd">
            <label class="weui-cell weui-check__label" for="x11">
                <div class="weui-cell__bd">
                    <p>外卖送餐</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" class="weui-check" name="radio1" id="x11" checked="checked">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x12">

                <div class="weui-cell__bd">
                    <p>店内就餐</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="radio1" class="weui-check" id="x12">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x13">

                <div class="weui-cell__bd">
                    <p>打包带走</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="radio1" class="weui-check" id="x13">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">位置:</label></div>
        <div class="weui-cell__bd">
            <a class="weui-cell weui-cell_access" href="javascript:;">
                <div class="weui-cell__bd">
                    <p>张三 13512345678</p>
                    <p>山东省青岛市市北区黄河路18号1号楼3层301室</p>
                </div>
                <div class="weui-cell__ft">编辑</div>
            </a>
        </div>
    </div>


</div>
<a href="javascript:;" class="weui-btn weui-btn_primary">下一步</a>
</body>
</html>