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

@WebServlet(name = "SaveOrderServlet")
public class SaveOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String userId = (String) httpSession.getAttribute("user_id");
        getSQLString lpgetSQLString = new getSQLString();
        lpgetSQLString.setSql19(userId);
        String sql = lpgetSQLString.getSql19();
        ResultSet resultSet = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("" +
                "<table>\n" +
                "        <tr>\n" +
                "            <th>\n" +
                "                订单号\n" +
                "            </th>\n" +
                "            <th>\n" +
                "                用户名\n" +
                "            </th>\n" +
                "            <th>\n" +
                "                商品名称\n" +
                "            </th>\n" +
                "            <th>\n" +
                "                数量\n" +
                "            </th>\n" +
                "            <th>\n" +
                "                订单时间\n" +
                "            </th>\n" +
                "        </tr>");
        try {
            linkDBByDBCP lpLinkDBByDBCP = new linkDBByDBCP();
            resultSet = lpLinkDBByDBCP.getData(sql);
            while (resultSet.next()) {
                int book_id = resultSet.getInt("订单号");
                String user_name = resultSet.getString("用户名");
                String good_name = resultSet.getString("商品名");
                int number = resultSet.getInt("数量");
                String date = resultSet.getString("订单日期");
                out.print("" +
                        "<tr>\n" +
                        "            <th>\n" +
                        book_id +
                        "            </th>\n" +
                        "            <th>\n" +
                        user_name +
                        "            </th>\n" +
                        "            <th>\n" +
                        good_name +
                        "            </th>\n" +
                        "            <th>\n" +
                        number +
                        "            </th>\n" +
                        "            <th>\n" +
                        date +
                        "            </th>\n" +
                        "        </tr>");
            }
            out.print("</table>");
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
