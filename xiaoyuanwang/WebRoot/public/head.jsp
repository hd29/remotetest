<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'head.jsp' starting page</title>
    

 <link rel="stylesheet" href="/xiaoyuanwang/css/common.css" type="text/css"/>
 <link rel="stylesheet" href="/xiaoyuanwang/css/head.css" type="text/css"/>
 <script type="text/javascript">
	  <!-- 
	function changeBG(o){
		o.style.backgroundColor="#5C75AA";
	}
	function changeBG2(o){
		o.style.backgroundColor="";
	}
	-->
  </script>
 </head>
 
  
  <body>
   <div class="head1">
 	 <img class="img1" src="/xiaoyuanwang/images/front/top1.gif" > 
 	 <img class="img2"  src="/xiaoyuanwang/images/front/top2.jpg">
     <img src="/xiaoyuanwang/images/front/xnw3.jpg" style="float:left;">
     <ul class="navi1">
     <li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="/xiaoyuanwang/register.do?flag=registUI">注册</a></li>
     <li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="#">设为首页</a></li>
     <li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="#">加入收藏</a></li>
     <li onmouseover="changeBG(this)" onmouseout="changeBG2(this)"><a class="anavi" href="#">帮助</a></li>
     </ul>
   </div>
  </body>
</html>
