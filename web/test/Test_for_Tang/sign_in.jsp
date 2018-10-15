<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/15
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="/Session/getInformationServlet_forJava_web" method="post">
        <p>请输入用户名：</p><input type="text" name="user_name">
        <p>请输入密码：</p><input type="password" name="user_passwordI">
        <p>请再次输入密码：</p><input type="password" name="user_passwordII">
        <input type="reset" value="重置">
        <input type="submit" value="提交">
    </form>
</body>
</html>
