<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/27
  Time: 下午7:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String strH = request.getParameter("h");
    String strM = request.getParameter("m");
    String strS = request.getParameter("s");
%>
<%=strH%>
<%=strM%>
<%=strS%>
</body>
</html>
