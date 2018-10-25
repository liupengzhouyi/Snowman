package makefriend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetUserInformationServlet")
public class GetUserInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        /*String test = (String) httpSession.getAttribute("test");
        String text = (String) httpSession.getAttribute("verify_code_server");
        PrintWriter out = response.getWriter();
        out.println(test);
        out.println(text);*/

        //获取用户电子邮件
        String user_email = request.getParameter("user_email");
        this.setEmail(user_email);
        //获取用户用户名
        String user_name = request.getParameter("user_name");
        this.setName(user_name);
        //获取用户性别
        String user_sex = request.getParameter("sex");
        this.setSex(user_sex);
        //获取用户密码I
        String user_passwordI = request.getParameter("user_passwordI");
        this.setPasswordI(user_passwordI);
        //获取用户密码II
        String user_passwordII = request.getParameter("user_passwordII");
        this.setPasswordII(user_passwordII);
        //获取用户电话号码
        String user_phone = request.getParameter("user_phone");
        this.setPhone(user_phone);
        //获取用户省份
        String user_privince = request.getParameter("privince");
        this.setPrivince(user_privince);
        //获取用户验证码
        String verify_code = request.getParameter("verify_code");
        this.setVerify_code(verify_code);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPasswordI() {
        return passwordI;
    }

    public void setPasswordI(String passwordI) {
        this.passwordI = passwordI;
    }

    public String getPasswordII() {
        return passwordII;
    }

    public void setPasswordII(String passwordII) {
        this.passwordII = passwordII;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrivince() {
        return privince;
    }

    public void setPrivince(String privince) {
        this.privince = privince;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

    private String email = null;

    private String name = null;

    private String sex = null;

    private String passwordI = null;

    private String passwordII = null;

    private String phone = null;

    private String privince = null;

    private String verify_code = null;
}
