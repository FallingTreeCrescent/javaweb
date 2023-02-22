<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>222</title>
</head>
<body>
<div class="pd-20">
    <form action="" class="form form-horizontal">
    
        <div class="row cl">
            <label class="form-label col-2">222</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="name" />
            </div>
            <div class="col-5"></div>
        </div>
    
        <div class="row cl">
            <label class="form-label col-2">222</label>
            <div class="formControls col-5">
                    <input id="subject1" type="checkbox" name="subjectIds" value="1" /><label for="subject1" style="margin-right: 10px;">Java</label>
                    <input id="subject2" type="checkbox" name="subjectIds" value="2" /><label for="subject2" style="margin-right: 10px;">.net</label>
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">描述</label>
            <div class="formControls col-5">
            <textarea name="description" class="textarea"></textarea>
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">222</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="courseware" />
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