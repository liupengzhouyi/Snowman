<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/9/27
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加GitHub记录</title>
</head>
<body>
<form action="getyourinformation8.jsp" method="post" accept-charset="UTF-8">
    <table width="1300" border="0" align="center">
        <tr>
            <td style="background-color:#ff7c2b;width:1300px;height:80px;">
                <h1>
                    <center>
                        添加GitHub记录
                    </center>
                </h1>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:275px;">
                <center>
                    <h3>
                        请输入您的GitHub项目名
                    </h3>
                    <input type="text" name="lp_github_name">
                </center>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:275px;">
                <center>
                    <h3>
                        请输入您的GitHub项目网址
                    </h3>
                    <input type="text" name="lp_github_url">
                </center>
            </td>
        </tr>
        <tr>
            <td style="background-color:#9656ee;width:1300px;height:100px;">
                <center>
                    <table>
                        <tr>
                            <td>
                                <button type="reset"><p>重置</p></button>
                            </td>
                            <td>
                                <button type="submit"><p>提交</p></button>
                            </td>
                        </tr>
                    </table>
                </center>
            </td>
        </tr>
    </table>
</form>
<%@include file="tail.jsp"%>
</body>
</html>
