<%@ page import="JavaBean.Test.getNowTime" %>
<%@ page import="JavaBean.linkDatabase.getSQLString" %>
<%@ page import="JavaBean.linkDatabase.linkDatabases" %>
<%@ page import="java.sql.SQLException" %><%--
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
    String datetime = date + " " + time;
    // System.out.print(datetime);
    //get your input
    String w = request.getParameter("w");
    String q = request.getParameter("q");
    String b = request.getParameter("b");
    String s = request.getParameter("s");
    String y = request.getParameter("y");
    String j = request.getParameter("j");
    String amount = w + q + b + s + y + "." + j;
    //get your input pay
    String account_class = request.getParameter("account_class");
    //get your input pay
    String pay = request.getParameter("pay");
    // get your input add text
    String addText = request.getParameter("addInformation");
    // up your information and get sql
    getSQLString lpGetSQLString = new getSQLString();
    lpGetSQLString.setSql9(datetime, amount, account_class, pay, addText);
    String sql = lpGetSQLString.getSql9();
    System.out.print(sql);
    //get link database
    linkDatabases lpLinkDatabases = null;
    boolean key = false;
    try {
        lpLinkDatabases = new linkDatabases();
        try {
            key = lpLinkDatabases.saveData(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
