<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>评估结果</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
    <style type="text/css">
        .bgback{
            margin-left: 10%;
            margin-right: 10%;
            height: 12%;
            display: flex;
            align-items: center;
            background-color: #f0f0f0
        }
        .margintop{
            margin-top: 10%;
        }
        .inputbg{
            background: url("../../static/statics/img/down.png") no-repeat 20px 20px
        }
        .line{
            height: 1px;
            background: #0C0C0C;
        }
        .fontsize{
            font-size: 34px;
            margin-left: 10px;
        }
        .input{
            margin-left: auto;
            outline-style: none ;
            border: 1px solid #ccc;
            border-radius: 1px;
            width: 100px;
            font-size: 34px;
            font-weight: 700;
            font-family: "Microsoft soft";
            /*background: url("../../static/statics/img/down.png") no-repeat 20px 20px*/
        }
        .selected{
            margin-left: auto;
            outline-style: none ;
            border: 1px solid #ccc;
            border-radius: 1px;
            width: 200px;
            font-size: 34px;
            font-weight: 700;
            font-family: "Microsoft soft";
        }
        .button{
            border-bottom-left-radius: 12px;
            border-top-left-radius:12px ;
            margin-left: 10%;
            height: 50px;
            display: block;border: 14px solid #34bEEF;
            background: #34bEEF;
            text-align: center;
            width: 20%;
        }
        .button1{
            height: 50px;
            display: block;border: 14px solid #26ca98;
            background: #26ca98;
            text-align: center;
            width: 20%;
        }
        .button2{
            height: 50px;
            display: block;border: 14px solid #FEA918;
            background: #FEA918;
            text-align: center;
            width: 20%;
        }
        .button3{
            border-bottom-right-radius: 12px;
            border-top-right-radius:12px ;
            margin-right: 10%;
            height: 50px;
            display: block;border: 14px solid #34bEEF;
            background: #34bEEF;
            text-align: center;
            width: 20%;
        }
    </style>

</head>
<body>


<div >
   <div style=" display: flex; align-items: center;margin-top: 10%;margin-left: 5%">
       <div style="height: 40px;width: 10px;background-color: #276CCC;"></div>
       <p style="margin-left: 20px;font-size: 28px">评估结果</p>
   </div>

    <div style=" display: flex; align-items: center;margin-top: 30px;justify-content: center">
        <div  class="button">
            <a href="javascript:;"
               style="font-size: 34px;
            display: block;color: #ffffff;line-height:50px " >偏瘦</a>
        </div>
        <div  class="button1">
            <a href="javascript:;"
               style="font-size: 34px;
            display: block;color: #ffffff;line-height:50px " >正常</a>
        </div>
        <div  class="button2">
            <a href="javascript:;"
               style="font-size: 34px;
            display: block;color: #ffffff;line-height:50px " >超重</a>
        </div>
        <div  class="button3">
            <a href="javascript:;"
               style="font-size: 34px;
            display: block;color: #ffffff;line-height:50px " >肥胖</a>
        </div>
    </div>


    <div style="display: flex;flex-direction: column;margin-top:30px;justify-content: center;
              align-items: center;background:url('../../static/statics/img/ypyw/img_fat.png');>
            <p style="margin-left: 20px;font-size: 58px">14.6</p>
           <p style="margin-left: 20px;font-size: 28px">偏瘦</p>
            <img src="/statics/img/ypyw/img_fat.png" alt=""/>

     </div>







</div>


</body>
</html>