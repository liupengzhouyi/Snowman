package makefriend.chat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SaveCharInformationServlet")
public class SaveCharInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取聊天信息
        String text = request.getParameter("charInformation");
        //获取用户
        HttpSession httpSession = request.getSession();
        String user_id = (String) httpSession.getAttribute("user_id");
        String friend_id = (String) httpSession.getAttribute("char_friend_id");

        //用户聊天数据表的构建

        String sql = "insert into char_information (char_id, user_id, friend_id, text, char_data_time)" +
                "values (1, \'" + user_id + "\', \'" + friend_id + "\', \'\', now());";

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
