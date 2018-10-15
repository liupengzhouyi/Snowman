<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/15
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/Session/LogInServlet_for_Java_web" method="post">
        <p>用户ID</p><input type="text" name="user_id"><br>
        <p>密码&nbsp;&nbsp;</p><input type="password" name="user_password"><br>
        <input type="reset" value="重置">&nbsp;&nbsp;&nbsp;
        <input type="submit" value="提交">
    </form>
</body>
</html>
