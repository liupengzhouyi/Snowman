<%--
  Created by IntelliJ IDEA.
  User: liupe
  Date: 10/21/2018
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<div>
    <center>
        <form action="" method="post">
            <table border="0">
                <tr style="background-color: #addd9e">
                    <th>
                        用户名
                    </th>
                    <td>
                        <input type="text" name="lp_user_name">
                    </td>
                </tr>
                <tr style="background-color: #8bffe9">
                    <th>
                        密码
                    </th>
                    <td>
                        <input type="password" name="lp_user_passowrd">
                    </td>
                </tr>
                <tr style="background-color: #addd9e">
                    <th>
                        验证码
                    </th>
                    <td>
                        <input type="text" name="lp_user_verifyCode">
                    </td>
                </tr>
                <tr style="background-color: #8bffe9">
                    <th>
                        <img src="/ServletPackage/VerifyCodeServlet/VerifyCodeServlet">
                    </th>
                    <th>
                        <button id="lp_button"><p>老子看不清楚！</p></button>
                    </th>
                </tr>
                <tr style="background-color: #addd9e">
                    <th>
                        <input type="reset" value="重置">
                    </th>
                    <th>
                        <input type="submit" value="提交">
                    </th>
                </tr>
            </table>
        </form>
    </center>
</div>

<script type="text/javascript">

    document.getElementById("lp_button").onclick = function () {
        // 获取img元素
        // 为了让浏览器发送请求到servlet, 所以一定要改变src
        document.getElementsByTagName("img")[0].src = "/ServletPackage/VerifyCodeServlet/VerifyCodeServlet"
            + "?time=" + new Date().getTime();
        ///day_1_12/VerifyCodeServlet?time=
    };
</script>

</body>
</html>
