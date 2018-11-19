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

    <form action="" method="">
        <table border="1">
            <tr>
                商品列表
            </tr>
            <tr>
                <th>
                    商品名称
                </th>
                <td>
                    商品价格
                </td>
            </tr>
            <tr>
                <td>
                    <a href="/teacher_chu/013/TheOrderPage.jsp?goodid=">

                    </a>
                </td>
                <td>

                </td>
            </tr>
        </table>
    </form>
</form>
</body>
</html>
