<#--  公用页面-->
<#--  chenyi 2019-07-01 21:09:34-->

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">BMI计算公式<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="bmi" maxlength="100" lay-verify="required"
                 value="${(model.bmi)!""}"  placeholder="请输入BMI计算公式"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">偏瘦<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="thin" maxlength="100" lay-verify="required"
                 value="${(model.thin)!""}"  placeholder="请输入偏瘦"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">正常<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="normal" maxlength="100" lay-verify="required"
                 value="${(model.normal)!""}"  placeholder="请输入正常"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">偏胖<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="overWeight" maxlength="100" lay-verify="required"
                 value="${(model.overWeight)!""}"  placeholder="请输入偏胖"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">肥胖<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="obesity" maxlength="100" lay-verify="required"
                 value="${(model.obesity)!""}"  placeholder="请输入肥胖"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">正常体重上限<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="normalWeightUp" maxlength="100" lay-verify="required"
                 value="${(model.normalWeightUp)!""}"  placeholder="请输入正常体重上限"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">正常体重下限<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="normalWeightDown" maxlength="100" lay-verify="required"
                 value="${(model.normalWeightDown)!""}"  placeholder="请输入正常体重下限"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">男性BEE<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="manBee" maxlength="100" lay-verify="required"
                 value="${(model.manBee)!""}"  placeholder="请输入男性BEE"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">女性BEE<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="woman" maxlength="100" lay-verify="required"
                 value="${(model.woman)!""}"  placeholder="请输入女性BEE"  class="layui-input">
            </div>
        </div>

        <#--<div class="layui-form-item">${(model.bucket)!""}-->
            <#--<label class="layui-form-label">运动系数设置<span class="span_must">*</span></label>-->

                <#--<div name="sportRatio" cyType="selectTool" cyProps="enumName:'SportRatioEnum'"-->
                     <#--value="${(model.sportRatio)!""}"  class="layui-input-inline">-->
                <#--</div>-->


              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">超重者每日摄取热量Down<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="overWeightHeatDown" maxlength="100" lay-verify="required"
                 value="${(model.overWeightHeatDown)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">超重者每日摄取热量Up<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="overWeightHeatUp" maxlength="100" lay-verify="required"
                 value="${(model.overWeightHeatUp)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">肥胖者每日摄取热量Down<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="obesityHeatDown" maxlength="100" lay-verify="required"
                 value="${(model.obesityHeatDown)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">肥胖者每日摄取热量Up<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="obesityHeatUp" maxlength="100" lay-verify="required"
                 value="${(model.obesityHeatUp)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>