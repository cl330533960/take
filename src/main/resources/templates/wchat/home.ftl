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
        ul,
        li {
            list-style: none;
        }

        a {
            text-decoration: none;
        }

        a:hover {
            cursor: pointer;
            text-decoration: none;
        }

        a:link {
            text-decoration: none;
        }

        img {
            vertical-align: middle;
        }

        .btn-numbox {
            overflow: hidden;
            margin-top: 20px;
        }

        .btn-numbox li {
            float: left;
        }

        .btn-numbox li .number,
        .kucun {
            display: inline-block;
            font-size: 12px;
            color: #808080;
            vertical-align: sub;
        }

        .btn-numbox .count {
            overflow: hidden;
        }

        .btn-numbox .count .num-jian,
        .input-num,
        .num-jia {
            display: inline-block;
            width: 38px;
            height: 38px;
            line-height: 38px;
            text-align: center;
            font-size: 18px;
            color: #999;
            cursor: pointer;
            border: 1px solid #e6e6e6;
        }
        .btn-numbox .count .input-num {
            width: 58px;
            height: 36px;
            color: #333;
            border-left: 0;
            border-right: 0;
        }
        .fontsize {
            font-size: 34px;
        }

        .uiclass {
            display: flex;
            justify-content: space-between;
            margin-left: 5%;
            margin-right: 5%;
            margin-top: 15px
        }
    </style>
</head>
<body>

<div >
    <div id="table1"  >
        <div style="display: flex;flex-direction: column;">
            <div style="display: flex;justify-content: center ;background-color:#24aa7d ; align-items:center;  ">
                <a style="height: 10%;font-size: 54px; margin-top: 20px;margin-bottom: 20px;color: #ffffff"> 健康餐品</a>
            </div>
        </div>

        <div id="list_view" style="height: 80%;position:absolute;bottom:10%;overflow: auto;width: 100% " >
            <ul   id="list_warp">
                <li class="uiclass">
                    <img src="http:\/\/00imgmini.eastday.com\/mobile\/20190706\/20190706124522_0d0dc844da776178f953616d161341ce_1_mwpm_03200403.jpg"
                         alt="" height="200px" width="200px" style=""/>
                    <div style="display: flex;flex-direction: column;align-items: center;justify-content: center">
                        <a style="font-size: 30px">西南桦盖饭</a>
                        <div style="  display: flex; justify-content: space-between;">
                            <a style="font-size: 30px;color: #ab1e1e">$36</a>
                            <a style="font-size: 30px;color: #ab1e1e">$36</a>
                        </div>
                    </div>
                </li>

                <li class="uiclass">
                    <img src="http:\/\/00imgmini.eastday.com\/mobile\/20190706\/20190706124522_0d0dc844da776178f953616d161341ce_1_mwpm_03200403.jpg"
                         alt="" height="200px" width="200px" style=""/>

                    <div style="display: flex;flex-direction: column;align-items: center;justify-content: center">
                        <a style="font-size: 30px">西南桦盖饭</a>
                    </div>
                </li>

            </ul>

        </div>

    </div>


    <div id="table2">
        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: center ;background-color:#24aa7d ; align-items:center; ">
                <a style="height: 10%;font-size: 54px; margin-top: 20px;margin-bottom: 20px;color: #ffffff"> 我的订单</a>
            </div>
        </div>

    </div>


    <div id="table3">
        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: center ;background-color:#24aa7d ; align-items:center; ">
                <a style="height: 10%;font-size: 54px; margin-top: 20px;margin-bottom: 20px;color: #ffffff"> 相关设置</a>
            </div>
        </div>

        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: space-between;margin-left: 5%;margin-top: 10%;
                  align-items:center;margin-right: 5%">
                <a style="height: 10%;font-size: 34px;"> 收货地址设置</a>
                <img src="/statics/img/ypyw/right.png" alt="" height="65px" width="65px" style=""/>
            </div>
            <div class="line"></div>
        </div>

        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: space-between;margin-left: 5%;margin-top: 10%;
                  align-items:center;margin-right: 5%">
                <a style="height: 10%;font-size: 34px;"> 优惠券</a>
                <img src="/statics/img/ypyw/right.png" alt="" height="65px" width="65px" style=""/>
            </div>
            <div class="line"></div>
        </div>


        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: space-between;margin-left: 5%;margin-top: 10%;
                  align-items:center;margin-right: 5%">
                <a style="height: 10%;font-size: 34px;"> 优惠预定</a>
                <img src="/statics/img/ypyw/right.png" alt="" height="65px" width="65px" style=""/>
            </div>
            <div class="line"></div>
        </div>

        <div style="display: flex;flex-direction: column">
            <div style="display: flex;justify-content: space-between;margin-left: 5%;margin-top: 10%;
                  align-items:center;margin-right: 5%">
                <a style="height: 10%;font-size: 34px;"> 定量点餐</a>
                <img src="/statics/img/ypyw/right.png" alt="" height="65px" width="65px" style=""/>
            </div>
            <div class="line"></div>
        </div>

    </div>

<#--底部导航栏-->
    <div class="weui-tabbar" style="height: 7%;position:absolute;bottom:0;">
        <a href="#table1" onclick="choice(1)" class="weui-tabbar__item weui-bar__item--on">
        <#--<span class="weui-badge" style="position: absolute;top: -.4em;right: 1em;">8</span>-->
            <div class="weui-tabbar__icon" style="width: 50px;height: 50px">
                <img src="/statics/img/ypyw/home.png" alt="">
            </div>
            <p class="weui-tabbar__label fontsize">餐品</p>
        </a>
        <a href="#table2" onclick="choice(2)" class="weui-tabbar__item ">
            <div class="weui-tabbar__icon" style="width: 50px;height: 50px">
                <img src="/statics/img/ypyw/my.png" alt="">
            </div>
            <p class="weui-tabbar__label fontsize">我的</p>
        </a>
        <a href="#table3" onclick="choice(3)" class="weui-tabbar__item">

            <div class="weui-tabbar__icon" style="width: 50px;height: 50px">
                <img src="/statics/img/ypyw/setting.png" alt="">
            </div>
            <p class="weui-tabbar__label fontsize">设置</p>
        </a>

    </div>

</div>
</body>
<script type="text/html" id="info">
    {{if data==null||data.length==0}}
    <div class="nodata">暂无内容11111222{{data }}</div>
    {{else}}

    {{each data as item}}

    <li class="uiclass">
        {{if item.author_name.length>4}}
        <img src="{{item.thumbnail_pic_s}}" style="width: 200px;height: 200px; ">

        <div style="display: flex;flex-direction: column;align-items: center;justify-content: center">
            <a style="font-size: 30px">{{item.author_name}}</a>
            <div style=" width:300px; display: flex; justify-content: space-between;align-items: center">
                <a style="font-size: 30px;color: #9f191f">￥36</a>
                <div  >
                    <ul class="btn-numbox">
                        <li>
                            <ul class="count">
                                <li><span id="num-jian" class="num-jian">-</span></li>
                                <li><input type="text" class="input-num" id="input-num" value="0" /></li>
                                <li><span id="num-jia" class="num-jia">+</span></li>
                            </ul>
                        </li>
                     </ul>
                </div>
            </div>
        </div>
        {{/if}}

    </li>
    {{/each}} {{/if}}
</script>
</html>