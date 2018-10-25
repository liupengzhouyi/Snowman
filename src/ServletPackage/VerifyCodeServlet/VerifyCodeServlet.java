package ServletPackage.VerifyCodeServlet;
import JavaBean.VerificationCode.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 用来生成图片验证码
 * Created by menglanyingfei on 2018/1/12.
 */
@WebServlet(name = "VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建对象
        VerifyCode vc = new VerifyCode();
        //获取图片对象
        BufferedImage bi = vc.getImage();
        //获得图片的文本内容
        String text = vc.getText();
        //打印获取的内容
        System.out.println(text);
        // 将系统生成的文本内容保存到session中
        HttpSession httpSession = request.getSession();
        String string = (String) httpSession.getAttribute("test");
        System.out.println("在验证码中：" + string);
        httpSession.setAttribute("verify_code_server", text);
        //向浏览器输出图片
        vc.output(bi, response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
