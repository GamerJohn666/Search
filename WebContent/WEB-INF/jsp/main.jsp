<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/js/js_cs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<link href="<%=root%>/css/layout.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#Clock {
	float: right;
	margin-top: 30px;
	font-size: medium;
	font-family: serif;
}
</style>
<script type="text/javascript">
	//定义一个tick函数，以获取系统的时间  
	function tick() {
		var year, month, day, hours, minutes, seconds, ap;
		var intYear, intMonth, intDay, intHours, intMinutes, intSeconds;
		var today;
		today = new Date();
		intYear = today.getYear() + 1900;
		intMonth = today.getMonth() + 1;
		intDay = today.getDate();
		intHours = today.getHours();
		intMinutes = today.getMinutes();
		intSeconds = today.getSeconds();
		//获取系统时间的小时数  
		if (intHours == 0) {
			hours = intHours + ":";
			ap = "凌晨";
		} else if (intHours < 12) {
			hours = intHours + ":";
			ap = "上午";
		} else if (intHours == 12) {
			hours = intHours + ":";
			ap = "中午";
		} else {
			intHours = intHours - 12;
			hours = intHours + ":";
			ap = "下午";
		}
		//获取系统时间的分数  
		if (intMinutes < 10) {
			minutes = "0" + intMinutes + ":";
		} else {
			minutes = intMinutes + ":";
		}
		//获取系统时间的秒数  
		if (intSeconds < 10) {
			seconds = "0" + intSeconds + " ";
		} else {
			seconds = intSeconds + " ";
		}
		timeString = "当前时间为： " + intYear + '年' + intMonth + '月' + intDay + '日'
				+ hours + minutes + seconds + ap;
		document.getElementById("Clock").innerHTML = "<font color='yellow'>"
				+ timeString + "</font>";
		//每隔0.1秒钟执行一次tick函数  
		window.setTimeout("tick()", 100);

	}
	window.onload = tick;
	function userLogout() {
		location.href = "${pageContext.request.contextPath}/userLogoff.do";
	}
</script>
</head>
<body>
<div class="easyui-layout" fit="true" style="width: 100%; height: 100%;">
<div region="north" border="false" id="north"><img alt="退出系统"
	align="right" src="images/hd_loginout.jpg" onclick="userLogout()">
 <a><img
	alt="首页" align="right" src="images/hd_home.jpg""></a>
<div id="Clock" style="text-align: center;"></div>
</div>

<div region="west" split="true" id="west" title="在线对账系统">
<div class="easyui-accordion" fit="true" border="false">
		<div title="SuperManager">
			<ul>
				<li><a
					href="javascript:addTab('tabid_inputPage','出入库对账','input.do')">出入库对账</a></li>
				<li><a
					href="javascript:addTab('tabid_changePwd','修改密码','changePwd.do')">修改密码</a></li>
			</ul>
		</div>
</div>

</div>
<div region="center" split="true" id="center">
<div class="easyui-tabs" id="centerTab" fit="true" border="false">
<div title="欢迎页" style="padding: 20px; overflow: hidden;">
<div style="margin-top: 20px;">
		<h2>你好，<font size="5">${sessionScope.managerName}</font>
		欢迎使用在线对账系统</h2>
</div>
</div>
</div>
</div>

<div region="south" border="false" id="south">
<h3 align="center">©2014 DreamLand工作室 使用前必读 京ICPX证030173号</h3>
</div>
</div>
</body>
</html>