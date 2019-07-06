<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>开始点餐</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/wchat/js/template.js"></script>
    <script type="text/javascript" src="/wchat/js/home.js"></script>
    <style type="text/css">
        .fontsize{
            font-size: 34px;
        }
        .uiclass{
            display: flex;justify-content: space-between;margin-left: 5%;margin-right: 5%;margin-top: 15px
        }
    </style>
</head>
<body >

<div style="width: 100%;height: 100%; ">
    <div  id="table1">
        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: center ;background-color:#24aa7d ; align-items:center; ">
                <a style="height: 10%;font-size: 54px; margin-top: 20px;margin-bottom: 20px;color: #ffffff"> 健康餐品</a>
            </div>
        </div>

        <div>
            <ul class="mui-table-view tblv-nl" id="list_warp">
                <li class="uiclass" >
                    <img src="http:\/\/00imgmini.eastday.com\/mobile\/20190706\/20190706124522_0d0dc844da776178f953616d161341ce_1_mwpm_03200403.jpg" alt="" height="265px" width="265px"style="" />
                    <div style="display: flex;flex-direction: column;align-items: center;justify-content: center">
                          <a style="font-size: 30px">西南桦盖饭</a>
                    </div>
                </li>

                <li class="uiclass" >
                    <img src="http:\/\/00imgmini.eastday.com\/mobile\/20190706\/20190706124522_0d0dc844da776178f953616d161341ce_1_mwpm_03200403.jpg" alt="" height="265px" width="265px"style="" />
                    <div style="display: flex;flex-direction: column;align-items: center;justify-content: center">
                        <a style="font-size: 30px">西南桦盖饭</a>
                    </div>
                </li>

            </ul>

        </div>

    </div>


    <div  id="table2">
        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: center ;background-color:#24aa7d ; align-items:center; ">
                <a style="height: 10%;font-size: 54px; margin-top: 20px;margin-bottom: 20px;color: #ffffff"> 我的订单</a>
            </div>
        </div>

    </div>



    <div  id="table3">
        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: center ;background-color:#24aa7d ; align-items:center; ">
                <a style="height: 10%;font-size: 54px; margin-top: 20px;margin-bottom: 20px;color: #ffffff"> 相关设置</a>
            </div>
        </div>

        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: space-between;margin-left: 5%;margin-top: 10%;
                  align-items:center;margin-right: 5%">
                <a style="height: 10%;font-size: 34px;"> 收货地址设置</a>
                <img src="/statics/img/ypyw/right.png" alt="" height="65px" width="65px"style="" />
            </div>
            <div class="line"></div>
        </div>

        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: space-between;margin-left: 5%;margin-top: 10%;
                  align-items:center;margin-right: 5%">
                <a style="height: 10%;font-size: 34px;"> 优惠券</a>
                <img src="/statics/img/ypyw/right.png" alt="" height="65px" width="65px"style="" />
            </div>
            <div class="line"></div>
        </div>


        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: space-between;margin-left: 5%;margin-top: 10%;
                  align-items:center;margin-right: 5%">
                <a style="height: 10%;font-size: 34px;"> 优惠预定</a>
                <img src="/statics/img/ypyw/right.png" alt="" height="65px" width="65px"style="" />
            </div>
            <div class="line"></div>
        </div>

        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: space-between;margin-left: 5%;margin-top: 10%;
                  align-items:center;margin-right: 5%">
                <a style="height: 10%;font-size: 34px;"> 定量点餐</a>
                <img src="/statics/img/ypyw/right.png" alt="" height="65px" width="65px"style="" />
            </div>
            <div class="line"></div>
        </div>

    </div>


    <div>
        <div class="weui-tabbar"  style="height: 7%" >
            <a  href="#table1" onclick="choice(1)" class="weui-tabbar__item weui-bar__item--on">
            <#--<span class="weui-badge" style="position: absolute;top: -.4em;right: 1em;">8</span>-->
                <div class="weui-tabbar__icon" style="width: 50px;height: 50px">
                    <img src="/statics/img/ypyw/home.png"  alt="">
                </div>
                <p class="weui-tabbar__label fontsize"  >餐品</p>
            </a>
            <a href="#table2" onclick="choice(2)" class="weui-tabbar__item ">
                <div class="weui-tabbar__icon" style="width: 50px;height: 50px">
                    <img src="/statics/img/ypyw/my.png"  alt="">
                </div>
                <p class="weui-tabbar__label fontsize">我的</p>
            </a>
            <a  href="#table3" onclick="choice(3)" class="weui-tabbar__item">

                <div class="weui-tabbar__icon" style="width: 50px;height: 50px">
                    <img src="/statics/img/ypyw/setting.png"  alt="">
                </div>
                <p class="weui-tabbar__label fontsize">设置</p>
            </a>

        </div>
    </div>
</div>

<script type="text/html" name = "list_view" id="list_view">
    {{if data==null||data.length==0}}
    <div class="nodata">暂无内容11111222{{data }}</div>
    {{else}}
    {{each data as item}}
    <li id="match_{{item.MatchId}}" class="mui-table-view-cell mui-media  ">

     {{if item.author_name.length>4}}
       <img  src="{{item.thumbnail_pic_s}}"  style="width: 50px;height: 50px; " >
     {{/if}}

    {{if item.author_name.length<5}}
        <img  src="{{item.thumbnail_pic_s}}"  style="width: 50px;height: 50px; " >
     {{/if}}

   </li>
 {{/each}} {{/if}}
</script>


</body>

</html>