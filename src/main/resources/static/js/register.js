//获取与失去input焦点
	getfoucs('.userName')
	getBulr('.userName');
	getfoucs('.password')
	getBulr('.password');
	getfoucs('.resetPwd')
	getBulr('.resetPwd');
	getfoucs('.realUser')
	getBulr('.realUser');
	getfoucs('.idcard')
	getBulr('.idcard');
	getfoucs('.tel')
	getBulr('.tel');
	getfoucs('.address')
	getBulr('.address');
	//保存
	$('.submitBtn').click(function() {
		var userName = $('.userName').val();
		var password = $('.password').val();
		var resetPwd = $('.resetPwd').val();
		var realUser = $('.realUser').val();
		var idcard = $('.idcard').val();
		var tel = $('.tel').val();
		var address = $('.address').val();
		// 选择性别
		var sex = $('input[name=sex]:checked').val();
		if (userName.length == 0) {
			layer.msg('请输入用户名');
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
		if (realUser.length == 0) {
			layer.msg('请输入您的真实姓名');
			return false;
		}
		if (idcard.length == 0) {
			layer.msg('请输入您的身份证号');
			return false;
		}
		if (tel.length == 0) {
			layer.msg('请输入您的手机号');
			return false;
		}
		if (address.length == 0) {
			layer.msg('请输入您的详细地址');
			return false;
		}
		console.log('用户名：'+userName);
		console.log('密码'+password)
		console.log('真实姓名'+realUser)
		console.log('身份证号'+idcard)
		console.log('手机号'+tel)
		console.log('详细地址'+address)
		console.log('性别'+sex)
		//性别：0表示女，1表示男,Number将字符串强制转化为数字
		postReq(userName, password, realUser, Number(sex),idcard, tel, address);//请求
	});
	//重置
	  $('.resetBtn').click(function() {
		$('.userName,.password,.resetPwd,.realUser,.idcard,.tel,.address').val('');
	});  
	//请求数据
	function  postReq( userName, password, realUser,sex, idcard, tel ,address ){
		$.ajax({
			url: '/yxl/user/add',
//			dataType: "json",
			contentType: "application/json;charset=utf-8",
			type: 'post',
			data:JSON.stringify({username: userName,password: password,name: realUser,sex: sex,idcard: idcard,tel: tel,address:address}),
			success:function(res){
				console.log(res);//如果success为false，弹出errorMessage信息 userId 为新添加的用户编号
				if (res.code=="0000") {//请求成功，执行的操作
					layer.msg('注册成功',{time:1000});
					setTimeout(function(){
						location.href = '../login.html';
					},3000)
				}else{
					layer.msg(res.message)
					setTimeout(function(){
						location.href = 'forgetPwd.html'; 
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
//	验证账号是否可用
			if(dom == ".userName"){
				$.ajax({
					url: '/yxl/localUserName',
					dataType: "json",// 数据格式
					//contentType: "application/json;charset=utf-8",
					type: 'post',
					data:{username: $(dom).val()},
					success:function(res){
						console.log(res);//如果success为false，弹出errorMessage信息 userId 为新添加的用户编号
						if (res.code=="0000") {//请求成功，执行的操作
							layer.msg('账号可用',{time:1000});
							
							//	location.href = '../login.html';
							
						}else{
							layer.msg(res.message)
							
							//	location.href = 'register.html';
							
						} 
					},
					error:function(error){
						layer.msg('注册功能出现异常11');
					}
				});
			}
//			验证身份证号是否可用
       if(dom == ".idcard"){
    		$.ajax({
    			url: '/yxl/localUserIdcard',
    			dataType: "json",// 数据格式
    			type: 'post',
    			data:{idcard: $(dom).val()},
    			success:function(res){
    				console.log(res);//如果success为false，弹出errorMessage信息 userId 为新添加的用户编号
    				if (res.code=="0000") {//请求成功，执行的操作
    					layer.msg('身份证号可用',{time:1000});
    				}else{
    					layer.msg(res.message)
    				} 
    			},
    			error:function(error){
    				layer.msg('注册功能出现异常12');
    			}
    		});
    	   
       }
	});
}