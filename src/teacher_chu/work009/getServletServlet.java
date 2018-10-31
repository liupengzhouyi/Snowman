package teacher_chu.work009;

import makefriend.CreateID.getNowTime;
import teacher_chu.javaBean.GuestBook;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

@WebServlet(name = "getServletServlet")
public class getServletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String phone =request.getParameter("phone");
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String content = request.getParameter("content");


        PrintWriter out = response.getWriter();

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
        out.println("</table>");
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

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (NamingException e) {
                e.printStackTrace();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
