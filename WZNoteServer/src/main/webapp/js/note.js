layui.use(['laypage', 'layer', 'table','jquery'], function(){
  var laypage = layui.laypage //分页
  ,layer = layui.layer //弹层
  ,table = layui.table //表格
  ,$=layui.jquery //jquery

  
  
  //执行一个 table 实例
  table.render({
    elem: '#demo'
    ,url: 'note/getnote.do' //数据接口
    ,title: '笔记表'
    ,page: true //开启分页
    ,where: {userid: getCookie("userid")}
    ,toolbar: 'true' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
    ,totalRow: true //开启合计行
    ,parseData: function(res){ //res 即为原始返回的数据
        return {
          "code": res.state==1?0:-1, //解析接口状态
          "msg": res.message, //解析提示文本
          "count": res.data.count, //解析数据长度
          "data": res.data.list //解析数据列表
        };
      }
    ,cols: [[ //表头
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', title: 'ID',hide:'true'}
      ,{field: 'name', title: '笔记名称'}
      ,{field: 'notebooksname', title: '所属笔记本'}
      ,{field: 'content', title: '笔记内容'}
      ,{field: 'addtime', title: '添加时间',templet:'<div>{{layui.util.toDateString(d.addtime)}}</div>'}
      ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
    ]]
  });
  
  
  //监听行工具事件
  table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
    ,layEvent = obj.event; //获得 lay-event 对应的值
    if(layEvent === 'del'){
      layer.confirm('真的删除吗？', function(index){
        //obj.del(); //删除对应行（tr）的DOM结构
    	var sendData={"id":data.id};
  		$.ajax({
  			type:"get",
  			url:"note/deletenote.do",
  			data:sendData,
  			datatype:"json",
  			success:function(msg){
  				if(msg.state==1){
  					//说明删除成功
  					layer.msg(msg.message);
  					//重新刷新表格
  					table.reload('demo', {
  		  				 page: {
  		  				    curr: 1 //重新从第 1 页开始
  		  				  }
  		  				}); //只重载数据
  					
  				}else{
  					//删除失败
  					layer.msg(msg.message);
  				}
  				
  			},
  			error:function(msg){
  				alert("通信失败");
  			}
  			
  		});
    	  
    	  
    	  
        layer.close(index);
        //向服务端发送删除指令
      });
    } else if(layEvent === 'edit'){
    	layer.open({
  		  area: ['700px', '550px'],
  		  shadeClose:true,
  		  anim: 1,
  		  type: 2, 
  		  content: 'note_edit.html?id='+data.id,
  		  cancel: function(index, layero){ 
  			  table.reload('demo', {
  				 page: {
  				    curr: 1 //重新从第 1 页开始
  				  }
  				}); //只重载数据
  			  layer.close(index)
  			  /*if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
  			    layer.close(index)
  			  }*/
  			  return false; 
  			}  
  		}); 
    }
  });
  
 
  
  //分页
  laypage.render({
    elem: 'pageDemo' //分页容器的id
    ,count: 100 //总页数
    ,skin: '#1E9FFF' //自定义选中色值
    //,skip: true //开启跳页
    ,jump: function(obj, first){
      if(!first){
        layer.msg('第'+ obj.curr +'页', {offset: 'b'});
      }
    }
  });
  
  $('#addnote').on("click",function(){
	  layer.open({
		  area: ['700px', '550px'],
		  shadeClose:true,
		  anim: 1,
		  type: 2, 
		  content: 'note_add.html',//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
		  cancel: function(index, layero){ 
			  table.reload('demo', {
				 page: {
				    curr: 1 //重新从第 1 页开始
				  }
				}); //只重载数据
			  layer.close(index)
			  /*if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
			    layer.close(index)
			  }*/
			  return false; 
			}  
		}); 
  });
  

});