<#--  chenyi 2019-06-25 17:47:38-->
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/srvfood/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">名称:</label>
        <div class="layui-input-inline">
            <input type="text" name=""  placeholder="请输入名称" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="srvFoodTable" lay-submit="" lay-filter="search">
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
        <@shiro.hasPermission name="srvfood:save">
        <button class="layui-btn" onclick="addPage('/srvfood/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="srvfood:update">
        <button class="layui-btn" onclick="editPage('srvFoodTable','/srvfood/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
         <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','srvFoodTable','/srvfood/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','srvFoodTable','/srvfood/limit')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="srvfood:delete">
         <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','srvFoodTable','/srvfood/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
        </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="srvFoodTable" cyType="pageGrid"
           cyProps="url:'/srvfood/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            			            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>
            
		                			
		          <th width="10%" param="{name:'name'}">餐厅</th>
			            			

		          <th width="10%" param="{name:'cal'}">热量Kcal</th>
			            			

		          <th width="10%" param="{name:'useScope',codeName:'usescope',isMultiple:'true'}"}">适用于</th>
			            			

		          <th width="10%" param="{name:'chianId',codeName:'chaincode'}">连锁店</th>
			            			
		          <th width="10%" param="{name:'restaurantId',tableName:'srv_restaurant'}">餐厅</th>

                <th width="10%" param="{name:'updateTime'}">最后修改时间</th>

                 <th width="10%" param="{name:'status',enumName:'StateEnum'}">状态</th>
			            			
			                        <!--isPrimary：渲染列-->
                <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>