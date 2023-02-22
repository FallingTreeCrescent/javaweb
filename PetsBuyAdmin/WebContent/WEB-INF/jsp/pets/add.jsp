<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

</head>
<body>
<div>
    <form action="<%=ctxPath%>/UeditorServlet" method="post">
       <br/>
              <br/>
              <br/>
       
         <div class="row cl">
            <label class="form-label col-2">图片uri</label>
            <div class="formControls col-5">
                <input type="text" class="input-text"  name="image" />
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">名称</label>
            <div class="formControls col-5">
                <input type="text" class="input-text"  name="name" />
            </div>
            <div class="col-5"></div>
        </div>
        
         <div class="row cl">
            <label class="form-label col-2">热度</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" placeholder="只能输入数字" name="age" />
            </div>
            <div class="col-5"></div>
        </div>
         <div class="row cl">
            <label class="form-label col-2">类型</label>
            <div class="formControls col-5">
                <input type="text" class="input-text"  placeholder="必须输入三个类型之一  否则无法分类显示"   name="type" />
            </div>
        </div>
          <div class="row cl">
            <label class="form-label col-2">价格</label>
            <div class="formControls col-5">
                <input type="text" class="input-text"  placeholder="必填"   name="sale" />
            </div>
            <div class="col-5"></div>
        </div>
          <div class="row cl">
            <label class="form-label col-2">描述</label>
            <div class="formControls col-5">
                <input type="text" class="input-text"  name="description" />
            </div>
            <div class="col-5"></div>
        </div>
       
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="submit" value="添加" />
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
            </div>
        </div>
    
    
</form>
</div>
</body>
</html>