<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<title>开始考试</title>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
<script src="${basePath}/jquery/jquery-ui.min.js"></script>
<script src="${basePath}/jquery/jquery.validate.min.js"></script>
<script src="${basePath}/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}/stuquestions/stuquestions_list.js"></script>
<link href="${basePath}/stuquestions/images/css2.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
<!--
.STYLE3 {font-size: 18px; }
.STYLE4 {font-size: 18px; font-weight: bold; }
.STYLE5 {color: #FF0000}
-->
</style>

</head>

<body onload="sT()">
<table width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="149" height="485">&nbsp;</td>
    <td width="741" valign="top" class="rightbian">
	 <form id="examination">
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="10" >
      <tr>
        <td><div align="center" class="STYLE3">考试时间：120 分钟</div></td>
        <td><div align="center" class="STYLE3" id="studentName"></div></td>
        <td><div align="center" class="STYLE3">总分 ：100 分</div></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><div id="tTime"></div></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3" bgcolor="#999999" class="STYLE4">选择题(每小题5分，共20个)</td>
      </tr>
	  <!--题目开始-->
	 
	  <tbody id="tbodyId">

	 </tbody>
	   <!--题目结束-->
      <tr>
        <td colspan="3"><div align="center">
          <input type="button" value=" 提交答卷 " name="Submit" class="btn-search" />
        </div></td>
      </tr>
    </table>
     </form>
    </td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
</body>
</html>
