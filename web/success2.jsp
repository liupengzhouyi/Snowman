<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/21
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>成功登录</title>
</head>
<body>
<%
    // 获取用户信息
    String username = (String) session.getAttribute("username");

    if (username == null) {
        // 保存错误信息到request中, 然后转发到login3.jsp中, 提醒登录
        request.setAttribute("message", "请登录!");

        // 转发到登录页面
        request.getRequestDispatcher("/jsp/login3.jsp").forward(request, response);
    }
%>
<h2>欢迎登录:${sessionScope.username}!!!</h2>
</body>
</html>