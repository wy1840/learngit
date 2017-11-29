<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
</script>
<form  class="form-horizontal" role="form" id="editFormId">
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >试题标题:</label> 
	    <div class="col-sm-10">
			<textarea class="form-control required" name="name" id="titleId">请输入试题标题</textarea>
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">选项A:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control" name="option" id="optionAId">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">选项B:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control" name="option" id="optionBId">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">选项C:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control"  name="option" id="optionCId">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">选项D:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control"  name="option" id="optionDId">
		</div>
	</div>
	<div class="form-group">
         <label class="col-md-2 control-label">答案:</label>
         <div class="col-md-10" id="answerId">
            <label class="radio-inline"><input type="radio" name="answer" checked value="A" > A</label>
            <label class="radio-inline"><input type="radio" name="answer" value="B"> B</label>
            <label class="radio-inline"><input type="radio" name="answer" value="C"> C</label>
            <label class="radio-inline"><input type="radio" name="answer" value="D"> D</label>
          </div>
    </div>
	<!-- <div class="form-group">
         <label class="col-md-2 control-label">有效:</label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="valid" checked value="1" > 启用</label>
            <label class="radio-inline"><input  type="radio" name="valid" value="0"> 禁用</label>
          </div>
    </div> -->
	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">答案解析:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="parseId"></textarea>
		</div> 
	</div>
</form>
<c:url var="url" value="/tsys/teacher/question_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>