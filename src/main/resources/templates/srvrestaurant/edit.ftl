<#--  chenyi 2019-06-21 18:55:54-->

<html>
<head>
    <title>修改页面</title>
<#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
    <#include "common.ftl"/>
        <input type="hidden" name="id" value="${model.id}">

        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>

            <div class="layui-input-normal">
                <input type="text" name="username" id="username"  value="${(model.username)!""}" lay-verify="required|username"
                       autocomplete="off" class="layui-input"  >
            </div>
        </div>
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/srvrestaurant/update"><i
                            class="fa fa-floppy-o">&nbsp;</i>保存
                    </button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    $(document).ready(function() {
        $('#username').attr('disabled', 'disabled');
    })
</script>

</body>
</html>

