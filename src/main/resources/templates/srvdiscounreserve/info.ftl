<#--  chenyi 2019-06-25 17:24:03-->

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
            <label class="layui-label-left">折扣开始时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.discountStart)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">折扣结束时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.discountEnd)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">用户ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">折扣比<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.discount)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
