package makefriend.makefriendonline;

import java.sql.*;

public class linkDatabases {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/make_friend_by_java";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USERNAME = "root";
    static final String PASSWORD = "lp184126";

    private Connection connection = null;

    private Statement statement = null;

    public linkDatabases() throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
    }

    public void createConnection() throws SQLException {
        connection = DriverManager.getConnection(
                DB_URL,
                USERNAME,
                PASSWORD
        );
    }

    public Connection getConnection() throws SQLException {
        this.createConnection();
        if (connection == null) {
            this.createConnection();
            return connection;
        } else {
            return connection;
        }
    }

    public void createStatement() throws SQLException {
        if (this.statement != null) {
            return;
        } else {
            if (this.getConnection() == null) {
                this.createConnection();
            } else {
                this.statement = this.getConnection().createStatement();
            }
        }
    }

    public Statement getStatement() throws SQLException {
        if (this.connection == null) {
            this.createStatement();
        } else {
            this.statement = this.getConnection().createStatement();
        }
        return this.statement;
    }

    public boolean saveData(String str) throws SQLException {
        this.createConnection();
        this.createStatement();
        if (this.statement == null) {
            return false;
        } else {
            String string = str;
            System.out.println(string);
            this.statement.execute(string);
            return true;
        }
    }

    public ResultSet getInformation(String sql) throws SQLException {
        this.createConnection();
        this.createStatement();
        // System.out.print(sql);
        ResultSet resultSet = this.statement.executeQuery(sql);
        return resultSet;
    }

    public void updateData(String sql) throws SQLException {
        this.createConnection();
        this.createStatement();
        this.statement.executeUpdate(sql);
    }
/*
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        linkDatabases linkDatabase = new linkDatabases();
        // linkDatabase.saveData("insert into lp_sleep_table(lp_id, lp_date, lp_time1) value (2, '2018-09-27', '21:58:32');");
        *//*Connection connection = linkDatabase.getConnection();
        if (connection != null) {
            System.out.print("数据库链接成功！！");
            String string = "INSERT INTO user (lp_id, lp_name, lp_password) VALUES (1809120007,1234,1234);";
            boolean ifSave = linkDatabase.saveData(string);
            if (ifSave) {
                System.out.print("数据保存成功！");
            } else {
                System.out.print("数据没有保存！");
            }
        } else {
            System.out.print("数据库链接失败！");
        }*//*
    }*/
}
