<#--  chenyi 2019-06-27 22:18:33-->

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
            <label class="layui-label-left">金额<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.amount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">有效期<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.validDay)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">类型<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.type)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">1打开0关闭<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.openClose)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
