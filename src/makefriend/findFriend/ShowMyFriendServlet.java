package makefriend.findFriend;

import makefriend.makefriendonline.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ShowMyFriendServlet")
public class ShowMyFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前的Session
        HttpSession httpSession = request.getSession();
        //获取当前用户编号
        String user_id = (String) httpSession.getAttribute("user_id");
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //生产你的SQL语句
        String sqlsql = "select * from apply_return where my_id = \'" + user_id + "\';";
        try {
            linkDatabases lpLinkDatabases = new linkDatabases();
            ResultSet resultSet = lpLinkDatabases.getInformation(sqlsql);
            String sql = "null";
            while(resultSet.next()) {
                //好友编号
                String friend_id = resultSet.getString("friend_id");
                //好友的态度
                int friend_activita = resultSet.getInt("can_make");
                if (friend_activita == 1) {
                    //同意
                    sql = friend_id + "编号的好友，与您建立了友谊的小桥！";
                } else {
                    //不同意
                    sql = friend_id + "编号的好友，好像对您不感兴趣！";
                }
                if (sql == "null") {
                    out.println("<h3>" + "没有好友" + "</h3>");
                } else {
                    out.println("<h3>" + sql + "</h3>");
                }
            }
        } catch (ClassNotFoundException e) {
            // 连接数据库失败， 跳转 联系我们
            response.sendRedirect("/makefirenfonline/errorPage/make_friend/notlinkdatabase/notlinkdatabase.jsp");
            e.printStackTrace();
        } catch (SQLException e) {
            // 连接数据库失败， 跳转 联系我们
            response.sendRedirect("/makefirenfonline/errorPage/make_friend/notlinkdatabase/notlinkdatabase.jsp");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
