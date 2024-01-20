package com.example.studentlessonservlet.filter;

import com.example.studentlessonservlet.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/addLesson", "/addStudent", "/deleteLesson", "/deleteStudent",
        "/home", "/lessons", "/students", "/logout", "/updateLesson", "/updateStudent"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        User user = (User) servletRequest1.getSession().getAttribute("user");
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
            servletResponse1.sendRedirect("/WEB-INF/index.jsp");
        }

    }
}
