<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/24
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线交友网</title>
</head>
<body>

<%
    HttpSession httpSession = request.getSession();
    String user_id = "-1";
    if (httpSession.isNew()) {
        user_id = "-1";
    } else {
        user_id = (String) httpSession.getAttribute("user_id");
    }
%>

<table width="1300" border="0" align="center">
    <tr>
        <td colspan="2" style="background-color:#7479ff;">
            <h1 align="center">在线交友网（Beat版本）</h1>
        </td>
    </tr>
</table>
    <a href="/makefirenfonline/login/index.jsp"><button type="button">登录</button></a>
    <a href="/makefirenfonline/signin/index.jsp"><button type="button">注册</button></a>
</body>
</html>
