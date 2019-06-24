<#--  公用页面-->
<#--  chenyi 2019-06-24 11:52:55-->
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">主键id<span class="span_must ">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="32" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">商户ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="restaurantId" maxlength="32" lay-verify="required"
                 value="${(model.restaurantId)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">评论内容<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="content" maxlength="2000" lay-verify="required"
                 value="${(model.content)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">提交时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="commentTime" maxlength="20" lay-verify="required"
                 value="${(model.commentTime?string("yyyy-MM-dd"))!""}"
                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true}) placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">商家名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="name" maxlength="20" lay-verify="required"
                 value="${(model.name)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">状态<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="status" maxlength="1" lay-verify="required"
                 value="${(model.status)!""}"  placeholder="请输入0待审核 1审核通过 2审核拒绝"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">电话号码<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="phone" maxlength="20" lay-verify="required"
                 value="${(model.phone)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">状态</label>-->
            <#--<div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"-->
                 <#--value="${(model.state)!"1"}" class="layui-input-inline">-->
            <#--</div>-->
        <#--</div>-->