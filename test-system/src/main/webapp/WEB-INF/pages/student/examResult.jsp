<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<title>考试结果</title>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
<script src="${basePath}/jquery/jquery-ui.min.js"></script>
<script src="${basePath}/jquery/jquery.validate.min.js"></script>
<script src="${basePath}/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}/stuquestions/stuquestions_list.js"></script>
<link href="${basePath}/stuquestions/images/css2.css" rel="stylesheet" type="text/css"/>
<style type="text/css">

.STYLE3 {font-size: 18px; }
.STYLE4 {font-size: 18px; font-weight: bold; }
.STYLE5 {color: #FF0000}

</style>
</head>
<body>
<table width="1003" height="485" border="0" cellpadding="0" cellspacing="0" class="centerbg">
  <tr>
    <td width="149" height="485">&nbsp;</td>
    <td width="741" valign="top" class="rightbian">
	<table width="60%" align="center" cellpadding="10" cellspacing="0" border="1">
      <tr>
        <td height="35" colspan="2"></td>
      </tr>
      <tr>
        <td height="49" colspan="2"><div align="center"><span class="STYLE4">考试情况表</span></div></td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td><div align="center" id="name"></div></td>
        <td><div align="center" id="stusub"></div></td>
      </tr>
      <tr>
        <td colspan="2"><div align="center"><a href="logout.do">退出系统</a></div></td>
      </tr>
    </table></td>
    <td width="113">&nbsp;</td>
  </tr>
</table>
</body>
</html>
