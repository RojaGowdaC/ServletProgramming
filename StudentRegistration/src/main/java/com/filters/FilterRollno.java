package com.filters;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class FilterRollno implements Filter
{
   public void init(FilterConfig config) throws ServletException
   {

   }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        PrintWriter out=response.getWriter();
        String sid=request.getParameter("rollno");
        if(sid != null && isValid(sid))
            chain.doFilter(request,response);
        else
        {
            out.print("Invalid Rollno");
        }
    }
    private boolean isValid(String roll) {
        if (roll.length() < 3) {
            return false;
        }
        if (roll.charAt(0) == 'R' && roll.charAt(1) == 'N') {
            for (int i = 2; i < roll.length(); i++) {
                if (!isNumeric(roll.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isNumeric(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }
    public void destroy()
    {

    }
}



