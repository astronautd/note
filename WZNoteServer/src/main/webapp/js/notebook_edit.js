/**
 * 
 */
layui.use([ 'layer', 'jquery' ], function() {
	var layer = layui.layer // 弹层
	, $ = layui.jquery // jquery

	console.log("edit:" + getQueryValue("id"));
	var sendData = {
		"id" : getQueryValue("id")
	};
	$.ajax({
		type : "get",
		url : "notebook/getdetail.do",
		data : sendData,
		datatype : "json",
		success : function(msg) {
			if (msg.state == 1) {
				// 根据id获取笔记本信息成功
				$('#name').val(msg.data.name);
			} else {
				// 根据id获取笔记本信息失败
				layer.msg(msg.message);
			}
		},
		error : function(msg) {
			alert("通信失败");
		}

	});
	$('#editnotebook').on("click", function() {
		if ($('#name').val() == '') {
			layer.msg("不能为空");
			return;
		}
		var sendData = {
			"name" : $('#name').val(),
			"id" : getQueryValue("id")
		};
		$.ajax({
			type : "get",
			url : "notebook/updatenotebook.do",
			data : sendData,
			datatype : "json",
			success : function(msg) {
				if (msg.state == 1) {
					// 更新成功
					layer.msg(msg.message);
				} else {
					// 更新失败
					layer.msg(msg.message);
				}
			},
			error : function(msg) {
				alert("通信失败");
			}

		});
	})

});

// 获取url参数值
function getQueryValue(queryName) {
	var query = decodeURI(window.location.search.substring(1));
	var vars = query.split("&");
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == queryName) {
			return pair[1];
		}
	}
	return null;
}