<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>HB热量评估</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>


<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">身高<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="height" type="number"  placeholder="请输入身高，单位cm">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">体重<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="weight" type="number"  placeholder="请输入体重，单位kg">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">腰围:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="waistline" type="number"  placeholder="请输入腰围，单位厘米">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">年龄<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="age" type="number"  placeholder="请输入年龄">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">性别<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input"  id="sex" placeholder="请选择性别">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">运动强度<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input"  id="sport" placeholder="请选择运动强度">
        </div>
    </div>
    <br>
    <a href="javascript:;" onclick="assessPage()"style="margin-right: 15px;margin-left: 15px;border-radius: 30px;margin-bottom: 50px" class="weui-btn weui-btn_primary">开始评估</a>

    <div>


        <script type="text/javascript">
            $("#sex").select({
                title: "选择性别",
                items: [{title: "男性", value: "1"}, {title: "女性", value: "2"}]
            });
            $("#sport").select({
                title: "运动强度",
                items: [{title: "很少运动", value: 1.1}, {title: "每周走步2-3次，每次40分钟以上", value: 1.15},{title: "每周慢跑3次以上，每次40分钟以上", value: 1.2}]
            });

            function assessPage(){
                checkData();
            }

            function checkData(){
                var height = parseFloat($("#height").val());
                var weight = parseFloat($("#weight").val());
                var sex = $("#sex").attr("data-values");
                var sport = parseFloat($("#sport").attr("data-values"));
                var age =parseInt($("#age").val());
                var waistline = parseFloat($("#waistline").val());


                if(!height){
                    $.toptip('身高为必须项', 'error');
                    return;
                }
                if(!weight){
                    $.toptip('体重为必须项', 'error');
                    return;
                }

                if(!age){
                    $.toptip('年龄为必须项', 'error');
                    return;
                }

                if(!sex){
                    $.toptip('性别为必须项', 'error');
                    return;
                }

                if(!sport){
                    $.toptip('运动系数为必须项', 'error');
                    return;
                }
                window.location.href = "/wx/assessOne?height="+height+"&weight="+weight+"&sex="+sex+"&waistline="+waistline+"&sportRatio="+sport+"&age="+age;
            }
        </script>

</body>
</html>