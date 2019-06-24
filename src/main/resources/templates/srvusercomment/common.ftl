<#--  公用页面-->
<#--  chenyi 2019-06-24 17:30:19-->
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">主键ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="32" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">用户ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="userId" maxlength="32" lay-verify="required"
                 value="${(model.userId)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">评价内容<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="content" maxlength="200" lay-verify="required"
                 value="${(model.content)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">提交时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="commentTime" maxlength="20" lay-verify="required"
                       value="${(model.commentTime?string("yyyy-MM-dd"))!""}"
                       placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">商家ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="restaurantId" maxlength="32" lay-verify="required"
                 value="${(model.restaurantId)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">审核状态<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="status" maxlength="1" lay-verify="required"
                 value="${(model.status)!""}"  placeholder="请输入0待审核 审核通过 审核拒绝"  class="layui-input">
            </div>
        </div>

              <#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">状态</label>-->
            <#--<div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"-->
                 <#--value="${(model.state)!"1"}" class="layui-input-inline"></div>-->
        <#--</div>-->