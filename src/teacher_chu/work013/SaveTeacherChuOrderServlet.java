package teacher_chu.work013;

import JavaBean.Test.getNowTime;
import JavaBean.linkDatabase.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SaveTeacherChuOrderServlet")
public class SaveTeacherChuOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.init();
        HttpSession httpSession = request.getSession();
        String user_id = (String) httpSession.getAttribute("user_id");
        String good_id = (String) httpSession.getAttribute("good_id");
        int number = Integer.parseInt(request.getParameter("number"));
        String data = new getNowTime().getDateTime();
        this.setSql(user_id, good_id, number, data);
        try {
            this.insertData();
            //添加订单成功

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        this.sql = new String();
    }

    public void insertData() throws ClassNotFoundException, SQLException {
        linkDatabases lpLinkDatabases = new linkDatabases();
        lpLinkDatabases.saveData(this.getSql());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private String sql = null;

    public String getSql() {
        return sql;
    }

    public void setSql(String user_id, String good_id, int number, String data) {
        this.sql = "insert into lp_shop_book_for_java_web(user_id, good_id, number, book_date) " +
                "values (\'" + user_id + "\', " + good_id + ", " + number + ", \'" + data + "\');";
        System.out.println(sql);
    }
}
