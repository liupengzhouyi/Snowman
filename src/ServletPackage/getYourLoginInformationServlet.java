package ServletPackage;

import JavaBean.Test.getNowTime;
import JavaBean.linkDatabase.linkDatabases;

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
import java.sql.Statement;


@WebServlet(name = "getYourLoginInformationServlet")
public class getYourLoginInformationServlet extends HttpServlet {
    private linkDatabases lpLinkDB;
    private Connection connection;
    private Statement statement;
    private getNowTime lpGetNowTime;
    private String SQL;

    public String getSQL() {
        return SQL;
    }

    public void setSQL(String lpName, String lpPassword) {
        this.SQL = "INSERT INTO user (lp_id, lp_name, lp_password) " +
                "VALUES " +
                "(" + Integer.parseInt(this.getyourID() + "0005") + "," + lpName + "," + lpPassword + ");";
        System.out.print(this.getSQL());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lpName = request.getParameter("lpName");
        String lpPassword = request.getParameter("lpPassword");
        System.out.print(lpName + lpPassword);
        this.setSQL(lpName, lpPassword);

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/database_for_java_web";
        // 数据库的用户名与密码，需要根据自己的设置
        String USERNAME = "root";
        String PASSWORD = "lp184126";

        Connection connection = null;

        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(
                    DB_URL,
                    USERNAME,
                    PASSWORD
            );
            statement = connection.createStatement();
            statement.execute(this.getSQL());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public String getyourID() {
        lpGetNowTime = new getNowTime();
        return lpGetNowTime.getUsedStringForID();
    }
}
