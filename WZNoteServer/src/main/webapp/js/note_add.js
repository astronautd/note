layui.use([ 'form', 'layedit', 'layer', 'jquery' ], function() {
	var layer = layui.layer // 弹层
	, $ = layui.jquery // jquery
	, form = layui.form, layedit = layui.layedit

	var index = layedit.build('content');

	var sendData = {
		"userid" : getCookie("userid")
	};
	$.ajax({
		type : "get",
		url : "notebook/getnotebookbyuserid.do",
		data : sendData,
		datatype : "json",
		success : function(msg) {
			if (msg.state == 1) {
				// 获取笔记本成功
				/* layer.msg(msg.message); */
				for (var i = 0; i < msg.data.length; i++) {
					$("#notebookid").append(
							"<option value='" + msg.data[i].id + "'>"
									+ msg.data[i].name + "</option>");
				}
				form.render();

			} else {
				layer.msg(msg.message);
			}

		},
		error : function(msg) {
			alert("通信失败");
		}

	});

	$("#addnote").on("click", function() {

		var sendData = {
			"name" : $('#name').val(),
			"notebookid" : $('#notebookid').val(),
			"content" : layedit.getContent(index),
			"userid" : getCookie("userid")
		};

		$.ajax({
			type : "get",
			url : "note/addnote.do",
			data : sendData,
			datatype : "json",
			success : function(msg) {
				if (msg.state == 1) {
					// 说明添加成功
					layui.layer.msg(msg.message);

				} else {
					// 添加失败
					layer.msg(msg.message);
				}

			},
			error : function(msg) {
				alert("通信失败");
			}

		});
	});

});
