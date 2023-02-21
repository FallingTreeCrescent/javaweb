<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>学习卡列表</title>
</head>
<body>
<div class="pd-20">
    <table class="table table-border table-bordered table-bg table-hover">
        <thead>
            <tr>
                <th>收货人</th>
                <th>货品名称</th>
                <th>货品价格</th>
                <th>地址</th>
                <th>下单人</th>
                
                <th>操作<label> <div style="color:red">${message}</div></label>
                </th> 
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listPets}" var="order">
               <tr>
                    <td>${order.rname}</td>
                    <td>${order.petsName }</td>
                    <td>${order.sale}</td>
                    <td>${order.address }${order.local}</td>
                    <td>${order.username}</td>
                    
                    <td>
                        <a href="<%=ctxPath %>/order?action=fahuo&&id=${order.id}" href="javascript:void(0)">
                        <button class="btn size-MINI radius" >发货</button>
                       </a>
                    </td>
                </tr>
            </c:forEach>
           
            
        </tbody>
    </table>
</div>
</body>
</html>