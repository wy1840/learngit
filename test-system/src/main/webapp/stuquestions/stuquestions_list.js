$(function(){
	doGetObject();
	doDateObject();
	doNnameObject();
	$("#examination").on("click", ".btn-search", doQueryObjects);
})
/*显示考生成绩*/
function doSubObject(b){
	var url = "stuQuestions/stuSubObject.do";
	$("#examination").load(url,function(){
		$("#name").html("考生名字为："+name);
		$("#stusub").html("考生成绩:"+b);
	});
}

/*更新学生成绩*/
function doUpdateResult() {
	var url = "stuQuestions/updateResult.do";
	var param = {"result":b};
	$.post(url,param,function(){
		
	});
}

/*考生姓名*/
function doNnameObject(){
	var url = "stuQuestions/studentName.do";
	$.post(url,function(result){
		if(result.state==1){
			console.log(result.data);
			name = result.data;
			$("#studentName").html("考生："+result.data);
		}else{
			alert(result.message);
		}
	})
}

/*考试倒计时*/
function doDateObject(){
	var the_s = 2*60*60;
	setInterval(function(){
		//console.log(the_s);
		var g = Math.floor(the_s/3600);
		var e = Math.floor((the_s-g*3600)/60);
		var f = (the_s-g*3600)%60;
		the_s-= 1;
		var date = "<b>"+g+"</b>:<b>"+e+"</b>:<b>"+f+"</b>";
		//将倒计时写入页面
		$("#tTime").html(date);
	}, 1000);
}



/*获取学生选择的答案*/
function doQueryObjects(){
	//创建数组用于存放考生答案
	var a = new Array();
	//用于记录分数
	//var b = 0;
	for(var i = 0;i<answer.length;i++){
		a[i] = $("#answer"+i+" input[name='subjectAnswer"+i+"']:checked").val();
		if(a[i]==answer[i].subjectAnswer){
			b+=5;
		}
		//sconsole.log(answer[i].subjectAnswer);
	}
	console.log(b);
	console.log(a);
	doSubObject(b);
	doUpdateResult();
}
/*考生名字全局变量*/
var name;
/*成绩全局变量*/
var b = 0;
/*试题全局变量*/
var answer;

/*获取随机试题*/
function doGetObject(){
	//debugger
	var url = "stuQuestions/doFindRandomQuestions.do";
	$.get(url,function(result){
		if(result.state==1){
			//console.log(result.data);
			setObject(result.data);
			answer = result.data;
		}else{
			alert(result.message);
		}
	})
}

function setObject(result){
	//debugger
	//获得tBody对象
	var tBody = $("#tbodyId");
	//清空反复查找的数据
	tBody.empty();
	
	for(var i in result){
		//构建tr对象
		//尝试着在strong中加入value(正确答案)
		//将字符串转为数字
		var a = i.valueOf();
		var trs =  "<tr><td colspan='3'><strong>第<span class='STYLE5'>"+(++a)+"</span>题&nbsp;"+result[i].subjectTitle+"</strong></td></tr>"
				  +"<tr><td colspan='3'><strong>A．"+result[i].subjectOptionA+"</strong></td></tr>"
				  +"<tr><td colspan='3'><strong>B．"+result[i].subjectOptionB+"</strong></td></tr>"
				  +"<tr><td colspan='3'><strong>C．"+result[i].subjectOptionC+"</strong></td></tr>"
				  +"<tr><td colspan='3'><strong>D．"+result[i].subjectOptionD+"</strong></td></tr>"
				  +"<tr><td id='answer"+i+"'>选择答案：" 
				  +" 	A<input type='radio' name='subjectAnswer"+i+"' value='A' />"
			      +"    B<input type='radio' name='subjectAnswer"+i+"' value='B' />"
			      +"    C<input type='radio' name='subjectAnswer"+i+"' value='C' />"
			      +"    D<input type='radio' name='subjectAnswer"+i+"' value='D' />"
			      +" </td></tr> ";
		tBody.data("subjectAnswer",result[i].subjectAnswer);
		tBody.append(trs);
	}	
}