package makefriend.JavaBean;

import makefriend.makefriendonline.linkDatabases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class friend_is_exist {
    public friend_is_exist() {

    }

    public boolean user_exist(String user_id) throws ClassNotFoundException, SQLException {
        boolean key = false;
        linkDatabases lpLinkDatabases = new linkDatabases();
        String sql = "select * from user where user_id = \'" + user_id + "\';";
        ResultSet resultSet = lpLinkDatabases.getInformation(sql);
        while(resultSet.next()) {
            String user_id1 = resultSet.getString("user_id");
            if (user_id1 == null) {
                key = false;
            } else {
                key = true;
            }
        }
        return key;
    }
}
