package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "SaveUserServlet")
public class SaveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        String httpSessionId = httpSession.getId();

        String user_name =request.getParameter("lp_user_name");

        if (httpSession.isNew()) {
            //全新的ID
            //保存SessionID
            // 为 session 添加信息
            httpSession.setAttribute(user_name, "user_name");
        } else {
            // 为 session 添加信息
            httpSession.setAttribute("", "");
        }


        Cookie cookieI = new Cookie("user_name", URLEncoder.encode(request.getParameter("user_name"), "UTF-8"));
        Cookie cookieII = new Cookie("user_password", URLEncoder.encode(request.getParameter("user_password"), "UTF-8"));




    }

    public void getSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();

        String string = httpSession.getId();

        //String user_id = httpSession.getAttribute("");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    private String name = null;
    private String password = null;
    private String user_id = null;
}
