<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/30
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网络留言本</title>
</head>
<body>
<form action="/teacher_chu/work016/Controller/GetInputGeastBookInformationServlet" method="post">
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
