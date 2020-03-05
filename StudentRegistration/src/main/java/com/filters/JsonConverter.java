package com.filters;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.fasterxml.jackson.xml.XmlMapper;
public class JsonConverter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String content = req.getHeader("Accept");
        Object data = servletRequest.getAttribute("rollnumber");
        PrintWriter out = res.getWriter();
        if(content.equals("application/json"))
        {
            ObjectMapper mapper = new ObjectMapper();
            Object json = mapper.writeValueAsString(data);
            servletResponse.setContentType(content);
            out.print(json);

        }
        else if(content.equals("application/xml"))
        {

            XmlMapper xmlMapper = new XmlMapper();
            Object xml = xmlMapper.writeValueAsString(data);
            servletResponse.setContentType(content);
            out.print(xml);
        }
        else
        {out.print(data);}
    }



    @Override
    public void destroy() {

    }
}