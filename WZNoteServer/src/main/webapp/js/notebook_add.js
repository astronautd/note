/**
 * 
 */
layui.use(['layer', 'jquery'], function(){
  var layer = layui.layer //弹层
  ,$ = layui.jquery //jquery
  
  $('#addnotebook').on("click",function(){
	  if($('#name').val()==''){
		  layer.msg("不能为空");
		  return;
	  }
	  var sendData={"name":$('#name').val()};
		$.ajax({
			type:"get",
			url:"notebook/addnotebook.do",
			data:sendData,
			datatype:"json",
			success:function(msg){
				if (msg.state==1) {
					//添加成功
					layer.msg(msg.message);
				}else {
					//添加失败
					layer.msg(msg.message);
				}
			},
			error:function(msg){
				alert("通信失败");
			}
			
		});
  })
  
});