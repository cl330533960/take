<#--  公用页面-->
<#--  chenyi 2019-07-05 23:30:59-->
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="32" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="foodId" maxlength="32" lay-verify="required"
                 value="${(model.foodId)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="restaurantId" maxlength="32" lay-verify="required"
                 value="${(model.restaurantId)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>