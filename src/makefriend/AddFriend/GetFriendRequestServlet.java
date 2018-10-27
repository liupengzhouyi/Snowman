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

@WebServlet(name = "GetFriendRequestServlet")
public class GetFriendRequestServlet extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置将字符以"UTF-8"编码输出到客户端浏览器
        response.setCharacterEncoding("UTF-8");
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setHeader("content-type", "text/html;charset=UTF-8");

        //获取当前会话
        HttpSession httpSession = request.getSession();
        //获取当前用户ID
        String user_id = (String) httpSession.getAttribute("user_id");
        //判断当前用户是否有在登录
        if(user_id == null) {
            //如果没有
            //跳转页面-》登录
        } else {
            //获取我的最新消息
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
                //统计好友申请数量, 同时也是一个判断是否拥有好友的键值
                int number = 0;
                linkDatabases linkDatabases = new linkDatabases();
                // 2.2 获取数据
                ResultSet resultSet = linkDatabases.getInformation(sql);
                //申请好友的ID
                String friend_id = "";
                //申请好友的名字
                String friend_name = "";
                //申请的数据库语句
                String addFriendSql = "";
                while(resultSet.next()) {
                    //获取信息
                    addFriendSql = resultSet.getString("my_sql");
                    friend_id = resultSet.getString("my_number");
                    friend_name = this.getFriendNameByFriendName(friend_id);
                    friendID.add(friend_id);
                    //信息添加
                    idToName.put(friend_id, friend_name);
                    idToSql.put(friend_id, addFriendSql);
                    //好友申请数量加一
                    number = number + 1;
                }
                // 2.3 判断时候有好友申请
                if (number == 0) {
                    //如果没有
                    //提示 ： 您没有新的好友申请
                    PrintWriter out = response.getWriter();
                    out.println("<h1>\n" +
                            "    <center>\n" +
                            "        您没有新的好友申请！\n" +
                            "    </center>\n" +
                            "</h1>");
                } else {
                    //如果有
                    PrintWriter out = response.getWriter();
                    out.println("<table>");
                    //
                    // 列表
                    for(int i=0;i<number;i++) {
                        out.println("<tr>");
                        String tempName = idToName.get(friendID.get(i).toString());
                        String tempId = friendID.get(i).toString();
                        String tempSql = idToSql.get(friendID.get(i).toString());
                        /*System.out.println("好友名称，" + idToName.get(friendID.get(i).toString()));
                        System.out.println("好友ID：" + friendID.get(i).toString());
                        System.out.println("好友SQL" + idToSql.get(friendID.get(i).toString()));*/
                        out.println("<th>");
                        out.println(friendID.get(i).toString());
                        out.println("</th>");
                        out.println("<th>");
                        out.println(idToName.get(friendID.get(i).toString()));
                        out.println("</th>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    //更新数据表，消除好友申请最新状态
                }
            } catch (ClassNotFoundException e) {
                //跳转错误页面. 获取数据出错
                response.sendRedirect("/makefirenfonline/contactUs/yourProblem.jsp");
            } catch (SQLException e) {
                //跳转错误页面
                response.sendRedirect("/makefirenfonline/contactUs/yourProblem.jsp");
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 通过好友ID获取好友名称
     * @param friendId
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String getFriendNameByFriendName(String friendId) throws ClassNotFoundException, SQLException {
        String friendName = "";
        String sql = "select * from user where user_id = \'" + friendId + "\';";
        linkDatabases linkDatabases = new linkDatabases();
        ResultSet resultSet = linkDatabases.getInformation(sql);
        while(resultSet.next()) {
            friendName = resultSet.getString("user_name");
        }
        return friendName;
    }
}
