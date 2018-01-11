<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录页面</title>
	  <style type="text/css">
		  body {

			  background: skyblue ;

			  margin: 0;
			  no-repeat: right bottom fixed;
		  }

	  </style>
	  <script>
          window.onload=function(){

//定时器每秒调用一次fnDate()
              setInterval(function(){
                  fnDate();
              },1000);
          }

          //js 获取当前时间
          function fnDate(){
              var oDiv=document.getElementById("div1");
              var date=new Date();
              var year=date.getFullYear();//当前年份
              var month=date.getMonth();//当前月份
              var data=date.getDate();//天
              var hours=date.getHours();//小时
              var minute=date.getMinutes();//分
              var second=date.getSeconds();//秒
              var time=year+"-"+fnW((month+1))+"-"+fnW(data)+" "+fnW(hours)+":"+fnW(minute)+":"+fnW(second);
              oDiv.innerHTML=time;
          }
          //补位 当某个字段不是两位数时补0
          function fnW(str){
              var num;
              str>10?num=str:num="0"+str;
              return num;
          }
	  </script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div id="div1"> </div>
  <h1>登录商城</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="../../user" method="post">
	<input type="hidden" name="method" value="login"/>

	用户名：<input type="text" name="username" value="${cookie.username.value}"/><br/>
	密　码：<input type="password" name="password"/><br/>
	<input type="submit" value="登录"/>
</form>
  </body>
</html>
<%--<c:url value='/jsps/main.jsp'/>--%>