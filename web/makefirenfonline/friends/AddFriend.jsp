<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/26
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加好友</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    String user_id = "-1";
    if (httpSession.isNew()) {
        //没有获取到Session，请您先登录
        //跳转页面
        response.sendRedirect("/makefirenfonline/errorPage/login/errorForAddFriend.jsp");
    } else {
        //获取Session，确定你的用户
        user_id = (String) httpSession.getAttribute("user_id");
        //
        if (user_id == null) {
            response.sendRedirect("/makefirenfonline/errorPage/login/errorForAddFriend.jsp");
        }
        //开始添加你的好友

        //提交表单数据，判断你的好友，如果你的好友存在，我们会给他发送一个信息。
    }
%>

<h1><%=user_id%></h1>

<form action="/makefriend/AddFriend/MakeFriendServlet", method="post" >
    <table>
        <tr style="background: #8bffe9">
            <th colspan="3">
                <center>
                    添加我的好友
                </center>
            </th>
        </tr>
        <tr style="background: #ff7c2b">
            <th content="1">
                <center>
                    好友账号
                </center>
            </th>
            <td colspan="2">
                <conter>
                    <input type="text" name="friend_id" style="background: #e7eee9">
                </conter>
            </td>
        </tr>
        <tr style="background: #ff7c2b">
            <th content="1">
                <center>
                    好友昵称
                </center>
            </th>
            <td colspan="2">
                <conter>
                    <input type="text" name="friend_name" style="background: #e7eee9">
                </conter>
            </td>
        </tr>
        <tr style="background: #eeebbc">
            <th>

            </th>
            <th style="background: #d2ff9e">
                <button style="background: red" type="reset">重置</button>
            </th>
            <th style="background: coral">
                <button style="background: chartreuse" type="submit">提交</button>
            </th>
        </tr>
    </table>
</form>
</body>
</html>
