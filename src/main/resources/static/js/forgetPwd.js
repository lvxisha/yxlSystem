//获取与失去input焦点
	getfoucs('.realUser')
	getBulr('.realUser');
	getfoucs('.userName')
	getBulr('.userName');
	getfoucs('.idcard')
	getBulr('.idcard');
	getfoucs('.password')
	getBulr('.password');
	getfoucs('.resetPwd')
	getBulr('.resetPwd');
	//保存
	$('.submitBtn').click(function() {
		var realUser = $('.realUser').val();
		var userName = $('.userName').val();
		var idcard = $('.idcard').val();
		var password = $('.password').val();
		var resetPwd = $('.resetPwd').val();
		if (realUser.length == 0) {
			layer.msg('请输入您的真实姓名');
			return false;
		}
		if (userName.length == 0) {
			layer.msg('请输入账号');
			return false;
		}
		if (idcard.length == 0) {
			layer.msg('请输入您的身份证号');
			return false;
		}
		if (password.length == 0) {
			layer.msg('请输入密码');
			return false;
		}
		if (resetPwd.length == 0) {
			layer.msg('请输入确认密码');
			return false;
		}
		if( resetPwd != password){
			layer.msg('两次密码不一样');
			return false;
		}
		console.log('真实姓名'+realUser)
		console.log('账号：'+userName);
		console.log('身份证号'+idcard)
		console.log('密码'+password)
		postReq(realUser,userName, idcard, password);//请求
	});
	//重置
	  $('.resetBtn').click(function() {
		$('.realUser,.userName,.idcard,.password,.resetPwd').val('');
	});  
	//请求数据
	function  postReq(realUser,userName, idcard,  password ){
		$.ajax({
			url: '/yxl/forgetPwd',
			dataType: "json",
			//contentType: "application/json;charset=utf-8",
			type: 'post',
			data:{name:realUser,username:userName, idcard:idcard,  password:password},
			success:function(res){
				console.log(res);//如果success为false，弹出errorMessage信息 userId 为新添加的用户编号
				if (res.code=="0000") {//请求成功，执行的操作
					layer.msg('注册成功',{time:1000});
					setTimeout(function(){
						 
					},3000)
				}else{
					layer.msg(res.message)
					setTimeout(function(){
						 
					},3000)
				} 
			},
			error:function(error){
				layer.msg('注册功能出现异常');
			}
		});
		
	}

	//获取焦点
	function getfoucs(dom){
		$(dom).focus(function() {
			$(dom).addClass('actived')
		});
	}
	//失去焦点
	function getBulr(dom){
		$(dom).blur(function() {
			$(dom).removeClass('actived');
		});
	}