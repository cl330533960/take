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
    <script type="text/javascript" src="/wchat/js/newdata.js"></script>
    <link rel="stylesheet" href="/wchat/js/iosSelect.css">
</head>
<body>


<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">去脂体重<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="weight" value="70"   type="number" placeholder="请选择体重，单位kg">
        </div>
        <#--<div id="weightdom" class="weui-cell__hd" style="color: #276Dcc">选择</div>-->
        <img id="weightdom"  src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">腰围:</label></div>
        <div class="weui-cell__bd">
            <#--<input class="weui-input" id="waistline" readonly="readonly"  placeholder="请选择腰围，单位厘米">-->
            <input type="text" class="weui-input" id="waistline"   placeholder="请选择腰围，单位厘米" value="85cm/2.55尺"/>
        </div>
        <#--<div id="waistlinedom" class="weui-cell__hd" style="color: #276Dcc">选择</div>-->
        <img id="waistlinedom"  src="/statics/img/ypyw/right.png" width="10px">
    </div>

    <#--<div class="weui-cell">-->
        <#--<div class="weui-cell__hd"><label class="weui-label">性别<span style="color: red">*</span>:</label></div>-->
        <#--<div class="weui-cell__bd">-->
            <#--&lt;#&ndash;<input class="weui-input" id="sex"  readonly="readonly" placeholder="请选择性别">&ndash;&gt;-->
            <#--<input type="text" class="weui-input" id="sex"  readonly="readonly" placeholder="请选择性别" value="iPhone 5"/>-->
        <#--</div>-->
        <#--<img  src="/statics/img/ypyw/right.png" width="10px">-->
    </div>
    <br>
    <a href="javascript:;" onclick="assessPage()" style="margin-right: 15px;margin-left: 15px;border-radius: 30px;margin-bottom: 50px;background-color: #276fd4"class="weui-btn weui-btn_primary">开始评估</a>

    <div>


        <script type="text/javascript">
            // $("#sex").select({
            //     title: "选择性别",
            //     items: [{title: "男性", value: "1"}, {title: "女性", value: "2"}]
            // });

            $("#waistline").picker({
                title: "请选择您的腰围",
                cols: [
                    {
                        textAlign: 'center',
                        values: waistlinedata
                    }
                ]
            });
            $("#weight").picker({
                title: "请选择您的体重",
                cols: [
                    {
                        textAlign: 'center',
                        values: weightdata
                    }
                ]
            });

            function assessPage() {
                checkData();
            }

            function checkData(){
                var sex = 1;
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
            //
            // var weightDom = document.querySelector('#weight');
            // var weight = document.querySelector('#weight');
            // weightDom.addEventListener('click', function () {
            //     var bankId = weightDom.dataset['value'];
            //
            //     var bankSelect = new IosSelect(1,
            //             [weightdata],
            //             {
            //                 container: '.container',
            //                 title: '选择体重',
            //                 itemHeight: 50,
            //                 itemShowCount: 3,
            //                 oneLevelId: bankId,
            //                 callback: function (selectOneObj) {
            //                     weight.value = selectOneObj.value;
            //                 }
            //             });
            // });

            // var waistlineDom = document.querySelector('#waistline');
            // var waistline = document.querySelector('#waistline');
            // waistlineDom.addEventListener('click', function () {
            //     var bankId = waistlineDom.dataset['value'];
            //     var bankSelect = new IosSelect(1,
            //             [waistlinedata],
            //             {
            //                 container: '.container',
            //                 title: '选择腰围',
            //                 itemHeight: 50,
            //                 itemShowCount: 3,
            //                 oneLevelId: bankId,
            //                 callback: function (selectOneObj) {
            //                     waistline.value = selectOneObj.value;
            //                 }
            //             });
            // });
        </script>


</body>
</html>