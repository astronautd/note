

layui.use([ 'layer','jquery'], function(){
	  var layer = layui.layer //弹层
	  ,$=layui.jquery //jquery
	  
	  //界面加载时根据用户id从服务器获取用户信息
	  var sendData={"id": getCookie("userid")};
		$.ajax({
			type:"post",
			//第1题，补充url路径
			url:"user/updateUser.do",
			data:sendData,
			datatype:"json",
			success:function(msg){
				if(msg.state==1){
					$("#name").val(msg.data.name);
					$("#age").val(msg.data.age);
				}else{
					layer.msg(msg.message);
				}
				
			},
			error:function(msg){
				alert("通信失败");
			}
			
		});
	
	
	  $('#submit').click(function(){
		
			/*判断年龄输入是否合法*/
			var reg=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
			if(reg.test($('#age').val())){
			}else{
				layer.msg('年龄输入不合法,1-120');
				$('#age').focus();
				return;
			}
			//第2题， 补充sendData内容
			var sendData={"age":$('#age').val()};
			$.ajax({
				type:"post",
				url:"user/updateregister.do",
				data:sendData,
				datatype:"json",
				success:function(msg){
					if(msg.state==1){
						layer.msg(msg.message);
					}else{
						layer.msg(msg.message);
					}
					
				},
				error:function(msg){
					alert("通信失败");
				}
				
			});
	})
});

	
	
	

