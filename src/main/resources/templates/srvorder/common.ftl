<#--  公用页面-->
<#--  chenyi 2019-06-26 14:01:40-->
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">主键ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="32" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入主键ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">订单号<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="orderNo" maxlength="16" lay-verify="required"
                 value="${(model.orderNo)!""}"  placeholder="请输入订单号"  class="layui-input">
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
            <label class="layui-form-label">商户ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="restaurantId" maxlength="32" lay-verify="required"
                 value="${(model.restaurantId)!""}"  placeholder="请输入商户ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">用户地址ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="userAddrId" maxlength="32" lay-verify="required"
                 value="${(model.userAddrId)!""}"  placeholder="请输入用户地址ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">快递公司<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="expressCompnay" maxlength="100" lay-verify="required"
                 value="${(model.expressCompnay)!""}"  placeholder="请输入快递公司"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">快递单号<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="expressNum" maxlength="50" lay-verify="required"
                 value="${(model.expressNum)!""}"  placeholder="请输入快递单号"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">骑手名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="expressName" maxlength="50" lay-verify="required"
                 value="${(model.expressName)!""}"  placeholder="请输入骑手名称"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">骑手电话<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="expressPhone" maxlength="20" lay-verify="required"
                 value="${(model.expressPhone)!""}"  placeholder="请输入骑手电话"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">订单状态<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="status" maxlength="2" lay-verify="required"
                 value="${(model.status)!""}"  placeholder="请输入订单状态"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">总金额<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="orderTotal" maxlength="20" lay-verify="required"
                 value="${(model.orderTotal)!""}"  placeholder="请输入总金额"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">备注<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="remark" maxlength="2000" lay-verify="required"
                 value="${(model.remark)!""}"  placeholder="备注"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">外卖类型<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="orderType" maxlength="0" lay-verify="required"
                 value="${(model.orderType)!""}"  placeholder="请输入外卖类型"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">用户支付费用<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="userPayFee" maxlength="20" lay-verify="required"
                 value="${(model.userPayFee)!""}"  placeholder="请输入用户支付费用"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">运费<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="wayFee" maxlength="11" lay-verify="required"
                 value="${(model.wayFee)!""}"  placeholder="请输入运费"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">包装费<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="packFee" maxlength="11" lay-verify="required"
                 value="${(model.packFee)!""}"  placeholder="请输入包装费"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">优惠券ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="couponId" maxlength="32" lay-verify="required"
                 value="${(model.couponId)!""}"  placeholder="请输入优惠券ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">折扣<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="discount" maxlength="20" lay-verify="required"
                 value="${(model.discount)!""}"  placeholder="请输入折扣"  class="layui-input">
            </div>
        </div>

              <#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">状态</label>-->
            <#--<div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"-->
                 <#--value="${(model.state)!"1"}" class="layui-input-inline"></div>-->
        <#--</div>-->