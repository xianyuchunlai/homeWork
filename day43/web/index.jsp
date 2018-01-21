<%--
  Created by IntelliJ IDEA.
  User: 0504
  Date: 2018/1/21
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>justgogogo</title>
  </head>
  <body>
  <table border="1px">
    <tr>
      <th>姓名</th>
      <th>年龄</th>
      <th>部门</th>
      <th>入职时间</th>
      <th>家庭住址</th>
      <th>电话号码</th>
      <th>change</th>
    </tr>
    <s:forEach items="${requestScope.list}" var="employee">
      <tr>
        <td>${employee.name}</td>
        <td>${employee.age}</td>
        <td>${employee.department}</td>
        <td>${employee.time}</td>
        <td>${employee.home}</td>
        <td>${employee.phone}</td>

        <td><a href="<c:url value="alter.action?method=alter&eid=${employee.eid}"/>">change</a></td>
      </tr>
    </s:forEach>
  </table>
  </body>
</html>
