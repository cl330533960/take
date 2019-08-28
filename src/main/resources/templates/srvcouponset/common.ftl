<#--  公用页面-->
<#--  chenyi 2019-06-27 22:18:33-->

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">金额<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="amount" maxlength="20" lay-verify="number"
                 value="${(model.amount)!""}"  placeholder="请输入金额"  class="layui-input">
            </div>
        </div>

              <#--<div class="layui-form-item">${(model.bucket)!""}-->
            <#--<label class="layui-form-label">有效期<span class="span_must">*</span></label>-->
            <#--<div class="layui-input-normal">-->
                <#--<input type="text"  name="validDay" maxlength="11" lay-verify="number"-->
                 <#--value="${(model.validDay)!""}"  placeholder="请输入有效期"  class="layui-input">-->
            <#--</div>-->
        <#--</div>-->

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">类型<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <div cyType="selectTool" cyProps="codeName:'redboxtype',disabled:'ordertype'" aria-disabled="true" name="type"
                     value="${(model.type)!""}" class="layui-input-inline"></div>
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">是否打开<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <div cyType="radioTool" cyProps="codeName:'openclose',name:'openclose'" name="openClose"
                     value="${(model.openClose)!""}" class="layui-input-inline"></div>
            </div>
        </div>
<script>
    $(document).ready(function() {
        $('select').attr('disabled', 'disabled');
        form.render('select');
    })
</script>