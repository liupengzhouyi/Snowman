<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/21
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<%
    // 获取浏览器发送过来的cookie, 获取用户信息
    Cookie[] cookies = request.getCookies();
    String username = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            }
        }
    }
%>

<%--<font color="red">${requestScope.message}</font>--%>
<form action="/ServletPackage/VerifyCodeServlet/LoginServlet3" method="post">
    用户名:<input type="text" name="username" value="<%= username%>"><font color="red">${requestScope.error}</font>
    <br>
    密码:<input type="password" name="password">
    <br>
    验证码:<input type="text" name="image">
    <img src="/ServletPackage/VerifyCodeServlet/VerifyCodeServlet">
    <input type="button" value="看不清? 换一张." id="btn"><font color="red">${requestScope.imageMess}</font>
    <br>
    <input type="submit" value="登录">
</form>



//
<script type="text/javascript">

    document.getElementById("btn").onclick = function () {
        // 获取img元素
        // 为了让浏览器发送请求到servlet, 所以一定要改变src
        document.getElementsByTagName("img")[0].src = "/ServletPackage/VerifyCodeServlet/VerifyCodeServlet"
            + "?time=" + new Date().getTime();
        ///day_1_12/VerifyCodeServlet?time=
    };
</script>

</body>
</html>
