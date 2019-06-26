<#--  公用页面-->
<#--  chenyi 2019-06-26 18:38:42-->
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">主键ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="32" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入主键ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">商家ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="restaurantId" maxlength="32" lay-verify="required"
                 value="${(model.restaurantId)!""}"  placeholder="请输入商家ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">余额<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="clearAmount" maxlength="20" lay-verify="required"
                 value="${(model.clearAmount)!""}"  placeholder="请输入余额"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">上次结余<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="clearTime" maxlength="20" lay-verify="required"
                 value="${(model.clearTime)!""}"  placeholder="请输入上次结余"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">操作人<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="optrName" maxlength="20" lay-verify="required"
                 value="${(model.optrName)!""}"  placeholder="请输入操作人"  class="layui-input">
            </div>
        </div>

              <#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">状态</label>-->
            <#--<div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"-->
                 <#--value="${(model.state)!"1"}" class="layui-input-inline"></div>-->
        <#--</div>-->