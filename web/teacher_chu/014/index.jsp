<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018-12-03
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 实现网络留言板</title>
</head>
<body>

<%--<form action="/teacher_chu/work009/getServletServlet" method="post">--%>
<form action="save.jsp" method="post">
    姓名：
    <input type="text" name="name" value=""><br>
    电话：
    <input type="text" name="phone" value=""><br>
    Email：
    <input type="text" name="email" value=""><br>
    主题：
    <input type="text" name="title" value=""><br>
    内容：
    <input type="text" name="content" value=""><br>
    <input type="reset" value="重置">&nbsp;&nbsp;
    <input type="submit" value="提交">
</form>

</body>
</html>
