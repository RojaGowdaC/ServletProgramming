package com.filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class FilterName implements Filter {
    public void destroy() {

    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (((HttpServletRequest) request).getMethod().equals("POST")) {
            PrintWriter out = response.getWriter();
            String name = request.getParameter("name");
            if (name != null && isValid(name))
                chain.doFilter(request, response);
            else {
                out.print("Invalid Name");
            }

        }
    }


    public void init(FilterConfig config) throws ServletException {

    }


    private boolean isValid(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}



