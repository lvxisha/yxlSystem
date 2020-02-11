$(function(){
	getInfo();
	

	//获取航班信息
	function getInfo(){
		$('#marCon').empty();
		$.ajax({
		url: "/yxl/selectFlightInformation",// 后台请求的数据
		dataType: "json",// 数据格式
		type: "post",// 请求方式
		async: true,// 是否异步请求
		data:{},
		success: function (data) {
			console.log("data",data);
			if(data.code=="0000"){
				if(data.data!=null){
					if(data.data.length>=0){
						var arrList=[];
						$.each(data.data,function(i,elom){
							var obj = new Object();
							obj.airnumber = elom.airnumber;
							obj.aptype = elom.aptype;
							obj.arrtime = elom.arrtime;
							obj.deptime = elom.deptime;
							obj.firstclass = elom.firstclass;
							obj.economyclass = elom.economyclass
							obj.startstation = elom.startstation;
							obj.terminus = elom.terminus;
							arrList.push(obj);
							})
							var html='<ul>';
							$.each(arrList,function(i,elom){
							html+='<li>'+(i+1)+'.航班班次：'+elom.airnumber+'.飞机型号：'+elom.aptype+'  始发站：'+elom.startstation+'-->'+elom.terminus+'  起飞时间：'+elom.deptime+'  预计到达时间：'+elom.arrtime+'  头等舱剩余票数：'+elom.firstclass+'  经济舱剩余票数：'+elom.economyclass+'</li>';
							})
							html+='</ul>'
							$('#marCon').append(html);
							console.log('=====',arrList);
					}else{
						$("#inform").text('暂无信息！！！');
					}
				}else{
					$("#inform").text('暂无信息！！！');
				}
			}else{
				$("#inform").text('暂无信息！！！');
			}
		}					
		})
	}

})

