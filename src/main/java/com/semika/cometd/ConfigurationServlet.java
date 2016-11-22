package com.semika.cometd;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ConfigurationServlet extends GenericServlet
{
    public void init() throws ServletException
    {
        // Grab Spring's ApplicationContent
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        // Trigger CometD service initialization
        context.getBean("echoService");
    }
    
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        throw new ServletException();
    }
}