package makefriend.BreakWithFriend;

import makefriend.makefriendonline.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "getMyFriendListServlet")
public class getMyFriendListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String user_id = (String) httpSession.getAttribute("user_id");
        String friend_id = (String) httpSession.getAttribute("friend_id");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 通过你的ID与朋友的ID绝交
     * @param user_id
     * @param friend_id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int findMyFriend(String user_id, String friend_id) throws ClassNotFoundException, SQLException {
        //返回值
        int returnKey = -1;
        linkDatabases lpLinkDatabases = new linkDatabases();
        //获取建立友谊的编号
        String sql = "select friend_id from my_friends where " +
                "(my_id = \'" + user_id + "\' and friend_id = \'" + friend_id + "\') " +
                "or (my_id = \'" + user_id + "\' and friend_id = \'" + friend_id + "\');";
        ResultSet resultSet = lpLinkDatabases.getInformation(sql);
        int friend_ship_id = -1;
        while(resultSet.next()) {
            friend_ship_id = resultSet.getInt("friend_id");
        }

        sql = "update my_friends set friendship = 0 where friend_id = " + friend_ship_id + ";";

        if (friend_ship_id == -1) {
            //没有获取到建立友谊表中的编号
            returnKey = -1;
        } else {
            lpLinkDatabases.updateData(sql);
            //删除完成
            returnKey = 1;
        }
        return returnKey;
    }
}
