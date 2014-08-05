<%@  page  language="java"
        pageEncoding="UTF-8"%>
<%@  include  file="/js/js_cs.jsp"  %>
<!DOCTYPE  html  PUBLIC  "-//W3C//DTD  HTML  4.01  Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type"  content="text/html;  charset=UTF-8">  
<title>在线对账系统登录</title>  
<link  href="${root  }/css/login.css"  rel="stylesheet"  type="text/css"  />  
<style  type="text/css">  
.box  {
  background-color:  transparent;
  border-bottom:  1px  solid  #cccccc;
  border-left-width:  0px;
  border-right-width:  0px;
  border-top-width:  0px;
  border-top-style:  none;
  border-left-style:  none;
  border-right-style:  none;
  padding:  0px;
  margin:  0px;
}
</style>  
<script  type="text/javascript">
  if(top.location.href != window.location.href){
	  top.location.href = window.location.href;
  }
  
  $(function(){
      $("#submit").click(login);
      $("#reset").click(reset);
      $("#btn .box").empty();
      $("#empUser").focus(clearErr);
      $("#empPassword").focus(clearErr);
  });
  
  function login(){
	var username = $("#empUser").val();
	var password = $("#empPassword").val();
	if(username == null || username.length<1||password == null || password.length<1)
	{
		$("#msg").html("<font color='red'>&nbsp;&nbsp;*用户名和密码均不得为空！</font>");
		return false;
	}
	var options={
		      url:'loginuser.do',
		      data:{"empUser":username,"empPassword":password},
		      callBackFun:function(data){
		          if(data.isSuccessOrfail=="SUCCESS")
		          {
		        	  location.href = "${root}/main.do";
		          }
		          else
		          {
		        	  $("#msg").html(data.message);
		          }
		        }
		        	
		    };
		    sendAjaxRequest(options);
		    return true;
  }
  
  function clearErr()
  {
	  $("#msg").html(""); 
  }
  function reset()  {
      $(".box").empty();
  }
</script>  
</head>
<body>  
  <div  id="login">  
    <div  id="top">  
      <div  id="top_left">
        <img  src="${root  }/images/login_03.gif"  />  
      </div>  
      <div  id="top_center"></div>  
    </div>  
  
    <div id="center">  
      <div  id="center_left"></div>  
      <div  id="center_middle">  
     
        <form  id="logincheck"  action=""  method="post"
      onsubmit="return login();">  
        <div  id="msg" class="box"></div>
        <div  id="user"> 用  户  
        <input  class="box"    type="text"  id="empUser"  name="empUser"  size=18  
           /><br/>  
        </div>  
        <div  id="password"> 密  码  
        <input  class="box"  type="password"  id="empPassword"  size=18  
          name="empPassword"/><br/>  
        </div>  
        <div id="btn">  
          <input id="submit" type="button" value="登录" />
          <input id="reset" type="reset" value="清除"/><br/>        
        </div>  
      </form> 
      </div>  
      <div  id="center_right"></div>  
    </div>  
    <div  id="down">  
      <div  id="down_left">  
        <div  id="inf">  
          <div  class="inf_text">版本信息</div>  <div  class="copyright">Excel对账管理系统
            2014  v1.0</div>  
        </div>  
      </div>  
      <div  id="down_center"></div>  
    </div>  
  
  </div>  
</body>

</body>
</html>
