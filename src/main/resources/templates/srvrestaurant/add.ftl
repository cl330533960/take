<!DOCTYPE html>
<html>
<head>
    <title>添加页面</title>
<#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"><span class="span_must">*</span>用户名</label>

            <div class="layui-input-normal">
                <input type="text" name="username" value="" lay-verify="required|username" placeholder="请输入用户名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">所属角色</label>

            <div class="layui-input-normal">
                <div cyType="selectTool" cyProps="url:'/sys/role/findAll',multiple:'true'" value=""
                     name="roleIdList[]" class="layui-input-normal"></div>
            </div>
        </div>


    <#include "common.ftl"/>



        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/srvrestaurant/save"><i
                            class="fa fa-floppy-o">&nbsp;</i>保存
                    </button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
