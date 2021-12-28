package by.epam.finalproject.controller.filter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.finalproject.controller.Parameter.CURRENT_PAGE;

public class CurrentPageFilter implements Filter {
    private static final Logger logger = LogManager.getLogger();
    private static final String CONTROLLER_PATTERN = "/controller?";

    public void init(FilterConfig config) throws ServletException {
        logger.log(Level.INFO,"init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        logger.log(Level.INFO,"Current page");
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpSession session = servletRequest.getSession();
        String requestURI = servletRequest.getRequestURI();
        logger.log(Level.INFO,"request URI: " + requestURI);
        String query = servletRequest.getQueryString();
        if(query != null){
            requestURI = CONTROLLER_PATTERN + query;
        }
        logger.log(Level.INFO, query);
        session.setAttribute(CURRENT_PAGE, requestURI);
        chain.doFilter(request, response);
//        String uri = servletRequest.getRequestURI();
//        logger.log(Level.INFO,uri);
//        String path = servletRequest.getPathInfo();
//        logger.log(Level.INFO, path);
//        StringBuffer url = servletRequest.getRequestURL();
//        logger.log(Level.INFO, url.toString());
//        String contextPath = servletRequest.getContextPath();
//        logger.log(Level.INFO, contextPath);
//        String servPath = servletRequest.getServletPath();
//        logger.log(Level.INFO, servPath);
    }
    public void destroy() {
    }
}
