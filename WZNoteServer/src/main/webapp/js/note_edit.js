
layui.use(['layer', 'jquery','form','layedit'], function(){
  var layer = layui.layer //弹层
  ,$=layui.jquery //jquery
  ,form=layui.form
  ,layedit=layui.layedit
  
  var index = layedit.build('content');
  
  var note={
		  initnote:function(){
			  //根据笔记id获取笔记信息
			  var sendData={"id":getQueryValue("id")};
				$.ajax({
					type:"get",
					url:"note/getdetail.do",
					data:sendData,
					datatype:"json",
					success:function(msg){
						if(msg.state==1){
							//根据id获取笔记本信息成功
							$('#name').val(msg.data.name);
							$("#notebookid").find("option[value="+msg.data.notebookid+"]").prop("selected",true);
							form.render();
							layedit.setContent(index, msg.data.content,true);
							
						}else{
							//根据id获取笔记本信息失败
							layer.msg(msg.message);
						}
						
					},
					error:function(msg){
						alert("通信失败");
					}
					
				});
		  },
		  initnotebook:function(){
			//获取笔记本信息
			  var sendData={"userid":getCookie("userid")};
				$.ajax({
					type:"get",
					url:"notebook/getnotebookbyuserid.do",
					data:sendData,
					datatype:"json",
					success:function(msg){
						if(msg.state==1){
							//获取笔记本成功
							/*layer.msg(msg.message);*/
							for(var i=0;i<msg.data.length;i++){
						        $("#notebookid").append("<option value='"+msg.data[i].id+"'>"+msg.data[i].name+"</option>");
						    }
							form.render();
							note.initnote();
						}else{
							layer.msg(msg.message);
						}
						
					},
					error:function(msg){
						alert("通信失败");
					}
					
				});
				
		  }
  };
  
  
  note.initnotebook();
  
  
  
  $("#editnote").on("click",function(){
	  if($('#name').val()==''){
		  layer.msg("名称不能为空");
		  return;
	  }
	  var sendData={"id":getQueryValue("id"),"name":$('#name').val(),"notebookid":$('#notebookid').val(),"content":layedit.getContent(index),"userid":getCookie("userid")};
		$.ajax({
			type:"get",
			url:"note/updatenote.do",
			data:sendData,
			datatype:"json",
			success:function(msg){
				if(msg.state==1){
					//说明更新成功
					layer.msg(msg.message);
					
				}else{
					//更新失败
					layer.msg(msg.message);
				}
				
			},
			error:function(msg){
				alert("通信失败");
			}
			
		});
  });
 
});

//获取url参数值
function getQueryValue(queryName) {
    var reg = new RegExp("(^|&)" + queryName + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if ( r != null ){
       return decodeURI(r[2]);
    }else{
       return null;
    }
 }