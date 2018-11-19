package teacher_chu.work012;

import JavaBean.linkDatabase.linkDatabases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class isUser {

    public isUser(String user_id, String user_password) {
        this.init();
        this.user_id = user_id;
        this.user_password = user_password;
        this.setSql(user_id);
    }

    public int isUserRight() throws ClassNotFoundException, SQLException {
        // 没有该用户
        int key = 0;
        linkDatabases lpLinkDatabases = new linkDatabases();
        ResultSet resultSet = lpLinkDatabases.getInformation(this.getSql());
        while (resultSet.next()) {
            String password = resultSet.getString("lp_password");
            if (password.equals(this.getUser_password())) {
                key = 1;
                // 正确用户密码
            } else {
                key = -1;
                // 错误用户密码
            }
        }
        return key;
    }

    public void init() {
        this.user_password = new String();
        this.user_id = new String();
        this.sql = new String();
    }

    String user_id = null;
    String user_password = null;
    String sql = "";


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String iuser_password) {
        this.user_password = iuser_password;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String user_id) {
        this.sql = "select * from user where lp_id = \'" + user_id + "\';";
    }
}
