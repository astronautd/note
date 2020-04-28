/**
 * 
 */
$(function(){
	
	$('#reset').click(function(){
		$('#username').val('');
		$('#username').blur();
		$('#password').val('');
		$('#password').blur();
		$('#repassword').val('');
		$('#repassword').blur();
		$('#name').val('');
		$('#name').blur();
		$('#age').val('');
		$('#age').blur();
	})
	
	//注册
	$('#submit').click(function(){
		
		var username = $('#username').val();
		if(username.length==0)
		{
			alert('用户名不能为空');
			$('#username').focus();
			return ;
		}else if($('#password').val()=='')
		{
			alert('密码不能为空');
			$('#password').focus();
			return ;
		}else if($('#repassword').val()=='')
		{
			alert('确认密码不能为空');
			$('#repassword').focus();
			return ;
		}else if($('#name').val()!==$('#name').val())
		{
			alert('姓名不能为空');
			$('#name').focus();
			return ;
		}else if($('#age').val()!==$('#age').val())
		{
			alert('年龄不能为空');
			$('#age').focus();
			return ;
		}
		//判断密码和确认密码是否一致
		if($('#password').val()!=$('#repassword').val()){
			alert('密码确认密码不能为空');
			$('#repassword').focus();
			return;
		}
		//判断年龄输入是否合法
		var reg=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
		if(reg.test($('#age').val())){
		}else{
			alert('年龄输入不合法,1-120');
			$('#age').focus();
			return;
		}
		
		var sendData={"username":$('#username').val(),"password":$('#password').val(),"name":$('#name').val(),"age":$('#age').val()};
		$.ajax({
			type:"post",
			url:"user/register.do",
			data:sendData,
			datatype:"json",
			success:function(msg){
				if (msg.state==1) {
					//说明注册成功
					alert(msg.message);
				}else {
					//注册失败
					alert(msg.message);
				}
			},
			error:function(msg){
				alert("通信失败");
			}
			
		});
	})
});