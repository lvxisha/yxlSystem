//30天内自动登录
var flags = false;
$(document).on('click', '.login-check', function() {
	if (flags) {
		$(this).addClass('login-check-active');
		flags = false;
	}else{
		$(this).removeClass('login-check-active');
		flags = true;
	}
});
var userId;
//忘记密码
$('.login-forget-pwd').click(function() {
	location.href = 'user/forgetPwd.html';
});
// 注册页面
$('.login-register').click(function() {
	location.href = 'user/register.html';
});

// 登录按钮
$('.login-submit').click(function() {
	postReq()
});
$(document).keydown(function(event) {
	if (event.keyCode == '13') {
		console.log(event.keyCode);
		 postReq();
	}
});
//点击登陆按钮时，提交数据
// 1.输入的用户名与密码是否与数据中的用户名与密码相同，并且判断该用户的角色是管理员还是用户(用户跳转到图书列表页；管理员跳转到后台首页)
// 2.
function postReq(){
	var userName = $('.login-userName').val();
	var loginPwd = $('.login-password').val();
	if (userName.length == 0 ) {
		layer.msg('用户名不能为空');
		return false;
	}
	if (loginPwd.length == 0) {
		layer.msg('密码不能为空');
		return false;
	}
	$.ajax({
		url: '/yxl/login',
		dataType: "json",// 数据格式
		type: 'post',
		data: {username: userName,password: loginPwd},//传参数,
		success:function(res){
			console.log(res);
			if (res.code=="0000") {//请求成功，执行的操作
				layer.msg('登陆成功',{time:1000});
						var roles = res.data.user.roleId;
						if (roles == 2) {
							console.log('管理员')
							location.href = 'admin/homePage.html';//进入管理员首页
							
						}else if (roles == 1) {
							console.log('普通用户')
							location.href = 'user/firstPage.html';//进入用户首页
						}
						layui.sessionData('myData',{
			                key :"user",
			                value: res.data.user
			            });
				 
			}else{
				layer.msg(res.message);
			}
		},
		error:function(e){
			console.log('出现异常');
		}
	});
}