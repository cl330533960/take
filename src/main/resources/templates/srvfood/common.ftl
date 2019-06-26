<#--  公用页面-->
<#--  chenyi 2019-06-25 17:47:38-->

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>餐品名称</label>
            <div class="layui-input-normal">
                <input type="text"  name="name" maxlength="50" lay-verify="required"
                 value="${(model.name)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>碳蛋脂比例</label>
            <div class="layui-input-normal">
                <input type="text"  name="scale" maxlength="50" lay-verify="required"
                 value="${(model.scale)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>热量</label>
            <div class="layui-input-normal">
                <input type="text"  name="cal" maxlength="20" lay-verify="required"
                 value="${(model.cal)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>餐厅单价</label>
            <div class="layui-input-normal">
                <input type="text"  name="price" maxlength="20" lay-verify="number"
                 value="${(model.price)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>系统单价</label>
            <div class="layui-input-normal">
                <input type="text"  name="sysPrice" maxlength="20" lay-verify="required"
                       value="${(model.sysPrice)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>


              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>适用于</label>
            <div class="layui-input-normal">
                <div cyType="checkboxTool" cyProps="codeName:'usescope',name:'useScope'" name="useScopes"
                     value="${(model.useScope)!""}" class="layui-input-inline"></div>
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <div cyType="radioTool" cyProps="codeName:'hotcoldcode',name:'hotCold'" name="hotCold"
                     value="${(model.hotCold)!""}" class="layui-input-inline"></div>
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">连锁店</label>
            <div class="layui-input-normal">
                <div cyType="selectTool" cyProps="codeName:'chainCode'" name="chianId"
                     value="${(model.chianId)!""}" class="layui-input-inline"></div>
            </div>
            </div>

        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">是否同步到所有门店</label>
            <div class="layui-input-normal">
            <div cyType="radioTool" cyProps="enumName:'IsInitEnum'" name="isAllRestaurant"
               value="${(model.isAllRestaurant)!""}" class="layui-input-inline" >
            </div>
        </div>


        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">门店</label>
            <div class="layui-input-normal">
                <div cyType="selectTool" cyProps="url:'/srvrestaurant/normalList/',name:'restaurantId'"
                     value="${(model.restaurantId)!""}" name="restaurantId" class="layui-input-inline"></div>
            </div>
        </div>

        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">餐品类型</label>
            <div class="layui-input-normal">
                <div cyType="selectTool" cyProps="codeName:'foodtype',name:'foodType'"
                     value="${(model.foodType)!""}" name="foodType" class="layui-input-inline"></div>
            </div>
        </div>

        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>商品图片</label>
            <div class="layui-input-normal">
                <div cyType="uploadTool" cyProps="url:'/getData/upload/',value:'${(model.imagePath)!""}',name:'imagePaths[]',btnName:'上传商品图片',multiple:'true',type:'img',size:'5000'"></div>
            </div>
        </div>


            <div class="layui-form-item">${(model.bucket)!""}
                <label class="layui-form-label">商品描述</label>
                <div class="layui-input-normal">
                    <textarea  maxlength="200" placeholder="请输入" class="layui-textarea"  >${(model.remark)!""}</textarea>
                <#--<input type="text"  name="remark" maxlength="200"-->
                <#--value="${(model.remark)!""}"  placeholder="请输入"  class="layui-input">-->
                </div>
            </div>

        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="status"
                 value="${(model.status)!"1"}" class="layui-input-inline"></div>
        </div>