<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>健康餐品</title>
    <style>
        .myweui-count__decrease{
        }
    </style>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
</head>
<body>
<div class="weui-cells weui-cells_form">

    <input type="hidden" id="orderType" name="orderType" value="${orderType!}"/>

    <div class="weui-cell">
        <img src="/statics/img/ypyw/icon_address.png" width="30px" alt=""/>
        <div class="weui-cell__bd" style="margin-left: 15px">
            <input type="hidden" id="wxId" value="${wxId!}"/>
            <input type="hidden" id="addrId" value="${model.id!}"/>

            <p id="nameAndPhone"><span >${(model.receiveName)!}&nbsp;&nbsp;</span><span style="font-size: 12px">${(model.receivePhone)!}</span></span></p>
            <p style="font-size: 12px" id="addr">${model.receiveAddr!}</p>
        </div>
    </div>
    <div class="weui-search-bar" id="searchBar">
        <form class="weui-search-bar__form">
            <div class="weui-search-bar__box">
                <i class="weui-icon-search"></i>
                <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="请输入菜品名称" required="">
                <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
            </div>
            <label class="weui-search-bar__label" id="searchText">
                <i class="weui-icon-search"></i>
                <span>搜索</span>
            </label>
        </form>
        <a href="javascript:" class="weui-search-bar__cancel-btn" id="searchCancel">取消</a>
    </div>
    <div class="weui-cells">
    <#list foodList! as food>
        <div   class="weui-cell weui-cell_swiped">
            <div class="weui-cell__bd "  style="transform: translate3d(0px, 0px, 0px);">
                <div class="weui-cell" >
                    <div class="weui-cell__hd  outadded_menu"  foodId="${food.id!}" restaurantId="${food.rid!}">
                        <img src="/getData/showImage?imagePath=${food.imagePath!}" alt="" style="width:50px;height:50px;margin-right:5px;display:block;border-radius: 15px;">
                    </div>
                    <div class="weui-cell__bd" >
                        <div style="display: flex;flex-direction: row">
                            <p>${food.rname!}店</p>
                            <p style="margin-left: 20px">${food.name!}</p>
                        </div>
                        <span class="price" style="font-size: 15px;color: #ff5740">￥${food.sysPrice!}</span>
                    </div>

                    <div class="weui-cell__ft">
                        <div class="weui-count">
                            <a class="weui-count__btn weui-count__decrease"></a>
                            <input id="${food.fudId!}" rid="${food.rid!}" class="weui-count__number" disabled="disabled"
                                   type="number"
                                   value="0">
                            <a class="weui-count__btn weui-count__increase"></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="weui-cell__ft">
                <a class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" href="javascript:">删除</a>
                <a class="weui-swiped-btn weui-swiped-btn_default close-swipeout" href="javascript:">关闭</a>
            </div>
        </div>
    </#list>
    <#if foodList?size<=0>
        <div class="weui-cell">
            <div class="weui-cell__bd">
                暂无推荐餐品
            </div>
        </div>
    </#if>
    </div>
    <div class="weui-cells">
        <a class="weui-cell weui-cell_access" href="javascript:;">
            <div class="weui-cell__bd">
                <p>优惠预定</p>
            </div>
            <div class="weui-cell__ft">
            </div>
        </a>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>包装费 <span id="packFee" style="color: red"> 0</span>元</p>

            <p>配送费 <span id="wayFee" style="color: red"> 0</span>元</p>
        </div>
    </div>
    <div class="weui-cells__title">添加备注</div>
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__bd">
                <textarea id="remark" class="weui-textarea" placeholder="请输入备注" rows="3"></textarea>

                <div class="weui-textarea-counter"><span>0</span>/200</div>
            </div>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>合计(不含运费)￥<span id="totalAmount" style="color: red">0</span></p>
        </div>
        <a href="#" onclick="checkOrder()" style="border-radius: 20px;width:100px;background-color: #ff5740" class="weui-btn weui-btn_primary">支付</a>
    </div>

</div>
</body>
<script>
    var dadaOrder = "";
    var expressNum = "";
    var foodList = new Array();
    var sumbitFoodList = new Array();
    var totalFoodPrice = 0;
    var restaurantFoodPrice = 0;
    var restaurantTotal = 0;
    var orderType = '';
    $(function () {
        orderType = $("#orderType").val();
        <#list foodList! as food>
            var food = '{"id":"${food.id!}","fudId":"${food.fudId!}","name":"${food.name!}","rid":"${food.rid!}","sysPrice":${food.sysPrice!},"packFee":${food.packFee!},"price":${food.price!}}';
            foodList.push($.parseJSON(food));
        </#list>
    })
    var MAX = 99, MIN = 0;
    $('.weui-count__decrease').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var foodId = $input.attr("id");
        var number = parseInt($input.val() || "0") - 1;
        reducePrice(foodId, number);
        calcTotal();
        if (number < MIN) number = MIN;
        $input.val(number)
    })
    $('.weui-count__increase').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var foodId = $input.attr("id");
        var rId = $input.attr("rid");
        var flag = checkOnlyFood(rId);
        if (!flag) {
            return;
        }
        var number = parseInt($input.val() || "0") + 1
        if (number > MAX) number = MAX;
        addPrice(foodId, number);
        calcTotal();
        $input.val(number)

    })



    function checkOnlyFood(id) {
        var flag = true;
        $.each(sumbitFoodList, function (index, item) {
            if (item.rid != id) {
                $.toptip('只能添加同一餐厅的食物', 'error');
                flag = false;
            }
        });
        return flag;
    }

    function addPrice(id, num) {
        if (num > 0) {
            $.each(foodList, function (index, item) {
                if (item.fudId == id) {
                    totalFoodPrice = totalFoodPrice + item.sysPrice;
                    restaurantFoodPrice = restaurantFoodPrice + item.price;
                    sumbitFoodList.push(item);
                }
            });
        }
    }

    function reducePrice(id, num) {
        if (num >= 0) {
            $.each(foodList, function (index, item) {
                if (num == 0) {
                    sumbitFoodList.splice($.inArray(item, sumbitFoodList), 1);
                }
                if (item.fudId == id) {
                    totalFoodPrice = totalFoodPrice - item.sysPrice;
                    restaurantFoodPrice = restaurantFoodPrice - item.price;
                }
            });
        }
    }

    function calcTotal() {
        var packFee = 0;
        if (orderType == "1" || orderType == "3") {
            $.each(sumbitFoodList, function (index, item) {
                packFee = item.packFee;
            });
        }
        $("#packFee").text(packFee);
        $("#totalAmount").text(totalFoodPrice + packFee);
        restaurantTotal = restaurantFoodPrice + packFee;
    }

    function getRestaurantId(){
        var restaurantId = "";
        $.each(sumbitFoodList, function (index, item) {
            restaurantId = item.rid;
        });
        return restaurantId;
    }

    function queryWayFee(){
        dadaOrder = guid();
        var restaurantId = getRestaurantId()
        if(!restaurantId){
            $.toptip('请至少选择一种餐品', 'error');
            return;
        }
        $.showLoading("正在计算运费，请稍后");
        $.ajax({
            //请求方式
            type: "POST",
            //请求的媒体类型
            //请求地址
            url: "/wx/queryWayFee",
            //数据，json字符串
            data: {
                dadaOrder: dadaOrder,
                userAddrId: $("#addrId").val(),
                totalAmount: parseInt($("#totalAmount").text()),
                restaurantId:restaurantId
            },
            //请求成功
            success: function (result) {
                $.hideLoading();
                var totalAmount = parseFloat($("#totalAmount").text()) + result.data.payFee;
                expressNum = result.data.expressNum;
                $("#wayFee").text(result.data.payFee);
                $.confirm({
                    title: '确认提交订单?',
                    text: '订单运费为'+result.data.payFee+'，订单总金额为'+totalAmount+'，确认提交订单吗？',
                    onOK: function () {
                        submitOrder();
                    },
                    onCancel: function () {

                    }
                });
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                $.hideLoading();
                $.toast("获取运费失败", "cancel");
            }
        });
    }

    function checkOrder() {
        if(orderType == 1){
            queryWayFee();
        }else{
            submitOrder();
        }
    }

    function submitOrder(){
        if(sumbitFoodList.length == 0) {
            $.toptip('请至少选择一种餐品', 'error');
            return;
        }
        $.showLoading("正在提交订单，请稍后");
        $.ajax({
            //请求方式
            type: "POST",
            //请求的媒体类型
            //请求地址
            url: "/wx/saveOrder",
            //数据，json字符串
            data: {
                wxId: $("#wxId").val(),
                foodList: JSON.stringify(sumbitFoodList),
                orderType: orderType,
                userAddrId: $("#addrId").val(),
                packFee: parseInt($("#packFee").text()),
                wayFee: parseInt($("#wayFee").text()),
                totalAmount: parseInt($("#totalAmount").text()),
                userPayAmount: parseInt($("#totalAmount").text()),
                restaurantTotal: restaurantTotal,
                dadaOrder: dadaOrder,
                remark: $("#remark").val(),
                expressNum:expressNum
            },
            //请求成功
            success: function (result) {
//                $.toast("操作成功");
                $.hideLoading();
                payInit(result.orderNo);
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                $.hideLoading();
                $.toast("操作失败", "cancel");
            }
        });
    }

    function payInit(orderNo) {
        $.showLoading("正在申请支付，请稍后");
        $.ajax({
            //请求方式
            type: "POST",
            //请求的媒体类型
            //请求地址
            url: "/wx/toPayInit",
            //数据，json字符串
            data: {wxId: $("#wxId").val(), payMoney: 1, orderNo: orderNo},
            //请求成功
            success: function (result) {
                var appId = result.appId;
                var packageStr = result.package;
                var paySign = result.paySign;
                var signType = result.signType;
                var noncestr = result.nonceStr;
                var timestamp = result.timeStamp;
                $.hideLoading();
                onBridgeReady(appId, packageStr, paySign, signType, noncestr, timestamp);
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                $.hideLoading();
                $.toast("操作失败", "cancel");
            }
        });
    }

    function onBridgeReady(appId, packageStr, paySign, signType, noncestr, timestamp) {
        WeixinJSBridge.invoke(
                'getBrandWCPayRequest',
                {
                    "appId": appId,     //公众号名称，由商户传入
                    "timeStamp": timestamp,         //时间戳，自1970年以来的秒数
                    "nonceStr": noncestr, //随机串
                    "package": packageStr,
                    "signType": signType, //微信签名方式：
                    "paySign": paySign //微信签名
                },
                function (res) {
                    // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                    if (res.err_msg == "get_brand_wcpay_request:ok") {//成功
                        $.toast('支付成功', 'success');
                        window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx688906a5f5df8b37&redirect_uri=http://www.tastyfit.vip/wx/orderList&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
                    } else if (res.err_msg == "get_brand_wcpay_request:cancel") {//取消
                        $.toast('用户取消支付','cancel');
                    } else if (res.err_msg == "get_brand_wcpay_request:fail") {//失败
                        $.toast('支付失败','error');
                    } else {
                        alert(res.err_msg);
                    }
                });

    }

    $('.outadded_menu').click(function(){
        gotodetail($(this).attr('foodId'),$(this).attr('restaurantId'),);
    })
    function gotodetail(foodid,restaurantId) {
        window.location.href = "/wx/foodInfo?foodId="+foodid+"&restaurantId="+restaurantId;
    }
</script>
</html>