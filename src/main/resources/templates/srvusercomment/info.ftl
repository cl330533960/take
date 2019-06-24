<#--  chenyi 2019-06-24 17:30:19-->

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
            <label class="layui-label-left">用户ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">评论内容<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.content)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">评论时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.commentTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">商家ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.restaurantId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
