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
                "(" + Integer.parseInt(this.getyourID() + "0001") + "," + lpName + "," + lpPassword + ");";
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lpName = request.getParameter("lpName");
        String lpPassword = request.getParameter("lpPassword");
        this.setSQL(lpName, lpPassword);
        try {
            this.getLinkDatabase();
            this.getConnection();
            this.getStatement().execute(this.getSQL());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*PrintWriter out = response.getWriter();
        out.print(lpName + lpPassword);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void getLinkDatabase() throws SQLException, ClassNotFoundException {
        lpLinkDB = new linkDatabases();
    }

    public Connection getConnection() {
        connection = lpLinkDB.getConnection();
        if (connection != null) {
            return connection;
        } else {
            return null;
        }
    }

    public Statement getStatement() throws SQLException {
        statement = connection.createStatement();
        if (statement.equals(null)) {
            return null;
        } else {
            return statement;
        }
    }

    public String getyourID() {
        lpGetNowTime = new getNowTime();
        return lpGetNowTime.getUsedStringForID();
    }
}
