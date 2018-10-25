package makefriend;

//import sun.jvm.hotspot.tools.Tool;

import makefriend.CreateID.CreateID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
        //原来的验证码
        String vcode = (String) httpSession.getAttribute("verify_code_server");


        //有没有输入的内容
        boolean judge_all_input = this.judgeAllInput();
        //密码不一致
        boolean judge_password = this.judgePassword();
        //验证码错误
        boolean judge_verify_code = this.judgeVerifyCode();
        //手机号码格式错误
        boolean judge_phone_number = this.judgePhoneNumber();

        boolean keyOfInput = false;
        if (judge_all_input) {
            if (judge_password) {
                if (judge_phone_number) {
                    if (judge_verify_code) {
                        keyOfInput = true;
                    } else {
                        //验证码出现错误
                    }
                } else{
                    //手机号码出现问题
                }
            } else {
                //密码不一致
            }
        } else {
            //没有全部输入

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 创建用户ID
     * @param privince
     * @param sex
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void createUserId(String privince, String sex) throws SQLException, ClassNotFoundException {
        this.setUserID(new CreateID(privince, sex).getID());
    }

    public void userInformationInputToDXatabase() {
        //
    }

    /**
     * 判断是否为手机号码格式
     * @return
     */
    public boolean judgePhoneNumber() {
        boolean returnKey = false;
        if (this.getPhone().length() != 11) {
            returnKey = false;
        } else {
            if (this.getPhone().charAt(0) != '1') {
                returnKey = false;
            } else {
                returnKey = true;
            }
        }
        return returnKey;
    }


    /**
     * 验证码是否正确
     * @return
     */
    public boolean judgeVerifyCode() {
        boolean returnKey = false;
        if (this.getV_code().equals(this.getVerify_code())) {
            returnKey = true;
        }
        return returnKey;
    }

    /**
     * 判断密码一致
     * @return
     */
    public boolean judgePassword() {
        boolean returnKey = false;
        if (this.getPasswordI().equals(this.passwordII)) {
            returnKey = true;
        }
        return returnKey;
    }

    /**
     * 判断用户是否全部输入
     * @return
     */
    public boolean judgeAllInput() {
        boolean returnKey = false;

        if (ToolForJudgeAllInput(this.getEmail())) {
            if (ToolForJudgeAllInput(this.getName())) {
                if (ToolForJudgeAllInput(this.getPasswordI())) {
                    if (ToolForJudgeAllInput(this.getPasswordII())) {
                        if (ToolForJudgeAllInput(this.getPhone())) {
                            if (ToolForJudgeAllInput(this.getPrivince())) {
                                if (ToolForJudgeAllInput(this.getSex())) {
                                    if (ToolForJudgeAllInput(this.getVerify_code())) {
                                        returnKey = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnKey;
    }

    public boolean ToolForJudgeAllInput(String value) {
        boolean returnKey = true;
        if (value.equals("") || value == null) {
            returnKey = false;
        }
        return returnKey;
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

    public String getV_code() {
        return v_code;
    }

    public void setV_code(String v_code) {
        this.v_code = v_code;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    private String userID = null;

    private String email = null;

    private String name = null;

    private String sex = null;

    private String passwordI = null;

    private String passwordII = null;

    private String phone = null;

    private String privince = null;

    private String verify_code = null;

    private String v_code = null;
}
