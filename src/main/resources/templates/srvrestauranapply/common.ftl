<#--  公用页面-->
<#--  chenyi 2019-07-03 22:17:41-->
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">主键ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="32" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入主键ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">申请人<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="applicant" maxlength="20" lay-verify="required"
                 value="${(model.applicant)!""}"  placeholder="请输入申请人"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">联系电话<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="applyPhone" maxlength="20" lay-verify="required"
                 value="${(model.applyPhone)!""}"  placeholder="请输入联系电话"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">餐厅名<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="restaurantName" maxlength="100" lay-verify="required"
                 value="${(model.restaurantName)!""}"  placeholder="请输入餐厅名"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">地址<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="addr" maxlength="100" lay-verify="required"
                 value="${(model.addr)!""}"  placeholder="请输入地址"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">健康等级<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="healthLevel" maxlength="20" lay-verify="required"
                 value="${(model.healthLevel)!""}"  placeholder="请输入健康等级"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">申请时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="applyTime" maxlength="20" lay-verify="required"
                 value="${(model.applyTime)!""}"  placeholder="请输入申请时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">状态<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="status" maxlength="20" lay-verify="required"
                 value="${(model.status)!""}"  placeholder="请输入状态"  class="layui-input">
            </div>
        </div>

              <#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">状态</label>-->
            <#--<div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"-->
                 <#--value="${(model.state)!"1"}" class="layui-input-inline"></div>-->
        <#--</div>-->