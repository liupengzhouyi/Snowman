<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/8
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="ServletPackage/work2Servlet">
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
