package makefriend.chat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CharServlet")
public class CharServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setContentType("text/html;charset=UTF-8");
        // 获取聊天好友的编号
        String friend_id = request.getParameter("friend_id");
        response.getWriter().println(friend_id);
        //获取用户ID
        //获取HttpSession
        HttpSession httpSession = request.getSession();
        String user_id = (String) httpSession.getAttribute("user_id");
        //验证传入参数是否是user的好友编号
        boolean key = false;
        try {
            key = new findFriend(user_id, friend_id).isFriend(friend_id);
            //判断是否为好友
            if (key == true) {
                //是好友
                response.getWriter().println("可以聊天！");
                //确保传入的参数是正确的
                httpSession.setAttribute("char_friend_id", friend_id);
            } else {
                //提示错误，没该好友
                response.sendRedirect("/makefirenfonline/errorPage/char/nofriend.jsp");
            }
        } catch (SQLException e) {
            //连接数据库出错
            // 连接数据库失败， 跳转 联系我们
            response.sendRedirect("/makefirenfonline/errorPage/make_friend/notlinkdatabase/notlinkdatabase.jsp");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //连接数据库出错
            // 连接数据库失败， 跳转 联系我们
            response.sendRedirect("/makefirenfonline/errorPage/make_friend/notlinkdatabase/notlinkdatabase.jsp");
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
