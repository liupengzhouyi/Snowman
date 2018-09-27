<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/27
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打卡午睡起床时间</title>
</head>
<body>
<form action="getyourinformation3.jsp" method="post">
    <table width="1300" border="0" align="center">
        <tr>
            <td style="background-color:#ff7c2b;width:1300px;height:80px;">
                <h1>
                    <center>
                        打卡午睡起床时间
                    </center>
                </h1>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:550px;">
                <center>
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
