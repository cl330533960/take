<#--  chenyi 2019-07-03 22:17:41-->
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
<#include "../resource.ftl"/>
    <script type="text/javascript" src="/srvrestauranapply/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">餐厅名:</label>

        <div class="layui-input-inline">
            <input type="text" name="restaurantName" placeholder="请输入名称" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="srvRestauranapplyTable" lay-submit="" lay-filter="search">
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
<@shiro.hasPermission name="srvrestauranapply:save">
    <button class="layui-btn" onclick="addPage('/srvrestauranapply/add')">
        <i class="fa fa-plus">&nbsp;</i>增加
    </button>
</@shiro.hasPermission>
<@shiro.hasPermission name="srvrestauranapply:update">
<#--<button class="layui-btn" onclick="editPage('srvRestauranapplyTable','/srvrestauranapply/edit')">-->
<#--<i class="fa fa-pencil-square-o">&nbsp;</i>修改-->
<#--</button>-->
    <button class="layui-btn layui-btn-green"
            onclick="updateState('批量通过','srvRestauranapplyTable','/srvrestauranapply/enable')">
        <i class="fa fa-check-square-o">&nbsp;</i>通过
    </button>
    <button class="layui-btn  layui-btn-danger"
            onclick="updateState('批量拒绝','srvRestauranapplyTable','/srvrestauranapply/limit')">
        <i class="fa fa-expeditedssl">&nbsp;</i>拒绝
    </button>
</@shiro.hasPermission>
<@shiro.hasPermission name="srvrestauranapply:delete">
    <button class="layui-btn layui-btn-delete"
            onclick="deleteBatch('批量删除','srvRestauranapplyTable','/srvrestauranapply/delete');">
        <i class="fa fa-trash-o">&nbsp;</i>删除
    </button>
</@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="srvRestauranapplyTable" cyType="pageGrid"
           cyProps="url:'/srvrestauranapply/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}">主键ID</th>
            <th width="10%" param="{name:'restaurantName'}">餐厅名</th>


            <th width="10%" param="{name:'applicant'}">申请人</th>

            <th width="10%" param="{name:'applyPhone'}">联系电话</th>


            <th width="10%" param="{name:'addr'}">地址</th>

            <th width="10%" param="{name:'healthLevel',}">健康等级</th>

            <th width="10%" param="{name:'applyTime'}">申请时间</th>

        <#--<th width="10%" param="{name:'status'}">状态</th>-->
            <th width="10%" param="{name:'status',codeName:'ispassStatus'}">状态</th>
            <!--isPrimary：渲染列-->
        <#--<th width="10%" param="{name:'state',enumName:'StateEnum',render:'Render.customState'}">状态</th>-->
        <#--<th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>-->
        </tr>
        </thead>
    </table>
</div>
</body>
</html>