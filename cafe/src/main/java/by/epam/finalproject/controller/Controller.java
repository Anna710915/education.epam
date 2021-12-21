package by.epam.finalproject.controller;


import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.factory.CommandType;
import by.epam.finalproject.exception.CommandException;
import by.epam.finalproject.model.pool.ConnectionPool;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static by.epam.finalproject.controller.PathPage.ERROR_500;

import static by.epam.finalproject.controller.Parameter.COMMAND;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.DEBUG,"It's a " + request.getMethod());
        processRequest(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.DEBUG,"It's a " + request.getMethod());
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(COMMAND);
        logger.log(Level.DEBUG,"The command is " + commandName);
        Optional<Command> command = CommandType.provideCommand(commandName);
        try {
            Router router;
            if(command.isPresent()){
                router = command.get().execute(request);
                String page = router.getCurrentPage();
                if(router.getCurrentType().equals(Router.Type.FORWARD)){
                    logger.log(Level.INFO,"Forward type.");
                    request.getRequestDispatcher(page)
                            .forward(request,response);
                }else{
                    logger.log(Level.INFO,"Redirect type.");
                    response.sendRedirect(page);
                }
            }else {
                throw new CommandException("Command " + commandName + " is empty.");
            }
        } catch (CommandException e) {
            logger.log(Level.ERROR,e.getMessage());
            Router router = new Router();
            router.setCurrentPage(ERROR_500);
            response.sendRedirect(router.getCurrentPage());
        }
    }
    @Override
    public void destroy(){
        super.destroy();
        ConnectionPool.getInstance().destroyPool();
    }
}
