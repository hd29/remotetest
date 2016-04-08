<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
 <link rel="stylesheet" href="css/index.css" type="text/css"></link>
  <link rel="stylesheet" href="css/common.css" type="text/css"></link>
  </head>
  
  <body>
    <jsp:include page="/public/head.jsp" />
	<div class="main">
		<div class="left">
			<div style="border-bottom:1px solid;">
				<form action="/xiaoyuanwang/login.do?flag=login" method="post">
				<span class="font4">登陆邮箱</span><br>
				<input type="text" name="email"/><br>
				<span class="font4">密码</span><br>
				<input type="password" name="pwd"/><br>
				<input type="checkbox"/>自动登录<br>
				<input type="submit" value="　登录　" class="sub"/>
				<a href="#">找回密码</a>
				</form>
			</div>
			<div style="margin-top: 10px;border-bottom: 1px solid;"><span class="font5">注册</span><br>
			<a href="#" >校内期待　你的加入</a><br>
			<span>　　　</span>
			</div>
			<div style="border-bottom: 1px solid;border-top: 1px solid;margin-top: 10px">
			<span>　　　</span><br>
			<span class="font5" >手机登录</span><br>
			<a href="#">请访问m.xiaonei.com </a><br>
					<span>　　　</span> 
			</div>
		
		</div>
		<div class="right">
			 <div class="banner1">
    			<img src="/xiaoyuanwang/images/front/ay-0812-658-280.jpg" style="width: 719px;height: 306px;"/>
   			 </div>
   			 <div>
   			  	<div style="float: left;"><span class="font2">校内是一个真实社交网络，加入她你可以：</span> 
   			  	<ul><li>联络朋友，了解他们的最新动态</li> 
					<li>用照片和日志记录生活，展示自我</li> 
					<li>找到老同学结识新朋友</li> 
				  	<li>和朋友分享相片、音乐和电影</li> 
					<li>自由、安全地控制个人隐私</li> 
   			  	</ul>
   			  	</div>
   			 	<div style="float: right;margin-top: 30px;margin-right: 7px;" ><span class="font2">因为真实 所以精彩</span>
   			 	<p>
    				　校内存知己<br/>
    				<input type="image" onclick="" src="/xiaoyuanwang/images/front/register.jpg" />
    			</p>
   			 	</div>
   			 	<div style="clear: left;" class="font2" ><span style="float: left">寻找你的朋友</span>　<input style="float: left" type="text"><img style="float: left;margin-left: 5px;margin-top: 2px;" src="/xiaoyuanwang/images/front/sou.jpg" /><br/></div>
   				<div style="clear: left;border-bottom: 1px solid;">  * <span class="font3">校内网目前已开通<font class="font1">海外1500所大学</font>、 <font class="font1">国内3000所大学</font>、 <font class="font1">56000所中学</font>及 <font class="font1">85000家公司</font>。</span></div>
				<div class="advice" style="line-height: 18px;">
				    <span class="font4" >我要提建议我们每天都在快乐地进步着：</span><br/> 
					10月16日 狗狗：全新界面登场 <br/>
					10月15日 相册预加载和FLASH版上传，浏览相册更快更爽<br/>
					10月14日 留言板新增“悄悄话”功能 <br/>
				    </div>	   			 
   			 </div>		 
		</div>
	</div>
	<jsp:include page="/public/foot.jsp" />
  </body>
</html>
