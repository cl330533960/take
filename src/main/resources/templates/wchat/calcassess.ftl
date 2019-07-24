<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>我的热量我知道</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>
<div class="weui-cells weui-cells_form">
    <div class="weui-cell">
        我的热量我知道，根据个性化的数据， 计算评估每天摄入热量的合理范围，并合理搭配三大营养素的比例。
    </div>
    <div class="weui-cell">请选择计算方法</div>
    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check__label" for="x11">
            <div class="weui-cell__bd">
                <p>1.Harris-Benedict方程 </p>

                <p>推荐，考虑因素全面，医学常用 </p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" class="weui-check" value="1" name="calcType" id="x11"
                       checked="checked">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="x12">
            <div class="weui-cell__bd">
                <p> 2.瘦体重法</p>

                <p>知道自己的瘦体重（去脂体重）者适用</p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" name="calcType" value="2" class="weui-check" id="x12">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
    </div>

    <div class="weui-cell">
        <div class="weui-media-box__bd">
            <h4 class="weui-media-box__title">温馨提示</h4>

            <p class="weui-media-box__desc"> 1、本热量评估仅供18-65岁有减脂需求的人士参考使用。</p>

            <p class="weui-media-box__desc"> 2、患有急慢性病者请在医生指导下使用。</p>

            <p class="weui-media-box__desc"> 3、怀孕、哺乳期不适用。</p>
        </div>
    <#--<p>温馨提示</p>-->

    <#--<p> 1、本热量评估仅供18-65岁有减脂需求的人士参考使用。</p>-->

    <#--<p> 2、患有急慢性病者请在医生指导下使用。</p>-->

    <#--<p> 3、怀孕、哺乳期不适用。</p>-->
    </div>
    <br>
    <a href="javascript:;" onclick="calcPage()" class="weui-btn weui-btn_primary">开始评估</a>

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

</script>