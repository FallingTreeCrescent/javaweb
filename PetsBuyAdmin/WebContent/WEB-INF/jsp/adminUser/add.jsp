<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>添加管理员账号</title>
</head>
<body>
<div class="pd-20">
    <form action="<%=ctxPath%>/addAdmin" class="form form-horizontal">
    
        <div class="row cl">
            <label class="form-label col-2">管理员邮箱</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="email" />
            </div>
            <div class="col-5"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-2">密码</label>
            <div class="formControls col-5">
                <input type="password" class="input-text" name="password" />
            </div>
            <div class="col-5"></div>
        </div>
               <div class="row cl">
            <label class="form-label col-2">名称</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="name" />
            </div>
            <div class="col-5"></div>
        </div>
                <div class="row cl">
            <label class="form-label col-2">手机号</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="phone" />
            </div>
            <div class="col-5"></div>
        </div>
             				    <label> <div style="color:red">${message}</div></label>
             
       

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