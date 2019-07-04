<#--  chenyi 2019-07-03 22:17:41-->

<html>
<head>
    <title>详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">主键ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">申请人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.applicant)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">联系电话<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.applyPhone)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">餐厅名<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.restaurantName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">地址<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.addr)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">健康等级<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.healthLevel)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">申请时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.applyTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
