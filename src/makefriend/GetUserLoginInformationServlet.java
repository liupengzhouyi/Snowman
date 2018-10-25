package makefriend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetUserLoginInformationServlet")
public class GetUserLoginInformationServlet extends HttpServlet {
    public void init() {
        this.user_id = new String();
        this.user_password = new String();
        this.user_verify_code = new String();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.init();
        this.setUser_id(request.getParameter("user_id"));
        this.setUser_password(request.getParameter("user_password"));
        this.setUser_verify_code(request.getParameter("user_verify_code"));
        boolean key = false;
        //判断用户登录信息是否正确
        key = judgeUser();
        if (key) {
            //如果正确， 保存Session
            this.saveSession(request, response);
            //跳转首页

        } else {
            //如果不正确，获取错误信息
            int kind = this.getKind_of_error();
            //跳转错误页面
            this.gotoError(kind);
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
    public boolean judgeUser() {
        boolean returnKey = false;

        return returnKey;
    }

    /**
     * 转移到错误页面
     * @param kind
     */
    public void gotoError(int kind) {
        if (kind == 1) {
            //密码错误

        } else if (kind == 2) {
            //验证码错误

        } else if (kind == 3) {
            //没有此用户

        }
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

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
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

    private String user_id = null;
    private String user_password = null;
    private String user_verify_code = null;
    private int kind_of_error = -1;
}
