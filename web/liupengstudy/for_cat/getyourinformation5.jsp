<%@ page import="JavaBean.Test.getNowTime" %>
<%@ page import="JavaBean.linkDatabase.getSQLString" %>
<%@ page import="JavaBean.linkDatabase.linkDatabases" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/27
  Time: 下午8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String number = request.getParameter("number");
    // get today's date
    getNowTime lpGetNowTime = new getNowTime();
    String date = lpGetNowTime.getDate();
    //add parameters and get sql
    getSQLString lpGetSQLString = new getSQLString();
    lpGetSQLString.setSql5(date, number);
    String sql = lpGetSQLString.getSql5();
    //
    linkDatabases lpLinkDatabases = null;
    try {
        lpLinkDatabases = new linkDatabases();
        try {
            boolean key = lpLinkDatabases.saveData(sql);
            if (key) {
                System.out.print(111);
            } else {
                System.out.print(222);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
