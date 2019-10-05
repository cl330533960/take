<#--  chenyi 2019-06-21 18:55:54-->
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/srvrestaurant/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">名称:</label>
        <div class="layui-input-inline">
            <input type="text" name="name"  placeholder="请输入名称" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="srvRestaurantTable" lay-submit="" lay-filter="search">
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
        <@shiro.hasPermission name="srvrestaurant:save">
        <button class="layui-btn" onclick="addPage('/srvrestaurant/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="srvrestaurant:update">
        <button class="layui-btn" onclick="editPage('srvRestaurantTable','/srvrestaurant/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
         <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','srvRestaurantTable','/srvrestaurant/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','srvRestaurantTable','/srvrestaurant/limit')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="srvrestaurant:delete">
         <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','srvRestaurantTable','/srvrestaurant/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
        </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="srvRestaurantTable" cyType="pageGrid"or
           cyProps="url:'/srvrestaurant/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="5%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>
            <th width="5%" param="{name:'name'}">餐厅名</th>
            <th width="5%" param="{name:'chainCode',codeName:'chaincode'}">连锁店</th>
            <th width="10%" param="{name:'area',}">省市区</th>
            <th width="10%" param="{name:'addr'}">详细地址</th>
            <th width="5%" param="{name:'healthLevel',codeName:'wsLevel'}">卫生等级</th>
            <th width="5%" param="{name:'contact'}">联系人</th>
            <th width="5%" param="{name:'phone'}">联系电话</th>
            <th width="5%" param="{name:'landline'}">座机</th>
            <th width="5%" param="{name:'inTime'}">入驻时间</th>
            <th width="5%" param="{name:'status',codeName:'busstatus'}">是否营业</th>
            <th width="5%" param="{name:'remark'}">备注</th>
            <#--<th width="5%" param="{name:'state',enumName:'StateEnum',render:'Render.customState'}">状态</th>-->
            <th width="15%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete,Render.adddada'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>