<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/20
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="/struts-tags" %>
<html>
<head>
    <title>编辑</title>
</head>
<body>


<s:form action="gogogo" method="POST">
    ID:<input name="employee.eid" value="<s:property value="#h.eid"/> "><br/>
    用 户 名:<input name="employee.name" value="<s:property value="#h.name"/> "><br/>
    年    龄:<input name="employee.age" value="<s:property value="#h.age"/> "><br/>
    部    门:<input name="employee.department" value="<s:property value="#h.department"/> "><br/>
    入职时间:<input name="employee.time" value="<s:property value="#h.time"/> "><br/>
    家庭住址:<input name="employee.home" value="<s:property value="#h.home"/> "><br/>
    电话号码:<input name="employee.phone" value="<s:property value="#h.phone"/> "><br/>
    <input type="submit" value="change">
</s:form>
</body>
</html>
