//�������ǵ�һ��js ������

function changeStatus(obj){
//	window.alert("ok"+obj.value);
  		if(obj.value=='worker'){
  			$(".gra_spe").css("display","none");
			$(".worker_spe").css("display","table-row");
  		}else if(obj.value=='graduate'){
  			//jquery����classȥѰ�ҿؼ�����.
  			$(".gra_spe").css("display","table-row");
			$(".worker_spe").css("display","none");
  		}
}



