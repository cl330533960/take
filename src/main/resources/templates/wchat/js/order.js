
function initPay(powerStationId,userId){

        if(typeof WeixinJSBridge == "undefined"){
            if( document.addEventListener ){
                document.addEventListener('WeixinJSBridgeReady', initPay, false);
            }else if (document.attachEvent){
                document.attachEvent('WeixinJSBridgeReady', initPay);
                document.attachEvent('onWeixinJSBridgeReady', initPay);
            }
        }else{
            toPay(powerStationId,userId);
        }

}

function toPay(powerStationId,userId){
    alert("toPay");
    $.ajax({
        url : "/wx/toPayInit", //TODO 预下单 就是这里一直签名报错 我估计是openID有问题
        type:"POST",
        dataType : 'json', // 服务器返回的格式,可以是json或xml等
        data:{
            payMoney:1,
            userWeixinOpenId:'ea0891f465c94367b7607ad1834e715b' //TODO 这里的openID需要动态去取真实的 
        },
        success : function(result) { // 服务器响应成功时的处理函数
            if(result.result==1){  //TODO 插入支付记录 是我们自己的业务代码
                var paySign = result.paySign;
                var prepay_id = result.prepay_id;
                var nonceStr = result.noncestr;
                var timestamp = result.timestamp;
                var unifiedOrderRequest = result.unifiedOrderRequest;
                var spbill_create_ip = unifiedOrderRequest.spbill_create_ip;
                var detail = unifiedOrderRequest.detail;
                var out_trade_no = unifiedOrderRequest.out_trade_no;
                $.ajax({
                    url : "/wx/toSavePayInfo",
                    type:"POST",
                    dataType : 'json', // 服务器返回的格式,可以是json或xml等
                    data:{
                        spbill_create_ip:spbill_create_ip,
                        detail:detail,
                        out_trade_no:out_trade_no,
                        total_fee:1,
                        powerStationId:powerStationId,
                        userId:userId,
                        order_type:1
                    },
                    success : function(result) { // 服务器响应成功时的处理函数
                        if(result>0){//插入支付记录
                            onBridgeReady(paySign,prepay_id,nonceStr,timestamp);
                        }
                    },
                    error : function(data, status, e) { // 服务器响应失败时的处理函数
                        $.toptip("系统出错，请联系系统运营商", 'error');
                    }
                });
            }else{
                $.toptip("初始化支付接口失败，请联系系统运营商", 'error');
            }
        },
        error : function(data, status, e) { // 服务器响应失败时的处理函数
            $.toptip("初始化支付接口失败，请联系系统运营商", 'error');
        }
    });
}

function onBridgeReady(paySign,prepay_id,nonceStr,timestamp){
    var weixinOperId = $("#weixinOperId").val();
    WeixinJSBridge.invoke(
        'getBrandWCPayRequest', {
            "appId":weixinOperId,     //公众号名称，由商户传入
            "timeStamp":timestamp,         //时间戳，自1970年以来的秒数
            "nonceStr":nonceStr, //随机串
            "package":"prepay_id="+prepay_id,
            "signType":"MD5",         //微信签名方式：
            "paySign":paySign //微信签名 （这个签名获取看后台）
        },
        function(res){
            // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
            if(res.err_msg == "get_brand_wcpay_request:ok" ) {
                alert("支付成功", 'success');
            }else if(res.err_msg == "get_brand_wcpay_request:cancel" ) {
                alert("用户取消", 'success');
            }
        }
    );
}
