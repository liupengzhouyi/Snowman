package Session;

import JavaBean.linkDatabase.getSQLString;
import JavaBean.linkDatabase.linkDBByDBCP;

import javax.naming.NamingException;
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

@WebServlet(name = "LogInServlet_for_Java_web")
public class LogInServlet_for_Java_web extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("user_id");
        String password = request.getParameter("user_password");
        String password_in_database = null;

        response.setContentType("text/html; charset=UTF-8");

        try {
            ResultSet resultSet = this.getInformation(id);
            while(resultSet.next()){
                password_in_database = resultSet.getString("user_password");
            }
            if (password_in_database.equals(password)) {
                //登录成功
                this.createSession(request, response, id);
            } else {
                //密码错误
                this.errorPassWord(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public ResultSet getInformation(String id) throws SQLException, NamingException {
        ResultSet resultSet = null;

        //获取SQL语句
        getSQLString lpGetSQLString = new getSQLString();
        lpGetSQLString.setSql12(id);
        String sql = lpGetSQLString.getSql12();

        //获取SQL语句
        linkDBByDBCP lpLinkDBByDBCP = new linkDBByDBCP();
        if (lpLinkDBByDBCP != null) {
            resultSet = lpLinkDBByDBCP.getData(sql);
        }

        return resultSet;
    }

    //密码错误
    public void errorPassWord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("" +
                "<h1>\n" +
                "        <center>\n" +
                "            密码错误\n" +
                "        </center>\n" +
                "    </h1>");
        out.print("<form action=\"\" method=\"post\">\n" +
                "        <p>用户ID</p><input type=\"text\" name=\"user_id\"></form><br>\n" +
                "        <p>密码&nbsp;&nbsp;</p><input type=\"password\" name=\"user_password\"><br>\n" +
                "        <input type=\"reset\" value=\"重置\">&nbsp;&nbsp;&nbsp;\n" +
                "        <input type=\"submit\" value=\"提交\">\n" +
                "    </form>");
    }

    //登录成功，创建Session
    public void createSession(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession sessionI = request.getSession();
        sessionI.invalidate();

        HttpSession session = request.getSession();
        //获取session的Id
        String sessionId = session.getId();

        //判断session是不是新创建的
        if (session.isNew()) {
            response.getWriter().print("session创建成功，session的id是："+sessionId);
            session.setAttribute("user_id",id);
        }else {
            response.getWriter().print("服务器已经存在session，session的id是：" + sessionId + "  " + session.getAttribute("user_id"));
        }
        response.getWriter().print("<a href=\"127.0.0.1/test/Test_for_Tang/showShop.jsp\" >跳转到订单添加！</a>");
    }
}
