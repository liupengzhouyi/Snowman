package makefriend.chat;

import makefriend.makefriendonline.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SaveCharInformationServlet")
public class SaveCharInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取聊天信息
        String text = request.getParameter("charInformation");
        //获取用户
        HttpSession httpSession = request.getSession();
        String user_id = (String) httpSession.getAttribute("user_id");
        String friend_id = (String) httpSession.getAttribute("char_friend_id");

        text = getText(text);

        //用户聊天数据表的构建
        //第一次
        /*String sql = "insert into char_information (char_id, user_id, friend_id, text, char_data_time)" +
                "values (1, \'" + user_id + "\', \'" + friend_id + "\', \'" + text + "\', now());";

        String sqlI = "insert into char_tie(tie_id, user_id, is_new) values (1, \'" + friend_id + "\', 0);\n";*/
        // 第二次
        String sql = "insert into char_information (user_id, friend_id, text, char_data_time)" +
                "values (\'" + user_id + "\', \'" + friend_id + "\', \'" + text + "\', now());";
        String sqlI = "insert into char_tie(user_id, is_new) values (\'" + friend_id + "\', 0);\n";

        System.out.println(sql);

        //数据储存
        try {
            //储存数据
            this.saveData(sql);
            //储存提示
            this.saveData(sqlI);
        } catch (ClassNotFoundException e) {
            //数据储存出错
            response.sendRedirect("");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据储存出错, 提交俩天信息学出错
            response.sendRedirect();
            e.printStackTrace();
        }

        //跳转
        response.sendRedirect("/makefriend/findFriend/ShowMyFriendServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public String getText(String text) {
        return text;
    }

    public void saveData(String sql) throws ClassNotFoundException, SQLException {
        linkDatabases lpLinkDatabases = new linkDatabases();
        lpLinkDatabases.saveData(sql);
    }
}