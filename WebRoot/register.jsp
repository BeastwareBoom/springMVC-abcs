<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <a href="${pageContext.request.contextPath }/system.action">前往/WEB-INF/下的jsp</a><br>
    
    <form action="${pageContext.request.contextPath }/register.action" method="get">
    	<table border="1px">
    		<tr>
	    		<th>姓名：</th>
	    		<td><input type="text" name="username"/></td>
    		</tr>
    		
    		<tr>
	    		<th>性别：</th>
	    		<td>
	    			<input type="radio" name="gender" value="male"/>男
	    			<input type="radio" name="gender" value="female" checked="checked"/>女
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
	    			<input type="submit" value="提交"/>
	    		</td>
	    	</tr>
    	</table>
    </form>
  </body>
</html>
