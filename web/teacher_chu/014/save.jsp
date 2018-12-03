<%@ page import="java.io.PrintWriter" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="makefriend.CreateID.getNowTime" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.naming.NamingException" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018-12-03
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


    /*PrintWriter out = response.getWriter();

    out.print("<table border=2>");
    out.print("<tr>");
    out.print("<td>姓名</td>");
    out.print("<td>"+name+"</td>");
    out.print("<td>电话</td>");
    out.print("<td>"+phone+"</td>");
    out.print("<td>Email</td>");
    out.print("<td>"+email+"</td>");
    out.print("<td>题目</td>");
    out.print("<td>"+title+"</td>");
    out.print("<td>内容</td>");
    out.print("<td>"+content+"</td>");
    out.println("<tr>");
    out.println("</table>");*/
    //GuestBook guestBook = new GuestBook(name, phone, email, title, content);

    Context context = null;
    try {
        context = new InitialContext();
        DataSource ds= null;
        try {
            ds = (DataSource)context.lookup("java:/comp/env/database_for_java_web");
            try {
                Connection con=ds.getConnection();

                String time = new getNowTime().getTime();

                String sql="insert into guestbook (name,phone,email,title,content,time) value(?,?,?,?,?,?)";

                PreparedStatement pstmt=con.prepareStatement(sql);

                pstmt.setString(1, name);
                pstmt.setString(2, phone);
                pstmt.setString(3, email);
                pstmt.setString(4, title);
                pstmt.setString(5, content);
                pstmt.setString(6, time);

                int i=pstmt.executeUpdate();

                pstmt.close();
                response.sendRedirect("/teacher_chu/014/end.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("/teacher_chu/014/error.jsp");
            }
        } catch (NamingException e) {
            e.printStackTrace();
            response.sendRedirect("/teacher_chu/014/error.jsp");
        }
    } catch (NamingException e) {
        e.printStackTrace();
        response.sendRedirect("/teacher_chu/014/error.jsp");
    }
    out.close();
%>
</body>
</html>
