package makefriend.AddFriend;

import makefriend.CreateID.getNowTime;
import makefriend.JavaBean.friend_is_exist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MakeFriendServlet")
public class MakeFriendServlet extends HttpServlet {
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.my_id = new String();
        this.friend_id = new String();
        this.make_friend_date = new String();
        this.make_friend_time = new String();
        HttpSession httpSession = request.getSession();
        this.setMy_id((String) httpSession.getAttribute("user_id"));
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //初始化
        init(request, response);
        //获取用户好友ID
        this.setFriend_id(request.getParameter("friend_id"));
        //判断用户好友是否存在
        boolean key = false;
        try {
            key = new friend_is_exist().user_exist(this.getFriend_id());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (key == true) {
            //如果存在，提交好友申请信息，入库
            getNowTime lpGetNowTime = new getNowTime();
            String time = lpGetNowTime.getTime();
            String date = lpGetNowTime.getDate();
            String my_friend_name = request.getParameter("friend_name");

            String sql = "";



        } else {
            //如果不存在，返回错误信息
            response.sendRedirect("/makefirenfonline/errorPage/make_friend/noFriendUsedThisNumber/no_friend_use_this_id.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public String getMy_id() {
        return my_id;
    }

    public void setMy_id(String my_id) {
        this.my_id = my_id;
    }

    public String getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(String friend_id) {
        this.friend_id = friend_id;
    }

    public String getMake_friend_date() {
        return make_friend_date;
    }

    public void setMake_friend_date(String make_friend_date) {
        this.make_friend_date = make_friend_date;
    }

    public String getMake_friend_time() {
        return make_friend_time;
    }

    public void setMake_friend_time(String make_friend_time) {
        this.make_friend_time = make_friend_time;
    }

    private String my_id = null;

    private String friend_id = null;

    private String make_friend_date = null;

    private String make_friend_time = null;
}
