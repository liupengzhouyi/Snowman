package teacher_chu.work012;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "GetUserIDAndPasswordInformationServlet")
public class GetUserIDAndPasswordInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        String user_password = request.getParameter("user_password");
        System.out.println(user_id +":" + user_password);
        // 验证你的身份
        int key = 0;
        isUser lpIsUser = new isUser(user_id, user_password);
        try {
            key = lpIsUser.isUserRight();
            if (key == 1) {
                // 添加你的Session
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user_id", user_id);
                //跳转到显示用户信息
                response.sendRedirect("/teacher_chu/012/show.jsp");
            } else if (key == 0) {
                //跳转到没有该用户
                response.sendRedirect("/teacher_chu/012/errorPage/noUser.jsp");
            } else if (key == -1) {
                //跳转到密码错误
                response.sendRedirect("/teacher_chu/012/errorPage/PasswordError.jsp");
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
