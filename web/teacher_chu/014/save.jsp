<%@ page import="java.io.PrintWriter" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="makefriend.CreateID.getNowTime" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="JavaBean.linkDatabase.linkDatabases" %>
<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018-12-03
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    int key = 0 ;
%>
<html>
<head>
    <title></title>
</head>
<body>
<%
    //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
    response.setContentType("text/html;charset=UTF-8");

    String name = request.getParameter("name");
    String phone =request.getParameter("phone");
    String email = request.getParameter("email");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    try {

        String time = new getNowTime().getTime();

        String sql="insert into guestbook (name,phone,email,title,content,time) " +
                "values (\'" + name + "\',\'" + phone + "\',\'" + email + "\',\'" + title + "\',\'" + content + "\',\'" + time + "\');";

        linkDatabases lpLinkDatabases = new linkDatabases();
        lpLinkDatabases.saveData(sql);
%>
<h1>
    <center>
        留言保存成功！
    </center>
</h1>
<hr>
<h3>
    <center>
        <a href="/teacher_chu/014/index.jsp">
            点我返回
        </a>
    </center>
</h3>
<%
    } catch (SQLException e) {
%>
<h1>
    <center>
        数据保存出错
    </center>
</h1>
<hr>
<h3>
    <center>
        <a href="/teacher_chu/014/index.jsp">
            点我返回
        </a>
    </center>
</h3>
<%
        e.printStackTrace();
    }
    out.close();
%>

</body>
</html>
