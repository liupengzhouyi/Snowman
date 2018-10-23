<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/27
  Time: 下午8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getbolgs</title>
</head>
<body>
<%
    String lp_blogs_url = request.getParameter("lp_blogs_url");
    String lp_blogs_name = request.getParameter("lp_blogs_name");
%>
<%=lp_blogs_name%>
<%=lp_blogs_url%>
</body>
</html>
