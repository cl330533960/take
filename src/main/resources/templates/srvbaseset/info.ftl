<#--  chenyi 2019-07-01 21:09:34-->

<html>
<head>
    <title>详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">BMI计算公式<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.bmi)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">偏瘦<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.thin)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">正常<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.normal)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">偏胖<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.overWeight)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">肥胖<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.obesity)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">正常体重上限<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.normalWeightUp)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">正常体重下限<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.normalWeightDown)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">男性BEE<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.manBee)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">女性BEE<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.woman)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sportRatio)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.overWeightHeatDown)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.overWeightHeatUp)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.obesityHeatDown)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.obesityHeatUp)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
