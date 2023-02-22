<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>食物列表</title>
</head>
<body>
<div class="pd-20">
    <table class="table table-border table-bordered table-bg table-hover">
        <thead>
            <tr>
                <th>请求路径</th>
                <th>描述</th>
                <th>库存</th>
                <th>价格</th>
                <th>操作
                <a href="<%=ctxPath%>/Pets?action=add"> <button class="btn size-M radius" onclick=""> 添加</button></th></a>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${petsList}" var="pets">
                <tr>
                    <td><img src="${pets.image}" width="200px" height="200px"/></td>
                    <td>${pets.description}</td>
                    <th>100</th>
                    <th>${pets.sale}</th>
                    
                   <td>
                    <a href="<%=ctxPath%>/Pets?action=delete&&id=${pets.id}">
                        <button class="btn size-MINI radius" onclick="">删除</button>
                        </a>
                      <a href="<%=ctxPath%>/Pets?action=update&&id=${pets.id}">
                        <button class="btn size-MINI radius" onclick="showLayer('修改权限','/rupeng-admin-prototype/page/permission/update.html')">修改</button>
                           </a>
                    </td>
                </tr>
                </c:forEach>
                
        </tbody>
    </table>
</div>
</body>
</html>