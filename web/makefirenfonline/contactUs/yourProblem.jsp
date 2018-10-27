<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/27
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tell us about your problem</title>
</head>
<body>
    <form action="" method="post">
        <table>
            <tr>
                <th colspan="2">
                    告诉我们你的问题
                </th>
            </tr>
            <tr>
                <td colspan="2">
                    我们会尽快解决这个问题！
                </td>
            </tr>
            <tr>
                <th>
                    问题描述
                </th>
                <td>
                    <input type="text" name="problem">
                </td>
            </tr>
            <tr>
                <th style="background: #d2ff9e">
                    <button style="background: red" type="reset">重置</button>
                </th>
                <th style="background: coral">
                    <button style="background: chartreuse" type="submit">提交</button>
                </th>
            </tr>
        </table>
    </form>
</body>
</html>
