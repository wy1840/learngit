<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<HTML>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <title>考试系统</title>
  <link rel="stylesheet" href="${basePath}/bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="${basePath}/bootstrap/css/font-awesome.min.css">
  <link rel="stylesheet" href="${basePath}/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="${basePath}/bootstrap/css/all-skins.min.css">
  <link rel="stylesheet" href="${basePath}/bootstrap/css/main.css">
  <script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
  <script src="${basePath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="hold-transition login-page">
<div class="login-box" id="rrapp">
  <div class="login-box-body">
   <form action="">
      <p class="login-box-msg"><b>考试系统 用户登录</b></p>
       <div class="alert alert-danger alert-dismissible" style="display:none">
        <h4 style="margin-bottom: 0px;"><i class="fa fa-exclamation-triangle" id="errorMessage"></i></h4>
      </div>
      <div class="form-group has-feedback">
          <input type="text" class="form-control" id="username" placeholder="账号">
          <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="password" class="form-control" id="userpwd" placeholder="密码">
          <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group">
         <label class="col-md-4 control-label">登录角色:</label>
         <div class="col-md-push-10" id="role">
            <label class="radio-inline"><input  type="radio" name="role" checked value="1" > 老师</label>
            <label class="radio-inline"><input  type="radio" name="role" value="2"> 学生</label>
          </div>
      </div>
      <div class="row">
        <div class="col-xs-12">
          <button type="button" class="btn btn-primary btn-block btn-flat" id="btn-login" >登录</button>
        </div>
      </div>
      </form>
  </div>
</div>
</body>
</HTML>

<script type="text/javascript">
$(document).ready(function(){
	//回车按钮
	$(document).keyup(function(event) {
		if (event.keyCode == 13) {
			//触发btn-login绑定的submit事件
			$("#btn-login").trigger("click");
		}
	});
	//点击登录按钮
	$('#btn-login').click(doLogin);
})
function doLogin(){
	var userName = $('#username').val();
	var userPwd = $('#userpwd').val();
	var role = $('#role input:checked').val();
	if(userName==''){
		$('#errorMessage').parent().parent().css('display','block');
		$('#errorMessage').text('用户名不能为空！');
		return false;
	}
	if(userPwd==''){
		$('#errorMessage').parent().parent().css('display','block');
		$('#errorMessage').text('密码不能为空！');
		return false;
	}
	//判断此用户是否存在于数据库中
	var url = 'login.do';
	var params = {'username':userName,'password':userPwd,'role':role};
	$.post(url,params,function(result){
		if(result.state==1){   //用户校验成功，跳转到主页面
			if (result.data == 1){
				location.href='indexUI.do';
			}else{
				location.href='stuQuestionsUI.do';
			}
			
		}else{
			$('#errorMessage').parent().parent().css('display','block');
			$('#errorMessage').text(result.message);
		}
	})
}
</script>
