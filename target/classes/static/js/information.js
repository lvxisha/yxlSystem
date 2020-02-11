$(function(){
	getInfo();
	

	//获取航班信息
	function getInfo(){
		$.ajax({
		url: "/yxl/userInfo",// 后台请求的数据
		dataType: "json",// 数据格式
		type: "post",// 请求方式
		async: true,// 是否异步请求
		data:{},
		success: function (res) {
			var usersex = null;
			console.log(res);
			if(res.code=="0000"){
			/*	for(int i=0;i<res.data.length;i++){
					
				}*/
				console.log(res.data);
				if(res.data.user!=null){
					console.log(Number(res.data.user.sex));
					if(Number(res.data.user.sex)==1){
						usersex="男性";
					}else{
						usersex="女性";
					}
						$('.name').text(res.data.user.name);
						$('.username').text(res.data.user.username);
						$('.idcard').text(res.data.user.idcard);
						$('.tel').text(res.data.user.tel);
						$('.tp').text(res.data.user.tp);
						$('.sex').text(usersex);
						$('.jf').text(res.data.user.jf);
						$('.logintimes').text(res.data.user.logintimes);
						$('.address').text(res.data.user.address);
				}else{
					$(".name").text('暂无信息！！！');
					$('.username').text('暂无信息！！！');
					$('.idcard').text('暂无信息！！！');
					$('.tel').text('暂无信息！！！');
					$('.tp').text('暂无信息！！！');
					$('.sex').text('暂无信息！！！');
					$('.jf').text('暂无信息！！！');
					$('.logintimes').text('暂无信息！！！');
					$('.address').text('暂无信息！！！');
				}
			}else{
				$(".name").text('暂无信息！！！');
				$('.username').text('暂无信息！！！');
				$('.idcard').text('暂无信息！！！');
				$('.tel').text('暂无信息！！！');
				$('.tp').text('暂无信息！！！');
				$('.sex').text('暂无信息！！！');
				$('.jf').text('暂无信息！！！');
				$('.logintimes').text('暂无信息！！！');
				$('.address').text('暂无信息！！！');
			}
		}					
		})
	}

})

