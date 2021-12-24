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
    private static final String ROOT = "root";
    private static final String INDEX_PAGE = "start_page";
    private String root;
    private String startPage;
    public void init(FilterConfig config) throws ServletException {
        root = config.getInitParameter(ROOT);
        startPage = config.getInitParameter(INDEX_PAGE);
        logger.log(Level.INFO,"init");
    }

    public void destroy() {
        root = null;
        startPage = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        String requestURI = httpRequest.getServletPath();
        logger.log(Level.INFO,"request URI: " + requestURI);
        session.setAttribute(CURRENT_PAGE, requestURI);
        chain.doFilter(request, response);
    }
}
