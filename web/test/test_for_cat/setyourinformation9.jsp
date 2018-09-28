<%@ page import="JavaBean.linkDatabase.linkDatabases" %>
<%@ page import="JavaBean.linkDatabase.getSQLString" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/27
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加消费记录</title>
</head>
<body>
<form action="getyourinformation9.jsp" method="post" accept-charset="UTF-8">
    <%
        request.setCharacterEncoding("UTF-8");
    %>
    <table width="1300" border="0" align="center">
        <tr>
            <td style="background-color:#ff7c2b;width:1300px;height:80px;">
                <h1>
                    <center>
                        添加消费记录
                    </center>
                </h1>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:100px;">
                <center>
                    <h3>
                        消费时间：
                        <select name="h">
                            <%
                                for(int i=1;i<24;i++) {
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                        时&nbsp;
                        <select name="m">
                            <%
                                for(int i=1;i<60;i++) {
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                        分&nbsp;
                        <select name="s">
                            <%
                                for(int i=1;i<60;i++) {
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                        秒
                    </h3>
                </center>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:100px;">
                <center>
                    <h3>
                        消费金额
                        <select name="w">
                            <%
                                for(int i=0;i<10;i++) {
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                        万&nbsp;
                        <select name="q">
                            <%
                                for(int i=0;i<10;i++) {
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                        仟&nbsp;
                        <select name="b">
                            <%
                                for(int i=0;i<10;i++) {
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                        佰&nbsp;
                        <select name="s">
                            <%
                                for(int i=0;i<10;i++) {
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                        拾&nbsp;
                        <select name="y">
                            <%
                                for(int i=0;i<10;i++) {
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                        圆&nbsp;
                        <select name="j">
                            <%
                                for(int i=0;i<10;i++) {
                            %>
                            <option><%=i%></option>
                            <%
                                }
                            %>
                        </select>
                        角
                    </h3>
                </center>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:100px;">
                <center>
                    <h3>
                        消费项目
                        <%
                            linkDatabases lpLinkDatabases = null;
                            try {
                                lpLinkDatabases = new linkDatabases();
                                getSQLString lpGetSQLString = new getSQLString();
                                lpGetSQLString.setSqlForGetclass();
                                String sql = lpGetSQLString.getSqlForGetclass();
                                try {
                                    ArrayList listName = new ArrayList();
                                    ArrayList listId = new ArrayList();
                                    ResultSet resultSet = lpLinkDatabases.getInformation(sql);
                                    while(resultSet.next()){
                                        // 通过字段检索
                                        int id  = resultSet.getInt("lp_id");
                                        String name = resultSet.getString("lp_name");
                                        listName.add(name);
                                        listId.add(id);
                                    }
                        %>
                        <select name="account_class">
                            <%
                                for(int i=0;i<listName.size();i++) {
                            %>
                            <option value="<%=listId.get(i)%>"><%=listName.get(i).toString()%></option>
                            <%
                                }
                            %>
                        </select>
                        <%
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        %>
                    </h3>
                </center>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:75px;">
                <center>
                    <h3>
                        收支情况
                        <input type="radio" name="pay" value="a">收入&nbsp;&nbsp;
                        <input type="radio" name="pay" value="s">支出
                    </h3>
                </center>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:175px;">
                <center>
                    <h3>
                        备注
                    </h3>
                    <textarea name="addInformation" id="addInformation" cols="60" rows="10"></textarea>
                </center>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:100px;">
                <center>
                    <table>
                        <tr>
                            <td>
                                <button type="reset"><p>重置</p></button>
                            </td>
                            <td>
                                <button type="submit"><p>提交</p></button>
                            </td>
                        </tr>
                    </table>
                </center>
            </td>
        </tr>
    </table>
</form>
<%@include file="tail.jsp"%>
</body>
</html>
