<#--  chenyi 2019-06-26 18:38:42-->

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
            <label class="layui-label-left">商家ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.restaurantId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">余额<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.clearAmount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">上次结余<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.clearTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">操作人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.optrName)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
