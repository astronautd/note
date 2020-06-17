
layui.use(['laypage', 'layer', 'table','jquery','upload'], function(){
  var laypage = layui.laypage //分页
  ,layer = layui.layer //弹层
  ,table = layui.table //表格
  ,$=layui.jquery //jquery
  ,upload=layui.upload

//拖拽上传
  upload.render({
    elem: '#test10'
    ,url: 'file/upload.do' //改成您自己的上传接口
    ,accept:"file"
    ,done: function(res){
      layer.msg(res.message);
     
      console.log(res)
    }
  });
  

  
  
  $("#download").click(function(){
	  $.ajax({
          url: "file/download.do",
          type: 'post',         
          success: function (data, status, xhr) {
              console.log("Download file DONE!");
              console.log(data); // ajax方式请求的数据只能存放在javascipt内存空间，可以通过javascript访问，但是无法保存到硬盘
              console.log(status);
              console.log(xhr);
              console.log("=====================");
          }
      }); 
  });

});