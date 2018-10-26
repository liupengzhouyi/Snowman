<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/26
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录错误</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    String kind_of_error = (String) httpSession.getAttribute("error");
    String errorInformation = "";
    if (kind_of_error.equals("1")){
        errorInformation = "验证码错误";
    } else if(kind_of_error.equals("2")) {
        errorInformation = "密码错误";
    } else if (kind_of_error.equals("3")) {
        errorInformation = "没有该用户";
    }
%>

<h1>
    <center>
        <%=errorInformation%>
    </center>
</h1>
<hr>
<p>
    <center>
    <a href="/makefirenfonline/login/index.jsp">点我返回</a>
</center>
</p>
</body>
</html>
