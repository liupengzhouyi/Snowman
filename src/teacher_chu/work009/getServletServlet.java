package teacher_chu.work009;

import teacher_chu.javaBean.GuestBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getServletServlet")
public class getServletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String name = request.getParameter("name");
         String phone =request.getParameter("phone");
         String email = request.getParameter("email");
         String title = request.getParameter("title");
         String content = request.getParameter("content");

        //GuestBook guestBook = new GuestBook(name, phone, email, title, content);

        String sql = "insert into guestbook(name, phone, email, title, content, time) " +
                "VALUES (\'"+ name + "\', \'" + phone + "\', \'" + email + "\', " +
                "\'" + title + "\', \'" + content + "\', \'" + title + "\')";

         
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
