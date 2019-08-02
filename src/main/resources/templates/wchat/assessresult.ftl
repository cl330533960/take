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
        <div style="background-color: #ff5740 ;width: 2px ;height: 20px;margin-left: 15px"></div>
        <div style="margin-left: 20px;font-size: 20px">评估结果</div>
    </div>
    <div >

        <#--<img src="/statics/img/ypyw/u341.png" />-->
        <div style="display: flex;flex-direction: row;width: 100%;align-items:center;justify-content: center">
            <div style="background-color: #34beef;width: 20%;height: 25px;text-align:center;color:#ffffff;border-top-left-radius: 5px;border-bottom-left-radius: 5px">偏瘦</div>
            <div style="background-color: #26ca98;width: 20%;height: 25px;text-align:center;color:#ffffff">正常</div>
            <div style="background-color: #fea918;width: 20%;height: 25px;text-align:center;color:#ffffff">超重</div>
            <div style="background-color: #ff725e;width: 20%;height: 25px;text-align:center;color:#ffffff;border-top-right-radius: 5px;border-bottom-right-radius: 5px">肥胖</div>
        </div>
        <div style="display: flex;flex-direction: row;width: 100%;align-items:center;justify-content: center;margin-top: 10px;margin-bottom: 15px">
                <div style=" width: 20%;height: 25px;text-align:center;">18.5</div>
                <div style=" width: 20%;height: 25px;text-align:center;">24</div>
                <div style=" width: 20%;height: 25px;text-align:center;">28</div>
        </div>
        <div style="border-bottom:1px dashed ;widows: 100%;margin-right: 5px;margin-left: 5px;margin-bottom: 20px;margin-top: 20px"></div>
        <div style="display: flex;justify-content: center;margin-bottom: 10px">

            <#if model.bmiRes! == '偏瘦'>
            <img src="/statics/img/ypyw/img_thin.png" width="150px" height="150px"/>
             </#if>
            <#if model.bmiRes! == '正常'>
            <img src="/statics/img/ypyw/img_normal.png" width="150px" height="150px"/>
            </#if>
            <#if model.bmiRes! == '超重'>
            <img src="/statics/img/ypyw/img_overweight.png" width="150px" height="150px"/>
            </#if>
            <#if model.bmiRes! == '肥胖'>
            <img src="/statics/img/ypyw/img_fat.png" width="150px" height="150px"/>
            </#if>


            <div style="position: absolute;top: 196px;color: #ffffff;font-size: 25px"><b>${model.bmi!}</b></div>
            <div style="position: absolute;top: 226px;color: #ffffff;font-size: 15px"">${model.bmiRes!}</div>
        </div>
      <div style="display: flex;justify-content: center;margin-bottom: 10px">
             您的体质指数(BMI)
      </div>

    </div>
    <div class="weui-cell">
        您的体质指数(BMI)为:${model.bmi!}属于：${model.bmiRes!}
    </div>
    <div class="weui-cell">
        体型(腹部)：${model.centerObesityRes!}
    </div>
    <div class="weui-cell">
        您的理想体重为：${model.normalWeightDown!}KG ~ ${model.normalWeightDown!}KG
    </div>
    <div class="weui-cell">
        您目前超重：${model.overWeight!}
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
            <h4 class="weui_media_title" style="color:#ff5740 ">CRD-1500方案</h4>

            <p class="weui_media_desc" style="margin-top: 10px">早餐:450kcal </p>
            <p class="weui_media_desc"style="margin-top: 10px">午餐:600kcal</p>
            <p class="weui_media_desc"style="margin-top: 10px">晚餐:450kcal</p>

            <p class="weui_media_desc"style="margin-top: 10px">蛋白质、脂肪、碳水化合物比例建议:2:3:5</p>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui_media_bd">
            <p class="weui_media_desc"style="color:#ff5740 ">有品有味联合多家线下优质餐厅，由营养师精心搭配，全新推出符合上述方案的多种套餐，既可堂食，也可外卖送餐，欢迎点餐</p>
        </div>
    </div>
    <br>
    <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx688906a5f5df8b37&redirect_uri=http://www.tastyfit.vip/wx/rationorderFood&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect" style="background-color: #ff5740;border-radius: 30px;margin-left: 15px;margin-right: 15px;margin-bottom: 30px "  class="weui-btn weui-btn_primary">去点餐</a>
</div>

</div>


</body>
</html>