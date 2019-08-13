<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>健康餐品</title>
    <style>
        .myweui-count__decrease{

            display:block;
            width:100%;
            height:270px;
            background-image:url('/statics/img/ypyw/button_+.png');
            background-repeat: no-repeat;
            background-position:50% 50%;
        }
        .myweui-count{
            height: 21px;
            width: 21px;
            line-height: 21px;
            display: inline-block;
            background-color: transparent;
            font-size: .8rem;
            border: 0;
            width: 1.3rem;
            text-align: center;
            color: #5f646e;
        }
        .myweui-count__btn{
            border-radius: 50%;
            vertical-align: -6px;
        }
    </style>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>
<div class="weui-cells weui-cells_form">

    <a class=" myweui-count__decrease"></a>
    <div class="weui-cell__ft">
        <div class="weui-count">
            <a class="weui-count__btn myweui-count__decrease"></a>
            <input   class="weui-count__number" disabled="disabled"
                   type="number"
                   value="0">
            <a class="weui-count__btn weui-count__increase"></a>
        </div>
    </div>
</div>
</body>
<script>

</script>
</html>