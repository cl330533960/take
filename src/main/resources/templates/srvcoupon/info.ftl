<#--  chenyi 2019-06-27 13:47:41-->

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
            <label class="layui-label-left">金额<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.amount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">开始时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.startTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">结束时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.endTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">用户ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">是否使用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.isUse)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
