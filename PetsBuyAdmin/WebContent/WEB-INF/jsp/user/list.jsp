<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>111</title>
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
                    <th>姓名</th>
                    <th>积分</th>
                    <th>余额</th>
                    <th>邮箱</th>
                    <th>手机</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>${user.name }</td>
                        <td>${user.score }</td>
                        <td>${user.money }</td>
                        <td>${user.email }</td>
                        <td>${user.phone }</td>
                        <td>
                        <a href="<%=ctxPath%>/User?action=update&&id=${user.id}">
                            <button class="btn size-MINI radius" onclick="showLayer('修改用户',')">修改</button>
                            </a>
                            <a href="<%=ctxPath%>/User?action=show&&id=${user.id}">
                            <button class="btn size-MINI radius" onclick="">查看</button>
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