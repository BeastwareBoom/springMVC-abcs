<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    
  </head>
  
  <body>
    
    <form action="${pageContext.request.contextPath }/user/register.action" method="post">
    	<table border="1px">
    		<tr>
	    		<th>用户名：</th>
	    		<td><input type="text" name="username"/></td>
    		</tr>
    		
    		<tr>
	    		<th>密码：</th>
	    		<td>
	    			<input type="password" name="password"/>
	    		</td>
    		</tr>
    		
    		<tr>
	    		<th>生日：</th>
	    		<td>
	    			<input type="text" name="birth" value="1992-04-06"/>
	    		</td>
    		</tr>
    		
    		<tr>
	    		<td align="center" colspan="2">
	    			<input type="submit" value="注册"/>
	    		</td>
	    	</tr>
    	</table>
    </form>
    
    <hr>
    
    <form action="${pageContext.request.contextPath }/user/login.action" method="get">
    	<table border="1px">
    		<tr>
	    		<th>用户名：</th>
	    		<td><input type="text" name="username"/></td>
    		</tr>
    		
    		<tr>
	    		<th>密码：</th>
	    		<td>
	    			<input type="password" name="password"/>
	    		</td>
    		</tr>
    		
    		
    		<tr>
	    		<td align="center" colspan="2">
	    			<input type="submit" value="登录"/>
	    		</td>
	    	</tr>
    	</table>
    </form>
    
    <hr>
    
    <form action="${pageContext.request.contextPath }/user/hobby.action" method="post">
    	<table border="1px">
    		<tr>
	    		<th>爱好</th>
    		</tr>
    		
    		<tr>
	    		<td align="center" colspan="2">
	    			<input type="checkbox" name="hobbies" value="足球"/>足球
	    		</td>
	    	</tr>
	    	<tr>
	    		<td align="center" colspan="2">
	    			<input type="checkbox" name="hobbies" value="篮球"/>篮球
	    		</td>
	    	</tr>
	    	<tr>
	    		<td align="center" colspan="2">
	    			<input type="checkbox" name="hobbies" value="游戏"/>游戏
	    		</td>
	    	</tr>
	    	
	    	<tr>
	    		<td align="center" colspan="2">
	    			<input type="submit" value="提交"/>
	    		</td>
	    	</tr>
    	</table>
    </form>
    
    <hr>
    10086 宗泽 6000 <a href="${pageContext.request.contextPath }/user/find.action?id=10086">编辑</a>
    
    <hr>
    <h3>Json转换</h3>
    <form>
    	<table border="1px">
    		<tr>
	    		<th>姓名：</th>
	    		<td><input type="text" name="name"/></td>
    		</tr>
    		
    		<tr>
	    		<th>薪水：</th>
	    		<td><input type="text" name="salary"/></td>
    		</tr>
    		
    		
    		<tr>
	    		<td align="center" colspan="2">
	    			<input type="button" value="提交"/>
	    		</td>
	    	</tr>
    	</table>
    </form>
    
    <input type="button" value="List转json"/><br>
    
    <input type="button" value="Map转json"/><br>
    
    
    <script type="text/javascript">
    	$("input:button:first").click(function(){
    		var url = "${pageContext.request.contextPath}/json/entity.action";
    		//alert(url)
			var sendData = {
				"name":"哈哈",
				"salary":5000
			};
			
			
			$.post(url,sendData,function(backData,textStatus,ajax){
				alert(ajax.responseText);
			});
    	})
    	
    	//List转json
    	$("input:button:odd").click(function(){
    	
    		var url = "${pageContext.request.contextPath}/json/list.action";
			var sendData = null;
			$.get(url,sendData,function(backData,textStatus,ajax){
				alert(ajax.responseText);
			});
    	})
    	
    	//Map转json
    	$("input:button:last").click(function(){
    		var url = "${pageContext.request.contextPath}/json/map.action";
			var sendData = null;
			$.post(url,sendData,function(backData,textStatus,ajax){
				alert(ajax.responseText);
			});
    	})
    </script>
    
    
  </body>
</html>
