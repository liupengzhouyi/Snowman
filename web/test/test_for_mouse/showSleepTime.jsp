<%@ page import="JavaBean.linkDatabase.linkDatabases" %>
<%@ page import="JavaBean.linkDatabase.getSQLString" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Time" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/28
  Time: 下午7:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show sleep time</title>
</head>
<body>
<%@include file="head.jsp"%>
<table width="1300" border="0" align="center">
    <tr>
        <td style="background-color:#ff7c2b;width:1300px;height:800px;">
            <table width="500" align="center" border="1">
                <tr>
                    <th style="background-color: #d2ff9e" width="50px">
                        编号
                    </th>
                    <td width="80px">
                        日期
                    </td>
                    <td width="80px">
                        时间1
                    </td>
                    <td width="80px">
                        时间2
                    </td>
                    <td width="80px">
                        时间3
                    </td>
                    <td width="80px">
                        时间4
                    </td>
                </tr>
                <%
                    linkDatabases lpLinkDatabases = null;
                    ResultSet resultSet = null;
                    try {
                        lpLinkDatabases = new linkDatabases();
                        getSQLString lpGetSQLString = new getSQLString();
                        lpGetSQLString.setSql_sleep_table();
                        String sql = lpGetSQLString.getSql_sleep_table();
                        try {
                            resultSet = lpLinkDatabases.getInformation(sql);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                %>
                <%
                    if (resultSet == null) {
                        // 返回对象为空
                    } else {
                        //设置表格颜色标记
                        int temp = 0;
                        String strForColor1 = "style=\"background-color: #ffde8f\"";
                        String strForColor2 = "style=\"background-color: #ffbeea\"";
                        String strForColor = "";
                        while (resultSet.next()) {
                            if(temp == 1) {
                                temp = temp - 1;
                                strForColor = strForColor1;
                            } else {
                                temp = temp + 1;
                                strForColor = strForColor2;
                            }
                            int lp_id = resultSet.getInt("lp_id");
                            String lp_date = resultSet.getString("lp_date");
                            String lp_time1 = resultSet.getString("lp_time1");
                            String lp_time2 = resultSet.getString("lp_time2");
                            String lp_time3 = resultSet.getString("lp_time3");
                            String lp_time4 = resultSet.getString("lp_time4");
                            //Time lp_time4 = resultSet.getTime("lp_time4");
                            %>
                <tr>
                    <th <%=strForColor%>>
                        <%=lp_id%>
                    </th>
                    <td <%=strForColor%>>
                        <%=lp_date%>
                    </td>
                    <td <%=strForColor%>>
                        <%=lp_time1%>
                    </td>
                    <td <%=strForColor%>>
                        <%=lp_time2%>
                    </td>
                    <td <%=strForColor%>>
                        <%=lp_time3%>
                    </td>
                    <td <%=strForColor%>>
                        <%=lp_time4%>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </td>
    </tr>
</table>
<%@include file="tail.jsp"%>
</body>
</html>



