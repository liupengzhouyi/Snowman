package JavaBean.Tools.makefriendonline;

import java.sql.ResultSet;
import java.sql.SQLException;

public class getPrivices {
    public String[] getPrivices() throws ClassNotFoundException, SQLException {

        linkDatabases lpLinkDatabases = new linkDatabases();

        String sql = "select * from privince_table;";

        ResultSet resultSet = lpLinkDatabases.getInformation(sql);

        String string = "";
        while (resultSet.next()) {

            String provices_name = resultSet.getString("provices_name");
            string = string + provices_name + ",";
        }

        String[] strings = string.split(",");
        return strings;
    }
}
