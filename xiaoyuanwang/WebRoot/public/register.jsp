<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <link rel="stylesheet" href="/xiaoyuanwang/css/common.css" type="text/css"/>
  <link rel="stylesheet" href="/xiaoyuanwang/css/register.css" type="text/css"/>
  <link rel="stylesheet" href="/xiaoyuanwang/css/css/common.css" type="text/css"/>
  <script type="text/javascript" src="/xiaoyuanwang/js/publicJs.js"></script>
  <script type="text/javascript" src="/xiaoyuanwang/js/jquery-1.3.1.js"></script>
   <script type="text/javascript" src="/xiaoyuanwang/myAJAX/ajax_uni.js"></script>
  
  </head>
  
  <body>
   <jsp:include page="head.jsp"/>
   <div class="reg_main_frame">
   		<div class="play_item">
   			<div class="play_item_img">
   				<img src="/xiaoyuanwang/images/front/jiaru.jpg" />
   			</div>
   		</div>
   		<div class="reg_table">
   		<span class="font6">简单一步,快速注册</span>
   		<form action="/xiaoyuanwang/register.do?flag=registUser" method="post">
   		<table>
   		<!-- 第一行 -->
   		<tr><td class="table_td1">真实姓名：</td>
   		<td class="table_td2"><input type="text" name="name"></td>
   		<td><span class="spanVal">请输入真实姓名　　　　</span>
   		</td></tr>
   		<!-- 第2行 -->
   		<tr><td class="table_td1">性别：</td>
   		<td><input type="radio" name="sex">男<input type="radio" name="sex">女</td>
   		<td></td></tr>
   		<!-- 第3行 -->
   		<tr>
   		<td class="table_td1">身份：</td>
   		<td><select size="4" onchange="changeStatus(this);">
   		<option value="worker">已工作</option>
   		<option value="graduate">大学生</option>
   		<option value="midstu">中学生/中专技校</option>
   		<option value="nothing">以上都不是</option>
   		</select></td>
   		<td></td>
   		</tr>
   		<!-- 第4行居住地错误 -->
   		<tr class="worker_spe">
   		<td class="table_td1">居住地:</td>
   		<td>
   		<select>
   		<option>---省份---</option>
   		<option>福建省</option>
   		<option>山东省</option>
   		<option>海南省</option>
   		</select>
   		</td>
   		<td></td>
   		</tr>
   		<tr class="worker_spe"><td></td>
   		<td ><select>
   		<option>---选择城市---</option>
   		<option>龙岩市</option>
   		<option>厦门市</option>
   		<option>连城市</option>
   		</select>
   		</td>
   		<td></td>
   		</tr>
   		<!-- 第5行 -->
   		<tr class="worker_spe"><td class="table_td1">公司:</td>
   		<td><input type="text" name="company">
   		</td>
   		<td></td>
   		</tr>
   		<!-- 考虑大学生要输入的特别信息 start -->
   		<!-- 第6行类型-->
   		<tr class="gra_spe"><td class="table_td1">类型:</td>
   		<td><select name="userType">
   		<option value="graduate">大学生</option>
   		<option value="master">硕士</option>
   		<option value="doctor">博士</option>
   		</select>
   		</td>
   		<td></td>
   		</tr>
   		<!-- 第7行 大学-->
   		<tr class="gra_spe">
   		<td class="table_td1">大学:</td>
   		<td>
   		<!-- 隐藏一个大学的id，注册一个用户，应以大学编号为准，而不能以大学的名称为准 -->
   		<input type="hidden" id="uuniversity" name="universityId"/>
   		<input type="text"  id="university" onclick="showRegin()"/>
   		</td>
   		<td></td>
   		</tr>
   		<!-- end大学生特殊信息 -->
   		<!-- 第8行 -->
   		<tr><td class="table_td1">电子邮箱:<br>&nbsp;
   		</td>
   		<td style="font-size:12px;"><input type="text" name="email"><br>
   		<img src="/xiaoyuanwang/images/front/tanhao.png"/><span >如果没有邮箱，请注册</span><a href="#">Hotmail</a>邮箱。
   		</td>
   		<td></td>
   		</tr>
   		<!-- 第9行 -->
   		<tr><td class="table_td1">设置密码：</td>
   		<td><input type="password" name="pwd">
   		</td>
   		<td></td>
   		</tr>
   		<!-- 第10行 -->
   		<tr><td class="table_td1">确认密码：</td>
   		<td><input type="password" name="pwd2">
   		</td>
   		<td></td>
   		</tr>
   		<!-- 第11行 -->
   		<tr><td class="table_td1">验证码:</td>
   		<td>请输入以下验证码，看不清楚换一张？</td>
   		<td>【1234】</td>
   		</tr>
   		<!-- 第12行 -->
   		<tr><td></td>
   		<td><input name="submit" type="submit" value="" class="button1"/> 
   		</td>
   		<td></td>
   		</tr>  
   		<tr><td></td>
   		<td><input type="checkbox" name="??"/><span class="font3" style="font-size:12px;">我已阅读并同意遵守</span><a href="#" style="font-size: 12px">校内网服务条款</a>
   		</td>
   		<td></td>
   		</tr>
   		</table>
   		</form>
   		</div>
   </div>
   <jsp:include page="/public/foot.jsp"/>
   <!-- 准备显示的大学表格 start -->
<div class="divSch" id="uniDiv"
	style="display: none; position: absolute; top: 50px; left: 750px;">
	<table border="1" align="center" height="380px" width="500px"
		bordercolor="#3B5888">
		<!-- 显示所有国家 -->
		<tr>
			<td bordercolor="#C3C3C3" width="500px">
		 <c:forEach var="country" items="${countrylist}">
			<a id="${country.id}" onclick="setCoUnis(this)" class="xh"
			href="javascript:void(0);">${country.name}</a> |
			</c:forEach>
			</td>
		</tr>
		<!-- 显示当前国家的所有直辖市和省份 -->
		<tr>
		<td bordercolor="#C3C3C3">
			<div id="proTbl">
				<table width="100%">
					<tr>
							<td>
							<c:forEach var="province" items="${provincelist}">
							<a onclick='setProUnis(this)' href="javascript:void(0);"
							class="xh" id="${province.id}" name="${province.country.id}">
							${province.name}</a>
							</c:forEach>							
							</td>							
					</tr>
				</table>
			</div>
		</tr>
		<!-- 显示当前省或者直辖市的大学 -->
		<tr>
		<td valign="top" bordercolor="#C3C3C3">
			<div style="width: 550px; height: 280px; overflow: auto"
				id="uniTbl">
				<table width="100%">
					<tr>
					<c:forEach var="university" items="${universitylist}" varStatus="vs">
					<td><li>  
					<a onclick='showMyUni(this)' href="javascript:void(0);"
					class="xh"  id="${university.id}">${university.name}</a></li></td>
					<c:if test="${vs.count%3==0}"></tr><tr></c:if>
					</c:forEach>
					</tr>
				</table>
			</div>
			</td>
			</tr>
			<tr>
			<td align="right" bordercolor="#FFFFFF">
				<input type="button" value="关闭窗口" onclick="closeUniTbl()"
					style="color: white; background-color: #3B5888; padding: 3px;" />
				<br />
				<br />
				<br />
				<br />
			</td>
			</tr>
	</table>
</div>
<!-- 准备显示的大学表格 end -->
  </body>
</html>