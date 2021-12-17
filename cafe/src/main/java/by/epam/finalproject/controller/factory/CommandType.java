package by.epam.finalproject.controller.factory;

import by.epam.finalproject.controller.Command;
import by.epam.finalproject.controller.command.SignInCommand;

public enum CommandType {
    SIGN_IN(new SignInCommand());
    private final Command command;
    CommandType(Command command){
        this.command = command;
    }
    public Command getCommand(){
        return command;
    }
}
