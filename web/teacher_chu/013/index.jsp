<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/11/19
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/teacher_chu/work013/GetUserIDAndPasswordInformationServlet" method="post">
    <table>
        <tr>
            <th colspan="2">
                登录
            </th>
        </tr>
        <tr>
            <th>
                账号
            </th>
            <th>
                <input type="text" name="user_id">
            </th>
        </tr>
        <tr>
            <th>
                密码
            </th>
            <th>
                <input type="password" name="user_id">
            </th>
        </tr>
    </table>
</form>
</body>
</html>
