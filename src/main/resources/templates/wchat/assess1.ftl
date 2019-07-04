<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>我的热量我知道</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>
<div style="margin-left: 5%;margin-right: 5%">
    <div>
        <a style=" color:#666; font-size: 42px;word-wrap:break-word;"> 我的热量我知道，根据个性化的数据， 计算评估每天摄入热量的合理范围，
            并合理搭配三大营养素的比例 </a>
    </div>

    <div class="weui-cells__title" style="font-size: 42px">请选择计算方法</div>

    <div class="weui-cells weui-cells_radio">
        <label class="weui-cell weui-check__label" for="x11">
            <div class="weui-cell__bd">
                <p style="font-size: 42px">1.Harris-Benedict方程 </p>
                <p style="font-size: 32px">推荐，考虑因素全面，医学常用 </p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" class="weui-check"  name="type1" id="x11"
                       checked="checked"  onclick="setdata(1)">
                <span class="weui-icon-checked"></span>
            </div>
        </label>

        <label class="weui-cell weui-check__label" for="x12">

            <div class="weui-cell__bd">
                <p style="font-size: 42px"> 2.瘦体重法</p>
                <p style="font-size: 32px">知道自己的瘦体重（去脂体重）者适用</p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" name="type1" class="weui-check" id="x12"
                       onclick="setdata(2)">
                <span class="weui-icon-checked"></span>
            </div>
    </div>

    <div style="margin-top: 5%"> <p style="font-size: 42px"> 温馨提示</p></div>
    <div> <p style="font-size: 32px"> 1、本热量评估仅供18-65岁有减脂需
        求的人士参考使用。</p></div>
    <div> <p style="font-size: 32px"> 2、患有急慢性病者请在医生指导下
        使用。</p></div>
    <div> <p style="font-size: 32px"> 3、怀孕、哺乳期不适用。</p></div>

    <div  style="height: 90px;width: 100%;
         display: block;border: 14px solid #06CB06;background: #06CB06;margin-top: 15%;text-align: center">
         <a href="javascript:;" onclick="start('/wx/start')"
            style="font-size: 34px;padding: 2px 6px;
            display: block;color: #ffffff;line-height:90px " >开始评估</a>
    </div>

</div>

</body>
</html>