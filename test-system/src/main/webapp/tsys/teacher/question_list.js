$(document).ready(function(){
	doGetObjects();
	$("#queryFormId").on("click", ".btn-search", doQueryObjects)
						.on("click", ".updateQuestion, .showQuestion, .btn-add", doShowEditDialog)
						.on("click", ".deleteQuestion", doDeleteById);
					 /*.on("click", ".btn-valid, .btn-invalid", doValidById);*/
});

function doDeleteById() {
	var id = $(this).parent().data("id");
	if (!confirm("确认删除编号为 " + id + " 的试题吗")) return;
	var params = {"subjectID":id};
	var url = "questions/doDeleteQuestions.do";
	$.getJSON(url, params, function(result) {
		if (result.state == 1) {
			alert(result.message);
			doGetObjects();
		} else {
			alert(result.message);
		}
	});
}

function doShowEditDialog() {
	debugger
	var title;
	if ($(this).hasClass("btn-add")) {
		title = "添加试题信息";
	}
	if ($(this).hasClass("updateQuestion") || $(this).hasClass("showQuestion")) {
		// 获取button所在行的id值
		var id = $(this).parent().data("id");
		// 将id值绑定到模态框上（根据此id判断要执行添加还是修改
		$("#modal-dialog").data("id", id);
		title = "修改试题信息";
		if ($(this).hasClass("showQuestion")) {
			title = "查看试题信息";
			// 将className绑定到模态框上（根据类名判定是否为查看操作）
			$("#modal-dialog").data("class", "showQuestion");
		}
	}
	var url = "questions/editUI.do";
	$("#modal-dialog .modal-body").load(url, function(){
		$('#myModalLabel').html(title);
		// 显示模态框
		$("#modal-dialog").modal('show');
	});	
}

/* 禁用或启用项目信息 */
function doValidById() {
	console.log("doValidById");
	// 1.获取要向服务端传递的参数
	// 1.1根据操作设置状态信息
	var valid;
	if ($(this).hasClass("btn-valid")) {
		valid = 1;
	}
	if ($(this).hasClass("btn-invalid")) {
		valid = 0;
	}
	console.log("valid=" + valid);
	// 1.2获取选中（CheckBox）的项目id值
	var checkedIds = getCheckedIds();
	if (checkedIds == "") {
		alert("请至少选择一个");
		return;
	}
	// 2.发起异步请求，禁用或启用项目信息
	var url = "project/doValidById.do";
	var params = {"checkedIds":checkedIds,"valid":valid};
	$.post(url, params, function(result) {
		if (result.state == 1) {
			alert("update ok");
			doGetObjects();
		} else {
			alert(result.message);
		}
	});
}

function getCheckedIds() {
	var checkedIds = "";
	$("#tbodyId input[name=checkItem]").each(function(){
		if ($(this).prop("checked")) {
			if (checkedIds == "") {
				checkedIds += $(this).val();
			} else {
				checkedIds += "," + $(this).val();
			}
		}
	});
	console.log(checkedIds);
	return checkedIds;
}

function doQueryObjects() {
	// 1.初始化当前页码信息
	$('#pageId').data("pageCurrent", 1);
	// 2.执行查询操作
	// 2.1获得表单数据
	// 2.2提交表单数据进行查询
	doGetObjects();
}

/* 获取表单数据 */
function getQueryFormData() {
	var params = {
			"subjectTitle":$('#searchNameId').val(),
			"valid":$('#searchValidId').val()
	}
	return params;
}

/* 异步加载服务端数据 */
function doGetObjects() {
	debugger
	// 1.定义访问项目信息的url
	var url = "questions/doFindQuestions.do";
	// 2.获取表单数据（查询时用）
	var params = getQueryFormData();
//	$.ajax({
//		url:url,
//		type:"get",
//		success:function(result	){
//			console.log(result);
//		}
//	});
	// 3.动态设置分页页码信息
	var pageCurrent = $('#pageId').data("pageCurrent");
	if (!pageCurrent)pageCurrent = 1;
	params.pageCurrent = pageCurrent;
	console.log(params)
	// 4.发起异步ajax请求
	
//	var params = {"pageCurrent":pageCurrent};
	/*
	 * 服务端：list<project>-->json串
	 * 客户端：json串-->json对象：Array
	 */
	$.getJSON(url, params, function(result){
		console.log(result);
		if (result.state == 1) {
			setTableBodyRows(result.data.list);
			// 设置分页信息
			setPagination(result.data.pageObject);
		} else {
			alert(result.message);
		}
	});
}

/* 将服务端返回的json对象数据显示在页面上 */
function setTableBodyRows(result) {
	debugger
	// 1.获得具体dom对象（显示数据位置的那个dom）
	var tBody = $("#tbodyId");// jQuery的函数
	tBody.empty();
	// 2.迭代result对象
	for (var i in result) {
		// 2.1构建tr对象
		var tr = $("<tr></tr>");
		var id = result[i].subjectID;
		tr.data("id", result[i].subjectID);
		// 2.2构建td对象
		var tds = /*"<td><input type='checkbox' name='checkItem' value='" + result[i].subjectID + "'></td>" +*/
				  "<td>" + result[i].subjectID + "</td>" +
				  "<td>" + result[i].subjectTitle + "</td>" +
				  "<td>" + result[i].subjectAnswer + "</td>" +
				  "<td class='showQuestion'>查看</td>" +
				  "<td class='updateQuestion'>更新</td>" +
				  "<td class='deleteQuestion'>删除</td>";
				  /*"<td>" + (result[i].valid?"启动":"禁用")+ "</td>" +*/
		// 2.3将td对象添加到tr中
		tr.append(tds);
		// 2.4将tr对象添加到tBody中
		tBody.append(tr);
	}
}