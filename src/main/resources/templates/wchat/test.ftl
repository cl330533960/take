<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>HB法·热量评估</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
    <script type="text/javascript" src="/wchat/js/iosSelect.js"></script>
    <script type="text/javascript" src="/wchat/js/data.js"></script>
    <link rel="stylesheet" href="/wchat/js/iosSelect.css">
</head>
<body>


<div class="weui-cells weui-cells_form">

    <a href="javascript:;" onclick="assessPage()"style="margin-right: 15px;margin-left: 15px;border-radius: 30px;margin-bottom: 50px;background-color: #276fd4" class="weui-btn weui-btn_primary">开始获取IP</a>

    <div>


        <script type="text/javascript">



            function assessPage(){
                $.ajax({
                    //请求方式
                    type: "GET",
                    //请求的媒体类型
                    //请求地址
                    url: '/wx/getip',
                    //数据，json字符串
                    //请求成功
                    success: function (result) {
                    alert(result);
                    },
                    //请求失败，包含具体的错误信息
                    error: function (e) {
                    }
                });
            }



        </script>

</body>
</html>