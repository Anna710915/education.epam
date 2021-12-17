package by.epam.finalproject.controller.command;

import by.epam.finalproject.controller.Command;
import by.epam.finalproject.exception.CommandException;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.service.UserService;
import by.epam.finalproject.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Optional;

import static by.epam.finalproject.controller.constant.PathPage.CLIENT_PAGE;
import static by.epam.finalproject.controller.constant.PathPage.SIGN_PAGE;
import static by.epam.finalproject.controller.constant.PathPage.ADMIN_PAGE;

public class SignInCommand implements Command {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ERROR_MESSAGE = "Incorrect login or password";
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession();
        String page = null;
        String login = request.getParameter(LOGIN);
        String pass = request.getParameter(PASSWORD);
        try {
            Optional<User> user = userService.signIn(login, pass);
            if (user.isPresent()) {
                if(user.get().getRole() == User.UserRole.ADMIN){
                    session.setAttribute("admin", login);
                    page = ADMIN_PAGE;
                }else if(user.get().getRole() == User.UserRole.CLIENT) {
                    session.setAttribute("user", login);
                    page = CLIENT_PAGE;
                }
            } else {
                session.setAttribute("errorLoginPassMessage", ERROR_MESSAGE);
                page = SIGN_PAGE;
            }

        } catch (ServiceException e) {
            throw new CommandException("Error during sign in", e);
        }
        return page;
    }
}
