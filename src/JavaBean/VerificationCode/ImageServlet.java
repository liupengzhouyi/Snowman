package JavaBean.VerificationCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "ImageServlet")
public class ImageServlet extends HttpServlet {
    public ImageServlet() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf - 8");
        int width = 78;
        int heigth = 20;
        BufferedImage bufferedImage = new BufferedImage(68, 20, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        Random random = new Random();
        graphics.setColor(new Color(random.nextInt(100), 205, random.nextInt(100)));
        graphics.fillRect(0,0,width,heigth);
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i=0;i<4;i++) {
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("华文隶书", Font.BOLD | Font.ITALIC, 22));
            int n = random.nextInt(10);
            //System.out.print(n);
            stringBuffer.append(n);
            graphics.drawString("" + n, i * 15 + 5, 18);
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("piccode", stringBuffer);

        //
        response.setHeader("Prame", "no-cache");
        response.setHeader("Coche-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
        response.getOutputStream().close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init() throws ServletException {
    }



}