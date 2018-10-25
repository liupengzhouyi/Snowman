package makefriend;

//import sun.jvm.hotspot.tools.Tool;

import makefriend.CreateID.CreateID;
import makefriend.CreateID.getNowTime;
import makefriend.makefriendonline.getPrivices;
import makefriend.makefriendonline.linkDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "GetUserInformationServlet")
public class GetUserInformationServlet extends HttpServlet {
    public void init() {
        this.email = new String();
        this.name = new String();
        this.verify_code = new String();
        this.passwordI = new String();
        this.passwordII = new String();
        this.sex = new String();
        this.phone = new String();
        this.v_code = new String();
        this.privince = new String();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        this.init();
        HttpSession httpSession = request.getSession();

        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码


        //获取用户电子邮件
        String user_email = request.getParameter("user_email");
        this.setEmail(user_email);
        //获取用户用户名
        String user_name = request.getParameter("user_name");
        this.setName(user_name);
        //获取用户性别
        String user_sex = request.getParameter("sex");
        if (user_sex.equals("0")) {
            user_sex = "男";
        } else {
            user_sex = "女";
        }
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
        //获取用户省份number
        String user_privince = "";
        String privince_number = request.getParameter("privince");

        try {
            user_privince = new getPrivices().getPrivinceByNumber(privince_number);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.setPrivince(user_privince);
        System.out.println(user_privince);
        //获取用户验证码
        String verify_code = request.getParameter("verify_code");
        this.setVerify_code(verify_code);
        //原来的验证码
        String vcode = (String) httpSession.getAttribute("verify_code_server");
        this.setV_code(verify_code);

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
                        response.sendRedirect("/makefirenfonline/errorPage/signin/verify_code.jsp");
                    }
                } else{
                    //手机号码出现问题
                    response.sendRedirect("/makefirenfonline/errorPage/signin/phone_number.jsp");
                }
            } else {
                //密码不一致
                response.sendRedirect("/makefirenfonline/errorPage/signin/password_different.jsp");
            }
        } else {
            //没有全部输入
            response.sendRedirect("/makefirenfonline/errorPage/signin/data_is_not_enough.jsp");
        }

        if (keyOfInput) {
            //保存数据
            try {
                this.userInformationInputToDXatabase();
                //注册成功的通知
                response.sendRedirect("/makefirenfonline/success/signin/index.jsp");
                httpSession.setAttribute("user_id", this.getUserID());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
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
        this.userID = new String();
        this.setUserID(new CreateID(privince, sex).getID());
    }

    /**
     * 将数据保存到数据库的注册页面
     */
    public void userInformationInputToDXatabase() throws SQLException, ClassNotFoundException {
        //创建ID
        this.createUserId(this.getPrivince(), this.getSex());
        //insert into user(user_id, user_name, user_password_value, user_email, user_sex, user_phone, user_privince, user_create_date, user_create_time) values ();
        int password_hash = this.getPasswordI().hashCode();
        System.out.println("开始写数据：" + this.getPrivince());
        int privinceNumber = this.getPriviceNumber(this.getPrivince());
        String data = new getNowTime().getDate();
        String time = new getNowTime().getTime();
        String sql = "insert into user(user_id, user_name, user_password_value, " +
                "user_email, user_sex, user_phone, user_privince, user_create_date, " +
                "user_create_time) values (\'" + this.getUserID() + "\', \'" + this.getName() + "\', " +
                "\'" + password_hash + "\', \'" + this.getEmail() + "\', \'" + this.getSex() + "\', " +
                "\'" + this.getPhone() + "\', " + privinceNumber + ", \'" + data + "\', \'" + time + "\');";
        System.out.println(sql);
        new linkDatabases().saveData(sql);
    }

    /**
     * 获取当前省份的编号
     * @param privince
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int getPriviceNumber(String privince) throws ClassNotFoundException, SQLException {
        String sql = "select * from privince_table where provices_name = \'" + privince + "\';";
        System.out.println(sql);
        ResultSet resultSet = new linkDatabases().getInformation(sql);
        int proviceId = -1;
        String dateInDB = "";
        while(resultSet.next()) {
            proviceId = resultSet.getInt("provices_id");
        }
        System.out.println(proviceId);
        return proviceId;
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
        System.out.println(this.getV_code());
        System.out.println(this.getVerify_code());
        System.out.println("---------------------------------------------");
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
