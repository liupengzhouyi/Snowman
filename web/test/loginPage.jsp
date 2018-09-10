<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/10
  Time: 下午2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>
    登录页面
</h1>
<br>
<form action="/ServletPackage/getYourLoginInformationServlet" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <th><input type="text" name="lpName"></th>
        </tr>
        <tr>
            <td>密码：</td>
            <th><input type="password" name="lpPassword"></th>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
