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
        chain.doFilter(req, resp);
        //ServletRequest -> HttpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        //ServletResponse -> HttpServletResponse
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        String strStartIp = this.filterConfig.getInitParameter("startIP");
        String strEndIp = this.filterConfig.getInitParameter("endIP");

        httpServletRequest.setAttribute("strstarIp", strStartIp);
        httpServletRequest.setAttribute("strEndIp", endIp);

        this.setStartIp(Integer.parseInt(strStartIp.replace(".", "")));
        this.setEndIp(Integer.parseInt(strEndIp.replace(".", "")));

        //获取客户端IP
        String reqIp = req.getRemoteHost();

        req.setAttribute("reqIp", reqIp);

        reqIp = reqIp.replace(".", "");
        int ip = Integer.parseInt(reqIp);

        if (ip>endIp || ip <startIp) {
            System.out.println("转到错误页面！");
            ((HttpServletResponse) resp).sendRedirect("/test/测试页面重定向/Hello.jsp");
        } else {
            System.out.println("您的IP允许访问！");
        }

    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
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
