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
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

        ArrayList<String> friendList = new ArrayList<String>();
        boolean keyOfLinkdatabase = false;
        String sqlI = "select * from my_friends where my_id = \'" + user_id + "\' and friendship = 1;";
        String sqlII = "select * from my_friends where my_friend_id = \'" + user_id + "\' and friendship = 1;";

        try {
            linkDatabases lpLinkDatabases = new linkDatabases();
            ResultSet resultSet = lpLinkDatabases.getInformation(sqlI);

            while(resultSet.next()) {
                //好友编号
                String friend_id = resultSet.getString("my_friend_id");
                //System.out.println(friend_id);
                friendList.add(friend_id);

            }
            lpLinkDatabases = new linkDatabases();
            resultSet = null;
            resultSet = lpLinkDatabases.getInformation(sqlII);
            keyOfLinkdatabase = true;
            while(resultSet.next()) {
                //好友编号
                String friend_id = resultSet.getString("my_id");
                //System.out.println(friend_id);
                friendList.add(friend_id);
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

        if (keyOfLinkdatabase == true) {
            out.println("<table border=\"1\">\n" +
                    "        <tr>\n" +
                    "            <th colspan=\"2\">\n" +
                    "                    我的好友列表\n" +
                    "                    </th>\n" +
                    "        </tr>");
            for (int i=0;i<friendList.size();i++) {
                //System.out.println(friendList.get(i));
                out.println("<tr>\n" +
                        "        <td>" + friendList.get(i) + "</td>\n" +
                        "    </tr>");
            }
            out.println("</table>");
        } else {
            //连接数据库出错
            // 连接数据库失败， 跳转 联系我们
            response.sendRedirect("/makefirenfonline/errorPage/make_friend/notlinkdatabase/notlinkdatabase.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
