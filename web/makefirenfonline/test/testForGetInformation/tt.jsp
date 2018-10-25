<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/25
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setContentType("text/html;charset=UTF-8");

    String s = request.getParameter("a");
%>
<%=s%>
</body>
</html>
