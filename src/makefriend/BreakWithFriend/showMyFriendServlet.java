package makefriend.BreakWithFriend;

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
import java.util.ArrayList;

@WebServlet(name = "showMyFriendServlet")
public class showMyFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showMyFriend(request, response);
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

    public void showMyFriend(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        //获取当前的Session
        HttpSession httpSession = request.getSession();
        //获取当前用户编号
        String user_id = (String) httpSession.getAttribute("user_id");
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //生产你的SQL语句

        ArrayList<String> friendList = new ArrayList<String>();
        boolean keyOfLinkdatabase = false;
        String sqlI = "select * from my_friends where my_id = \'" + user_id + "\' and friendship = 1;";
        String sqlII = "select * from my_friends where my_friend_id = \'" + user_id + "\' and friendship = 1;";
        linkDatabases lpLinkDatabases = new linkDatabases();

        ResultSet resultSet = lpLinkDatabases.getInformation(sqlI);
        int number = 0;
        while(resultSet.next()) {
            number = number + 1;
            //好友编号
            String friend_id = resultSet.getString("my_friend_id");
            //System.out.println(friend_id);
            friendList.add(friend_id);
            keyOfLinkdatabase = true;
        }
        lpLinkDatabases = new linkDatabases();
        resultSet = null;
        resultSet = lpLinkDatabases.getInformation(sqlII);
        while(resultSet.next()) {
            number = number + 1;
            //好友编号
            String friend_id = resultSet.getString("my_id");
            //System.out.println(friend_id);
            friendList.add(friend_id);
            keyOfLinkdatabase = true;
        }

        if (keyOfLinkdatabase == true) {
            httpSession.setAttribute("number", "" + number);
            out.println("<form action=\"/makefriend/BreakWithFriend/getMyFriendListServlet\" method=\"post\">\n" +
                        "    <table border=\"1\">\n" +
                        "        <tr>\n" +
                        "            <th colspan=\"2\">\n" +
                        "                我的好友列表\n" +
                        "            </th>\n" +
                        "        </tr>");
            for (int i=0;i<friendList.size();i++) {
                //System.out.println(friendList.get(i));
                String friend_id = friendList.get(i);
                //断绝关系的标示
                String friend_id_i = friend_id + "1";
                //保持关系的标示
                String friend_id_ii = friend_id + "0";
                String friend_id_s = "friend_id_" + i;
                out.println("<tr>\n" +
                            "    <td>\n" +
                            "        " + friend_id +
                            "    </td>\n" +
                            "    <td>\n" +
                            "        划清界限<input type=\"radio\" name=\"" + friend_id_s + "\" value=\"" + friend_id_i + "\">\n" +
                            "        保持关系<input type=\"radio\" name=\"" + friend_id_s + "\" value=\"" + friend_id_ii + "\">\n" +
                            "    </td>\n" +
                            "</tr>");

            }
            out.println("        <tr>\n" +
                        "            <td>\n" +
                        "                <input type=\"reset\" value=\"重置\">\n" +
                        "            </td>\n" +
                        "            <td>\n" +
                        "                <input type=\"submit\" value=\"提交\">\n" +
                        "            </td>\n" +
                        "        </tr>");
            out.println("   </table>\n" +
                         "</form>");
        } else {
            //连接数据库出错
            // 连接数据库失败， 跳转 联系我们
            response.sendRedirect("/makefirenfonline/errorPage/make_friend/notlinkdatabase/notlinkdatabase.jsp");
        }
    }

}
