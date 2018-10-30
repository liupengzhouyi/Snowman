package teacher_chu;

/*
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class test {
    public test() {
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

                List list = (List) queryRunner.query(connection, "select user_id, user_name from user", new MapListHandler());

                for (int i=0;i<list.size();i++) {
                    Map map = (Map) list.get(i);
                    System.out.println("id:" + map.get("user_id") + "; name:" + map.get("user_name"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }

    }

    public static void main(String[] args) {
        new test();
    }
}
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;


public class test {
    public static void main(String agrs[]) {
        Connection con=null;
        String jdbcDriver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/database_for_java_web?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        String user="root";
        String password="lp184126";

        DbUtils.loadDriver(jdbcDriver);

        try {
            con=DriverManager.getConnection(url,user,password);
            QueryRunner qr = new QueryRunner();
            List results = (List) qr.query(con,"select * from user;",new MapListHandler());
            for(int i=0;i<results.size();i++) {
                Map map = (Map)results.get(i);
                System.out.println(map.toString());
                System.out.println("id:" + map.get("user_id") + "; name:" + map.get("user_name"));
                //System.out.println("id="+map.get("l_id")+"    "+"name="+map.get("l_name"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(con);
        }
    }

}



