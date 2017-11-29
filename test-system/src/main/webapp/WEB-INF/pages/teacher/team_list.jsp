<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath}/tsys/teacher/team_list.js"></script>
<script type="text/javascript" src="${basePath}/tsys/common/page.js"></script>
 <!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<ol class="breadcrumb">
				  <li class="active">学生信息查询</li>
				</ol>
			</div>
			<div class="page-stats"></div>
		</div>
		<form method="post" id="queryFormId">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
					<li><input type="text" id="searchNameId" class="form-control"placeholder="姓名"></li>
					<li class='O1'><button type="button" class="btn btn-primary btn-name" >查询</button></li>
					<li><input type="text" id="searchClassId" class="form-control"placeholder="班级"></li>
					<li class='O2'><button type="button" class="btn btn-primary btn-class">查询</button></li>
				</ul>
			  </div>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
						   <th>学号</th>
							<th>姓名</th>
							<th>成绩</th>
							<th>班别</th>
						</tr>
					</thead>
					<!-- ajax异步获得,并将数据填充到tbody中 -->
					<tbody id="tbodyId">
					</tbody>
				</table>
          <%@include file="../common/page.jsp" %>
			</div>
		</form>
	</div>  