package JavaBean.linkDatabase;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class linkDBByDBCP {

    public linkDBByDBCP() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource ds = (DataSource) context.lookup("java:/comp/env/database_for_java_web");
        this.connection = ds.getConnection();
        this.statement = connection.createStatement();
    }

    public boolean saveData(String sql) throws SQLException {
        boolean key = false;

        String string = sql;
        //string = "INSERT INTO user (lp_id, lp_name, lp_password) VALUES (1809120006,1234,1234);";
        key = this.statement.execute(string);

        return key;
    }

    public ResultSet getData(String sql) throws SQLException {
        ResultSet resultSet = null;
        resultSet = this.statement.executeQuery(sql);
        return resultSet;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    Connection connection = null;

    Statement statement = null;
}
