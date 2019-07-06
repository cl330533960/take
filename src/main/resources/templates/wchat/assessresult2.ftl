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
        }
        .margintop{
            margin-top: 5%;
        }
        .inputbg{
            background: url("../../static/statics/img/down.png") no-repeat 20px 20px
        }
        .line{
            margin-left: 5%;
            margin-right: 5%;
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
            font-size: 34px;
            font-family: "Microsoft soft";
            /*background: url("../../static/statics/img/down.png") no-repeat 20px 20px*/
        }
        .gobutton{margin-bottom: 30px;
            border-radius:12px;
            margin-left: 5%;
            margin-right: 5%;
            height: 90px;
            display: block;border: 14px solid #ff563e;
            background: #ff563e;margin-top: 10%;text-align: center
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


    <div style="display: flex;flex-direction: column;justify-content: center;
                align-items: center;">
        <p style=" font-size: 28px">您的体质指数(BMI)</p>
    </div>

    <div class="bgback margintop">
        <label style="float:left; line-heighe:45px; font-size: 34px">体脂(腹部)</label>
        <p class="input">中心肥胖前期</p>
    </div>
    <div class="line"></div>


    <div class="bgback margintop">
        <label style="float:left; line-heighe:45px; font-size: 34px">每日摄入量建议</label>
        <p class="input">1300-1500kj</p>
    </div>
    <div class="line"></div>

    <div style=" display: flex; align-items: center;margin-top: 10%;margin-left: 5%">
        <div style="height: 40px;width: 10px;background-color: #ff563e;"></div>
        <p style="margin-left: 20px;font-size: 28px">饮食建议</p>
    </div>

    <div>
        <p style="margin-left: 5%;margin-top: 4px;color:#ff563e;font-size: 34px">CRD 方案</p>
    </div>

    <div>
        <p style="margin-left: 5%;margin-top:4px; font-size: 24px">早餐 450kj</p>
    </div>

    <div>
        <p style="margin-left: 5%;margin-top:4px; font-size: 28px">午餐 600kj</p>
    </div>
    <div>
        <p style="margin-left: 5%;margin-top:4px; font-size: 28px">晚餐 450kj</p>
    </div>

    <div>
        <p style="margin-left: 5%;margin-top:4px; font-size: 28px">蛋白质脂肪糖水化合物比 2:3:5</p>
    </div>


    <div>
        <p style="margin-left: 5%;margin-top:10%;color: #ff563e; font-size: 28px">有品有味联合多家线下优质餐厅,由营养师搭配,全新推出上述符合的多种方案 既可食堂又可以外卖欢迎点餐</p>
    </div>

    <div  class="gobutton">
        <a href="javascript:;" onclick="gohome()"
           style="font-size: 34px;padding: 2px 6px;
            display: block;color: #ffffff;line-height:90px " >去点餐 </a>
    </div>










</div>


</body>
</html>