package makefriend.makefriendonline;

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

    public String[] getNumber() throws ClassNotFoundException, SQLException {
        linkDatabases lpLinkDatabases = new linkDatabases();

        String sql = "select * from privince_table;";

        ResultSet resultSet = lpLinkDatabases.getInformation(sql);

        String string = "";
        while (resultSet.next()) {

            String provices_name = resultSet.getString("provices_id");
            string = string + provices_name + ",";
        }

        String[] strings = string.split(",");
        return strings;
    }

    public String getPrivinceByNumber(String number) throws SQLException, ClassNotFoundException {
        linkDatabases lpLinkDatabases = new linkDatabases();

        String sql = "select * from privince_table where provices_id = " + number + ";";

        ResultSet resultSet = lpLinkDatabases.getInformation(sql);

        String string = "";
        String provices_name = "";
        while (resultSet.next()) {
            provices_name = resultSet.getString("provices_name");
        }
        return provices_name;
    }
}
