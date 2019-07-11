<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>健康餐品</title>
<#include "../resource.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
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
            margin-top: 40px;
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
<div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>张三 13512345678</p>
            <p>山东省青岛市市北区黄河路18号1号楼3层301室</p>
        </div>
    </div>
    <div class="weui-search-bar" id="searchBar">
        <form class="weui-search-bar__form">
            <div class="weui-search-bar__box">
                <i class="weui-icon-search"></i>
                <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="请输入菜品名称" required="">
                <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
            </div>
            <label class="weui-search-bar__label" id="searchText">
                <i class="weui-icon-search"></i>
                <span>搜索</span>
            </label>
        </form>
        <a href="javascript:" class="weui-search-bar__cancel-btn" id="searchCancel">取消</a>
    </div>
    <#--<div id="list_view" style="height: 80%;position:absolute;bottom:10%;overflow: auto;width: 100% ">-->
        <#--<ul id="list_warp">-->
            <#--<li class="uiclass">-->
                <#--<img src="http://03imgmini.eastday.com/mobile/20190706/20190706131806_56aecc32cbbb3810c2f3658a7a59011b_3_mwpm_03200403.jpg"-->
                     <#--style="width: 200px;height: 200px; ">-->

                <#--<div style="display: flex;flex-direction: column;align-items: center;justify-content: center">-->
                    <#--<a style="font-size: 30px">法国赫美娇胶原蛋白</a>-->

                    <#--<div style=" width:300px; display: flex; justify-content: space-between;align-items: center">-->
                        <#--<a style="font-size: 30px;color: #9f191f">￥36</a>-->

                        <#--<div>-->
                            <#--<ul class="btn-numbox">-->
                                <#--<li>-->
                                    <#--<ul class="count">-->
                                        <#--<li><span id="num-jian" class="num-jian">-</span></li>-->
                                        <#--<li><input type="text" class="input-num" id="input-num" value="0"></li>-->
                                        <#--<li><span id="num-jia" class="num-jia">+</span></li>-->
                                    <#--</ul>-->
                                <#--</li>-->
                            <#--</ul>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</li>-->
        <#--</ul>-->
    <#--</div>-->
    <#--<div class="weui-cell">-->
        <#--<div style="display: flex;flex-direction: column">-->
            <#--<div style="display: flex;justify-content: space-between;margin-left: 5%;margin-top: 10%;-->
                  <#--align-items:center;margin-right: 5%">-->
                <#--<a style="height: 10%;font-size: 34px;"> 优惠预定</a>-->
                <#--<img src="/statics/img/ypyw/right.png" alt="" height="65px" width="65px" style=""/>-->
            <#--</div>-->
            <#--<div class="line"></div>-->
        <#--</div>-->
    <#--</div>-->
    <div class="weui-cell__bd">
        <a class="weui-cell weui-cell_access" href="javascript:;">
            <div class="weui-cell__bd">
                <p>优惠预定</p>
        </a>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>包装费 2元</p>
            <p>配送费 6元</p>
        </div>
    </div>
    <div class="weui-cells__title">添加备注</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <textarea class="weui-textarea" placeholder="请输入备注" rows="3"></textarea>
                <div class="weui-textarea-counter"><span>0</span>/200</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>