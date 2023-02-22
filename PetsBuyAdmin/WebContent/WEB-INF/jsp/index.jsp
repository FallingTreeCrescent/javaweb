<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/WEB-INF/jsp/header.jsp" %>
   <%
    //图片保存的路径,可以到这个路径下查看
    out.println(request.getRealPath(""));
%>
<link href="<%=ctxPath %>/skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<title>食品专区后台管理系统</title>
</head>
<body>
<header class="Hui-header cl"> 
    <a class="Hui-logo l" title="食品专区 后台管理系统">食品专区后台管理系统</a> 
	<ul class="Hui-userbar">
		<li class="dropDown dropDown_hover"><a class="dropDown_A">${adminUser.account } <i class="Hui-iconfont">&#xe6d5;</i></a>
			<ul class="dropDown-menu radius box-shadow">
					<a href="<%=ctxPath%>/adminUser?action=reset">
				<li>
			修改密码
				</li>
				</a>
				<li><a href="<%=ctxPath%>/adminUser?action=logout">退出</a></li>
			</ul>
		</li>
		<li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
			<ul class="dropDown-menu radius box-shadow">
				<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
				<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
				<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
				<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
				<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
				<li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
			</ul>
		</li>
	</ul>
	<a aria-hidden="false" class="Hui-nav-toggle" href="#"></a> </header>
    <aside class="Hui-aside">
    	<input runat="server" id="divScrollValue" type="hidden" value="" />
    	<div class="menu_dropdown bk_2">
    		<dl id="menu-picture">
    			<dt><i class="Hui-iconfont">&#xe613;</i> 商城管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
    			<dd>
    				<ul>
                        <li><a _href="<%=ctxPath %>/order?action=list" href="javascript:void(0)">用户订单管理</a></li>
                        <li><a _href="<%=ctxPath %>/Pets?action=list" href="javascript:void(0)">食品管理</a></li>
                        <li><a _href="<%=ctxPath %>/Answer?action=list" href="javascript:void(0)">评价管理</a></li>
                        
    				</ul>
    			</dd>
    		</dl>
    		
    		<dl id="menu-comments">
    			<dt><i class="Hui-iconfont">&#xe62e;</i>系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
    			<dd>
    				<ul>
                        <li><a _href="<%=ctxPath %>/adminUser?action=list" href="javascript:void(0)">管理员用户管理</a></li>
                        <li><a _href="<%=ctxPath %>/User?action=list" href="javascript:void(0)">用户管理</a></li>
    				</ul>
    			</dd>
    		</dl>
    	</div>
    </aside>
<div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" data-href="<%=ctxPath%>/IndexServlet?action=welcome">我的桌面</span><em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="<%=ctxPath%>/Admin?action=welcome"></iframe>
		</div>
	</div>
</section>

</body>
</html>