package teacher_chu.work008;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import teacher_chu.javaBean.GuestBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class index {
    /**
     * 构造函数
     */
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

                List list = (List) queryRunner.query(connection, "select id, name from guestbook;", new BeanListHandler(GuestBook.class));

                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).toString());
                    GuestBook guestBook = (GuestBook) list.get(i);
                    System.out.println("id:" + guestBook.getId()+ "; name:" + guestBook.getName());
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
