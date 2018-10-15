package ServletPackage;

import JavaBean.Test.getNowTime;
import JavaBean.linkDatabase.getSQLString;
import JavaBean.linkDatabase.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "work2Servlet")
public class work2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        String l_name=request.getParameter("name");
        String l_phone=request.getParameter("phone");
        String l_email=request.getParameter("email");
        String l_title=request.getParameter("title");
        String l_content=request.getParameter("content");
        out.print("<table border=2>");
        out.print("<tr>");
        out.print("<td>姓名</td>");
        out.print("<td>"+l_name+"</td>");
        out.print("<td>电话</td>");
        out.print("<td>"+l_phone+"</td>");
        out.print("<td>Email</td>");
        out.print("<td>"+l_email+"</td>");
        out.print("<td>题目</td>");
        out.print("<td>"+l_title+"</td>");
        out.print("<td>内容</td>");
        out.print("<td>"+l_content+"</td>");
        try {
            String l_time = new getNowTime().getTime();
            getSQLString lpgetSQLString = new getSQLString();
            lpgetSQLString.setSqlForWord2_1(l_name, l_phone, l_email, l_title, l_content, l_time);
            String sql = lpgetSQLString.getSqlForWord2_1();
            linkDatabases lpLinkDatabases = new linkDatabases();
            boolean key = lpLinkDatabases.saveData(sql);
            if (key) {
                out.print("数据保存成功！");
            } else {
                out.print("数据保存失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
