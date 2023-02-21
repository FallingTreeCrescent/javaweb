<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>购物车</title>
	     <%@include file="/WEB-INF/NewHeader.jsp" %>

<!--loading页结束-->
<body>
	     <%@include file="/WEB-INF/NewNav.jsp" %>

    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t">我的购物车</div>
            <div class="leftNav none">
                <ul>      
                    <li>
                        <div class="zj">
                            <div class="zj_l">
                            
                               <c:if test="${pid!=0}">
                               <c:forEach items="${petsList}" var="pets">
                                    
                                    <h2>${pets.name}</h2>
                                    <img src="${pets.image}" height="200px" width="200px"/></figure>
                                     <p> 【宠物名字】:${pets.name}</p>
                                     <p> 【宠物描述】:${pets.description}</p>
                                     <p> 【宠物年龄】${pets.age}岁了  
                                     <p>  类型:${pets.type}</p>
                                       <b>商品价格:${pets.sale}元</b>
                                     
		                        </c:forEach>     
		                        </c:if>
                                <br/>                                <br/>
                                                                <br/>
                                                                <br/>
                             	<br/>
		<br/>
		<br/>
		<br/>
		<br/><br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>   
       <tr valign="top" height="150">
          	<td colspan="6" align="right">
            	<a href="#"><img src="images/buy1.gif" /></a>&nbsp; &nbsp; <a href="<%=ctxPath%>/User?action=buy"><img src="images/buy2.gif" /></a>
            </td>
          </tr>

         

                        </div>

	</li>
	</ul>
	</div>
	<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/><br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
	<div class="b_btm_bg bg_color">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b1.png" width="62" height="62" /></td>
                <td><h2>正品保障</h2>正品行货  放心购买</td>
              </tr>
            </table>
			<table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b2.png" width="62" height="62" /></td>
                <td><h2>满38包邮</h2>满38包邮 免运费</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b3.png" width="62" height="62" /></td>
                <td><h2>天天低价</h2>天天低价 畅选无忧</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b4.png" width="62" height="62" /></td>
                <td><h2>准时送达</h2>收货时间由你做主</td>
              </tr>
            </table>
        </div>
    </div>
		
	</div>
		
	
			     <%@include file="/WEB-INF/NewFooter.jsp" %>
	
</body>

</html>