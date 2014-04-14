<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<% 
	String root = request.getContextPath(); 
	pageContext.setAttribute("root", root);
%>
<script type="text/javascript">
 var root = "<%=root%>"; //js中存放当前页面的root路径方便调用
</script>
<link href="<%=root%>/js/jquery/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/js/jquery/themes/icon.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=root%>/css/custom.css" rel="stylesheet" type="text/css" />

<script src="<%=root%>/js/jquery/jquery.min.js" type="text/javascript"></script>
<script src="<%=root%>/js/jquery/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="<%=root%>/js/jquery/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="<%=root%>/js/jquery/plugins/jquery.form.js" type="text/javascript"></script>
<script src="<%=root%>/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>


<script src="<%=root%>/js/common/custom.js" type="text/javascript"></script>
<script src="<%=root%>/js/common/validator.js" type="text/javascript"></script>

<script src="<%=root%>/js/Calendar.js" type="text/javascript"></script>

