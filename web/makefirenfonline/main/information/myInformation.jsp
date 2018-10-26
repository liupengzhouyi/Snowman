<%@ page import="java.sql.ResultSet" %>
<%@ page import="makefriend.makefriendonline.linkDatabases" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 10/26/2018
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的信息</title>
</head>
<body>
<%
    //获取当前会话
    HttpSession httpSession = request.getSession();
    //获取你的用户ID
    String user_id = (String) httpSession.getAttribute("user_id");
    //判断你的用户ID是否合法
    if(user_id == null) {
        //如果合法
        //开始获取用户数据
        String friend_id = "";
        String friend_name = "";
        //标示好友个数，同时也是判断时候拥有好友
        int i = -1;
        Map<String, String> friend_names_ids = new HashMap<String, String>();
        String sqlI = "select * from my_friends where my_id = \'" + user_id + "\';";
        String sqlII = " select *from my_friends where my_friend_id = \'" + user_id + "\';";
        //获取我的好友列表
        ResultSet resultSet = new linkDatabases().getInformation(sqlI);
        while(resultSet.next()) {
            friend_id = resultSet.getString("my_friend_id");
            friend_name = resultSet.getString("my_friend_name");
            //添加好友信息
            friend_names_ids.put(friend_name, friend_id);
            //好友个数自增
            i = i + 1;
        }
        resultSet = null;
        resultSet = new linkDatabases().getInformation(sqlII);
        while(resultSet.next()) {
            friend_id = resultSet.getString("my_id");
            friend_name = resultSet.getString("my_name");
            //添加好友信息
            friend_names_ids.put(friend_name, friend_id);
            //好友个数 自增
            i = i + 1;
        }
        System.out.println("好友个数" + i);
        //判断时候拥有好友
        if (i == -1) {
            //没有好友
            %>
<h1>
    <center>
        您没有好友，请尽快建立您的好友关系！
    </center>
</h1>
<%
            /*PrintWriter out = response.getWriter();
            out.println("");*/
        } else {
            //拥有好友

        }
    } else {
        //如果不合法
        //转到错误-》登录页面
        response.sendRedirect("/makefirenfonline/errorPage/login/errorForAddFriend.jsp");
    }
%>
    <table>

    </table>

</body>
</html>
