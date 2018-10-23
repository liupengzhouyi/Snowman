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
    <title>Title</title>
</head>
<body>
<%
    String account_class = request.getParameter("lp_account_class");
    account_class = new String(account_class.getBytes("ISO-8859-1"),"utf-8");
    getSQLString lpGetSQLString = new getSQLString();
    lpGetSQLString.setSql10(account_class);
    String sql = lpGetSQLString.getSql10();
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
