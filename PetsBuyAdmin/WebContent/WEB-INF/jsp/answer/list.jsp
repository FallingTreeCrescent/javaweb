<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>评价</title>
</head>
<body>
<div class="pd-20">
    <form action="<%=ctxPath%>/user/list.do">
        <input type="hidden" id="curr" name="curr" />
    </form>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover">
            <thead>
                <tr>
                    <th>用户</th>
                    <th>主题信息</th>
                    <th>消息</th>
                    <th>商品编号</th>
                    <th>卖家回复</th>
                <th>操作<label> <div style="color:red">${message}</div></label>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${eva}" var="e">
                    <tr>
                        <td>${e.username }</td>
                        <td>${e.title }</td>
                        <td>${e.message }</td>
                        <td>${e.petsid }</td>
                        <td>${e.answer }</td>
                        <td>
                        <a href="<%=ctxPath%>/Answer?action=answer&&id=${e.id}">
                            <button class="btn size-MINI radius" onclick="showLayer('修改用户',')">回复</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${pageInfo.pages>1 }">
            <div id="pagination" style="margin: 20px;"></div>
            <script type="text/javascript" src="<%=ctxPath %>/lib/laypage/1.2/laypage.js"></script>
            <script type="text/javascript">
                laypage({
                    cont:'pagination',
                    pages:${pageInfo.pages},
                    curr: ${pageInfo.pageNum},
                    jump:function(obj,first){
                        if(!first){
                            $("#curr").val(obj.curr);
                            $("form").submit();
                        }
                    }
                });
            </script>
        </c:if>
    </div>
</div>
</body>
</html>