<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/27
  Time: 下午3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <%@include file="head.jsp"%>
    <table width="1300" align="center">
        <tr>
            <td style="background-color:#ff9499;width:260px;height:800" align="center">

            </td>
            <td style="background-color:#e1eede;width:1040px;height:800px;">
                <table align="center" width="1000">
                    <%
                        String str1 = new String();
                        String str2 = new String();
                        String[] strings  = new String[11];
                        // 这个属于硬编码
                        strings[1] = "打卡早上起床时间";
                        strings[2] = "打卡午睡时间";
                        strings[3] = "打卡午睡起床时间";
                        strings[4] = "打卡晚上休息时间";
                        strings[5] = "记录词汇量";
                        strings[6] = "记录阅读量";
                        strings[7] = "添加博客记录";
                        strings[8] = "添加GitHub记录";
                        strings[9] = "添加消费记录";
                        strings[10] = "添加消费类别";
                        str1 = "style=\"background-color:#47e9ee;width:1000px;height:80px;\"";
                        str2 = "style=\"background-color:#eee353;width:1000px;height:80px;\"";
                        for (int i=1;i<=10;i++) {
                    %>
                    <tr>
                        <td <%if (i%2==0) {%>
                                <%=str1%>
                            <% } else { %>
                                <%=str2%>
                            <% } %>
                                <%="align=\"center\""%>
                        </td>
                        <a href="setyourinformation<%=i%>.jsp"><h1><%=strings[i]%></h1></a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </td>
        </tr>
    </table>
    <%@include file="tail.jsp"%>
</body>
</html>
