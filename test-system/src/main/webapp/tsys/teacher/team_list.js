	$(function(){
	$("#queryFormId").on("click",".btn-name",doQueryObjects)
					 .on("click",".btn-class",doQueryClassObjects)
});

function doQueryObjects(){
	//debugger
	var url = "student/doFindName.do";
	var params = {"StudentName":$("#searchNameId").val()};
	
	console.log(params);
	$.getJSON(url,params,function(result){
		if(result.state==1){
			setTableBodyRows(result.data);
			
		}else{
			alert(result.message);
		}
	});
}



function doQueryClassObjects(){
	debugger
	var url = "student/doFindClass.do";
	var params = {"sclass":$("#searchClassId").val()};
	var pageCurrent = $('#pageId').data("pageCurrent");
	
	if (!pageCurrent)
		pageCurrent = 1;
	
	params.pageCurrent = pageCurrent;
	$.getJSON(url, params, function(result) {
		if(result.state==1){
		setTableBodyClass(result.data.list);
		setPagination(result.data.pageObject);
		
		}else{
			alert(result.message);
		}
	});
}

function setTableBodyClass(list){
	var tBody = $("#tbodyId");
	tBody.empty();
	var tds=
		"<td>[studentID]</td>"+
		"<td>[studentName]</td>"+
		"<td>[result]</td>"+
		"<td>[sclass]</td>"
		for(var i in list){
			var tr=$("<tr></tr>");
			tBody.append(tr.append(tds.replace('[studentID]',list[i].studentID)
									  .replace('[studentName]',list[i].studentName)
									  .replace('[result]',list[i].result)
									  .replace('[sclass]',list[i].sclass)))
		}
}
function setTableBodyRows(list){
	var tBody = $("#tbodyId");
	tBody.empty();
	var tds=
		"<td>[studentID]</td>"+
		"<td>[studentName]</td>"+
		"<td>[result]</td>"+
		"<td>[sclass]</td>"
		//for(var i in list){
			var tr=$("<tr></tr>");
			tBody.append(tr.append(tds.replace('[studentID]',list.studentID)
									  .replace('[studentName]',list.studentName)
									  .replace('[result]',list.result)
									  .replace('[sclass]',list.sclass)))
		//}
}
