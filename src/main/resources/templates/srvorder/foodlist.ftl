<#--  chenyi 2019-07-03 22:45:47-->
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/srvorder/js/list.js"></script>
</head>
<body>
<div class="layui-form ">
    <table class="layui-table" id="srvOrderFoodTable" cyType="pageGrid"
           cyProps="url:'/srvorderfood/listData?orderId=${model.id}',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>


            <th width="10%" param="{name:'foodId'}">商品</th>

            <th width="10%" param="{name:'number'}"></th>

            <th width="10%" param="{name:'totalPrice'}"></th>
            <!--isPrimary：渲染列-->
        </tr>
        </thead>
    </table>
</div>
</body>
</html>