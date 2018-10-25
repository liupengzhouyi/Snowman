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
<h1>
    恭喜您，加入我们！
</h1>

<%
    HttpSession httpSession = request.getSession();
    String id = (String) httpSession.getAttribute("user_id");
%>

<h3>
    <ccenter>
        您的用户ID是:&nbsp;<%=id%>
    </ccenter>
</h3>

</body>
</html>
