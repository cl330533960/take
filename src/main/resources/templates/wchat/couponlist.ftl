<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>我的优惠券</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>

<!-- 容器 -->
<div class="weui-tab">
    <div class="weui-navbar">
        <a class="weui-navbar__item weui-bar__item--on" href="/wx/couponList?wxId=1&isValid=0">
            未过期
        </a>
        <a class="weui-navbar__item" href="/wx/couponList?wxId=2&isValid=1">
            已过期
        </a>
    </div>
    <div class="weui-tab__bd">
        <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
        <#list model! as cp>
            <div class="weui-form-preview">
                <div class="weui-form-preview__bd">
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">¥${cp.amount!}</label>
                        <label class="weui-form-preview__value"><#if cp.isUse == "1">已使用<#else>未使用</#if></label>
                    </div>
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">类型：${cp.type!}</label>
                    </div>
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">红包来源${cp.source!}</label>
                    </div>
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">有效期：${cp.startTime?string('yyyy-MM-dd')}
                            至 ${cp.endTime?string('yyyy-MM-dd')}</label>
                    </div>
                </div>
            </div>
        </#list>
        </div>
        <div id="tab2" class="weui-tab__bd-item">
        <#list model! as cp>
            <div class="weui-form-preview">
                <div class="weui-form-preview__bd">
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">¥${cp.amount!}</label>
                        <label class="weui-form-preview__value"><#if cp.isUse == "1">已使用<#else>未使用</#if></label>
                    </div>
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">类型：${cp.type!}</label>
                    </div>
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">红包来源${cp.source!}</label>
                    </div>
                    <div class="weui-form-preview__item">
                        <label class="weui-form-preview__label">有效期：${cp.startTime?string('yyyy-MM-dd')}
                            至 ${cp.endTime?string('yyyy-MM-dd')}</label>
                    </div>
                </div>
            </div>
        </#list>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('.weui-navbar__item').on('click', function () {
            $(this).addClass('weui-bar__item_on').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
            $(".weui-tab__panel .weui_tab_bd_item_active").removeClass('weui_tab_bd_item_active');
            var data_toggle = jQuery(this).attr("href");
            $(data_toggle).addClass("weui_tab_bd_item_active");
        });
    });
</script>


</body>
</html>