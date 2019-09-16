<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>分享得优惠券</title>
<#include "../wx.ftl"/>
</head>
<body>



    <script type="text/javascript">
        var orderNo = '${orderNo}';
        var userId = '${userId}';
        $.ajax({
            url: "/wx/share",
            type: 'post',
            data: {orderNo: orderNo, userId: userId},
            success: function (result) {
                goGz();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                goGz();
            }
        });


        function goGz() {
            window.location.href = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzU0OTk2NjI0Ng==&scene=126&bizpsid=0&sharer_username=gh_9469ac874773&clicktime=1568608532#wechat_redirect";
        }

    </script>

</body>
</html>