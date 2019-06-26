<#--  chenyi 2019-06-25 17:47:38-->

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
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.name)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.scale)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.cal)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.price)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">1早晨2午餐3晚餐 多选<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.foodType)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">1冷2热<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.hotCold)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.chianId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.restaurantId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">1是 0否<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.isAllRestaurant)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.remark)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">1启用0禁用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sysPrice)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
