<%@ page import="JavaBean.Test.getNowTime" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/27
  Time: 下午8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    // get your input time
    String strH = request.getParameter("h");
    String strM = request.getParameter("m");
    String strS = request.getParameter("s");
    String time = strH + ":" + strM + ":" + strS;
    // get today's date
    getNowTime lpGetNowTime = new getNowTime();
    String date = lpGetNowTime.getDate();

%>
</body>
</html>
