package by.epam.finalproject.controller;


import by.epam.finalproject.controller.factory.CommandProvider;
import by.epam.finalproject.exception.CommandException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {
    private static final String COMMAND = "command";
    private static final Logger logger = LogManager.getLogger();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO,"I'm here!");
        processRequest(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO,"I'm here!");
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String commandName = request.getParameter(COMMAND);
        logger.log(Level.INFO,"The command is " + commandName);
        Optional<Command> command = CommandProvider.provideCommand(commandName);
        try {
            page = command.get().execute(request, response);
            if(page != null){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
                dispatcher.forward(request,response);
            }
        } catch (CommandException e) {
            logger.log(Level.INFO,e.getMessage());
        }
    }
}
