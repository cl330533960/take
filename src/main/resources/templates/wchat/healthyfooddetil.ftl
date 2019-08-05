<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <style>
        img {
            width: 100%;
            height: 200px;
        }

        .circle {
            width: 80px;
            height: 80px;
            background-color: #ff5740;
            border-radius: 50%;
            -moz-border-radius: 50%;
            -webkit-border-radius: 50%;
        }
    </style>
    <title>餐品</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>
<div>

    <div class="swiper-container" style="z-index:1">
        <div class="swiper-wrapper">
        <#list model.imageList! as img>
            <div class="swiper-slide"><img src="/getData/showImage?imagePath=" +${img!} alt=""></div>
        </#list>
        </div>
        <div class="swiper-pagination"></div>
    </div>
    <div class="circle" style="position: absolute;top: 160px;z-index: 998;right: 15px">
        <div style="display: flex;align-items: center;align-content: center;height: 100%;flex-direction: column;justify-content: center">
            <p style="font-size: 20px;color: white">${model.cal!}</p>

            <p style="font-size: 12px;color: white">Kcal</p>
        </div>
    </div>
    <div class="weui-cell">
        <div id="foodname" style="font-weight:bold">${model.name!}</div>
    </div>
    <div class="weui-cell">
        <div style="flex-direction: row;display: flex; align-items: center; width: 100%">
            <div id="price" style="font-weight:bold"><span style="color: red">￥${model.sys_price!}</span></div>
            <p id="number" style="margin-left: 60%;font-size: 14px">月销 ${model.month_sale!}</p>
        </div>
    </div>
    <div class="weui-cell">
        <div style="background-color: #ff5740 ;width: 3px ;height: 12px;"></div>
        <div style="margin-left: 20px;font-size: 16px">餐品详情</div>
    </div>
    <div class="weui-cell">
        <div class="weui-media-box__bd">
            <p class="weui-media-box__desc" style="margin-top: 10px "> ${model.remark!}</p>
        </div>
    </div>
    <div class="weui-cell">
        <div style="background-color: #ff5740 ;width: 3px ;height: 12px;"></div>
        <div style="margin-left: 20px;font-size: 16px">用户评价</div>
    </div>

<#list model.commentList! as comment>
    <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">
        <div class="weui-media-box__hd">
            <img class="weui-media-box__thumb" src="/statics/img/ypyw/account_profile_small.png" alt="">
        </div>
        <div class="weui-media-box__bd">
            <h4 class="weui-media-box__title">
                ${comment.name!}
                <span class="weui-media-box__title-after" style=" float: right; padding-right: 5px">${comment.commentTime?string('yyyy-MM-dd')}</span>
            </h4>

            <p class="weui-media-box__desc"> ${comment.content!}</p>
        </div>
    </a>
</#list>
</div>


</body>
<script>
    $(function () {
        var mySwiper = new Swiper('.swiper-container',
                {
                    speed: 3000,//播放速度
                    autoHeight: true,
                    loop: true,//是否循环播放
                    setWrapperSize: true,
                    autoplay: {
                        delay: 5000,
                        disableOnInteraction: false,
                    },
                    pagination: '.swiper-pagination',//分页
                    effect: 'slide',//动画效果
                }
        );

    })


</script>
</html>