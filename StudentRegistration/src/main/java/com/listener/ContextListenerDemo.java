package com.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileNotFoundException;

public class ContextListenerDemo implements ServletContextListener
{

    @Override
    public void contextInitialized( ServletContextEvent servletContextEvent )
    {
        System.out.println("\n###################################\n");

        System.out.println("contextInitialized method has been called in "
                + this.getClass().getName());

        ServletContext servletContext = servletContextEvent.getServletContext();

        System.out.println(servletContext + " is Initialized or Created");
        String path = servletContext.getInitParameter("path");


        try {
            InputStream in = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(in);
            servletContext.setAttribute("properties",prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n#####################################\n");

        /*
         * If ServletContext is created, based on that if you want to perform
         * any operation then you can do it here.
         */

    }

    @Override
    public void contextDestroyed( ServletContextEvent servletContextEvent )
    {
        System.out.println("\n###################################\n");

        System.out.println("contextDestroyed method has been called in "
                + this.getClass().getName());

        ServletContext servletContext = servletContextEvent.getServletContext();

        System.out.println(servletContext + " is destroyed");

        System.out.println("\n#####################################\n");



    }

}
