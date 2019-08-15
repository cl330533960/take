
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>餐厅名</label>
            <div class="layui-input-normal">
                <input type="text"  name="name" maxlength="100" lay-verify="required"
                 value="${(model.name)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">连锁店名</label>
              <div class="layui-input-normal">
                  <div cyType="selectTool" cyProps="codeName:'chainCode'" name="chainCode"
                       value="${(model.chainCode)!""}" class="layui-input-inline"></div>
              </div>
        </div>

       <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">省市区</label>
           <div class="layui-input-inline" style="width:700px;">
               <div cyType="linkSelectTool" cyProps="url:'/area/normalList/',topId:'1111111111',name:'parentAreaIds[]'"
                    value="${(model.area)!""}" class="layui-input-inline"></div>
           </div>
        </div>


            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>详细地址</label>
            <div class="layui-input-normal">
                <input type="text"  name="addr" maxlength="100" lay-verify="required"
                 value="${(model.addr)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>卫生等级</label>
            <div class="layui-input-normal">
                <div cyType="selectTool" cyProps="codeName:'wsLevel'" name="healthLevel"
                     value="${(model.healthLevel)!""}" class="layui-input-inline"></div>
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>联系人</label>
            <div class="layui-input-normal">
                <input type="text"  name="contact" maxlength="20" lay-verify="required"
                 value="${(model.contact)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>联系电话</label>
            <div class="layui-input-normal">
                <input type="text"  name="phone" maxlength="20" lay-verify="phone"
                 value="${(model.phone)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>座机</label>
            <div class="layui-input-normal">
                <input type="text"  name="landline" maxlength="20"
                 value="${(model.landline)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>入驻时间</label>
            <div class="layui-input-normal">
                <input type="text" value="${(model.inTime?string("yyyy-MM-dd"))!""}"   name="inTime" maxlength="20" lay-verify="required"
                 placeholder="请输入" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>餐厅logo</label>
          <div cyType="uploadTool" cyProps="url:'/getData/upload',multiple:'false',name:'logoPath',value:'${(model.logoPath)!""}'" lay-verify="required"
               class="layui-input-inline"></div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>营业执照</label>
                  <div cyType="uploadTool" cyProps="url:'/getData/upload',multiple:'false',name:'busLicense',value:'${(model.busLicense)!""}'" lay-verify="required"
                       class="layui-input-inline"></div>
        </div>

        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span>卫生许可证</label>
            <div cyType="uploadTool" cyProps="url:'/getData/upload',multiple:'false',name:'hygieneLicensePath',value:'${(model.hygieneLicensePath)!""}'" lay-verify="required"
                  class="layui-input-inline"></div>
        </div>


        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">备注</label>
            <div class="layui-input-normal">
                <textarea  maxlength="200" placeholder="请输入" class="layui-textarea"  >${(model.remark)!""}</textarea>
                <#--<input type="text"  name="remark" maxlength="200"-->
                 <#--value="${(model.remark)!""}"  placeholder="请输入"  class="layui-input">-->
            </div>
        </div>




            <div class="layui-form-item">
            <label class="layui-form-label"><span class="span_must">*</span>状态</label>
            <div cyType="radioTool" cyProps="codeName:'busstatus'" name="status"
                 value="${(model.status)!"1"}" class="layui-input-inline"></div>
        </div>

        <#--<script>-->
            <#--layui.use('laydate', function(){-->
                <#--var laydate = layui.laydate;-->
                <#--//执行一个laydate实例-->
                <#--laydate.render({-->
                    <#--elem: '#inTime' //指定元素-->
                <#--});-->
            <#--});-->
        <#--</script>-->