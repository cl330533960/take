<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <style>
        img{
            width: 100%;
            height: 200px;
        }
        .circle{   width: 80px;
            height: 80px;
            background-color:#ff5740;
            border-radius: 50%;
            -moz-border-radius: 50%;
            -webkit-border-radius: 50%;    }
    </style>
    <title>餐品</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>
<div >

    <div class="swiper-container" style="z-index:1">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img  src="http://03imgmini.eastday.com/mobile/20190706/20190706131806_56aecc32cbbb3810c2f3658a7a59011b_3_mwpm_03200403.jpg" alt=""></div>
            <div class="swiper-slide"><img  src="https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1564886926&di=2355c33b93e00a211b1805982744657a&src=http://b-ssl.duitang.com/uploads/blog/201510/20/20151020193329_rjWfs.jpeg" alt=""></div>
            <div class="swiper-slide"><img  src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564897102315&di=491965139f57e78ae8adb8da365cea25&imgtype=0&src=http%3A%2F%2Fimg18.3lian.com%2Fd%2Ffile%2F201711%2F03%2F33658744127579fb2b7252146dd79a36.png" alt=""></div>
        </div>
        <div class="swiper-pagination"></div>
    </div>
    <div class="circle" style="position: absolute;top: 160px;z-index: 998;right: 15px">
       <div style="display: flex;align-items: center;align-content: center;height: 100%;flex-direction: column;justify-content: center">
           <p style="font-size: 20px;color: white" >120</p>
           <p style="font-size: 12px;color: white" >Kcal</p>
       </div>
    </div>
    <div class="weui-cell">
          <div id="foodname" style="font-weight:bold">西蓝花盖饭</div>
    </div>
    <div class="weui-cell">
        <div style="flex-direction: row;display: flex; align-items: center; width: 100%">
            <div id="price" style="font-weight:bold"><span style="color: red">￥35</span></div>
            <p id="number"  style="margin-left: 60%;font-size: 14px">月销 20001</p>
        </div>
    </div>
    <div class="weui-cell">
        <div style="background-color: #ff5740 ;width: 3px ;height: 12px;"></div>
        <div style="margin-left: 20px;font-size: 16px">餐品详情</div>
    </div>
    <div class="weui-cell" >
        <div class="weui-media-box__bd">
            <p class="weui-media-box__desc" style="margin-top: 10px "> 1、本餐品新鲜美味,晶莹剔透。</p>
            <p class="weui-media-box__desc"style="margin-top: 10px "> 2、餐品美味,分类包装代销。</p>
            <p class="weui-media-box__desc"style="margin-top: 10px "> 3、怀孕、哺乳期不适用。</p>
        </div>
    </div>
    <div class="weui-cell">
        <div style="background-color: #ff5740 ;width: 3px ;height: 12px;"></div>
        <div style="margin-left: 20px;font-size: 16px">用户评价</div>
    </div>

</div>


</body>
<script>
    $(function () {
        var mySwiper = new Swiper('.swiper-container',
                {
                    speed:3000,//播放速度
                    autoHeight:true,
                    loop:true,//是否循环播放
                    setWrapperSize:true,
                    autoplay:
                            {
                                delay: 5000,
                                disableOnInteraction: false,
                            },
                    pagination:  '.swiper-pagination',//分页
                    effect : 'slide',//动画效果
                }
        );

    })



</script>
</html>