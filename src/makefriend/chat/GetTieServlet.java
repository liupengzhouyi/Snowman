package makefriend.chat;

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

@WebServlet(name = "GetTieServlet")
public class GetTieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String user_id = (String) httpSession.getAttribute("user_id");

        String sql = "select * from char_tie where user_id = \'" + user_id + "\';";

        int number = 0;

        try {
            linkDatabases lpLinkDatabases = new linkDatabases();

            ResultSet resultSet = lpLinkDatabases.getInformation(sql);

            while(resultSet.next()) {
                number = number + 1;
            }

        } catch (ClassNotFoundException e) {
            // 数据库连接失败

            e.printStackTrace();
        } catch (SQLException e) {
            //数据库获取数据失败!

            e.printStackTrace();
        }

        this.setNumber(number);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void init(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        if (this.getNumber() == 0) {
            //显示没有消息
            out.println("<h1>\n" +
                        "    <center>\n" +
                        "        暂时没有您的消息\n" +
                        "    </center>\n" +
                        "</h1>\n" +
                        "<hr>\n" +
                        "<h3>\n" +
                        "    <center>\n" +
                        "        <a href=\"\">点我返回</a>\n" +
                        "    </center>\n" +
                        "</h3>");
        } else {
            //显示提示内容
            out.println("<h1>\n" +
                    "    <center>\n" +
                    "        您有3条新信息\n" +
                    "    </center>\n" +
                    "</h1>\n" +
                    "<hr>\n" +
                    "<h3>\n" +
                    "    <center>\n" +
                    "        <a href=\"\">点我查看</a>\n" +
                    "    </center>\n" +
                    "</h3>");
        }
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number = 0;
}
