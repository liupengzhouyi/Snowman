<%--
  Created by IntelliJ IDEA.
  User: liupe
  Date: 2018/10/22
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

<table>
    <tr>
        <th>
            用户名
        </th>
        <td>
            <input type="text" name="lp_new_user_name">
        </td>
    </tr>
    <tr>
        <th>
            邮箱地址
        </th>
        <td>
            <input type="email" name="lp_new_user_email">
        </td>
    </tr>
    <tr>
        <th>
            密码
        </th>
        <td>
            <input type="password" name="lp_new_user_passwordI">
        </td>
    </tr>
    <tr>
        <th>
            重复密码
        </th>
        <td>
            <input type="password" name="lp_new_user_passwordII">
        </td>
    </tr>
    <tr>
        <th>
            联系方式
        </th>
        <td>
            <input type="text" name="lp_new_user_phone_number">
        </td>
    </tr>
    <tr>
        <th>
            <img src="/ServletPackage/VerifyCodeServlet/VerifyCodeServlet">
        </th>
        <td>
            <button id="lp_new_user_verify_code_image">看不清，换一张</button>
        </td>
    </tr>
    <tr>
        <th>
            验证码
        </th>
        <td>
            <input type="text" name="l[p_new_user_verify_code">
        </td>
    </tr>
    <tr>
        <th>

        </th>
        <td>
            <input type="reset" value="重置" id="lp_new_user_reset">
            &nbsp;&nbsp;&nbsp;
            <<input type="submit" value="提交" id="lp_new_user_submit">
        </td>
    </tr>
</table>

<script type="text/javascript">

    document.getElementById("lp_new_user_verify_code_image").onclick = function () {
        // 获取img元素
        // 为了让浏览器发送请求到servlet, 所以一定要改变src
        document.getElementsByTagName("img")[0].src = "/ServletPackage/VerifyCodeServlet/VerifyCodeServlet"
            + "?time=" + new Date().getTime();
        ///day_1_12/VerifyCodeServlet?time=
    };
</script>

</body>
</html>
