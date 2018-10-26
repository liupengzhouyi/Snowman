package makefriend;

import makefriend.makefriendonline.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "GetUserLoginInformationServlet")
public class GetUserLoginInformationServlet extends HttpServlet {
    /**
     * 初始化函数
     * @param request
     * @param response
     */
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.user_id = new String();
        this.user_verify_code = new String();
        HttpSession httpSession = request.getSession();
        String temp_v_code = (String) httpSession.getAttribute("verify_code_server");
        System.out.println("获取当前Session：" + temp_v_code);
        this.set_user_verify_code_by_session(temp_v_code);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入");
        this.init(request, response);
        this.setUser_id(request.getParameter("user_id"));
        this.setUser_password(request.getParameter("user_password"));
        this.setUser_verify_code(request.getParameter("user_verify_code"));
        boolean key = false;
        //判断用户登录信息是否正确
        try {
            key = judgeUser();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (key == true) {
            //如果正确， 保存Session
            this.saveSession(request, response);
            //跳转首页
            response.sendRedirect("/index.jsp");
        } else {
            //如果不正确，获取错误信息
            int kind = this.getKind_of_error();
            //跳转错误页面
            this.gotoError(kind, request, response);
        }
    }

    /**
     * 如果确定登录用户正确，位当前用户创建session储存ID
     * @param request
     * @param response
     */
    public void saveSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        if(httpSession.isNew()) {
            //位当前Session添加user_id
            httpSession.setAttribute("user_id", this.getUser_id());
        } else {
            //销毁当前Session
            httpSession.invalidate();
            //获取全新的Session
            httpSession = request.getSession();
            httpSession.setAttribute("user_id", this.getUser_id());
        }

    }

    /**
     * 判断登录信息是否正确
     * @return
     */
    public boolean judgeUser() throws ClassNotFoundException, SQLException {
        boolean returnKey = false;
        int passwordKey = this.getUser_password();
        linkDatabases lpLinkDatabases = new linkDatabases();
        String temp_user_id = null;
        int tmep_user_password_value = -1;
        //数据库语句： 更具ID获取信息
        String sql = "select * from user where user_id = \'" + this.getUser_id() + "\';";
        ResultSet resultSet = lpLinkDatabases.getInformation(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.toString());
            //实例话临时ID储存对象
            temp_user_id = new String();
            //获取信息
            temp_user_id = resultSet.getString("user_id");
            tmep_user_password_value = resultSet.getInt("user_password_value");
        }
        //判断验证码
        System.out.println("输入的验证码：" + this.getUser_verify_code());
        if (this.get_user_verify_code_by_session().equals(this.getUser_verify_code())) {
            System.out.println("jinru0----");
            System.out.println(this.getUser_id() + ":" + temp_user_id);
            //如果相同，继续判断是否有该用户
            if (this.getUser_id().equals(temp_user_id)){
                System.out.println("返回个人ID： " + temp_user_id);
                //如果有，判断是否密码正确
                if (tmep_user_password_value != passwordKey) {
                    //如果错误，设置错误信息
                    this.setKind_of_error(2);
                } else {
                    //如果正确，设置返回对象的值
                    returnKey = true;
                }
            } else {
                //如果没有。设置错误信息
                this.setKind_of_error(3);
            }
        } else {
            //如果不正确，设置错误信息
            this.setKind_of_error(1);
        }

        return returnKey;
    }

    /**
     * 转移到错误页面
     * @param kind
     * @param request
     * @param response
     * @throws IOException
     */
    public void gotoError(int kind, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        //创建回话，保存错误类型
        httpSession.setAttribute("error",kind);
        //跳转页面
        response.sendRedirect("/makefirenfonline/errorPage/login/error.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password.hashCode();
    }

    public String getUser_verify_code() {
        return user_verify_code;
    }

    public void setUser_verify_code(String user_verify_code) {
        this.user_verify_code = user_verify_code;
    }

    public int getKind_of_error() {
        return kind_of_error;
    }

    public void setKind_of_error(int kind_of_error) {
        this.kind_of_error = kind_of_error;
    }

    public void set_user_verify_code_by_session(String code) {
        this.user_verify_code_by_session = code;
    }

    public String get_user_verify_code_by_session() {
        return this.user_verify_code_by_session;
    }

    private String user_id = null;
    private int user_password = -1;
    private String user_verify_code = null;
    private int kind_of_error = -1;
    private String user_verify_code_by_session = null;
}
