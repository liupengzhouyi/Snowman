<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/21
  Time: 下午5:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    function reloadImage(t) {
        t.src = "./ImageServlet?flag = " + Math.random();
    }
</script>
<html>
<head>
    <title></title>
</head>
<body>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServletPath() + path + "/";
    %>
    <center>
        <form action="" method="post">
            <table>
                <tr>
                    <td colspan="2" align="center">
                        用户登录
                    </td>
                </tr>
                <tr><td>登录名：</td><td><input type="text" name="user"></td></tr>
                <tr><td>密码：</td><td><input type="password" name="password"></td></tr>
                <tr><td>验证码：</td>
                    <td><input type="text" name="checkcode">
                        <img src="./ImageServlet" align="middle" alt="看不清，点击这里！"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="提交">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
