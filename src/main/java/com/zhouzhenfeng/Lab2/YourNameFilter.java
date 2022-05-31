package com.zhouzhenfeng.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "YourNameFilter",urlPatterns = {"/Lab2/validate.jsp","/Lab2/welcome.jsp"})
public class YourNameFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("your nameFilter -->before chain");
        chain.doFilter(request, response);
        System.out.println("your nameFilter -->after chain");
    }
}