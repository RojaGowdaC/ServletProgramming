package com.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
public class Propertyfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Properties prop = (Properties) getServletContext().getAttribute("properties");
        out.write(prop.getProperty("db.url"));
        out.write(prop.getProperty("db.user"));
        out.write(prop.getProperty("db.password"));
    }
}