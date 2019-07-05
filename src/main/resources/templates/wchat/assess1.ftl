<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>HB热量评估</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/wchat/js/index.js"></script>
    <style type="text/css">
        .bgback{
            margin-left: 10%;
            margin-right: 10%;
            height: 12%;
            display: flex;
            align-items: center;
            background-color: #f0f0f0;
        }
        .margintop{
            margin-top: 10%;
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
            /*background: url("../../static/statics/img/down.png") no-repeat 20px 20px*/
        }
        .button{
            border-radius:12px;
            margin-left: 5%;
            margin-right: 5%;
            height: 90px;
            display: block;border: 14px solid #06CB06;
            background: #06CB06;margin-top: 15%;text-align: center
        }

    </style>

</head>
<body>


     <div >
         <div style="background: #f0f0f0" class="margintop"></div>
         <div class="bgback">
             <label style="float:left; line-heighe:45px; font-size: 44px">身高</label>
             <label style="float:left; line-heighe:45px; font-size: 34px;color: #ab1e1e">*</label>
             <input type="text" maxlength="3"  type='number'class="input" placeholder=""  >  <span class="fontsize">厘米</span></input>
         </div>
         <div class="line"></div>

         <div class="bgback margintop">
             <label style="float:left; line-heighe:45px; font-size: 44px">体重</label>
             <label style="float:left; line-heighe:45px; font-size: 34px;color: #ab1e1e">*</label>
             <input type="text" maxlength="3" type='number'class="input" placeholder=""  >  <span class="fontsize">千克</span></input>
         </div>
         <div class="line"></div>

         <div class="bgback margintop">
             <label style="float:left; line-heighe:45px; font-size: 44px">腰围</label>
             <input type="text" maxlength="3"class="input" placeholder=""  >  <span class="fontsize">厘米</span></input>
         </div>
         <div class="line"></div>

         <div class="bgback margintop">
             <label style="float:left; line-heighe:45px; font-size: 44px">年龄</label>
             <label style="float:left; line-heighe:45px; font-size: 34px;color: #ab1e1e">*</label>
             <input type="text" maxlength="3" type='number'class="input" placeholder=""  >  <span class="fontsize">&nbsp&nbsp&nbsp&nbsp&nbsp岁</span></input>
         </div>
         <div class="line"></div>

         <div class="bgback margintop">
             <label style="float:left; line-heighe:45px; font-size: 44px">性别</label>
             <label style="float:left; line-heighe:45px; font-size: 34px;color: #ab1e1e">*</label>
             <input type="text"maxlength="3" type='number' class="input" placeholder=""  >  <span class="fontsize">厘米</span></input>
         </div>
         <div class="line"></div>
         <div style="background: #f0f0f0" class="margintop"></div>
         <div class="bgback margintop">
             <label style="float:left; line-heighe:45px; font-size: 44px">运动强度</label>
             <label style="float:left; line-heighe:45px; font-size: 24px;color: #ab1e1e">*</label>
             <select class="selected" id="numbers" >
                    <option value="1"style="font-size: 33px">不运动</option>
                    <option value="2" style="font-size: 33px" selected>偶尔运动</option>
                     <option value="3" style="font-size: 33px"selected>经常运动</option>
             </select>
         </div>


         <div  class="button">
             <a href="javascript:;" onclick="getassessresult()"
                style="font-size: 34px;padding: 2px 6px;
            display: block;color: #ffffff;line-height:90px " >开始评估</a>
         </div>

     </div>


</body>
</html>