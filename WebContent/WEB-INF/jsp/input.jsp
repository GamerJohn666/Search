<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  include  file="/js/js_cs.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

    form{
      margin: 5px 0;
    }
    
    fieldset{
      padding: 0 1em 1em 1em;
      margin: auto;      
      width: 300px;
      display: block;
      text-align: left;
      float:left;
      margin-left: 10px;
    }
    
    fieldset div{
      margin: 5px 0;
    }
    
    legend {
  		padding: 1em;
  	}
	
    label{
      float: left;
      width: 100px;
    }
    
    #content div input{
      width: 200px;
    }
    
    fieldset.buttons{
      border: solid 1px #ffffff;
      text-align: center;
      float:left;
      display:block;
      margin-top: 20px;
    }
  	
  	#footer{
	  clear:both;
	  text-align:center;
	  }
}
  </style>
</head>
<body bgcolor="lightblue">
 <center>
<fieldset>
       <legend>出库Excel表</legend>
        <div>
          <label for="username">出库Excel</label>
        </div>
        <div>
          <input type="file" name="exportXls" />
        </div>
 </fieldset>
 <fieldset>
        <legend>入库Excel表</legend>
        <div>
          <label for="username">入库Excel</label>
        </div>
        <div>
          <input type="file" name="importXls" />
        </div>
        </fieldset>
 <fieldset class="buttons">
              <input type="button" id="btn" name="btn"value="提交" />
 </fieldset>
</center>
</body>
</html>