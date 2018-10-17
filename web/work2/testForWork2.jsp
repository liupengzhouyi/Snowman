<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/17
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="JavaBean.linkDatabase.linkDBByDBCP" %>
<%@ page import="JavaBean.linkDatabase.getSQLString" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>Java Web Work2 Link Database And Show Data</title>
</head>
<body>

<table border="1">
    <center>
        <%
            linkDBByDBCP lpLinkDBByDBCP = new linkDBByDBCP();
            getSQLString lpGetSQLString = new getSQLString();
            lpGetSQLString.setSqlForWord2_2();
            String sql = lpGetSQLString.getSqlForWord2_2();

            ResultSet resultSet = lpLinkDBByDBCP.getData(sql);

            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String time = resultSet.getString("time");

                out.print("<tr>");
                out.print("<td>姓名</td>");
                out.print("<td>"+name+"</td>");
                out.print("<td>电话</td>");
                out.print("<td>"+phone+"</td>");
                out.print("<td>Email</td>");
                out.print("<td>"+email+"</td>");
                out.print("<td>题目</td>");
                out.print("<td>"+title+"</td>");
                out.print("<td>内容</td>");
                out.print("<td>"+content+"</td>");
                out.print("<td>时间</td>");
                out.print("<td>"+time+"</td>");
                out.print("</tr>");
            }
        %>
    </center>
</table>
</body>
</html>
