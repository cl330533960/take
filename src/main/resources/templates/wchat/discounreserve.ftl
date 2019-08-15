<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>优惠预订</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
    <script type="text/javascript" src="/wchat/js/iosSelect.js"></script>
    <script type="text/javascript" src="/wchat/js/data.js"></script>
    <link rel="stylesheet" href="/wchat/js/iosSelect.css">
    <style type="text/css">
        .bgback{  margin-left: 10%;
            margin-right: 10%;
            height: 12%;
            display: flex;
            align-items: center;
            background-color: #ffffff; }
        .margintop{
            margin-top: 4%;
        }
        .line{
            margin-left: 5%;
            margin-right: 5%;
            height: 1px;
            background: #0C0C0C;
        }
        .fontsize{
            font-size: 24px;
            margin-left: 10px;
        }
        .input{
            margin-left: auto;
            outline-style: none ;
            border: 1px solid #ccc;
            border-radius: 1px;
            width: 200px;
            font-size: 24sp;
            height: 30px;
            font-family: "Microsoft soft";
            /*font-weight: 700;*/
            font-family: "Microsoft soft";
            /*background: url("../../static/statics/img/down.png") no-repeat 20px 20px*/
        }
        .selected{
            height: 30px;
            margin-left: auto;
            outline-style: none ;
            border: 1px solid #ccc;
            border-radius: 1px;
            width: 80px;
            font-size: 24sp;
            /*font-weight: 700;*/
            font-family: "Microsoft soft";
            /*background: url("../../static/statics/img/down.png") no-repeat 20px 20px*/
        }
        .button{
            border-radius:12px;
            margin-left: 15%;
            margin-right: 15%;
            height: 20px;
            display: block;border: 14px solid #06CB06;
            background: #06CB06;margin-top: 15%;text-align: center
        }

    </style>
</head>
<body>

<!-- 容器 -->
<div class="weui-cells weui-cells_form">

    <div class="" style="display:flex;flex-direction: row;height: 42px;align-items: center">
        <div style="background-color: #276fd4 ;width: 2px ;height: 20px;margin-left: 15px"></div>
        <div style="margin-left: 20px;font-size: 16px">优惠预定介绍</div>
    </div>
    <div class="weui-msg__text-area" style="margin-left: 15px;margin-right: 15px;margin-top: 15px">
        <p class="weui-msg__desc">优惠预订,您可以在此选择优惠。优惠类型以及时间如下,敬请选择</p>
    </div>


    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">手机<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="weight" maxlength="11"   type="number" placeholder="请输入手机号">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">备注:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="waistline" type="number" placeholder="请输入备注">
        </div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">套餐类型:<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="ctype"  readonly="readonly" placeholder="套餐类型">
        </div>
        <div id="ctypedom" class="weui-cell__hd" style="color: #276fd4;margin-right: 5px">选择</div>
        <img  src="/statics/img/ypyw/right.png" width="10px">
    </div>

    <br/>

    <a href="javascript:;" onclick="savediscounreserve()" style="margin-right: 15px;margin-left: 15px;margin-bottom: 50px;margin-top50px;border-radius: 30px;background-color: #276fd4" class="weui-btn weui-btn_primary">确定</a>





</div>
<script type="text/javascript">

    var ctypeDom = document.querySelector('#ctypedom');
    var ctypedom = document.querySelector('#ctype');
    ctypeDom.addEventListener('click', function () {
        var bankId = ctypeDom.dataset['value'];
        var bankSelect = new IosSelect(1,
                [typedata],
                {
                    container: '.container',
                    title: '选择套餐',
                    itemHeight: 50,
                    itemShowCount: 3,
                    oneLevelId: bankId,
                    callback: function (selectOneObj) {
                        ctypedom.value = selectOneObj.value;
                    }
                });
    });


    function savediscounreserve() {

        var discounType =  $('#numbers option:selected') .val();//选中的值
        var remark =  $("#remark").val();
        var phone= $("#phone").val();

        $.showLoading("正在提交数据，请稍后");

        var url="/wx/discountReserve?wxId=${wxId}&discounType="+discounType+"&remark="+remark;
        $.ajax({
            //请求方式
            type: "POST",
            //请求的媒体类型
            //请求地址
            url: url,
            //数据，json字符串
            //请求成功
            success: function (result) {
                $.hideLoading();
                $.toast("保存成功");
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                $.hideLoading();
                $.toast("获取数据失败", "cancel");
            }
        });
    }


</script>

</body>
</html>