<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/23
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房源注册</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    // 获取用户ID
    //String user_id = httpSession.getAttribute("user_id");


%>
    <table border="1">
        <tr>
            <th>
                街道
            </th>
            <td>

            </td>
        </tr>
        <tr>
            <th>
                房屋类型
            </th>
            <td>

            </td>
        </tr>
        <tr>
            <th>
                租金
            </th>
            <td>
                <input type="number">
            </td>
        </tr>
        <tr>
            <th>
                题目
            </th>
            <td>
                <input type="text">
            </td>
        </tr>
        <tr>
            <th>
                描述
            </th>
            <td>
                <input type="text">
            </td>
        </tr>
        <tr>
            <th>
                备注
            </th>
            <td>
                <input type="text">
            </td>
        </tr>

    </table>
</body>
</html>
