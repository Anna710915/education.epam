package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.exception.CommandException;
import by.epam.finalproject.util.LanguageUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import static by.epam.finalproject.controller.Parameter.CURRENT_PAGE;
import static by.epam.finalproject.controller.Parameter.LANGUAGE;

import static by.epam.finalproject.controller.PathPage.ERROR_404;

public class ChangeLanguageCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Router router = new Router();
        String currentPage = (String) session.getAttribute(CURRENT_PAGE);
        String language = request.getParameter(LANGUAGE);
        if(!LanguageUtil.isCorrectLanguage(language)){
            router.setCurrentPage(ERROR_404);
            router.setRedirectType();
            return router;
        }
        logger.log(Level.INFO,"Language parameter is " + language);
        logger.log(Level.INFO,"Current page is " + currentPage);
        session.setAttribute(LANGUAGE,language);
        router.setCurrentPage(currentPage);
        router.setRedirectType();
        return router;
    }
}
