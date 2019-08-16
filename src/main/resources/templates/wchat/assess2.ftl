<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>瘦体重法热量评估</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
    <script type="text/javascript" src="/wchat/js/iosSelect.js"></script>
    <script type="text/javascript" src="/wchat/js/data.js"></script>
    <link rel="stylesheet" href="/wchat/js/iosSelect.css">
</head>
<body>


<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">体重<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="weight" type="number" placeholder="请输入体重，单位kg">
        </div>
        <div id="weightdom" class="weui-cell__hd" style="color: #276Dcc">选择</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">腰围:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="waistline" readonly="readonly"  placeholder="请输入腰围，单位厘米">
        </div>
        <div id="waistlinedom" class="weui-cell__hd" style="color: #276Dcc">选择</div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">性别<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="sex"  readonly="readonly" placeholder="请选择性别">
        </div>
        <img  src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <br>
    <a href="javascript:;" onclick="assessPage()" style="margin-right: 15px;margin-left: 15px;border-radius: 30px;margin-bottom: 50px;background-color: #276fd4"class="weui-btn weui-btn_primary">开始评估</a>

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

                var waistlinedata =$("#waistline").val();
                waistline=waistlinedata.split("cm")[0];
                window.location.href = "/wx/assessTwo?weight=" + weight +  "&sex=" + sex + "&waistline=" + waistline;

            }

            var weightDom = document.querySelector('#weightdom');
            var weight = document.querySelector('#weight');
            weightDom.addEventListener('click', function () {
                var bankId = weightDom.dataset['value'];

                var bankSelect = new IosSelect(1,
                        [weightdata],
                        {
                            container: '.container',
                            title: '选择体重',
                            itemHeight: 50,
                            itemShowCount: 3,
                            oneLevelId: bankId,
                            callback: function (selectOneObj) {
                                weight.value = selectOneObj.value;
                            }
                        });
            });

            var waistlineDom = document.querySelector('#waistlinedom');
            var waistline = document.querySelector('#waistline');
            waistlineDom.addEventListener('click', function () {
                var bankId = waistlineDom.dataset['value'];
                var bankSelect = new IosSelect(1,
                        [waistlinedata],
                        {
                            container: '.container',
                            title: '选择腰围',
                            itemHeight: 50,
                            itemShowCount: 3,
                            oneLevelId: bankId,
                            callback: function (selectOneObj) {
                                waistline.value = selectOneObj.value;
                            }
                        });
            });
        </script>


</body>
</html>