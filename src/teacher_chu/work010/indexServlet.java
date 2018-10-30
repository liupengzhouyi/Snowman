package teacher_chu.work010;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import teacher_chu.javaBean.GuestBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "indexServlet")
public class indexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/database_for_java_web";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "lp184126";

        DbUtils.loadDriver(jdbcDriver);

        try {
            connection = DriverManager.getConnection(url, userName, password);

            if (connection == null) {
                System.out.println("数据库连接失败！");
            } else {
                QueryRunner queryRunner = new QueryRunner();

                List list = (List) queryRunner.query(connection, "select id, name from guestbook;", new BeanListHandler(GuestBook.class));
                out.println("<table border=\"1\">");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).toString());
                    GuestBook guestBook = (GuestBook) list.get(i);
                    out.println("<tr><td>" + guestBook.getId() + "</td></tr>");
                    out.println("<tr><td>" + guestBook.getName() + "</td></tr>");
                    System.out.println("id:" + guestBook.getId()+ "; name:" + guestBook.getName());
                }
                out.println("</table>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
