<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>订单详情</title>
<#include "../wx.ftl"/>

    <script type="text/javascript" src="/wchat/js/template.js"></script>
    <script type="text/javascript" src="/wchat/js/home.js"></script>


</head>
<body>
<div class="weui-panel weui-panel_access">
    <div class="weui-panel__hd" style="text-align: center;font-size: 54px;height: 10%; color: #F0F9F2; background-color:#24aa7d">订单详情</div>

    <div class="swiper-container" data-space-between='120'   data-pagination='.swiper-pagination' data-autoplay="2000">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img
                    src="https://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i1/TB1n3rZHFXXXXX9XFXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg" width="100%" height="400px"
                    alt=""></div>
            <div class="swiper-slide"><img
                    src="https://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i4/TB10rkPGVXXXXXGapXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg" width="100%" height="400px"
                    alt=""></div>
            <div class="swiper-slide"><img
                    src="https://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i1/TB1kQI3HpXXXXbSXFXXXXXXXXXX_!!0-item_pic.jpg_320x320q60.jpg" width="100%" height="400px"
                    alt=""></div>
        </div>
    </div>

    <div class="weui-cell weui-cell_vcode">
        <div class="weui-cell__bd">
            <label class="weui-label">西蓝花盖饭</label>
        </div>
        <div class="weui-cell__bd">
            <label class="weui-label" style="color: red">￥36</label>
        </div>
        <div class="weui-cell__bd">
            <label class="weui-label">1</label>
        </div>
    </div>
    <div class="weui-cell weui-cell_vcode">
        <div class="weui-cell__bd">
            <label class="weui-label">西蓝花盖饭</label>
        </div>
        <div class="weui-cell__bd">
            <label class="weui-label" style="color: red">￥36</label>
        </div>
        <div class="weui-cell__bd">
            <label class="weui-label">1</label>
        </div>
    </div>
</div>
<#--<div class="weui-panel__ft">-->
<#--<a href="javascript:void(0);" class="weui-cell weui-cell_access weui-cell_link">-->
<#--<div class="weui-cell__bd">查看更多</div>-->
<#--<span class="weui-cell__ft"></span>-->
<#--</a>-->
<#--</div>-->
</div>

<script type="text/javascript">
    var mySwiper = new Swiper('.swiper-container',
            {
                speed: 2000,//播放速度
                autoHeight: true,
                loop: true,//是否循环播放
                setWrapperSize: true,
                autoplay:
                        {
                            delay: 5000,
                            disableOnInteraction: false,
                        },
                pagination: '.swiper-pagination',//分页
                effect: 'slide',//动画效果
            }
    );
</script>
</body>

</html>