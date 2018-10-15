<%@ page import="JavaBean.linkDatabase.getSQLString" %>
<%@ page import="JavaBean.linkDatabase.linkDBByDBCP" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/15
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>货架</title>
</head>
<body>
    <h1>
        <center>
            添加订单
        </center>
    </h1>
<hr>
<form action="/Session/getOrderServlet" method="post">
    商品名
    <select name="name">
    <%
        getSQLString lpGetSQLString = new getSQLString();
        lpGetSQLString.setSql14();
        String sql = lpGetSQLString.getSql14();

        //获取SQL语句
        linkDBByDBCP lpLinkDBByDBCP = new linkDBByDBCP();
        if (lpLinkDBByDBCP != null) {
            ResultSet resultSet = lpLinkDBByDBCP.getData(sql);
            while(resultSet.next()){
                String goodName = resultSet.getString("good_name");
                %>
                <option><%=goodName%></option>
        <%
            }
        }
    %>
    </select>
    &nbsp;&nbsp;
    数量
    <select name="number">
        <%
            for(int i=0;i<10;i++) {
        %>
        <option><%=i%></option>
        <%
            }
        %>
    </select>
    <input type="submit" value="添加订单">&nbsp;&nbsp;&nbsp;
    <input type="reset" value="重置">
</form>
</body>
</html>
