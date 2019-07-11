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
<div class="weui-cells weui-cells_form">
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
<#--<div class="weui-cells">-->
<#--<div class="weui-cell weui-cell_swiped">-->
<#--<div class="weui-cell__bd" style="transform: translate3d(0px, 0px, 0px);">-->
<#--<div class="weui-cell">-->
<#--<div class="weui-cell__hd"><img src="http://03imgmini.eastday.com/mobile/20190706/20190706131806_56aecc32cbbb3810c2f3658a7a59011b_3_mwpm_03200403.jpg" alt="" style="width:150px;height:150px;margin-right:5px;display:block"></div>-->
<#--<div class="weui-cell__bd">-->
<#--<p>清风纸巾12包装</p>-->
<#--</div>-->
<#--<div class="weui-cell__ft">-->
<#--<div class="weui-cell__bd">-->
<#--<span class="price">￥24.00</span>-->
<#--</div>-->
<#--<div class="weui-count">-->
<#--<a class="weui-count__btn weui-count__decrease"></a>-->
<#--<input class="weui-count__number" type="number" value="1">-->
<#--<a class="weui-count__btn weui-count__increase"></a>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<div class="weui-cell__ft">-->
<#--<a class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" href="javascript:">删除</a>-->
<#--<a class="weui-swiped-btn weui-swiped-btn_default close-swipeout" href="javascript:">关闭</a>-->
<#--</div>-->
<#--</div>-->
<#--<div class="weui-cell weui-cell_swiped">-->
<#--<div class="weui-cell__bd" style="transform: translate3d(0px, 0px, 0px);">-->
<#--<div class="weui-cell">-->
<#--<div class="weui-cell__hd"><img src="http://03imgmini.eastday.com/mobile/20190706/20190706131806_56aecc32cbbb3810c2f3658a7a59011b_3_mwpm_03200403.jpg" alt="" style="width:150px;height:150px;margin-right:5px;display:block"></div>-->
<#--<div class="weui-cell__bd">-->
<#--<p>七匹狼男士长筒袜</p>-->
<#--</div>-->
<#--<div class="weui-cell__ft">-->
<#--<span class="price">￥35.00</span>-->
<#--<div class="weui-count">-->
<#--<a class="weui-count__btn weui-count__decrease"></a>-->
<#--<input class="weui-count__number" type="number" value="1">-->
<#--<a class="weui-count__btn weui-count__increase"></a>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<div class="weui-cell__ft">-->
<#--<a class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" href="javascript:">删除</a>-->
<#--<a class="weui-swiped-btn weui-swiped-btn_default close-swipeout" href="javascript:">关闭</a>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
    <div class="weui-cells" style="padding-bottom: 15px;">
        <ul id="list_warp">
            <li class="uiclass">
                <img src="http://03imgmini.eastday.com/mobile/20190706/20190706131806_56aecc32cbbb3810c2f3658a7a59011b_3_mwpm_03200403.jpg"
                     style="width: 200px;height: 200px; ">

                <div style="display: flex;flex-direction: column;align-items: center;justify-content: center">
                    <a style="font-size: 30px">法国赫美娇胶原蛋白</a>

                    <div style=" width:300px; display: flex; justify-content: space-between;align-items: center">
                        <a style="font-size: 30px;color: #9f191f">￥36</a>

                        <div>
                            <div class="weui-count">
                                <a class="weui-count__btn weui-count__decrease"></a>
                                <input class="weui-count__number" type="number" value="1">
                                <a class="weui-count__btn weui-count__increase"></a>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <div class="weui-cells">
        <a class="weui-cell weui-cell_access" href="javascript:;">
            <div class="weui-cell__bd">
                <p>优惠预定</p>
            </div>
            <div class="weui-cell__ft">
            </div>
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
<script>
    var MAX = 99, MIN = 1;
    $('.weui-count__decrease').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var number = parseInt($input.val() || "0") - 1
        if (number < MIN) number = MIN;
        $input.val(number)
    })
    $('.weui-count__increase').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var number = parseInt($input.val() || "0") + 1
        if (number > MAX) number = MAX;
        $input.val(number)
    })
</script>
</html>