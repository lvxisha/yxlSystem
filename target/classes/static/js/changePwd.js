//获取与失去input焦点
	getfoucs('.password')
	getBulr('.password');
	getfoucs('.changePwd')
	getBulr('.changePwd');
	getfoucs('.resetPwd')
	getBulr('.resetPwd');
	//保存
	$('.submitBtn').click(function() {
		var password = $('.password').val();
		var changePwd = $('.changePwd').val();
		var resetPwd = $('.resetPwd').val();
		
		if (password.length == 0) {
			layer.msg('请输入您的密码');
			return false;
		}
		if (changePwd.length == 0) {
			layer.msg('请输入新密码');
			return false;
		}
		if (resetPwd.length == 0) {
			layer.msg('请输入确认密码');
			return false;
		}
		if( resetPwd != changePwd){
			layer.msg('两次密码不一样');
			return false;
		}
//		console.log('密码：'+password);
//		console.log('新密码'+changePwd)
//		console.log('确认密码'+resetPwd)
		postReq(password,changePwd);//请求
	});
	//重置
	  $('.resetBtn').click(function() {
		$('.password,.changePwd,.resetPwd').val('');
	});  
	//请求数据
	function  postReq(password,changePwd, resetPwd){
		$.ajax({
			url: '/yxl/changePwd',
			dataType: "json",
			//contentType: "application/json;charset=utf-8",
			type: 'post',
			data:{password:password,changePwd:changePwd,resetPwd:resetPwd},
			success:function(res){
				//console.log(res);//如果success为false，弹出errorMessage信息 userId 为新添加的用户编号
				if (res.code=="0000") {//请求成功，执行的操作
					layer.msg('修改成功',{time:1000});
					setTimeout(function(){
						window.location.replace("http://localhost:8080/yxl/views/login.html")
						//window.location.href='/yxl/views/login.html'
					},1000)
				}else{
					layer.msg('修改失败');
				} 
			},
			error:function(error){
				layer.msg('修改密码功能出现异常');
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