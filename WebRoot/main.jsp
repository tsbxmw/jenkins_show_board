<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>测试数据可视化系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">

<!-- Extra Styles, not needed for Mega Menu or Boostrap -->
<link href="css/style.css" rel="stylesheet">

<!-- Mega Menu Style, you kinda really need Bootstrap in order for this to work -->
<link href="css/mega-menu.css" rel="stylesheet">

<!-- Red Color -->
<link href="css/red.css" rel="stylesheet">
<link href="css/blue.css" rel="stylesheet">
<link href="css/teal.css" rel="stylesheet">
<link href="css/green.css" rel="stylesheet">
<link href="css/orange.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet"
	media="screen">


<link rel="stylesheet" href="css/bootstrap-table.css">
<link rel="stylesheet" href="css/examples.css">

<!-- Le Google font 
<link
	href='http://fonts.googleapis.com/css?family=Karla:400,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:400,300'
	rel='stylesheet' type='text/css'>
-->

<!-- You can delete this later -->
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>

</head>
<body action="visualServlet" method="post">

	<header   class="container">

		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner nav-blue">
				<div class="container">
				<div class="nav-collapse collapse">
					
						<ul class="nav">
							<li><a href="main.jsp" style="font-size:25px">测试数据看板</a></li>
						</ul>
					
						<ul class="nav navbar-nav navbar-right">
							<li><a href="login.jsp" style="font-size:10px">管理员登录</a></li>
						</ul>
					
						<form>
							<td>
								<select  name="team" id="team" onchange="Select()">
								<option value="select" >----选择----</option>
								<option value="sh_shiyan" >----测试数据项----</option>
								</select>
							</td>
						</form>
					</div>
					
					<!--/.nav-collapse -->
				</div>
				
				<!-- Container -->
			</div>
			
			<!-- Nav Bar - Inner -->
		</div>
		<!-- Nav Bar -->
		
	</header>
	
	<!-- /container -->

	<section class="container">
		<form action="" class="form-horizontal pull-right">
			<div class="control-group">

				<div class="controls input-append date form_date"
					id="datetimepicker" data-date="" data-date-format="yyyy-mm-dd"
					data-link-field="dtp_input_date" data-link-format="yyyy-mm-dd">
					<input id="datetimepicker_result" size="16" type="text" value=""
						readonly> <span class="add-on"><i
						class="icon-remove"></i></span> <span class="add-on"><i
						class="icon-th"></i></span>
				</div>
				<input type="hidden" id="dtp_input_date" value="" /><br />
			</div>
		</form>

		<table id="table">
            <thead>
            <tr>
                <th class="span2" data-field="name">测试项</th>
                <th class="span2" data-field="userid">序号</th>
                <th class="span5" data-field="work"></th>
                <th class="span5" data-field="feel">我的心情</th>
                <th class="span2" data-field="action">操作</th>
                
            </tr>
            </thead>
        </table>
	</section>

	<hr class="container">
	
	<footer class="container">
		<p>  @2016-2017 Wei.Meng Inc</p>
		<br/>

	</footer>
	
	<!-- Le javascript ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

	<script type="text/javascript" src="js/bootstrap-table.js"></script>
	 <script src="js/ga.js"></script>
	 


	<script type="text/javascript">
	
	var teamval=<%=request.getParameter("team")%>;
 	if(teamval==null||teamval=="")
 		teamval="sh_shiyan";
	document.getElementById('team').value=teamval;
	
	
	var selected_val = document.getElementById("team");
	var val1=selected_val.value;

	window.onbeforeunload = function(){
		$table.bootstrapTable('refresh', {url: "./visualServlet?date="+$("#datetimepicker_result").val()+"&team="+val1});
		}
	
	   function Select(){
			var selected_val = document.getElementById("team");
			var val=selected_val.value;
	    	val1=val;
	    	$table.bootstrapTable('refresh', {url: "./visualServlet?date="+$("#datetimepicker_result").val()+"&team="+val1});
	    	
	    }
	  
	
	
//增加
  $(".btn-primary").click(function(){
    if($("table tr").hasClass("addtr")){
	alert("先完成操作！！！");
	}else{
     $("table tr:last").after(' <tr class="addtr"><td><input type="text" name="names" value="" /></td>'+' <td><input type="text" name="sexs" value="" /></td>'+'<td><input type="text" name="ages" value="" /></td>' +'<td> <a href="javascript:;" class="btn save btn-info btn-lg">保存</a>  <a href="javascript:;" class="btn off btn-info btn-lg">取消</a> </td>'+' </tr>');
       } 
		 
    
  })
 	
  

  //保存
  $(document).on("click",".save",function(){
  
   var name = $(this).parent().parent().find('td').eq(0).text();
   var name1=encodeURIComponent(name);
   var userid = $(this).parent().parent().find('td').eq(1).text();
   var userid1 = encodeURIComponent(userid);
   VAR WORK =$('TEXTAREA[NAME="WORK"]').VAL();
   var work1 = encodeURIComponent(work);
   var feel =$('textarea[name="feel"]').val();
   var feel1 = encodeURIComponent(feel);
   var selected_val = document.getElementById("team");
   var val1=selected_val.value;
  
	$.ajax({
			tpye:"post",
			url:"./updateContentServlet",
			data:{
				"name":name1,
				"userid":userid1,
				"work":work1,
				"feel":feel1,
				"date":$("#datetimepicker_result").val(),
				"team":val1
			},
			success:function(data,textStatus){
			}
		});
		
	var workbr = work.toString().replace(/\n|\r|(\r\n)|(\u0085)|(\u2028)|(\u2029)/g, "<br>\n"); 
	var feelbr = feel.toString().replace(/\n|\r|(\r\n)|(\u0085)|(\u2028)|(\u2029)/g, "<br>\n");		
	 var n="";
      			n+='<td>'+name+'</td>';
      			n+='<td>'+userid+'</td>';
        		n+=' <td class="span5">'+workbr+'</td>';
       			n+='  <td class="span5">'+feelbr+'</td>';
				n+=' <td>';
				n+='  <a href="javascript:;" class="btn edit btn-info btn-lg"><span class="icon-edit"></span>修改</a>';
				n+=' </td>';
       			$(this).parent().parent().removeClass("addtr");
      			$(this).parent().parent().html(n);

  })
  
   
   //修改
  $(document).on("click",".edit",function(){
  if($("table tr").hasClass("addtr")){
	alert("先完成操作！！！");
	}else{
   var name =$(this).parent().parent().find('td').eq(0).text();
   var userid = $(this).parent().parent().find('td').eq(1).text();
   var work =$(this).parent().parent().find('td').eq(2).text();
   var feel =$(this).parent().parent().find('td').eq(3).text();
  
    var n="";
      n+='<td>'+name+'</td>';
	  n+='<td>'+userid+'</td>';
	  n+='<td><textarea name="work" cols=40 rows=3 style="width:350px;resize: none;">'+work+'</textarea></td>';
	  n+='<td><textarea name="feel" cols=40 rows=3 style="width:350px;resize: none;">'+feel+'</textarea></td>';
		n+=' <td>';
		n+='  <a href="javascript:;" class="btn save btn-info btn-lg">保存</a>';
		n+='  <a href="javascript:;" class="btn off btn-info btn-lg">取消</a>';
		n+=' </td>';
       $(this).parent().parent().addClass("addtr");
      $(this).parent().parent().html(n);
	  }
   
  })
   
	  
	  $(document).on("click",".off",function(){
	   window.location.reload();
	  })
  
		$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
    
    
	var $table = $('#table');
    $(function () {
    	$('#datetimepicker_result').val(getNowFormatDate());
    	if(val1==null||val1=="") val1="sh_shiyan";
    	 $table.bootstrapTable({
    	 url: "./visualServlet?date="+getNowFormatDate()+"&team="+val1
    	 
            /* data: [{
                "name":"我的名字",
                "work": "今天工作很忙",
                "feel": "我要吐槽",
                "action" : '<a href="javascript:;" class="btn btn-info edit btn-lg"><span class="icon-edit"></span>修改 </a>'
            }] */
        });
    });
	
	$("#datetimepicker").datetimepicker().on('changeDate', function(ev){
		if(val1==null||val1=="") val1="sh_shiyan";
		$table.bootstrapTable('refresh', {url: "./visualServlet?date="+$("#datetimepicker_result").val()+"&team="+val1});
		
	});
	
	function getNowFormatDate(){
		var date = new Date();
		var seperator1 = "-";
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var strDate = date.getDate();
		
		if(month>=1 && month<=9){
			month = "0"+month;
		}
		
		if(strDate>=1 && strDate<=9){
			strDate = "0"+strDate;
		}
		
		var currentDate = year + seperator1 + month + seperator1 + strDate;
		return currentDate;
	
	}
	
  </script>
</body>
</html>
