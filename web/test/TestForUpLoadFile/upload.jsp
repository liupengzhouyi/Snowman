<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/22
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>using commons Upload to upload file </title>
</head>

<body>
<form action="/ServletPackage/FlieUpToNetwork/SimpleFileuploadServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="file" size="50">
    <input type="submit" value="提交">
</form>
</body>
</html>