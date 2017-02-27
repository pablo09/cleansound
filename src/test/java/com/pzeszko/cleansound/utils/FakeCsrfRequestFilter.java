package com.pzeszko.cleansound.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Admin on 27.02.2017.
 */
@Component
public class FakeCsrfRequestFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("_csrf", new FakeCsrf());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() { }

    @Data
    public static class FakeCsrf {
        private final String parameterName = "csrf";
        private final String token = "token";
    }
}
