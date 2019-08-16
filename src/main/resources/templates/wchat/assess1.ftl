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
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">身高<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="height" type="number"   readonly="readonly" placeholder="请输入身高,单位cm">
        </div>
        <div id="heightdom" class="weui-cell__hd" style="color: #276Dcc">选择</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">体重<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="weight" type="number"  readonly="readonly" placeholder="请输入体重,单位kg">
        </div>
        <div id="weightdom" class="weui-cell__hd" style="color: #276Dcc">选择</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">腰围:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="waistline" readonly="readonly" placeholder="请输入腰围，单位厘米">
        </div>
        <div id="waistlinedom" class="weui-cell__hd" style="color: #276Dcc">选择</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">年龄<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="age" type="number"  readonly="readonly" placeholder="请输入年龄">
        </div>
        <div id="agedom" class="weui-cell__hd" style="color: #276Dcc">选择</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">性别<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input"  id="sex" placeholder="请选择性别">
        </div>
        <img  src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">运动强度<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input"  id="sport" placeholder="请选择运动强度">
        </div>
        <img  src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <br>
    <a href="javascript:;" onclick="assessPage()"style="margin-right: 15px;margin-left: 15px;border-radius: 30px;margin-bottom: 50px;background-color: #276fd4" class="weui-btn weui-btn_primary">开始评估</a>

    <div>


        <script type="text/javascript">
            $("#sex").select({
                title: "选择性别",
                items: [{title: "男性", value: "1"}, {title: "女性", value: "2"}]
            });
            $("#sport").select({
                title: "运动强度",
                items: [{title: "很少运动", value: 1.1}, {title: "每周走步2-3次,每次40分钟以上", value: 1.15},{title: "每周慢跑3次以上,每次40分钟以上", value: 1.2}]
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

                var waistlinedata =$("#waistline").val();
                waistline=waistlinedata.split("cm")[0];

                window.location.href = "/wx/assessOne?height="+height+"&weight="+weight+"&sex="+sex+"&waistline="+waistline+"&sportRatio="+sport+"&age="+age;
            }


            var heightDom = document.querySelector('#heightdom');
            var height = document.querySelector('#height');
            heightDom.addEventListener('click', function () {
                // var bankId = weightDom.dataset['id'];
                var bankId = weightDom.dataset['value'];

                var bankSelect = new IosSelect(1,
                        [heightdata],
                        {
                            container: '.container',
                            title: '选择身高',
                            itemHeight: 50,
                            itemShowCount: 3,
                            oneLevelId: bankId,
                            callback: function (selectOneObj) {
                                height.value = selectOneObj.value;
                                // showBankDom.innerHTML = selectOneObj.value;
                                // showBankDom.dataset['id'] = selectOneObj.id;
                                // showBankDom.dataset['value'] = selectOneObj.value;
                            }
                        });
            });


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

            var ageDom = document.querySelector('#agedom');
            var age = document.querySelector('#age');
            ageDom.addEventListener('click', function () {
                var bankId = waistlineDom.dataset['value'];
                var bankSelect = new IosSelect(1,
                        [agedata],
                        {
                            container: '.container',
                            title: '选择年龄',
                            itemHeight: 50,
                            itemShowCount: 3,
                            oneLevelId: bankId,
                            callback: function (selectOneObj) {
                                age.value = selectOneObj.value;
                            }
                        });
            });

            


        </script>

</body>
</html>