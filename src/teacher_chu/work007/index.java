package teacher_chu.work007;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class index {
    public index() {
        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/database_for_java_web";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "lp184126";

        DbUtils.loadDriver(jdbcDriver);

        try {
            connection = DriverManager.getConnection(url, userName, password);

            if (connection == null) {
                System.out.println("数据库连接失败！");
            } else {
                QueryRunner queryRunner = new QueryRunner();

                List list = (List) queryRunner.query(connection, "select lp_id, lp_name from user", new MapListHandler());

                for (int i = 0; i < list.size(); i++) {
                    Map map = (Map) list.get(i);
                    System.out.println("id:" + map.get("lp_id") + "; name:" + map.get("lp_name"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }

    }

    public static void main(String[] args) {
        new index();
    }

}
