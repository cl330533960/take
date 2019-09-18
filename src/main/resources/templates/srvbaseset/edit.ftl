<#--  chenyi 2019-07-01 21:09:34-->

<html>
<head>
    <title>修改页面</title>
    <#include "../resource.ftl"/>
</head>
<script type="text/javascript">
    layui.use(['form'], function () {
        var form = layui.form();
        //监听提交
        form.on('submit(submit)', function (data) {
            var url=$(this).attr("data-url");
            $.ajax({
                url: url,
                type: "post",
                contentType: "application/x-www-form-urlencoded",
                data: data.field,
                async: false,
                dataType: "json",
                success: function (R) {
                    if (R.code == 0) {
                        $t.Refresh();
                        //刷新页面
                        parent.layer.msg('操作成功 !', {icon: 1});
                    } else {
                        parent.layer.msg(R.msg, {icon: 5});
                    }
                },
                error: function () {
                    alert("系统繁忙");
                }
            });
            return false;
        });
    });

</script>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
       <#include "common.ftl"/>
        <input type="hidden" name="id" value="${model.id}">
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/srvbaseset/update"><i class="fa fa-floppy-o">&nbsp;</i>保存</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>

