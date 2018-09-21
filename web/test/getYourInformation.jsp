<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/10
  Time: 下午2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录中……</title>
</head>
<body>
    <%
        String lpName = request.getParameter("lpName");
        String lpPassword = request.getParameter("lpPassword");
    %>
    <%=lpName%>
    <%=lpPassword%>
</body>
</html>
