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
  
  <body bgcolor="green">
  <!--添加数据-->
		<form action="action_execute" method="get">
 添加数据<br>
			用户ID
			<input type="text" name="id" />
			<br>
			账户：
			<input type="text" name="username" />
			<br>
			密码：
			<input type="password" name="password" />
			<br>
			<input type="submit" value="添加" />
		</form>
		<!--删除数据-->
		<form action="action_delete" method="get">
			删除数据<br>
			用户ID
			<input type="text" name="id" />
			<br>
			<input type="submit" value="删除" />
		</form>
		<!--更新数据-->
		<form action="action_update" method="get">
	更新数据<br>
			用户ID
			<input type="text" name="id" />
			<br>
			密码：
			<input type="password" name="password" />
			<br>
			<input type="submit" value="更新" />
		</form>
		<!--查询数据-->
		<form action="action_query" method="get">
		查询数据<br>
			用户ID：
			<input type="text" name="id" />
			<br>
			<input type="submit" value="查询" />
		</form>
	</body>
</html>
