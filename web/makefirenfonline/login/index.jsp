<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/24
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线交友网登录</title>
</head>
<body>

<table border="1">
    <tr>
        <th colspan="3">
            用户注册
        </th>
    </tr>
    <tr>
        <th colspan="1">
            请输入你的电子邮件
        </th>
        <td colspan="2">
            <input type="email" name="user_email">
        </td>
    </tr>
    <tr >
        <th colspan="1">
            验证码
        </th>
        <th colspan="1">
            <img src="/ServletPackage/VerifyCodeServlet/VerifyCodeServlet">
        </th>
        <td colspan="1">
            <button type="button" id="lp_button">看不清，换一张！</button>
        </td>
    </tr>
    <tr>
        <th colspan="1">
            请输入验证码
        </th>
        <td colspan="2">
            <input type="text" name="verify_code">
        </td>
    </tr>
    <tr>
        <td colspan="1">
            <button type="reset">重置</button>
        </td>
        <td colspan="1">
            <button type="submit">提交</button>
        </td>
    </tr>
</table>

</body>
</html>
