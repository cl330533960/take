<#--  公用页面-->
<#--  chenyi 2019-06-25 17:24:03-->
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">主键ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="32" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">折扣开始时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="discountStart" maxlength="20" lay-verify="required"
                ${(model.discountStart?string("yyyy-MM-dd"))!""}    placeholder="请输入折扣开始时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">折扣结束时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="discountEnd" maxlength="20" lay-verify="required"
                 value= ${(model.discountEnd?string("yyyy-MM-dd"))!""}   placeholder="请输入折扣结束时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">状态<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="status" maxlength="1" lay-verify="required"
                 value="${(model.status)!""}"  placeholder="请输入状态"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">用户ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="userId" maxlength="32" lay-verify="required"
                 value="${(model.userId)!""}"  placeholder="请输入用户ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">折扣比<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="discount" maxlength="20" lay-verify="required"
                 value="${(model.discount)!""}"  placeholder="请输入折扣比"  class="layui-input">
            </div>
        </div>

              <#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">状态</label>-->
            <#--<div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"-->
                 <#--value="${(model.state)!"1"}" class="layui-input-inline"></div>-->
        <#--</div>-->