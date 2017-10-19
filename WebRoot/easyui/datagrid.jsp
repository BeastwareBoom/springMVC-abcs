<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'datagrid.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/default/easyui.css" type="text/css"></link>
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/icon.css" type="text/css"></link>
  		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
  		<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_TW.js"></script>
    
    
  </head>
  
  <body>
    
    	<table id="dg"></table>
    	<script type="text/javascript">
	    	$("#dg").datagrid({
	    		url:"${pageContext.request.contextPath}/json/datagrid.action?time="+new Date().getTime(),
	    		columns:[[    
			        {field:'name',title:'姓名',width:100},    
			        {field:'salary',title:'薪水',width:100},    
			    ]],
			    //单选
	    		singleSelect : true,
	    		//分页
		    	pagination : true  
	    	})
	    	
    	</script>
    
  </body>
</html>
