package by.epam.finalproject.controller.filter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger();
    private static final String CODE = "encoding";
    private String code;
    public void init(FilterConfig config) throws ServletException {
        logger.log(Level.INFO,"Encoding filter: method - init");
        code = config.getInitParameter(CODE);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String codeRequest = request.getCharacterEncoding();
        if(code != null && !code.equalsIgnoreCase(codeRequest)){
            request.setCharacterEncoding(code);
            response.setCharacterEncoding(code);
        }
        chain.doFilter(request, response);
    }
    public void destroy() {
        logger.log(Level.INFO,"Encoding filter: method - destroy");
        code = null;
    }


}
