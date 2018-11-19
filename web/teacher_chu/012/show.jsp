<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/11/19
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示用户信息</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    String user_id = (String) httpSession.getAttribute("user_id");
%>
<h1>
    <center>
        你好：<%=user_id%>
    </center>
</h1>
<hr>
<h2>
    <center>
        <a href="/teacher_chu/work013/ShowGoodsServlet">
            欢迎把你的钱变成我的钱！
        </a>
    </center>
</h2>
</body>
</html>
