/**跳转到添加页面*/
function add(url) {
    //$("body").load(url);
    //type：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
    parent.layer.open({
        type: 2,
        title: '添加',
        shadeClose: false,
        shade: [0.3, '#000'],
        maxmin: true, //开启最大化最小化按钮
        area: ['893px', '600px'],
        content: url
    });
}
//显示一个对话框
var type =1;

function setdata(num) {
    type=num;
    // alert(type);
}

function start(url) {

    window.location.href=url+'?type='+type;

    // confirm("确认初始化？", function () {
    //         $.ajax({
    //             type: "get",
    //             url: url+'?type='+type,
    //             contentType: "application/json",
    //             async: false,
    //             success: function (R) {
    //                 Msg.success('操作成功'+R);
    //             },
    //             error: function (e) {
    //                 Msg.error("系统繁忙"+e);
    //             }
    //         });
    //     });

}
function getassessresult() {

    window.location.href='/wx/gotoassessresult?type='+type;



}