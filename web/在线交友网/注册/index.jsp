<%@ page import="JavaBean.Tools.makefriendonline.getPrivices" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/10/24
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线交友网注册</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    if (httpSession.isNew()) {
        httpSession.setAttribute("test", "test");
    } else {
        httpSession.setAttribute("test", "test");
    }
%>
<form action="/makefriend/GetUserInformationServlet" method="post">
    <table border="1">
        <tr>
            <th colspan="3">
                用户注册
            </th>
        </tr>
        <tr>
            <th colspan="1">
                请输入你的电子邮件
            </th>
            <td colspan="2">
                <input type="email" name="user_email">
            </td>
        </tr>
        <tr>
            <th colspan="1">
                用户名
            </th>
            <td colspan="2">
                <input type="text" name="user_name">
            </td>
        </tr>
        <tr>
            <th colspan="1">
                设置密码
            </th>
            <td colspan="2">
                <input type="password" name="user_passwordI">
            </td>
        </tr>
        <tr>
            <th colspan="1">
                再次输入密码
            </th>
            <td colspan="2">
                <input type="password" name="user_passwordII">
            </td>
        </tr>
        <tr>
            <th colspan="1">
                个人手机号码
            </th>
            <td colspan="2">
                <input type="text" name="user_phone">
            </td>
        </tr>
        <tr>
            <th colspan="1">
                选择你的省份
            </th>
            <td colspan="2">
                <%--<select name="privince">
                    <%
                        getPrivices lpGetPrivices = new getPrivices();
                        String[] strings = lpGetPrivices.getPrivices();
                        for (int i=0;i<strings.length;i++) {
                            String name = strings[i];
                    %>
                    <option><%=name%></option>
                    <%
                        }
                    %>--%>
                </select>
            </td>
        </tr>
        <tr >
            <th colspan="1">
                验证码
            </th>
            <th colspan="1">
                <img src="/ServletPackage/VerifyCodeServlet/VerifyCodeServlet">
            </th>
            <td colspan="1">
                <button type="button" id="lp_button">看不清，换一张！</button>
            </td>
        </tr>
        <tr>
            <th colspan="1">
                请输入验证码
            </th>
            <td colspan="2">
                <input type="text" name="verify_code">
            </td>
        </tr>
        <tr>
            <td colspan="1.5">
                <button type="reset">重置</button>
            </td>
            <td colspan="1.5">
                <button type="submit">提交</button>
            </td>
        </tr>
    </table>
</form>
    <script type="text/javascript">

        document.getElementById("lp_button").onclick = function () {
            // 获取img元素
            // 为了让浏览器发送请求到servlet, 所以一定要改变src
            document.getElementsByTagName("img")[0].src = "/ServletPackage/VerifyCodeServlet/VerifyCodeServlet"
                + "?time=" + new Date().getTime();
            ///day_1_12/VerifyCodeServlet?time=
        };
    </script>
    <%--////--%>
</body>
</html>
