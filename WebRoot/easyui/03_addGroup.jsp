<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>增加部门</title>
    
	<!-- 引入css文件，不限顺序 -->
    <link rel="stylesheet" href="../themes/default/easyui.css" type="text/css"></link>
    <link rel="stylesheet" href="../themes/icon.css" type="text/css"></link>
  
  	<!-- 引入js文件，有顺序限制 -->
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    
  </head>
  <body>
	
	<form>
		<table border="2" align="center">
			<tr>
				<th>部门名</th>
				<td><input type="text" name="department"/></td>
			</tr>
			<tr>
				<th>部门负责人</th>
				<td><input type="text" name="leader"/></td>
			</tr>
			<tr>
				<th>部门职责</th>
				<td>
					<textarea rows="5" cols="33">
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="提交"/>
				</td>
			</tr>
		</table>	
	</form>		

  </body>
</html>








