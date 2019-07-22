<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>优惠预订</title>
<#include "../wx.ftl"/>
<style type="text/css">
    .bgback{  margin-left: 10%;
              margin-right: 10%;
              height: 12%;
              display: flex;
              align-items: center;
              background-color: #ffffff; }
     .margintop{
         margin-top: 4%;
     }
    .line{
          margin-left: 5%;
          margin-right: 5%;
          height: 1px;
          background: #0C0C0C;
      }
    .fontsize{
        font-size: 24px;
        margin-left: 10px;
    }
    .input{
        margin-left: auto;
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 1px;
        width: 200px;
        font-size: 24sp;
        height: 30px;
        font-family: "Microsoft soft";
        /*font-weight: 700;*/
        font-family: "Microsoft soft";
        /*background: url("../../static/statics/img/down.png") no-repeat 20px 20px*/
    }
    .selected{
        height: 30px;
        margin-left: auto;
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 1px;
        width: 80px;
        font-size: 24sp;
        /*font-weight: 700;*/
        font-family: "Microsoft soft";
        /*background: url("../../static/statics/img/down.png") no-repeat 20px 20px*/
    }
    .button{
        border-radius:12px;
        margin-left: 15%;
        margin-right: 15%;
        height: 20px;
        display: block;border: 14px solid #06CB06;
        background: #06CB06;margin-top: 15%;text-align: center
    }

 </style>
</head>
<body>

<!-- 容器 -->
<div>
     <div>
         <div style="display: flex;justify-content: center ;background-color:#24aa7d ; align-items:center; ">
             <a style="height:40px;font-size: 24px; color: #ffffff"> 优惠预订</a>
         </div>
         <div class="weui-msg__text-area" style="margin-left: 15%;margin-right: 15%;margin-top: 15px">
             <p class="weui-msg__desc">优惠预订,您可以在此选择优惠。优惠类型以及时间如下,敬请选择</p>
         </div>


         <div class="bgback margintop">
             <label  style="float:left; line-heighe:45px; font-size: 24sp">套餐类型:</label>
             <select class="selected" id="numbers" >
                    <option value="2" style="font-size: 23sp">月套餐</option>
                    <option value="1" style="font-size: 23sp" selected>周套餐</option>
             </select>
         </div>
         <#--<div class="line"></div>-->

         <div class="bgback margintop">
             <label  style="float:left; line-heighe:45px; font-size: 24sp">手机号:</label>
             <input type="text" maxlength="11" type='number'class="input" id="phone" placeholder=""  >   </input>
         </div>
         <#--<div class="line"></div>-->

         <div class="bgback margintop">
             <label style="float:left; line-heighe:45px; font-size: 24sp">备注:</label>
             <input type="text" maxlength="10"  class="input" id="remark" placeholder=""  >   </input>
         </div>

         <div  class="button">
             <a href="javascript:;" onclick="savediscounreserve()"
                style="font-size: 24sp;padding: 2px 6px;
            display: block;color: #ffffff;line-height:20px " >确定</a>
         </div>

     </div>


</div>
<script type="text/javascript">


    function savediscounreserve() {

        var discounType =  $('#numbers option:selected') .val();//选中的值
        var remark =  $("#remark").val();
        var phone= $("#phone").val();


        var url="/wx/discounreserve?wxId=${wxId}&discounType="+discounType+"&remark="+remark;
        $.ajax({
            //请求方式
            type: "POST",
            //请求的媒体类型
            //请求地址
            url: url,
            //数据，json字符串
            //请求成功
            success: function (result) {
                $.toast("保存成功", "cancel");
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                $.toast("获取数据失败", "cancel");
            }
        });
    }


</script>

</body>
</html>