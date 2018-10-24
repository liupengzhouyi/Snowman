<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/23
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的</title>
</head>
<body>

<%
    HttpSession httpSession = request.getSession();
    // 获取用户ID
    //String user_id = httpSession.getAttribute("user_id");


%>

<a href="/我的租房网/我的/showMyHouse.jsp">
    <button type="button" >
        我的房源
    </button>
</a>

<a href="/我的租房网/我的/showMyOrderFrom.jsp">
    <button type="button" >
        我的租房
    </button>
</a>

</body>
</html>
