<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>定量点餐</title>
<#include "../wx.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
    <script type="text/javascript" src="/wchat/js/template.js"></script>
</head>
<body>
<div class="weui-cells weui-cells_radio">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">热量（K）:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="cal" type="number" pattern="[0-9]*" placeholder="请输入热量">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">用餐方式:</label></div>
        <div class="weui-cell__bd" id="orderTypeRadio">
            <label class="weui-cell weui-check__label" for="x11">
                <div class="weui-cell__bd">
                    <p>外卖送餐</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" class="weui-check" value="1" name="orderType" id="x11" checked="checked">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x12">

                <div class="weui-cell__bd">
                    <p>店内就餐</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="orderType" value="2" class="weui-check" id="x12">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x13">
                <div class="weui-cell__bd">
                    <p>打包带走</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="orderType" value="3" class="weui-check" id="x13">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">位置:</label></div>
        <div class="weui-cell__bd">
        <a class="weui-cell weui-cell_access" id="locationActions" href="javascript:;">

        <#--<a class="weui-cell weui-cell_access open-popup" data-target="#locationList" href="javascript:;">-->
                <div class="weui-cell__bd" id="showHtml">
                    <input type="hidden" id="addrId" value="${(model.id)!""}"/>

                    <p id="nameAndPhone">${(model.receiveName)!""}&nbsp;&nbsp;${(model.receivePhone)!""}</p>


                    <p id="addr">${(model.receiveAddr)!""}</p>
                </div>
                <div class="weui-cell__ft"></div>
            </a>
        </div>
    </div>
</div>

<a href="#" onclick="toDiancan()" class="weui-btn weui-btn_primary">下一步</a>

<div id="locationList" class="weui-popup__container" style="display: none;">
    <div class="weui-popup__overlay"></div>
    <div class="weui-popup__modal">
        <div class="toolbar">
            <div class="toolbar-inner">
                <a href="javascript:;" class="picker-button close-popup">确定</a>

                <h1 class="title">选择地址</h1>
            </div>
        </div>
        <div class="modal-content">
            <div class="weui-cells">
                <div class="weui-cells weui-cells_radio" id="locationListPup">
                <#list locs! as emp>
                    <label class="weui-cell weui-check__label">
                        <div class="weui-cell__bd" id="${emp.id!}">
                            <input type="hidden" id="addrId" value="${emp.id!}"/>

                            <p id="nameAndPhone">${emp.receiveName!}&nbsp;&nbsp;${emp.receivePhone!}</p>

                            <p id="addr">${emp.receiveAddr!}</p>
                        </div>
                        <div class="weui-cell__ft">
                            <input type="radio" class="weui-check" <#if emp.id == model.id>checked="checked"</#if>
                                   value="${emp.id!}" name="addrs">
                            <span class="weui-icon-checked"></span>
                        </div>
                    </label>
                </#list>
                </div>
            </div>
        </div>

    </div>
</div>

<div id="addLocation" class="weui-popup__container" style="display: none;">
    <div class="weui-popup__overlay"></div>
    <div class="weui-popup__modal">
        <div class="toolbar">
            <div class="toolbar-inner">
                <a href="javascript:;" class="picker-button close-popup">关闭</a>

                <h1 class="title">新增收货地址</h1>
            </div>
        </div>
        <div class="modal-content">
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">联系人</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" name="receiveName" id="receiveName" placeholder="请输入联系人">
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label class="weui-label">联系电话</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" name="receivePhone" id="receivePhone" type="tel"
                               placeholder="请输入联系电话">
                    </div>
                </div>
            <#--<div class="weui-cell">-->
            <#--<div class="weui-cell__hd"><label class="weui-label">小区/大厦/学校</label></div>-->
            <#--<div class="weui-cell__bd">-->
            <#--<a class="weui-cell weui-cell_access" href="javascript:;">-->
            <#--<div class="weui-cell__bd">-->
            <#--<input class="weui-input" placeholder="请选择小区/大厦/学校">-->
            <#--</div>-->
            <#--<div class="weui-cell__ft">编辑</div>-->
            <#--</a>-->
            <#--</div>-->
            <#--</div>-->


                <div class="weui-cell">

                    <div class="weui-cell__hd"><label class="weui-label">详细地址</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" name="receiveAddr" id="receiveAddr" placeholder="请输入详细地址">
                    </div>
                </div>
                <a href="javascript:;" onclick="saveAddr()" id="locSubmit" class="weui-btn weui-btn_primary" style="margin-top: 10px;">保存</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">


    $(function () {
        $('#locationActions').click(function () {
            $.actions({
                actions: [{
                    text: "选择地址",
                    onClick: function () {
                        $("#locationList").popup();
                    }
                }, {
                    text: "新增地址",
                    onClick: function () {
                        $("#addLocation").popup();
                    }
                }]
            });
        })
    });
    $(document).on('click','input:radio[name="addrs"]',function(){
        var checkValue = $('input:radio[name="addrs"]:checked').val();
        $("#showHtml").html($("#" + checkValue).html());
    })

    function toDiancan() {
        var orderType = $("input[name='orderType']:checked").val();
        var userAddrId = $("#addrId").val();
        var cal = $("#cal").val();
        window.location.href = "/wx/healthyFood?wxId=${wxId!}&orderType=" + orderType + "&userAddrId=" + userAddrId + "&cal=" + cal;
    }

    function saveAddr() {
        $.ajax({
            //请求方式
            type: "POST",
            url: "/wx/modifyLocation",
            //数据，json字符串
            data: {
                wxId: "${wxId!}",
                receiveName: $("#receiveName").val(),
                receiveAddr: $("#receiveAddr").val(),
                receivePhone: $("#receivePhone").val()
            },
            //请求成功
            success: function (result) {
                $.toast("新增地址成功");
                var html = template("addLocationHtml", {data: result.data});
                $("#locationListPup").append(html);
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                $.toast("操作失败", "cancel");
            }
        });
    }
</script>

<script type="text/html" id="addLocationHtml">
    <label class="weui-cell weui-check__label">
        <div class="weui-cell__bd" id="{{data.id}}">
            <input type="hidden" id="addrId" value="{{data.id}}"/>

            <p id="nameAndPhone">{{data.receiveName}}&nbsp;&nbsp;{{data.receivePhone}}</p>

            <p id="addr">{{data.receiveAddr}}</p>
        </div>
        <div class="weui-cell__ft">
            <input type="radio" class="weui-check" value="{{data.id}}" name="addrs">
            <span class="weui-icon-checked"></span>
        </div>
    </label>
</script>

</body>
</html>