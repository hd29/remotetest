
//==============================================
//	幻灯片模块
//==============================================
	$(document).ready(function () {
		var clickN = 1;
//		点击跳到相应图片
		$("#s1").click(function() {
			document.getElementById("img0").src="../imgs/img_1.jpg";
			document.getElementById("s"+clickN).style.color="black";
			document.getElementById("s1").style.color="red";
			clickN = 1;
		});
		$("#s2").click(function() {
			document.getElementById("img0").src="../imgs/img_2.jpg";
			document.getElementById("s"+clickN).style.color="black";
			document.getElementById("s2").style.color="red";
			clickN = 2;
		});
		$("#s3").click(function() {
			document.getElementById("img0").src="../imgs/img_3.jpg";
			document.getElementById("s"+clickN).style.color="black";
			document.getElementById("s3").style.color="red";
			clickN = 3;
		});
		$("#s4").click(function() {
			document.getElementById("img0").src="../imgs/img_4.jpg";
			document.getElementById("s"+clickN).style.color="black";
			document.getElementById("s4").style.color="red";
			clickN = 4;
		});
		$("#s5").click(function() {
			document.getElementById("img0").src="../imgs/img_5.jpg";
			document.getElementById("s"+clickN).style.color="black";
			document.getElementById("s5").style.color="red";
			clickN = 5;
		});
	});
//	==========================================
//		登录注册模块
//	==========================================
//  获取表单数据
	$(document).ready(function() {
		$("#submit").click(function() {
			var name = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var email = document.getElementById("email").value;
			var phone = document.getElementById("phone").value;
			var addr = $("#select1 option:selected").text()
			+$("#select2 option:selected").text()
			+$("#select3 option:selected").text();
			var age = $("#selectA1 option:selected").text()+"年"
			+$("#selectA2 option:selected").text()
			+$("#selectA3 option:selected").text();
			alert("帐号："+name+"\n"+
					  "密码："+password+"\n"+
					  "邮箱："+email+"\n"+
					  "电话："+phone+"\n"
					  +"地址："+addr+"\n"
					 +"年龄："+age+"\n"
					);
		});
	});
	
//	表单样式变化
	$(document).ready(function() {
		$("input").focus(function() {
			$(this).css("border-color","red");
		}).blur(function() {
			$(this).css("border-color","");
		});
				
	});
	
//	提交按钮的控制，勾选同意协议才可以提交
	$(document).ready(function() {
		$("#check1").click(function() {
			if($(this).attr("checked")){
				document.getElementById("submit").disabled = false;
//				$("#submit").disabled = false;
			}else{
				document.getElementById("submit").disabled = true;
//				$("#submit").disabled=true;
			}
			
		});
	});	

//	ajax加载协议文件
//		$(document).ready(function() {
//			var click = 0;
//			
//			$("#xieyi").click(function() {
//				click =click+1;
//				$("#div1").load("load.html");
//			if(click%2==0){
////				$("#div1").load("load.html");
//				$("#div1").hide();
//			}else{
////				$("#div1").load("load.html");
//				$("#div1").show();
//			}
//			
//			});
//		});
		
		
	
//	===================================================
//	个人练习
//	===================================================
//	展示隐藏	
	$(document).ready(function() {
	    var click = false;
		$("#btn1").click(function() {
			if (!click) {
				click = true;
				$("p").hide();
				$("#div1").hide();
				$("#div2").hide();
			} else {
				click = false;
				$("p").show();
				$("#div1").show();
				$("#div2").show();
			}
		});
	});
	
//	动画移动
	$(document).ready(function() {
		var click = false;
		$("#btn").click(function() {
			if (!click) {
				
				$("#div1").animate({
					left : '200px'
				});
				$("#div2").animate({
					left : '200px'
				});
				click = true;
//				$("div").css("color","red").slideUp(2000).slideDown(2000);
			}else {
				$("#div1").animate({
					left : '400px'
				});
				$("#div2").animate({
					left : '400px'
				});
				click = false;
			}
		});
	});
	
//	
////
//$(document).ready(function(){
//	  $("#btn3").click(function(){
//	  htmlobj=$.ajax({url:"http://localhost:8080/Homework/jQuery/jQuery/loadl.html",async:false});
//	  $("#div2").html(htmlobj.responseText);
//	  });
//	});