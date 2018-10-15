package ServletPackage;

import JavaBean.linkDatabase.getSQLString;
import JavaBean.linkDatabase.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "work2getInformationServlet")
public class work2getInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        getSQLString lpGetSQLString = new getSQLString();
        lpGetSQLString.setSqlForWord2_2();
        String sql = lpGetSQLString.getSqlForWord2_2();
        try {
            out.print("<table>");
            linkDatabases lpLinkDatabases = new linkDatabases();
            ResultSet resultSet = lpLinkDatabases.getInformation(sql);
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String time = resultSet.getString("time");

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
                out.print("<td>时间</td>");
                out.print("<td>"+time+"</td>");
                out.print("</tr>");
            }
            out.print("</table>");
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
