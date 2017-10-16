<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String msg = "test";
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
msg = (String)request.getAttribute("msg");
if(msg==null){
	msg = "Wellcom";
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login Page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background:#B0C4DE" >
  <center>
<div >
<h1 >欢迎登陆</h1>
<form action="LoginServlet" method="post" style="background:#C1FFE4;border:2px solid #006600;width:400px;height:250px">
	<table >
	<tr>
	<td colspan="3" align="center"><br></td>
	</tr>
	<tr>
	<td colspan="3" align="center"><br></td>
	</tr>
	<tr>
	
	<td  width="66" align="right"><font size="3">帐号：</font></td><td colspan="2"><input type="text" name="username" placeholder="username"  style="width:200;height:25;"/></td>
	</tr>
	<tr>
	<td colspan="3" align="center"><br></td>
	</tr>
	<tr>
	<td width="66" align="right"><font size="3">密码：</font></td><td colspan="2"><input type="password" name="password"  placeholder="password" style="width:200;height:25;"/></td>
	
	</tr>
	<tr>
	<td colspan="3" align="center"><br></td>
	</tr>
	<tr>
	</tr>
	<tr><td colspan="3" align="center"><input type="submit" value="登录" style="width:130;height:30;background:#80FFFF"/></td></tr>
	<tr>
	<td colspan="3" align="center"><br></td>
	</tr>
	<tr>
	<td colspan="3" align="center"> <font style="background:#DA70D6" ><%=msg%></font></td>
	</tr>
	</table>
	</form>
	<div >
	<font  >@2016-2017 Wei.Meng Inc</font>
	</div> 
</div>
</center>

  </body>
</html>