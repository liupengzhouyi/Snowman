package Session;
// C9TL3
import JavaBean.Test.getNowTime;
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

@WebServlet(name = "getOrderServlet")
public class getOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //获取提交表单
        String goodName = request.getParameter("name");
        String number = request.getParameter("number");
        //获取用户
        String user_id = null;
        String user_name = null;
        // 获取Session
        HttpSession session = request.getSession();
        user_id = (String) session.getAttribute("user_id");
        // 整合数据
        try {
            this.doFuck(request, response, goodName, number, user_id, user_name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // 整合数据
    public void doFuck(HttpServletRequest request, HttpServletResponse response, String goodName, String number, String
            user_id, String user_name) throws SQLException, NamingException, IOException {
        //获取SQL语句
        getSQLString lpGetSQLString = new getSQLString();
        //通过用户ID获取用户名
        lpGetSQLString.setSql15(user_id);
        String sqlGetUserName = lpGetSQLString.getSql15();
        //通过货物名称获取货物的ID
        lpGetSQLString.setSql16(goodName);
        String sqlGetGoodId = lpGetSQLString.getSql16();
        ResultSet resultSet = null;

        String name = null;
        String goodId = null;
        int goodPrice = 0;
        //获取数据库存储类
        linkDBByDBCP lpLinkDBByDBCP = new linkDBByDBCP();
        if (lpLinkDBByDBCP != null) {
            resultSet = lpLinkDBByDBCP.getData(sqlGetUserName);
            while (resultSet.next()) {
                name = resultSet.getString("user_name");
            }
        }
        if (lpLinkDBByDBCP != null) {
            resultSet = lpLinkDBByDBCP.getData(sqlGetGoodId);
            while (resultSet.next()) {
                goodId = resultSet.getString("good_id");
                goodPrice = resultSet.getInt("good_prich");
            }
        }



        //获取总价
        int price = Integer.parseInt(number) * goodPrice;

        //获取当前时间
        getNowTime lpGetNowTime = new getNowTime();
        String datetime = lpGetNowTime.getDateTime();

        PrintWriter out = response.getWriter();

        out.print("" +
                "<form action=\"/Session/SaveOrderServlet\" method=\"post\">" +
                "        <table border=\"1\">\n" +
                "            <tr>\n" +
                "                <th>\n" +
                "                    订单属性\n" +
                "                </th>\n" +
                "                <th>\n" +
                "                    您的选择\n" +
                "                </th>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <th>\n" +
                "                    商品编号\n" +
                "                </th>\n" +
                "                <td>\n" +
                goodId +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <th>\n" +
                "                    商品名称\n" +
                "                </th>\n" +
                "                <td>\n" +
                goodName +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <th>\n" +
                "                    用户编号\n" +
                "                </th>\n" +
                "                <td>\n" +
                user_id +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <th>\n" +
                "                    用户名称\n" +
                "                </th>\n" +
                "                <td>\n" +
                name +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <th>\n" +
                "                    商品单价\n" +
                "                </th>\n" +
                "                <td>\n" +
                goodPrice +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <th>\n" +
                "                    商品数量\n" +
                "                </th>\n" +
                "                <td>\n" +
                number +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <th>\n" +
                "                    总价\n" +
                "                </th>\n" +
                "                <td>\n" +
                price  +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <th>\n" +
                "                    下单时间\n" +
                "                </th>\n" +
                "                <td>\n" +
                datetime +
                "                </td>\n" +
                "            </tr>\n" +
                "    </form>");

        //保存数据
        if (lpLinkDBByDBCP != null) {
            lpGetSQLString.setSql17(user_id,goodId,number,datetime);
            String sql = lpGetSQLString.getSql17();
            lpLinkDBByDBCP.saveData(sql);
        }

    }
}
