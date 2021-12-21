package by.epam.finalproject.controller.command.impl;

import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.exception.CommandException;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static by.epam.finalproject.controller.PathPage.REGISTRATION_PAGE;
import static by.epam.finalproject.controller.PathPage.CLIENT_PAGE;

import static by.epam.finalproject.controller.Parameter.INVALID_BIRTHDAY;
import static by.epam.finalproject.controller.Parameter.INVALID_FIRST_NAME;
import static by.epam.finalproject.controller.Parameter.INVALID_GMAIL;
import static by.epam.finalproject.controller.Parameter.INVALID_LOGIN;
import static by.epam.finalproject.controller.Parameter.INVALID_PASSWORD;
import static by.epam.finalproject.controller.Parameter.INVALID_LAST_NAME;
import static by.epam.finalproject.controller.Parameter.INVALID_PHONE_NUMBER;
import static by.epam.finalproject.controller.Parameter.USER_FIRST_NAME;
import static by.epam.finalproject.controller.Parameter.USER_BIRTHDAY;
import static by.epam.finalproject.controller.Parameter.USER_GMAIL;
import static by.epam.finalproject.controller.Parameter.USER_LAST_NAME;
import static by.epam.finalproject.controller.Parameter.USER_PHONE_NUMBER;
import static by.epam.finalproject.controller.Parameter.LOGIN;
import static by.epam.finalproject.controller.Parameter.PASSWORD;

import static by.epam.finalproject.controller.PropertiesKey.INVALID_BIRTHDAY_MESSAGE;
import static by.epam.finalproject.controller.PropertiesKey.INVALID_FIRST_MESSAGE;
import static by.epam.finalproject.controller.PropertiesKey.INVALID_GMAIL_MESSAGE;
import static by.epam.finalproject.controller.PropertiesKey.INVALID_LOGIN_MESSAGE;
import static by.epam.finalproject.controller.PropertiesKey.INVALID_PASSWORD_MESSAGE;
import static by.epam.finalproject.controller.PropertiesKey.INVALID_PHONE_NUMBER_MESSAGE;
import static by.epam.finalproject.controller.PropertiesKey.INVALID_LAST_MESSAGE;

public class RegistrationCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Map<String,String> mapData = new HashMap<>();
        mapData.put(USER_FIRST_NAME, request.getParameter(USER_FIRST_NAME));
        mapData.put(USER_LAST_NAME, request.getParameter(USER_LAST_NAME));
        mapData.put(LOGIN, request.getParameter(LOGIN));
        mapData.put(PASSWORD, request.getParameter(PASSWORD));
        mapData.put(USER_GMAIL, request.getParameter(USER_GMAIL));
        mapData.put(USER_PHONE_NUMBER, request.getParameter(USER_PHONE_NUMBER));
        mapData.put(USER_BIRTHDAY, request.getParameter(USER_BIRTHDAY));
        UserServiceImpl service = UserServiceImpl.getInstance();
        Router router = new Router();
        try {
            if (service.userRegistration(mapData)) {
                router.setCurrentPage(CLIENT_PAGE);
                router.setRedirectType();
            } else {
                for (String key : mapData.keySet()) {
                    String currentKey = mapData.get(key);
                    switch (currentKey) {
                        case INVALID_BIRTHDAY -> request.setAttribute(INVALID_BIRTHDAY, INVALID_BIRTHDAY_MESSAGE);
                        case INVALID_FIRST_NAME -> request.setAttribute(INVALID_FIRST_NAME, INVALID_FIRST_MESSAGE);
                        case INVALID_GMAIL -> request.setAttribute(INVALID_GMAIL, INVALID_GMAIL_MESSAGE);
                        case INVALID_LAST_NAME -> request.setAttribute(INVALID_LAST_NAME, INVALID_LAST_MESSAGE);
                        case INVALID_LOGIN -> request.setAttribute(INVALID_LOGIN, INVALID_LOGIN_MESSAGE);
                        case INVALID_PASSWORD -> request.setAttribute(INVALID_PASSWORD, INVALID_PASSWORD_MESSAGE);
                        case INVALID_PHONE_NUMBER -> request.setAttribute(INVALID_PHONE_NUMBER, INVALID_PHONE_NUMBER_MESSAGE);
                    }
                }
                router.setCurrentPage(REGISTRATION_PAGE);
            }
        } catch (ServiceException e) {
            throw new CommandException("Error while registration command", e);
        }
        return router;
    }
}
