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
            <label class="layui-label-left">订单号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.orderNo)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">用户<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.wxName)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">商户<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.restaurantName)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">收件人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.receiveName)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">收件人电话<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.receivePhone)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">收件人地址<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.receiveAddr)!"-"}</label>
        </div>
        <table id="foodList" lay-filter="test"></table>
        <div class="layui-form-item">
            <label class="layui-label-left">用户支付费用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userPayFee)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">总金额<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.orderTotal)!"-"}</label>
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
            <div class="layui-form-item">
                <label class="layui-label-left">备注<span class="label_span">:</span></label>
                <label class="layui-label-right">${(model.remark)!"-"}</label>
            </div>
            <div class="layui-form-item">
                <label class="layui-label-left">外卖类型<span class="label_span">:</span></label>
                <div class="layui-input-normal">
                    <div cyType="selectTool" cyProps="codeName:'ordertype',name:'ordertype'" name="openClose"
                         value="${(model.orderType)!""}" class="layui-input-inline"></div>
                </div>
            </div>

    </form>
</div>
<script>
    $(document).ready(function() {
        $('select').attr('disabled', 'disabled');
    })
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#foodList'
            ,height: 200
            ,width:600
            ,url: '/srvorderfood/listData?orderId=${model.id}' //数据接口
            ,cols: [[ //表头
                {field: 'foodName', title: '食品', width:145}
                ,{field: 'price', title: '单价', width:145}
                ,{field: 'number', title: '数量', width:150}
                ,{field: 'totalPrice', title: '总价', width:150}
            ]]
        });
    });
</script>


</body>
</html>
