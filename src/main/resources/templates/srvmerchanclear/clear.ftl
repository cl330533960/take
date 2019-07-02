<#--  chenyi 2019-06-26 18:38:42-->

<html>
<head>
    <title>添加页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <input type="hidden" name="restaurantId" value="${model.id}">
        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">操作人</label>
            <div class="layui-input-normal">
                <input type="text"   maxlength="32" lay-verify="required" id="optrName"
                       value="${(model.restaurantId)!""}" disabled="disabled"     class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">结算费用<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="clearAmount"  lay-verify="number||clearamount"
                      placeholder="请输入结算费用"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">费用余额</label>
            <div class="layui-input-normal">
                <input type="text" id="balance"  maxlength="32"
                       value="${(model.balance)!""}"  disabled="disabled"  class="layui-input">
            </div>
        </div>
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/srvmerchanclear/clearAmount"><i class="fa fa-floppy-o">&nbsp;</i>保存</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>

<script>
    $.getJSON("/sys/user/info?_"+$.now(), function(r){
        $("#optrName").val(r.user.username) ;
    });
    layui.use('form', function () {
        var form = layui.form();
        form.verify({
            clearamount: function (value, item) {
                if (value - $("#balance").val() > 0) { // 不满足库存
                   return "结算金额不能大于余额";
                }
            }
        });

    })
</script>
</body>
</html>
