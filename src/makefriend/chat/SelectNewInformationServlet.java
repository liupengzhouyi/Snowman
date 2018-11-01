package makefriend.chat;

import makefriend.makefriendonline.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectNewInformationServlet")
public class SelectNewInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String user_id = (String) httpSession.getAttribute("user_id");

        String sql = "select * from char_information where friend_id = \'" + user_id + "\' and is_new = 0;";

        try {
            ArrayList<String> list = new ArrayList<String>();

            linkDatabases lpLinkDatabases = new linkDatabases();

            ResultSet resultSet = lpLinkDatabases.getInformation(sql);

            while(resultSet.next()) {

                String temp_user_id = resultSet.getString("user_id");
                String temp_friend_id = resultSet.getString("friend_id");
                String temp_text = resultSet.getString("text");
                String temp_char_date_time = resultSet.getString("char_data_time");


                String tie_id = resultSet.getString("tie_id ");
                list.add(tie_id);

                //准备数据表的更新语句
                this.setSqlI(tie_id);

            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    public String getSqlI() {
        return sqlI;
    }

    public void setSqlI(String tie_id) {
        this.sqlI = "update char_information set is_new = 1 where char_id = " + tie_id + ";";
    }

    private String sqlI = "";


}
