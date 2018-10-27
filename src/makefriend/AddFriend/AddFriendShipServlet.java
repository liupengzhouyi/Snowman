package makefriend.AddFriend;

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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddFriendShipServlet")
public class AddFriendShipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        HttpSession httpSession = request.getSession();
        //获取当前用户
        String user_id = (String) httpSession.getAttribute("user_id");

        //获取要处理的好友申请和数
        String temp_number = "0";
        temp_number = (String) httpSession.getAttribute("number_of_friend");
        System.out.println("tempNumber:" + temp_number);
        int number = Integer.parseInt(temp_number);
        System.out.println("number:" + number);

        // 1. 准备SQL语句
        String sql = "select * from apply_for_friend where friend_number = \'" + user_id + "\' and new_key = 0;";
        // 2. 获取数据
        // 2.1 创建数据库连接类
        try {
            // friend_id -> friend_friend -> sql
            Map<String, String> idToName = new HashMap<String, String>();
            Map<String, String> idToSql = new HashMap<String, String>();
            //储存数据
            ArrayList friendID = new ArrayList();
            linkDatabases lpLinkDatabases = new linkDatabases();
            // 2.2 获取数据
            ResultSet resultSet = lpLinkDatabases.getInformation(sql);
            //申请好友的ID
            String friend_id = "";
            //申请好友的名字
            String friend_name = "";
            //申请的数据库语句
            String addFriendSql = "";
            while (resultSet.next()) {
                //获取信息
                addFriendSql = resultSet.getString("my_sql");
                friend_id = resultSet.getString("my_number");
                friendID.add(friend_id);
                //信息添加
                idToName.put(friend_id, friend_name);
                idToSql.put(friend_id, addFriendSql);
                //好友申请数量加一
                number = number + 1;
            }
            for (int i = 0; i < number; i++) {
                String temp_friend_id = request.getParameter("friend_ids_" + i);
                //获取处理方式
                boolean key = this.getWhichDo(temp_friend_id);
                //获取friend_id
                temp_friend_id = this.getFriendId(temp_friend_id);
                //判断是否同意好友
                if (key == true) {
                    //同意
                    //获取操作信息SQL
                    String this_sql = idToSql.get(temp_friend_id);
                    System.out.println(this_sql);
                    //操作SQL
                    lpLinkDatabases.saveData(this_sql);
                    //给好友发送申请通过通知
                    //第一次生产 自增开始
                    String new_sql = "insert into apply_return(return_id, my_id, friend_id, can_make) " +
                            "values (1, \'" + friend_id + "\', \'" + user_id + "\', 1);";
                    //非第一次
                    /*String new_sql = "insert into apply_return(my_id, friend_id, can_make) " +
                            "values (\'" + friend_id + "\', \'" + user_id + "\', 1);";*/
                    lpLinkDatabases.saveData(new_sql);
                    out.println(friend_id +  "<h3>用户！友谊的小桥建立完成</h3>");
                } else {
                    //不同意
                    //给好友发送申请不通过通知
                    String new_sql = "insert into apply_return(return_id, my_id, friend_id, can_make) " +
                            "values (1, \'" + friend_id + "\', \'" + user_id + "\', 0);";
                    //非第一次
                    /*String new_sql = "insert into apply_return(my_id, friend_id, can_make) " +
                            "values (\'" + friend_id + "\', \'" + user_id + "\', 0);";*/
                    lpLinkDatabases.saveData(new_sql);
                    out.println(friend_id +  "<h3>用户！友谊的小桥暂时未建立</h3>");
                }
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
        if (c == 0) {
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
        System.out.println("--" + friend_id);
        return friend_id;
    }

}
