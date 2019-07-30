<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>瘦体重法热量评估</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>


<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">体重<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="weight" type="number" placeholder="请输入体重，单位kg">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">腰围:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="waistline" type="number" placeholder="请输入腰围，单位厘米">
        </div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">性别<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="sex" placeholder="请选择性别">
        </div>
    </div>
    <br>
    <a href="javascript:;" onclick="assessPage()" class="weui-btn weui-btn_primary">开始评估</a>

    <div>


        <script type="text/javascript">
            $("#sex").select({
                title: "选择性别",
                items: [{title: "男性", value: "1"}, {title: "女性", value: "2"}]
            });

            function assessPage() {
                checkData();
            }

            function checkData(){
                var sex = $("#sex").attr("data-values");
                var weight = parseFloat($("#weight").val());
                var waistline = parseFloat($("#waistline").val());

                if(!weight){
                    $.toptip('体重为必须项', 'error');
                    return;
                }
                if(!sex){
                    $.toptip('性别为必须项', 'error');
                    return;
                }
                $.showLoading("正在提交数据，请稍后");
                window.location.href = "/wx/assessTwo?weight=" + weight +  "&sex=" + sex + "&waistline=" + waistline;

            }
        </script>


</body>
</html>