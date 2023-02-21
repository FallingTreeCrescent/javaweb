<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

</head>
<body>
<div>
    <form action="<%=ctxPath%>/Answer?action=answerSubmit&&id=${eid}" method="post">
       <br/>
              <br/>
              <br/>
       
         <div class="row cl">
            <label class="form-label col-2">回复内容</label>
            <div class="formControls col-5">
                <input type="text" class="input-text"  name="answer" />
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