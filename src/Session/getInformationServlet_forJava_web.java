package Session;

import JavaBean.linkDatabase.getSQLString;
import JavaBean.linkDatabase.linkDBByDBCP;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "getInformationServlet_forJava_web")
public class getInformationServlet_forJava_web extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = request.getParameter("user_name");
        String user_passwordI = request.getParameter("user_passwordI");
        String user_passwordII = request.getParameter("user_passwordII");

        response.setContentType("text/html; charset=UTF-8");

        if (user_name.isEmpty() || user_passwordI.isEmpty() || user_passwordII.isEmpty()) {
            //没有完全的输入
            this.donotinput(request, response);
        } else if(user_passwordI.equals(user_passwordII)) {
            //可以注册
            try {
                this.saveUser(user_name, user_passwordI, request, response);
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //密码不一样
            this.diffPassword(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //没有完全的输入
    public void donotinput(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("" +
                "<h1>\n" +
                "        <center>\n" +
                "            有未输入的数据，请重新设置\n" +
                "        </center>\n" +
                "    </h1>");
        out.print("<form action=\"/Session/getInformationServlet_forJava_web\" method=\"post\">\n" +
                "        <p>请输入用户名：</p><input type=\"text\" name=\"user_name\">\n" +
                "        <p>请输入密码：</p><input type=\"password\" name=\"user_passwordI\">\n" +
                "        <p>请再次输入密码：</p><input type=\"password\" name=\"user_passwordII\">\n" +
                "        <input type=\"reset\" value=\"重置\">\n" +
                "        <input type=\"submit\" value=\"提交\">\n" +
                "    </form>");
    }

    //密码不一样
    public void diffPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("" +
                "<h1>\n" +
                "        <center>\n" +
                "            密码不一致，请重新设置\n" +
                "        </center>\n" +
                "    </h1>");
        out.print("<form action=\"/Session/getInformationServlet_forJava_web\" method=\"post\">\n" +
                "        <p>请输入用户名：</p><input type=\"text\" name=\"user_name\">\n" +
                "        <p>请输入密码：</p><input type=\"password\" name=\"user_passwordI\">\n" +
                "        <p>请再次输入密码：</p><input type=\"password\" name=\"user_passwordII\">\n" +
                "        <input type=\"reset\" value=\"重置\">\n" +
                "        <input type=\"submit\" value=\"提交\">\n" +
                "    </form>");
    }

    public void saveUser(String name, String passowrd, HttpServletRequest request, HttpServletResponse response) throws NamingException, SQLException, IOException {

        //获取SQL语句
        getSQLString lpGetSQLString = new getSQLString();
        lpGetSQLString.setSql11(name, passowrd);
        String sql = lpGetSQLString.getSql11();
        //获取数据库存储类
        linkDBByDBCP lpLinkDBByDBCP = new linkDBByDBCP();
        if (lpLinkDBByDBCP != null) {
            lpLinkDBByDBCP.saveData(sql);
        }



        PrintWriter out = response.getWriter();
        out.print("" +
                "<h1>\n" +
                "        <center>\n" +
                "            注册完成\n" +
                "        </center>\n" +
                "</h1>");
    }

}
