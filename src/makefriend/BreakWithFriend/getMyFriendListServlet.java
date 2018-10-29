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

@WebServlet(name = "getMyFriendListServlet")
public class getMyFriendListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession httpSession = request.getSession();
        String user_id = (String) httpSession.getAttribute("user_id");
        //获取提交数量
        String temp_number = "0";
        temp_number = (String) httpSession.getAttribute("number");
        int number = Integer.parseInt(temp_number);
        out.println("<table border=\"1\">");
        for(int i=0;i<number;i++) {
            String getValueKey = "friend_id_" + i;
            String friend_id = request.getParameter(getValueKey);
            boolean friendShipKey = this.getWhichDo(friend_id);
            friend_id = this.getFriendId(friend_id);
            if (friendShipKey == true) {
                //断绝关系
                try {
                    this.findMyFriend(user_id, friend_id);
                    //显示断绝关系
                    out.println("<tr>\n" +
                                "            <h1>\n" + friend_id +
                                "                断绝好友关系\n" +
                                "            </h1>\n" +
                                "        </tr>");
                } catch (ClassNotFoundException e) {

                    e.printStackTrace();

                } catch (SQLException e) {
                    e.printStackTrace();
                    //断绝关系出错
                }
            } else {
                //保持关系，不处理
            }
        }
        out.println("</table>");
        //String friend_id = (String) httpSession.getAttribute("friend_id");
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
                "(my_id = \'" + user_id + "\' and my_friend_id = \'" + friend_id + "\') " +
                "or (my_id = \'" + friend_id + "\' and my_friend_id = \'" + user_id + "\');";
        System.out.println(sql);
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

    /**
     * 返回尾数的标示
     * 1。 同意好友申请，true
     * 2。 拒绝好友申请， false
     * @param friend_id
     * @return
     */
    public boolean getWhichDo(String friend_id) {
        boolean returnKey = false;
        char c = friend_id.charAt(friend_id.length()-1);
        System.out.println("==" + c);
        if (c == '0') {
            returnKey = false;
        } else {
            returnKey = true;
        }
        return returnKey;
    }

    /**
     * 除去最后一个字符，
     * 返回
     * @param friendId
     * @return
     */
    public String getFriendId(String friendId) {
        String friend_id = friendId.substring(0, friendId.length() - 1);
        //System.out.println("--" + friend_id);
        return friend_id;
    }

}
