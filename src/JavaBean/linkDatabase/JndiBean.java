package JavaBean.linkDatabase;



import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 从系统配置的JNDI数据连接池中获得数据库连接
 *
 * @author john
 *
 */
public class JndiBean {
    /**
     * 从系统配置的JNDI数据连接池中获得数据库连接
     *
     * @return 获得的数据库连接，该连接在使用之后应该释放（close）
     *
     * @throws NamingException
     * @throws SQLException
     * @throws Exception
     */

    public static Connection getConnection() throws NamingException, SQLException {
        Connection conn = null;
        Context initCtx = new InitialContext();
        //jdbc/database_for_java_web
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/database_for_java_web");
        if (ds != null) {
            conn = ds.getConnection();
        }
        return conn;
    }

    public static void main(String args[]) throws NamingException, SQLException{
        Connection conn = JndiBean.getConnection();
        //isUserExisted("123");
        System.out.println("OK");
    }

    public static boolean isUserExisted(String userName){
        boolean result=false;
        Connection conn=null;
        try{
            Context c = new InitialContext();
            DataSource ds = (DataSource)c.lookup("java:comp/env/jdbc/database_for_java_web");
            conn = ds.getConnection();
            if (conn != null) {
                System.out.print("DFGHJK");
            }
			/*
			此处与一般数据库连接的处理相同，写上所需处理的sql语句、参数、结果的处理，以下为示例
			String sql="select count(*) from user where username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs=ps.executeQuery();
			rs.next();
			if(rs.getInt(1)>0)result=true;
			*/

        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                if(conn!=null&&!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

}
