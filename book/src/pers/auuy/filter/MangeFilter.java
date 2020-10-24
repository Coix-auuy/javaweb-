package pers.auuy.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MangeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 得到 session
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpSession session = httpServletRequest.getSession();
        // 判断 session 中是否存在用户名
        if(session.getAttribute("user") == null) {
            // 不存在禁止访问
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        } else {
            // 存在
            chain.doFilter(request,response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
