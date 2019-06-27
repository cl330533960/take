<#--  公用页面-->
<#--  chenyi 2019-06-27 13:47:41-->
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">主键ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="32" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入主键ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">金额<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="amount" maxlength="20" lay-verify="required"
                 value="${(model.amount)!""}"  placeholder="请输入金额"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">开始时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="startTime" maxlength="20" lay-verify="required"
                 value="${(model.startTime)!""}"  placeholder="请输入开始时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">结束时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="endTime" maxlength="20" lay-verify="required"
                 value="${(model.endTime)!""}"  placeholder="请输入结束时间"  class="layui-input">
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
            <label class="layui-form-label">是否使用<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="isUse" maxlength="1" lay-verify="required"
                 value="${(model.isUse)!""}"  placeholder="请输入是否使用"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>