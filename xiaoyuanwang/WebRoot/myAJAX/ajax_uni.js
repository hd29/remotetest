

var xmlrequest;
function createXMLHttpRequest() {
  
	if (window.ActiveXObject) {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		xmlrequest = new XMLHttpRequest();
	}
}
function setCoUnis(o) {
	createXMLHttpRequest();
	if (xmlrequest) {
			//准备发送请求
	//		window.alert(o.id);
		var req = "serShowCoUnis?coId=" + o.id;
			//打开请求
		xmlrequest.open("get", req, true);
			//指定处理结果的函数
		xmlrequest.onreadystatechange = getCoUnis;
			//发送请求
		xmlrequest.send(req);
	}
}

function getCoUnis() {
	if (xmlrequest.readyState == 4) {
		if (xmlrequest.status == 200) {
			var pros = xmlrequest.responseXML.getElementsByTagName("province");
			var con = "<table width='100%'><tr>";
			//window.alert(pros.length);
			if(pros.length>0){
				for (var i = 1; i <= pros.length; i++) {
					con += "<td><a onclick='setProUnis(this)' href='javascript:void(0);' id='" + pros[i - 1].childNodes[0].childNodes[0].data + "' coId='" + pros[i - 1].childNodes[2].childNodes[0].data + "' class='xh'>" + pros[i - 1].childNodes[1].childNodes[0].data + "</a></td>";
					if (i % 15 == 0) {
						con += "</tr><tr>";
					}
				}
				con += "</tr></table>";
			}else{
				con = "&nbsp;";
			}
			document.getElementById("proTbl").innerHTML = con;
			
			var unis = xmlrequest.responseXML.getElementsByTagName("unis");
			var con2 = "<table width='100%'><tr>";
			for (var i = 1; i <= unis.length; i++) {
				con2 += "<td><li><a onclick='showMyUni(this)' href='javascript:void(0);' id='" + unis[i - 1].childNodes[0].childNodes[0].data + "' class='xh'>" + unis[i - 1].childNodes[1].childNodes[0].data + "</a></li></td>";
				if (i % 3 == 0) {
					con2 += "</tr><tr>";
				}
			}
			con2 += "</tr></table>";
			document.getElementById("uniTbl").innerHTML = con2;
		}
	}
}


//响应用户点击省市
function setProUnis(o) {
	
	createXMLHttpRequest();
	
	//js特点 非空为真 只要有对象就是真
	if (xmlrequest) {
		
		//准备发送请求
		var req = "/xiaoyuanwang/ChangeInfo?proid="+o.id+"&cid="+o.name;
//		window.alert(req);
//		window.alert(o.name);
		//打开请求
		xmlrequest.open("get", req, true);
		//指定处理结果的函数
		xmlrequest.onreadystatechange = getProUnis;
		//发送请求
		xmlrequest.send();
//		window.alert(o.name);
	}
}

function getProUnis() {
	//完成
	
	if (xmlrequest.readyState == 4) {
		//成功返回!
		if (xmlrequest.status == 200) {
			//表示获取unis,并拼接成一个新的大学表格
		
//			var unis = xmlrequest.responseXML.getElementsByTagName("unis");
			var unis=xmlrequest.responseXML.getElementsByTagName("unis");
			var con = "<table width='100%'><tr>";
		
			for (var i = 1; i <= unis.length; i++) {
				con += "<td><li><a onclick='showMyUni(this)' href='javascript:void(0);' id='" + unis[i - 1].childNodes[0].childNodes[0].data + "' class='xh'>" + unis[i - 1].childNodes[1].childNodes[0].data + "</a></li></td>";
				if (i % 3 == 0) {
					con += "</tr><tr>";
				}
			}
			
			con += "</tr></table>";
			//替换成最新的表格
//			window.alert(con);
			document.getElementById("uniTbl").innerHTML = con;


		}
	}
}
function showMyUni(o) {
	//取出被点击的大学的名称.o.innerHTML
	//document.getElementById("university").value=o.innerHTML;
	$("#university").val(o.innerHTML);
	//把选择大学的框框关闭
	//document.getElementById("uniDiv").style.display="none";
	//#开头表示以id号查询， .号开头表示以css查询
	$("#uniDiv").css("display","none");
	//document.getElementById("uuniversity").value=o.id;
	$("#uuniversity").val(o.id);
}
//显示大学框框
function showUniTbl() {
	
	//document.getElementById("uniDiv").style.display = "";
	$('#uniDiv').show();
}
//关闭大学框框
function closeUniTbl() {
	//document.all.uniDiv.style.display = "none";
	document.getElementById("uniDiv").style.display = "none";
}
//显示大学div
function showRegin() {
	$("#uniDiv").show();
}

