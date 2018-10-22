<%--
  Created by IntelliJ IDEA.
  User: liupe
  Date: 2018/10/22
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie</title>
</head>
<body>

<form action="/ServletPackage/SaveCookie/saveCookieServlet" method="POST">
    站点名 ：<input type="text" name="name">
    <br/>
    站点 URL：<input type="text" name="url" /><br>
    <input type="submit" value="提交" />
</form>

</body>
</html>
