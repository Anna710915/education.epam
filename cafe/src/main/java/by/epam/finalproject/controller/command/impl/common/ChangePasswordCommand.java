package by.epam.finalproject.controller.command.impl.common;

import by.epam.finalproject.controller.Router;
import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.exception.CommandException;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.service.UserService;
import by.epam.finalproject.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static by.epam.finalproject.controller.Parameter.*;
import static by.epam.finalproject.controller.PropertiesKey.INVALID_PASSWORD_MESSAGE;
import static by.epam.finalproject.controller.PropertiesKey.INVALID_REPEAT_PASSWORD_MESSAGE;

public class ChangePasswordCommand implements Command {
    private static final UserService service = UserServiceImpl.getInstance();

    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router = new Router();
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(CURRENT_PAGE);
        router.setCurrentPage(currentPage);
        User user = (User) session.getAttribute(USER);
        Map<String, String> map = new HashMap<>();
        map.put(OLD_PASSWORD, request.getParameter(OLD_PASSWORD));
        map.put(NEW_PASSWORD, request.getParameter(NEW_PASSWORD));
        map.put(REPEAT_PASSWORD, request.getParameter(REPEAT_PASSWORD));
        try {
            boolean result = service.changePasswordByOldPassword(map, user);
            if(result){
                router.setRedirectType();
                session.setAttribute(USER, user);
            } else{
                for(String key: map.keySet()){
                    String value = map.get(key);
                    switch (value){
                        case INVALID_NEW_PASSWORD -> request.setAttribute(INVALID_NEW_PASSWORD, INVALID_PASSWORD_MESSAGE);
                        case INVALID_OLD_PASSWORD -> request.setAttribute(INVALID_OLD_PASSWORD, INVALID_PASSWORD_MESSAGE);
                        case INVALID_REPEAT_PASSWORD -> request.setAttribute(INVALID_REPEAT_PASSWORD, INVALID_REPEAT_PASSWORD_MESSAGE);
                    }
                }
            }
        } catch (ServiceException e) {
            throw new CommandException("Exception in a ChangePasswordCommand class ", e);
        }
        return router;
    }
}
