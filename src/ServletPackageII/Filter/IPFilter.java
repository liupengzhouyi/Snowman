package ServletPackageII.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "IPFilter")
public class IPFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //ServletRequest -> HttpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        //ServletResponse -> HttpServletResponse
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        String strStartIp = this.filterConfig.getInitParameter("startIP");
        String strEndIp = this.filterConfig.getInitParameter("endIP");

        httpServletRequest.setAttribute("strStarIp", strStartIp);
        httpServletRequest.setAttribute("strEndIp", endIp);

        this.setStartIp(Integer.parseInt(strStartIp.replace(".", "")));
        this.setEndIp(Integer.parseInt(strEndIp.replace(".", "")));

        System.out.println(this.getStartIp());
        System.out.println(this.getEndIp());

        //获取客户端IP
        //String reqIp = req.getRemoteHost();
        String reqIp = req.getRemoteAddr();

        if (reqIp.equals("0:0:0:0:0:0:0:1")) {
            reqIp = "127.0.0.1";
        } else {
            System.out.println("-------");
        }

        System.out.println(reqIp);

        req.setAttribute("reqIp", reqIp);

        reqIp = reqIp.replace(".", "");
        int ip = Integer.parseInt(reqIp);

        System.out.println("IP:" + ip);

        if (ip != startIp) {
            System.out.println("开始使用您的IP");
            chain.doFilter(req, resp);
        } else {
            //((HttpServletResponse) resp).sendRedirect("/paly.jsp");
            System.out.println("转到错误页面！");
            req.getRequestDispatcher("/paly.jsp").forward(req, resp);
        }

       /* if (ip>endIp || ip <startIp) {
            System.out.println("转到错误页面！");
            req.getRequestDispatcher("/test/测试页面重定向/Hello.jsp").forward(req, resp);
        } else {
            System.out.println("您的IP允许访问！");
        }*/
        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
        System.out.println("开始使用过滤器");
    }


    public int getStartIp() {
        return startIp;
    }

    public void setStartIp(int startIp) {
        this.startIp = startIp;
    }

    public int getEndIp() {
        return endIp;
    }

    public void setEndIp(int endIp) {
        this.endIp = endIp;
    }

    //起始IP
    private int startIp;
    //结束IP
    private int endIp;
    //
    private FilterConfig filterConfig ;
}
