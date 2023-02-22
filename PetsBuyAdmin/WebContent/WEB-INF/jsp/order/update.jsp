<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<title>333</title>
</head>
<body>
<div class="pd-20">
    <form action="" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-2">333</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="name" value="Java基础" />
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">333</label>
            <div class="formControls col-5">
                    <input id="subject1" type="checkbox" name="subjectIds" value="1" checked="checked" /><label for="subject1" style="margin-right: 10px;">Java</label>
                    <input id="subject2" type="checkbox" name="subjectIds" value="2" /><label for="subject2" style="margin-right: 10px;">.net</label>
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">描述</label>
            <div class="formControls col-5">
            <textarea name="description" class="textarea">Java基础语法、基本类库、IO、集合、多线程、网络编程、正则、反射内省等JavaSE相关技术</textarea>
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">333</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="courseware" value="链接：http://pan.baidu.com/s/1qY4GyiKm 密码：9qdb" />
            </div>
            <div class="col-5"></div>
        </div>

        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="submit" value="修改" />
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
            </div>
        </div>
    </form>
</div>
</body>
</html>