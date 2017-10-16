<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <style>
  	body{text-align:center}
  	.div{margin:0 auto;width:200px;height:200px;border:1px solid #f00}
  </style>
  <body>
 	 <div >
   	 <div style=" background:#000; color:#FFF;padding: 200px 100px 20px;">
   		 <form class="bs-example bs-example-form" role="form">
        <div class="input-group input-group-lg">
            <span class="input-group-addon">USERNAME  </span>
            <input type="text" class="form-control" placeholder="user">
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">PASSWORD  </span>
            <input type="text" class="form-control" placeholder="pass">
        </div>
        <br>
        <div class="btn-group">
    		<button type="button" class="icon-edit">  LOGIN  </button>
		</div>
   		 </form>
	</div>
	</div>	
	
	
	
	
	
	
	
	
	
  </body>
</html>
