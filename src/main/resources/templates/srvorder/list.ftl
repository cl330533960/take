<#--  chenyi 2019-06-26 14:01:40-->
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
<#include "../resource.ftl"/>
    <script type="text/javascript" src="/srvorder/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">名称:</label>

        <div class="layui-input-inline">
            <input type="text" name="" placeholder="请输入名称" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="srvOrderTable" lay-submit="" lay-filter="search">
                <i class="fa fa-search">&nbsp;</i>查询
            </button>
            <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
        </div>
    </div>
    <div class="layui-form-item more-search">
    <#-- 更多条件-->
    </div>
</form>
<div class="layui-btn-group">
<#--<@shiro.hasPermission name="srvorder:save">-->
        <#--<button class="layui-btn" onclick="addPage('/srvorder/add')">-->
            <#--<i class="fa fa-plus">&nbsp;</i>增加-->
        <#--</button>-->
        <#--</@shiro.hasPermission>-->
        <#--<@shiro.hasPermission name="srvorder:update">-->
        <#--<button class="layui-btn" onclick="editPage('srvOrderTable','/srvorder/edit')">-->
            <#--<i class="fa fa-pencil-square-o">&nbsp;</i>修改-->
        <#--</button>-->
         <#--<button class="layui-btn layui-btn-green" onclick="updateState('批量启用','srvOrderTable','/srvorder/enable')">-->
            <#--<i class="fa fa-check-square-o">&nbsp;</i>启用-->
        <#--</button>-->
        <#--<button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','srvOrderTable','/srvorder/limit')">-->
            <#--<i class="fa fa-expeditedssl">&nbsp;</i>禁用-->
        <#--</button>-->
        <#--</@shiro.hasPermission>-->
        <#--<@shiro.hasPermission name="srvorder:delete">-->
         <#--<button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','srvOrderTable','/srvorder/delete');">-->
            <#--<i class="fa fa-trash-o">&nbsp;</i>删除-->
        <#--</button>-->
        <#--</@shiro.hasPermission>-->

</div>
<div class="layui-form ">
    <table class="layui-table" id="srvOrderTable" cyType="pageGrid"
           cyProps="url:'/srvorder/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="5%" param="{name:'id',isPrimary:'true',hide:'true'}">主键ID</th>


            <th width="5%" param="{name:'wxName'}">用户</th>

            <th width="5%" param="{name:'restaurantName'}">商户</th>

            <th width="5%" param="{name:'orderNo'}">订单号</th>

            <th width="5%" param="{name:'orderTotal'}">总金额</th>

            <th width="5%" param="{name:'status'}">订单状态</th>

            <th width="5%" param="{name:'orderTime'}">订单日期</th>

            <th width="5%" param="{name:'receiveName'}">收件人</th>

            <th width="5%" param="{name:'receivePhone'}">收件人电话</th>

            <th width="5%" param="{operate:'true',buttons:'Render.info'}">操作1</th>

        </tr>
        </thead>
    </table>
</div>
</body>
</html>