package JavaBean.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class linkSQLServer {
    public static void main(String[] args) {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=databases_for_java_web";

        String userName = "dbaroot";

        String userPwd = "lp184126";

        Connection dbConn = null;

        try
        {

            Class.forName(driverName);

            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

            System.out.println("连接数据库成功");

        }

        catch (Exception e)

        {

            e.printStackTrace();

            System.out.print("连接失败");

        }
    }
}
