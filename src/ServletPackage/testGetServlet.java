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
import java.sql.SQLException;

@WebServlet(name = "testGetServlet")
public class testGetServlet extends HttpServlet {
    private String SQL;

    private getNowTime lpGetNowTime;

    private boolean isSave;

    public String getSQL() {
        return SQL;
    }

    public void setSQL(String lpName, String lpPassword) {
        this.SQL = "INSERT INTO user (lp_id, lp_name, lp_password) " +
                "VALUES " +
                "(" + Integer.parseInt(this.getyourID() + "0008") + "," + lpName + "," + lpPassword + ");";
        // System.out.print(this.getSQL());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("lpName");
        String password = request.getParameter("lpPassword");
        this.isSave = false;
        this.setSQL(name, password);
        try {
            linkDatabases lpLinkDatabases = new linkDatabases();
            isSave = lpLinkDatabases.saveData(this.getSQL());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        if (isSave) {
            out.print("数据保存成功");
        } else {
            out.print("数据保存失败！");
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
