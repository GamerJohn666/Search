<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  include file="/js/js_cs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
form {
	margin: 5px 0;
}

fieldset {
	padding: 0 1em 1em 1em;
	margin: auto;
	width: 430px;
	display: block;
	margin-left: 10px;
	height: 125px;
}

fieldset div {
	margin: 5px 0;
}

legend {
	padding: 1em;
}

label {
	float: left;
	width: 100px;
}

fieldset.buttons {
	border: solid 1px #ffffff;
	text-align: center;
	float: left;
	display: block;
	margin-top: 20px;
	width: 100%;
}

#footer {
	clear: both;
	text-align: center;
}
font{

    font: 14px/1.5 Tahoma,Helvetica,Arial,'宋体',sans-serif;
}
}
</style>
<script type="text/javascript">
  function check()
  {

	  $("#err").html("");
	  var flg = false;
	  var exValue = $("input[name='exportXls']").val();
	  var imValue = $("input[name='importXls']").val();
	  
	 
	  if(exValue == null || exValue.length<1 )
	  {
		  $("#err").html("<font color='red' size='4'>&nbsp;&nbsp;*公司出库文档不得为空！</font>");  
		  return flg;
	  }
	  if(imValue == null || imValue.length <1)
	  {
		  $("#err").html("<font color='red'>&nbsp;&nbsp;*客户入库文档不得为空！</font>");  
		  return flg;  
	  }
	  else
	  {
		 $("#form").attr("action","transferEecel.jsp");
		 flg = !glg;
		 return true;
	  }  
	  return flg;
  }
  
  function setValue(id)
  {
	  $("#err").html("");
	  var exValue = $("input[name='exportXls']").val();
	  var imValue = $("input[name='importXls']").val();
	  var typePoint = "";
	  var namePoint = "";
	  var type = "";
	  if("#importXls"==id)
	  {
		  typePoint = imValue.lastIndexOf("."); 
		  type = imValue.substr(typePoint).toLowerCase();
		  if(type == ".xls" || type == ".xlsx")
		  {
			  $("#imName").html(imValue.substr(12));
			  return ;
		  }
		  else
		  {
			  $("#err").html("<font color='red'>&nbsp;&nbsp;*请确保上传的文件是.xls或者.xlsx的Excel文件！</font>");
			  var objFile=document.getElementsByTagName('input')[1];
			  objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
			  return;
		  }		  
		 
	  }
	  else
	  {
		  typePoint = exValue.lastIndexOf("."); 
		  type = exValue.substr(typePoint).toLowerCase();
		  if(type == ".xls" || type == ".xlsx")
		  {			  
			  $("#exName").html(exValue.substr(12));
			  return ;
		  }
		  else
		  {
			  $("#err").html("<font color='red'>&nbsp;&nbsp;*请确保上传的文件后缀是.xls或者.xlsx的Excel文件！</font>");
			  var objFile=document.getElementsByTagName('input')[0];
			  objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
			  return;
		  }		  
	  }
	  
  }
  </script>
</head>
<body>
<center>
<div
	style="font-size: 22pt; line-height: 16pt; color: #008B8B; letter-spacing: 0.1em; margin-top: 20px">Excel
对账</div>
<font color="grey">上传需要对比的Excel 文档</font>
<div id="err" style="margin-top: 3px; height: 10px;font-size: 12px"></div>
<form id="form" action="" method="post" onsubmit="return check();"
	enctype="multipart/form-data">

<table>
	<tr>
		<td>
		<fieldset style="color: blue"><legend style="color: blue">公司出库Excel表</legend>
		<div><label for="exportXls">出库Excel</label>
		<br />
		<label for="exportXls">文件名：</label><br/>
		<div id="exName" style="font-size: 14px;height: 15px;";></div>
		</div>
		<div><input type="file" name="exportXls" id="exportXls"
			style="width: 80%" onchange="setValue('#exportXls')"/></div>
		</fieldset>
		</td>
		<td>
		<fieldset style="color: green"><legend style="color: green">客户入库Excel表</legend>
		<div><label for="importXls">入库Excel</label><br />
		<label for="importXls">文件名：</label><br/>
		<div id="imName" style="height: 14px; height: 15px;"></div>
		</div>
		<div><input type="file" name="importXls" id="importXls"
			style="width: 80%" onchange="setValue('#importXls')"/></div>
		</fieldset>
		</td>

	</tr>
	<tr>
		<td colspan="2" align="center">
		<fieldset class="buttons"><input type="submit" value="上传文件" />
		</fieldset>
		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>