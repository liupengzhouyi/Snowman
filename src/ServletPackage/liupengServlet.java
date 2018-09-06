package ServletPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "liupengServlet")
public class liupengServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<table align='center' border='1'>");
        out.println("<tr><th>参数名</tg><th>数值</th></tr>");
        out.println("<tr><td>服务器IP</td><td>"+request.getRemoteAddr()+"</td></tr>");
        out.println("<tr><td>服务器名</td><td>"+request.getServerName()+"</td></tr>");
        out.println("<tr><td>服务器端口号</td><td>"+request.getServerPort()+"</td></tr>");
        out.println("<tr><td>协议名</td><td>"+request.getScheme()+"</td></tr>");
        out.println("<tr><td>协议版本</td><td>"+request.getProtocol()+"</td></tr>");
        out.println("<tr><td>请求的方法</td><td>"+request.getMethod()+"</td></tr>");
        out.println("<tr><td>请求的url</td><td>"+request.getRequestURI()+"</td></tr>");
        out.println("<tr><td>上下文路径</td><td>"+request.getContextPath()+"</td></tr>");
        out.println("<tr><td>Servlet路径</td><td>"+request.getServletPath()+"</td></tr>");
        out.println("</table>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
