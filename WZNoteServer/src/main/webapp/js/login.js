/**
 * 
 */
$(function(){
	
	$('#reset').click(function(){
		$('#username').val('');
		$('#username').blur();
		$('#password').val('');
		$('#password').blur();
	})
	
	//注册
	$('#submit').click(function(){
		
		var username = $('#username').val()
		if(username.length==0)
		{
			alert('请输入用户名');
			$('#username').focus();
			return ;
		}else if($('#password').val()=='')
		{
			alert('请输入登录密码');
			$('#password').focus();
			return ;
		}
		var sendData={"username":$('#username').val(),"password":$('#password').val()};
		$.ajax({
			type:"post",
			url:"user/login.do",
			data:sendData,
			datatype:"json",
			success:function(msg){
				/* var objmsg = eval('(' + msg + ')');
				console.log(objmsg.result); */
				/* alert(msg); */
				if (msg.state==1) {
					//登录成功
					console.log(msg.data.name);
					SetCookie("userid",msg.data.id);
					//alert("欢迎"+msg.data.name);
					window.location.href = "main.html";
				}else {
					//登录失败
					alert(msg.message);
				}
			},
			error:function(msg){
				alert("通信失败");
			}
			
		});
	})
});