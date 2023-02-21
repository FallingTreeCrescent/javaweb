<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>修改</title>
</head>
<body>
<div class="pd-20">
    <form action="" class="form form-horizontal">
        <input type="hidden" name="id" value="1" />
        <div class="row cl">
            <label class="form-label col-2">姓名</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="name" value="${user.name}" />
            </div>
            <div class="col-5"></div>
        </div>

  
        <div class="row cl">
            <label class="form-label col-2">邮箱</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="email" value="${user.email}" />
            </div>
            <div class="col-5"></div>
        </div>
  
        <div class="row cl">
            <label class="form-label col-2">手机</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="phone" value="${user.phone}" />
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">密码</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="school" value="${user.password }" />
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
            </div>
        </div>
    </form>
</div>
</body>
</html>