<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/30
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>聊天</title>
</head>
<body>

<%
    HttpSession httpSession = request.getSession();
    String friend_id = (String) httpSession.getAttribute("char_friend_id");
%>

<form action="/makefriend/chat/SaveCharInformationServlet" method="post">
    <table>
        <tr>
            <th>
                <center>
                    <h2>
                        <%=friend_id%>
                    </h2>
                </center>
            </th>
        </tr>
        <tr>
            <td>
                <textarea name="charInformation" cols="30" rows="10"></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
