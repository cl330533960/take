<#--  chenyi 2019-06-26 14:01:40-->

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
            <label class="layui-label-left">订单号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.orderNo)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">用户ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">商户ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.restaurantId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">用户地址ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userAddrId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">快递公司<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.expressCompnay)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">快递单号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.expressNum)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">骑手名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.expressName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">骑手电话<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.expressPhone)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">订单状态<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">总金额<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.orderTotal)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">备注<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.remark)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">外卖类型<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.orderType)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">用户支付费用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userPayFee)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">运费<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.wayFee)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">包装费<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.packFee)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">优惠券ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.couponId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">折扣<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.discount)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
