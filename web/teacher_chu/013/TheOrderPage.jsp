<%@ page import="teacher_chu.work013.getGoodNameAndMoney" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2018/11/19
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String good_id = request.getParameter("good_id");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("good_id", good_id);
        getGoodNameAndMoney lpGetGoodNameAndMoney = new getGoodNameAndMoney(good_id);
        String good_name = lpGetGoodNameAndMoney.getGood_name();
        int money = lpGetGoodNameAndMoney.getMoney();
        String string = "/teacher_chu/013/img/00" + good_id + ".png";
    %>
    <div>
        <center>
            <form action="/teacher_chu/work013/SaveTeacherChuOrderServlet" method="post">
                <table border="1">
                    <tr>
                        <td>
                            <%=good_name%>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            样图
                        </td>
                        <td>
                            价格
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <img src="<%=string%>" widht="300" height="100">
                        </td>
                        <td>
                            <input type="number" name="number">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="reset" value="重置">
                        </td>
                        <td>
                            <input type="submit" value="确定">
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </div>
</body>
</html>
