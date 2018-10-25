<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/25
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    HttpSession httpSession = request.getSession();
    String id = (String) httpSession.getAttribute("user_id");
%>

<%=id%>

</body>
</html>
