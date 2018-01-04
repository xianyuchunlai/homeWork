<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2018/1/3
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</body>
<script type="text/javascript">
    <%
        String username = (String) session.getAttribute("username");
        if(username!=null){
    %>
    $('#username').val("<%=username%>");
    <%
    }
    %>


</script>
</html>
