<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>有品有味·热量评估</title>
    <style>
        .myweui{
            position: absolute;
            left: 0;
            top: 0;
            right: 0;
            height: 1px;
            border-top: 1px solid #e5e5e5;
            color: #e5e5e5;
            -webkit-transform-origin: 0 0;
            transform-origin: 0 0;
            -webkit-transform: scaleY(.5);
            transform: scaleY(.5);
            left: 15px;
            z-index: 2;
        }
        .itembg{
            margin-top: 10px;
            margin-right: 10px;
            margin-left: 10px;
            margin-bottom: 10px;
            background:rgba(255,255,255,1);
            box-shadow:0px 2px 20px 0px rgba(163, 197, 182, 0.35);
            border-radius:20px;
        }
        .borderline{
            border:1px #276fd4  solid;
        }
        /*label{*/
            /*line-height: 20px;*/
            /*display: inline-block;*/
            /*margin-left: 5px;*/
            /*margin-right:15px;*/
            /*color: #777;*/
        /*}*/
        .radio_type{
            width: 20px;
            height: 20px;
            appearance: none;
            display: inline-block;
            position: relative;
        }
        .radio_type:before{
            content: '';
            width: 20px;
            height: 20px;
            /*border: 1px solid #7d7d7d;*/
            display: inline-block;
            border-radius: 50%;
            vertical-align: middle;
        }
        .radio_type:checked:before{
            content: '';
            width: 20px;
            height: 20px;
            border: 1px solid #276fd4;
            background:#276fd4;
            display: inline-block;
            border-radius: 50%;
            vertical-align: middle;
        }
        .radio_type:checked:after{
            content: '';
            width: 10px;
            height:5px;
            border: 2px solid white;
            border-top: transparent;
            border-right: transparent;
            text-align: center;
            display: block;
            position: absolute;
            top: 6px;
            left:5px;
            vertical-align: middle;
            transform: rotate(-45deg);
        }
        .radio_type:checked+label{
            color: #276fd4;
        }
    </style>

<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>
<div class="weui-cells weui-cells_form" >
    <div>
        <img src="/statics/img/ypyw/top_banner_img.png" width="100%" height="140px" />
        <h3 style="position: absolute;top: 30px;left: 15px;"  >
            我的热量我知道
        </h3>
        <div style="position: absolute;top: 60px;left: 15px;font-size: 8px;color:rgba(154,169,189,1);"  >

        </div>
        <div style="position: absolute;top: 80px;left: 15px;font-size: 8px;color:rgba(154,169,189,1);"  >
            根据个性化的数据计算评估每天摄入热量的
        </div>
        <div style="position: absolute;top: 100px;left: 15px;font-size: 8px;color:rgba(154,169,189,1);"  >
            合理范围并合理搭配三大营养素的比例
        </div>

    </div>

    <div class="weui-cell">请选择计算方法</div>
    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check__label itembg  borderline" id="div11" for="x11" >
            <div class="weui-cell__bd">

                <a  class="weui-media-box weui-media-box_appmsg" style="height: 30px">
                    <div class="weui-media-box__hd">
                        <img class="weui-media-box__thumb" src="/statics/img/ypyw/icon_fangcheng.png">
                    </div>
                    <div class="weui-media-box__bd">
                        <h4 class="weui-media-box__title">1.Harris-Benedict方程</h4>
                        <p class="weui-media-box__desc">推荐，考虑因素全面，医学常用</p>
                    </div>
                </a>
            </div>

            <div class="weui-cell__ft">
                <input type="radio" class="radio_type" value="1" name="calcType" id="x11"
                       checked="checked">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check__label itembg" id="div12"  for="x12">
            <div class="weui-cell__bd">
                <a  class="weui-media-box weui-media-box_appmsg"style="height: 30px">
                    <div class="weui-media-box__hd">
                        <img class="weui-media-box__thumb" src="/statics/img/ypyw/icon_lose_weight.png">
                    </div>
                    <div class="weui-media-box__bd">
                        <h4 class="weui-media-box__title">2.瘦体重法</h4>
                        <p class="weui-media-box__desc">适合知道自己去脂体重者</p>
                    </div>
                </a>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" name="calcType" value="2" class="radio_type" id="x12">
                <span class="weui-icon-checked"></span>
            </div>
        </label>

    </div>

    <div class="weui-cell" >
        <div class="weui-media-box__bd">
            <h4 class="weui-media-box__title" style="color:red ">温馨提示</h4>

            <p class="weui-media-box__desc" style="margin-top: 10px "> 1、本热量评估仅供18-65岁有减脂需求的人士参考使用。</p>
            <p class="weui-media-box__desc"style="margin-top: 10px "> 2、患有急慢性病者请在医生指导下使用。</p>
            <p class="weui-media-box__desc"style="margin-top: 10px "> 3、怀孕、哺乳期不适用。</p>
        </div>
    <#--<p>温馨提示</p>-->

    <#--<p> 1、本热量评估仅供18-65岁有减脂需求的人士参考使用。</p>-->

    <#--<p> 2、患有急慢性病者请在医生指导下使用。</p>-->

    <#--<p> 3、怀孕、哺乳期不适用。</p>-->
    </div>
    <br>
    <a href="javascript:;" onclick="calcPage()" style="margin-right: 15px;margin-left: 15px;margin-bottom: 50px;border-radius: 30px;background-color: #276fd4" class="weui-btn weui-btn_primary">开始评估</a>
    <div></div>
<#--<div class="button">-->
<#--<a href="javascript:;" onclick="start('/wx/start')"-->
<#--style="font-size: 34px;padding: 2px 6px;-->
<#--display: block;color: #ffffff;line-height:90px ">开始评估</a>-->
<#--</div>-->

</div>

</body>
</html>
<script type="text/javascript">
    function calcPage() {
        var calcType = $("input[name='calcType']:checked").val();
        window.location.href="/wx/calcPage"+'?type='+calcType;
    }

    $(document).ready(function() {


        if($("input[type=radio][name=calcType]:checked").val()==1){
            $("#div11").addClass("borderline"); //添加样式
            $("#div12").removeClass("borderline"); //
        }else {
            $("#div12").addClass("borderline"); //添加样式
            $("#div11").removeClass("borderline"); //
        }

        $('input[type=radio][name=calcType]').change(function() {
            if (this.value == 1) {

                $("#div11").addClass("borderline"); //添加样式
                $("#div12").removeClass("borderline"); //
            }
            else if (this.value == 2) {
                $("#div12").addClass("borderline"); //添加样式
                $("#div11").removeClass("borderline"); //
            }
        });
    });

</script>