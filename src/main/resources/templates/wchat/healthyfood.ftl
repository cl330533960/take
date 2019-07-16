<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>健康餐品</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>
<div class="weui-cells weui-cells_form">
    <input type="hidden" name="orderType" value="${orderType!}"/>

    <div class="weui-cell">
        <div class="weui-cell__bd">
            <input type="hidden" id="addrId" value="${model.id!}"/>

            <p id="nameAndPhone">${model.receiveName!}&nbsp;&nbsp;${model.receivePhone!}</p>

            <p id="addr">${model.receiveAddr!}</p>
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
    <div class="weui-cells">
    <#list foodList! as food>
        <div class="weui-cell weui-cell_swiped">
            <div class="weui-cell__bd" style="transform: translate3d(0px, 0px, 0px);">
                <div class="weui-cell">
                    <div class="weui-cell__hd"><img
                            src="http://03imgmini.eastday.com/mobile/20190706/20190706131806_56aecc32cbbb3810c2f3658a7a59011b_3_mwpm_03200403.jpg"
                            alt="" style="width:80px;height:80px;margin-right:5px;display:block"></div>
                    <div class="weui-cell__bd">
                        <p>${food.name!}</p>
                        <span class="price">￥${food.sysPrice!}</span>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input class="weui-count__number" type="number" value="0">
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="weui-cell__ft">
                <a class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" href="javascript:">删除</a>
                <a class="weui-swiped-btn weui-swiped-btn_default close-swipeout" href="javascript:">关闭</a>
            </div>
        </div>
    </#list>
    <#if foodList?size<=0>
        <div class="weui-cell">
            <div class="weui-cell__bd">
                暂无推荐餐品
            </div>
        </div>
    </#if>
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
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>合计<span id="totalAmount" style="color: red">￥0</span></p>
        </div>
    </div>
    <a href="#" class="weui-btn weui-btn_primary">提交订单</a>
</div>
</body>
<script>
    var MAX = 99, MIN = 0;
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