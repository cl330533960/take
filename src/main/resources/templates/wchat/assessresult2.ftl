<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>评估结果</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>

<div class="weui-cells weui-cells_form">
    <div class="" style="display:flex;flex-direction: row;height: 50px;align-items: center">
        <div style="background-color: #266ece ;width: 2px ;height: 20px;margin-left: 15px"></div>
        <div style="margin-left: 20px;font-size: 20px">评估结果</div>
    </div>
    <div class="weui-cell">
        体型(腹部)：${model.centerObesityRes!}
    </div>
    <div class="weui-cell">
        每日摄取热量建议为：${model.cal!}Kcal
    </div>
    <div class="" style="display:flex;flex-direction: row;height: 50px;align-items: center">
        <div style="background-color: #ff5740 ;width: 2px ;height: 20px;margin-left: 15px"></div>
        <div style="margin-left: 20px;font-size: 20px">饮食建议</div>
    </div>
    <div class="weui-cell">
        <div class="weui_media_bd">
            <h4 style="color: #ff5740 ;margin-top: 5px" class="weui_media_title">CRD-${model.cal!}方案</h4>

            <p style=" margin-top: 5px" class="weui_media_desc">早餐:${model.cal!*0.3}kcal </p>
            <p style=" margin-top: 5px" class="weui_media_desc">午餐:${model.cal!*0.4}kcal</p>
            <p style=" margin-top: 5px" class="weui_media_desc">晚餐:${model.cal!*0.3}kcal</p>

            <p style=" margin-top: 5px" class="weui_media_desc">蛋白质、脂肪、碳水化合物比例建议:2:3:5</p>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui_media_bd">
            <p style="color: #ff5740 " class="weui_media_desc">有品有味联合多家线下优质餐厅，由营养师精心搭配，全新推出符合上述方案的多种套餐，既可堂食，也可外卖送餐，欢迎点餐</p>
        </div>
    </div>
    <br>
    <#--<a href="javascript:;" onclick="assessPage()"  style="background-color: #ff5740;border-radius: 30px;margin-left: 15px;margin-right: 15px;margin-bottom: 30px " class="weui-btn weui-btn_primary">去点餐</a>-->
    <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx688906a5f5df8b37&redirect_uri=http://www.tastyfit.vip/wx/rationorderFood&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect" style=";background-color: #276fd4;border-radius: 30px;margin-left: 15px;margin-right: 15px;margin-bottom: 30px " class="weui-btn weui-btn_primary">去点餐</a>
</div>

</div>












</body>
</html>