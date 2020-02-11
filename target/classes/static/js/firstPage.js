//JavaScript代码区域
layui.use(['element','jquery'], function(){
  var element = layui.element,$=layui.jquery;
  
  //点击显示对应得菜单路径
  $('#mainItem a').click(function(){
	  var dataUrl = $(this).attr('data-url');
	  console.log(dataUrl);
	  $('#right').attr('src',dataUrl);
  })
  //修改密码
  $('#updataPwd').click(function(){
	  var dataUrl = $(this).attr('data-url');
	  console.log(dataUrl);
	  $('#right').attr('src',dataUrl);
  })
  //退出
  $('#layOut').click(function(){
	  $.post('/yxl/logout',function(data){
		  if(data.code=="0000"){
			  location.href='../login.html'
		  }
		  layer.msg(data.message)
	  })
  })
  //取session
  var userInfo = layui.sessionData('myData').user;
  $('.userName').text(userInfo.name);
  console.log(userInfo)
});