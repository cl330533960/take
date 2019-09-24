/**
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-26 14:01:40
 */

//设置日期
layui.use('laydate', function(){
    var laydate = layui.laydate;

    var start = {
        max: '2099-06-16 23:59:59'
        ,istoday: false
        ,choose: function(datas){
            // end.min = datas; //开始日选好后，重置结束日的最小日期
            // end.start = datas //将结束日的初始值设定为开始日
        }
    };

    var end = {
        max: '2099-06-16 23:59:59'
        ,istoday: false
        ,choose: function(datas){
            // start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };

    document.getElementById('LAY_demorange_s').onclick = function(){
        start.elem = this;
        laydate(start);
    };
    document.getElementById('LAY_demorange_e').onclick = function(){
        end.elem = this
        laydate(end);
    };

});
/**数据渲染对象*/

var Render = {
    /**
     * 渲染状态列
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @param index
     * @param value      当前对象值
     */
    customState: function (rowdata,renderData, index, value) {
        if(value == "启用"){
            return '<span style="color:green">'+value+'</span>';
        }
        if(value == "禁用"){
            return '<span style="color:red">'+value+'</span>';
        }
        return value;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      详情按钮渲染
     */
    info:function(rowdata,renderData){
        var btn=' <button  onclick="detailOne(\''+"/srvorder/info"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini">详情</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      修改按钮渲染
     */
    edit:function(rowdata,renderData){
        var btn=' <button  onclick="editOne(\''+"/srvorder/edit"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini">修改</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      删除按钮渲染
     */
    delete:function(rowdata,renderData){
        var btn=' <button  onclick="deleteOne(\''+"删除"+'\',\''+"/srvorder/delete"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini layui-btn-delete">删除</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      退款按钮渲染
     */
    refund:function(rowdata,renderData){
        var btn=' <button  onclick="refund(\''+"退款"+'\',\''+"/srvorder/refund"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini layui-btn-delete">退款</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      启用禁用按钮渲染
     */
    state:function(rowdata,renderData){
        if(rowdata.state=='0'){
            return' <button onclick="updateStateOne(\''+"启用"+'\',\''+"/srvorder/enable"+'\',\''+rowdata.id+'\')"' +
                '  class="layui-btn layui-btn-mini layui-btn-green">启用</button>';
        }
        if(rowdata.state=='1'){
            return' <button  onclick="updateStateOne(\''+"禁用"+'\',\''+"/srvorder/limit"+'\',\''+rowdata.id+'\')" ' +
                'class="layui-btn layui-btn-mini layui-btn-danger">禁用</button>';
        }
        return "";
    }
};
