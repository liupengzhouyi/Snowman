<%@ page import="java.util.List" %>
<%@ page import="teacher_chu.work016.Model.Guestbook" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018-12-12
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC显示数据</title>
</head>
<body>
<table border="1">

<%
    HttpSession httpSession = request.getSession();
    List<Guestbook> list = (List) httpSession.getAttribute("list");

    for (Guestbook guestbook : list
            ) {
        %>
<tr>
    <td>
        <%=guestbook.getId()%>
    </td>
    <td>
        <%=guestbook.getName()%>
    </td>
    <td>
        <%=guestbook.getPhone()%>
    </td>
    <td>
        <%=guestbook.getEmail()%>
    </td>
    <td>
        <%=guestbook.getTitle()%>
    </td>
    <td>
        <%=guestbook.getContent()%>
    </td>
    <td>
        <%=guestbook.getTime()%>
    </td>
</tr>

<%
    }
%>

</table>

</body>
</html>
