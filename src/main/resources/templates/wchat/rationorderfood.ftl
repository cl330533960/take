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
    <div class="weui-cell" style="display:flex;flex-direction: row;height: 30px;align-items: center">
        <div style="background-color: #ff5740 ;width: 3px ;height: 12px;margin-left: 15px"></div>
        <div style="margin-left: 20px;font-size: 16px">用餐方式</div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__bd" id="orderTypeRadio">
            <label class="weui-cell weui-check__label" for="x11">
                <div class="weui-cell__bd">
                    <div style="display: flex ;flex-direction: row;align-items:center">
                        <img src="/statics/img/ypyw/icon_waimai.png" width="20px"/>
                        <p style="margin-left: 15px">外卖送餐</p>
                    </div>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" class="weui-check" value="1" name="orderType" id="x11" checked="checked">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x12">

                <div class="weui-cell__bd">
                    <div style="display: flex ;flex-direction: row;align-items:center">
                        <img src="/statics/img/ypyw/icon_store.png" width="20px"/>
                        <p style="margin-left: 15px">店内就餐</p>
                    </div>

                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="orderType" value="2" class="weui-check" id="x12">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x13">
                <div class="weui-cell__bd">
                <div style="display: flex ;flex-direction: row;align-items:center">
                    <img src="/statics/img/ypyw/icon_takeaway.png" width="20px"/>
                    <p style="margin-left: 15px">打包带走</p>
                </div>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="orderType" value="3" class="weui-check" id="x13">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
        </div>
    </div>

    <div class="weui-cell" style="display:flex;flex-direction: row;height: 30px;align-items: center">
        <div style="background-color: #ff5740 ;width: 3px ;height: 12px;margin-left: 15px"></div>
        <div style="margin-left: 20px;font-size: 16px">热量</div>
    </div>

    <div class="weui-cell">
        <div style="margin-left: 15px" class="weui-cell__hd"><label class="weui-label">输入热量(K)<span style="color: red">*</span>:</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" id="cal" type="number" pattern="[0-9]*" placeholder="请输入热量">
        </div>
    </div>
    <div class="weui-cell" style="display:flex;flex-direction: row;height: 30px;align-items: center">
        <div style="background-color: #ff5740 ;width: 3px ;height: 12px;margin-left: 15px"></div>
        <div style="margin-left: 20px;font-size: 16px">选择位置</div>
    </div>
    <div class="weui-cell">

        <#--<div style="margin-left: 15px" class="weui-cell__hd"><label class="weui-label">选择位置<span style="color: red">*</span>:</label></div>-->
        <div class="weui-cell__bd">
        <a class="weui-cell weui-cell_access" id="locationActions" href="javascript:;">

        <#--<a class="weui-cell weui-cell_access open-popup" data-target="#locationList" href="javascript:;">-->
                <div class="weui-cell__bd" id="showHtml">
                    <input type="hidden" id="addrId" value="${(model.id)!""}"/>

                    <p id="nameAndPhone"><span >${(model.receiveName)!"请选择地址"}&nbsp;&nbsp;</span><span style="font-size: 10px">${(model.receivePhone)!""}</span></span></p>

                    <p style="font-size: 10px;margin-top: 5px" id="addr">${(model.receiveAddr)!""}</p>
                </div>
                <div class="weui-cell__ft"></div>
            </a>
        </div>
    </div>

    <a href="#" onclick="toDiancan()" style="margin-right: 15px;margin-left: 15px;border-radius: 30px;margin-bottom: 50px;margin-top: 20px" class="weui-btn weui-btn_primary">下一步</a>
</div>



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

                <div class="weui-cell">

                    <div class="weui-cell__hd"><label class="weui-label">详细地址</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" name="receiveAddr" id="receiveAddr" placeholder="请输入详细地址">
                    </div>
                </div>
                <a href="javascript:;" onclick="saveAddr()" id="locSubmit" class="weui-btn weui-btn_primary" style="margin-top: 10px;margin-right: 15px;border-radius: 30px;margin-left: 15px;margin-bottom: 50px;">保存</a>
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
        if(!cal){
            $.toptip('热量为必须项', 'error');
            return;
        }
        if(!orderType){
            $.toptip('用餐方式为必须项', 'error');
            return;
        }
        if(!userAddrId){
            $.toptip('位置为必须项', 'error');
            return;
        }
        window.location.href = "/wx/healthyFood?wxId=${wxId!}&orderType=" + orderType + "&userAddrId=" + userAddrId + "&cal=" + cal;
    }

    function saveAddr() {
        var receiveName = $("#receiveName").val()
        var receiveAddr = $("#receiveAddr").val()
        var receivePhone = $("#receivePhone").val()
        if(!receiveName){
            $.toptip('联系人为必须项', 'error');
            return;
        }
        if(!receivePhone){
            $.toptip('联系电话必须项', 'error');
            return;
        }
        if(!receiveAddr){
            $.toptip('详细地址必须项', 'error');
            return;
        }
        $.showLoading("正在提交数据，请稍后");
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
                $.hideLoading();
                $.toast("新增地址成功");
                var html = template("addLocationHtml", {data: result.data});
                $("#locationListPup").append(html);
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                $.hideLoading();
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