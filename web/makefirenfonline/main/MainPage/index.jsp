<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/11/1
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>交友网</title>
</head>
<body>
<table border="1">
    <tr>
        <td>
            <a href="/makefirenfonline/friends/AddFriend.jsp">添加新朋友</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/makefriend/findFriend/ShowMyFriendServlet">我的好友列表</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/makefriend/AddFriend/GetFriendRequestServlet">我的新好友</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/makefriend/chat/GetTieServlet">我的新信息</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/makefriend/chat/FindFriendToChatServlet">聊天</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/makefriend/BreakWithFriend/showMyFriendServlet">绝交</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/makefirenfonline/about/about.jsp">关于</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/makefriend/outLogin/outLoginServlet">退出</a>
        </td>
    </tr>
</table>
</body>
</html>
