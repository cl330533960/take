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
    <script type="text/javascript" src="/wchat/js/newdata.js"></script>
    <link rel="stylesheet" href="/wchat/js/iosSelect.css">
    <script type="text/javascript">
        var sportdata = [];
        var sportnumberdata=[];
        <#list sportList! as item>
            var data = '{"id":${item.code},"value":"${item.value}"}';
            // sportdata.push($.parseJSON(data));
         sportdata.push("${item.value}");
         sportnumberdata.push("${item.code}");
        </#list>
    </script>
</head>
<body>


<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">身高<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="height" type="number"  value="170"    placeholder="请选择体身高.单位cm">
        </div>
        <img id="heightdom" src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">体重<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="weight" type="number"  value="70" placeholder="请选择体重,单位kg">
        </div>
        <img id="weightdom" src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">腰围:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="waistline"value="85cm/2.55尺" placeholder="请选择腰围，单位厘米">
        </div>
        <img id="waistlinedom" src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">年龄<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="age" type="number"  value="35" placeholder="请选择年龄">
        </div>
        <img  id="agedom" src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">性别<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input"  id="sex"  value="男性" placeholder="请选择性别">
        </div>
        <img  src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">运动强度<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input"  id="sport"  placeholder="请选择运动强度">
        </div>
        <img  src="/statics/img/ypyw/right.png" width="10px">
    </div>
    <br>
    <a href="javascript:;" onclick="assessPage()"style="margin-right: 15px;margin-left: 15px;border-radius: 30px;margin-bottom: 50px;background-color: #276fd4" class="weui-btn weui-btn_primary">开始评估</a>

    <div>


        <script type="text/javascript">

            $("#height").picker({
                title: "请选择您的身高",
                cols: [
                    {
                        textAlign: 'center',
                        values: heightdata
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
            $("#waistline").picker({
                title: "请选择您的腰围",
                cols: [
                    {
                        textAlign: 'center',
                        values: waistlinedata
                    }
                ]
            });
            $("#age").picker({
                title: "请选择您的年龄",
                cols: [
                    {
                        textAlign: 'center',
                        values: agedata
                    }
                ]
            });
            $("#sex").picker({
                title: "请选择您的性别",
                cols: [
                    {
                        textAlign: 'center',
                        values: sexdata
                    }
                ]
            });
            $("#sport").picker({
                title: "请选择您的运动强度",
                cols: [
                    {
                        textAlign: 'center',
                        values: sportdata
                    }
                ]
            });

            var sexnumber = null;
            var sportnumber = null;
            function assessPage(){
                checkData();
            }

            function getArrayIndex() {
                var i = sportdata.length;
                while (i--) {
                    if (sportdata[i] === ($("#sport").val())) {
                        sportnumber =sportnumberdata[i] ;
                    }
                }
            }

            function checkData(){
                var height = parseFloat($("#height").val());
                var weight = parseFloat($("#weight").val());
                if("男性"==$("#sex").val()){
                    sexnumber=1
                }else{
                    sexnumber=2;
                }
                getArrayIndex();
                var sex = parseInt(sexnumber);
                var sport = parseFloat(sportnumber);
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
                if(!waistlinedata){
                    $.toptip('腰围为必须项', 'error');
                    return;
                }

                waistline=waistlinedata.split("cm")[0];


                window.location.href = "/wx/assessOne?height="+height+"&weight="+weight+"&sex="+sex+"&waistline="+waistline+"&sportRatio="+sport+"&age="+age;

            }


            // var heightDom = document.querySelector('#height');
            // var height = document.querySelector('#height');
            // heightDom.addEventListener('click', function () {
            //     // var bankId = weightDom.dataset['id'];
            //     var bankId = weightDom.dataset['value'];
            //
            //     var bankSelect = new IosSelect(1,
            //             [heightdata],
            //             {
            //                 container: '.container',
            //                 title: '选择身高',
            //                 itemHeight: 50,
            //                 itemShowCount: 3,
            //                 oneLevelId: bankId,
            //                 callback: function (selectOneObj) {
            //                     height.value = selectOneObj.value;
            //                 }
            //             });
            // });
            //
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
            //
            //
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
            //
            // var ageDom = document.querySelector('#age');
            // var age = document.querySelector('#age');
            // ageDom.addEventListener('click', function () {
            //     var bankId = waistlineDom.dataset['value'];
            //     var bankSelect = new IosSelect(1,
            //             [agedata],
            //             {
            //                 container: '.container',
            //                 title: '选择年龄',
            //                 itemHeight: 50,
            //                 itemShowCount: 3,
            //                 oneLevelId: bankId,
            //                 callback: function (selectOneObj) {
            //                     age.value = selectOneObj.value;
            //                 }
            //             });
            // });
            //
            // var sexDom = document.querySelector('#sex');
            // var sex = document.querySelector('#sex');
            // sexDom.addEventListener('click', function () {
            //     var bankId = waistlineDom.dataset['value'];
            //     var bankSelect = new IosSelect(1,
            //             [sexdata],
            //             {
            //                 container: '.container',
            //                 title: '选择性别',
            //                 itemHeight: 50,
            //                 itemShowCount: 3,
            //                 oneLevelId: bankId,
            //                 callback: function (selectOneObj) {
            //                     sex.value = selectOneObj.value;
            //                     sexnumber= selectOneObj.id;
            //                 }
            //             });
            // });
            //
            //
            // var sportDom = document.querySelector('#sport');
            // var sport = document.querySelector('#sport');
            // sportDom.addEventListener('click', function () {
            //     var bankId = waistlineDom.dataset['value'];
            //     var bankSelect = new IosSelect(1,
            //             [sportdata],
            //             {
            //                 container: '.container',
            //                 title: '选择运动强度',
            //                 itemHeight: 50,
            //                 itemShowCount: 3,
            //                 oneLevelId: bankId,
            //                 callback: function (selectOneObj) {
            //                     sport.value = selectOneObj.value;
            //                     sportnumber= selectOneObj.id;
            //                 }
            //             });
            // });

        </script>

</body>
</html>