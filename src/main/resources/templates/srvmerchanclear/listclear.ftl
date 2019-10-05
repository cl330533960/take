<#--  chenyi 2019-06-26 18:38:42-->
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
<#include "../resource.ftl"/>
    <script type="text/javascript" src="/srvmerchanclear/js/list.js"></script>
</head>
<body>
<#--<form class="layui-form " action="">-->
    <#--<div class="layui-form-item">-->
        <#--<label class="layui-form-label">名称:</label>-->

        <#--<div class="layui-input-inline">-->
            <#--<input type="text" name="" placeholder="请输入名称" class="layui-input">-->
        <#--</div>-->

        <#--<div class="layui-input-normal">-->
            <#--<button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">-->
                <#--<i class="fa fa-chevron-down">&nbsp;</i>更多-->
            <#--</button>-->
            <#--<button class="layui-btn search-btn" table-id="srvMerchanclearTable" lay-submit="" lay-filter="search">-->
                <#--<i class="fa fa-search">&nbsp;</i>查询-->
            <#--</button>-->
            <#--<button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>-->
        <#--</div>-->
    <#--</div>-->
    <#--<div class="layui-form-item more-search">-->
    <#--&lt;#&ndash; 更多条件&ndash;&gt;-->
    <#--</div>-->
<#--</form>-->
<div class="layui-btn-group">

</div>
<div class="layui-form ">
    <table class="layui-table" id="srvMerchanclearTable" cyType="pageGrid"
           cyProps="url:'/srvmerchanclear/listData?restaurantId=${id}',checkbox:'false',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <#--<th width="1%" param="{type:'checkbox'}">-->
                <#--<input type="checkbox" lay-skin="primary" lay-filter="allChoose">-->
            <#--</th>-->
            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}">主键ID</th>


            <th width="10%" param="{name:'wxName'}">用户</th>

            <th width="10%" param="{name:'receivePhone'}">手机号</th>

            <th width="10%" param="{name:'orderNo'}">订单号</th>
            <th width="10%" param="{name:'restaurantTotal'}">订单金额</th>

            <th width="10%" param="{name:'orderTime'}">下单时间</th>
            <th width="10%" param="{name:'expressName'}">配送员</th>
            <th width="10%" param="{name:'expressPhone'}">配送电话</th>
            <!--isPrimary：渲染列-->
        </tr>
        </thead>
    </table>
</div>
</body>
</html>