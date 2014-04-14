<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>

<%@page import="java.io.Reader"%>
<%@page import="com.jspsmart.upload.*"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doUpload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body >
    <%
    String exPath= "";
    String imPath= "";
    String exportName= "";
    String importName= "";
    	try
    	{
    	    request.setCharacterEncoding("UTF-8");
    	    
    	  //创建SmartUpload对象
	    	SmartUpload su = new SmartUpload();
	    	//初始化
	    	su.initialize(pageContext);
	    	//上传	    	
	    	su.upload();
	    	Request req = su.getRequest();
	    	//获得上传的文件对象
	    	File file1 = su.getFiles().getFile(0);
	    	//获取上传文件的名字
	    	exportName = file1.getFileName();
	    	
	    	//定义上传的路径
	    	String filePath1 = "Compare/"+exportName;
	    	//保存
	    	file1.saveAs(filePath1, File.SAVEAS_VIRTUAL);
	    	File file2 = su.getFiles().getFile(1);
	    	//获取上传文件的名字
	    	importName = file2.getFileName();
	    	//定义上传的路径
	         String filePath2 = "Compare/"+importName;
	    	//保存
	    	file2.saveAs(filePath2, File.SAVEAS_VIRTUAL);
	    	
	    	//需要使用jar包中的Request
	    	//获取文本值
	    	String url = "getFile.do?exportName="+exportName+"&importName="+importName;
	    	String sendUrl =new String(url.getBytes("Utf-8"),"ISO-8859-1");
	    	response.sendRedirect(sendUrl);
	    	
    	}
    	catch(Exception e)
    	{
    	    e.printStackTrace();
    	}
     %>
     
    
  </body>
</html>
