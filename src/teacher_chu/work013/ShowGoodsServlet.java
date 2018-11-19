package teacher_chu.work013;

import JavaBean.linkDatabase.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ShowGoodsServlet")
public class ShowGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.init();
        ArrayList<goods> list = new ArrayList();
        try {
            linkDatabases lpLinkDatabases = new linkDatabases();
            ResultSet resultSet = lpLinkDatabases.getInformation(this.getSql());
            while(resultSet.next()) {
                String tempId = resultSet.getString("good_id");
                String tempName = resultSet.getString("good_name");
                int tempMoney = resultSet.getInt("good_prich");
                goods tempGood = new goods(tempId, tempName, tempMoney);
                list.add(tempGood);
            }

            for (goods good : list
                 ) {
                System.out.println(good);
            }


            PrintWriter out = response.getWriter();
            out.println("<table border=\"1\">\n" +
                        "            <tr>\n" +
                        "                商品列表\n" +
                        "            </tr>\n" +
                        "            <tr>\n" +
                        "                <th>\n" +
                        "                    商品名称\n" +
                        "                </th>\n" +
                        "                <td>\n" +
                        "                    商品价格\n" +
                        "                </td>\n" +
                        "            </tr>\n");
            for (goods good : list
            ) {
                System.out.println(good);
                String id = good.getId();
                String name = good.getName();
                int money = good.getMoney();

                out.println("<tr>\n" +
                            "                <td>\n" +
                            "                    <a href=\"/teacher_chu/013/TheOrderPage.jsp?good_id=" + id + "\">\n" +
                                                    name +
                            "                    </a>\n" +
                            "                </td>\n" +
                            "                <td>\n" +
                                                    money +
                            "                </td>\n" +
                            "            </tr>");
            }
            out.println("       </table>\n" +
                        "    </form>");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void init() {
        this.sql = new String();
        this.setSql();
    }

    String sql = null;

    public String getSql() {
        return sql;
    }

    public void setSql() {
        this.sql = "select * from lp_goods_for_java_web;";
    }
}
