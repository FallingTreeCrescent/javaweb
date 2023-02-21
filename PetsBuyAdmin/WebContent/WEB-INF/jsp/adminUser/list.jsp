<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>管理员用户列表</title>
</head>
<body>
<div class="pd-20">
    <table class="table table-border table-bordered table-bg table-hover">
        <thead>
            <tr>
                <th>管理员名称</th>
                  <th>邮箱</th>

                <th>密码</th>
                <th>操作 <button class="btn size-M radius" onclick="showLayer('添加管理员','<%=ctxPath%>/adminUser?action=add')"> 添加</button></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${adminList}" var="admin">
                <tr>
                    <td>${admin.name}</td>
                    <td>${admin.email}</td>
                    <td>${admin.password}</td>
                    
                    <td>
                    <a href="<%=ctxPath%>/adminUser?action=delete&&id=${admin.id}">
                        <button class="btn size-MINI radius" onclick="">删除</button>

                    </a>
                 <a href="<%=ctxPath%>/adminUser?action=reset&&id=${admin.id}">
                        <button class="btn size-MINI radius" onclick="">重置密码</button>
                 </a>
                    </td>
                </tr>
                </c:forEach>
               
        </tbody>
    </table>
</div>
</body>
</html>