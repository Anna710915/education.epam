package by.epam.finalproject.controller.factory;

import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.command.impl.ChangeLanguageCommand;
import by.epam.finalproject.controller.command.impl.SignInCommand;

import java.util.Optional;

public enum CommandType {
    SIGN_IN(new SignInCommand()),
    CHANGE_LANGUAGE(new ChangeLanguageCommand());
    private final Command command;
    CommandType(Command command){
        this.command = command;
    }
    public Command getCommand(){
        return command;
    }
    public static Optional<Command> provideCommand(String command){
        Optional<Command> resultCommand;
        if(command == null || command.isEmpty()){
            return Optional.empty();
        }
        try{
            CommandType commandType = CommandType.valueOf(command.toUpperCase());
            resultCommand = Optional.of(commandType.getCommand());
        }catch (IllegalArgumentException exp){
            resultCommand = Optional.empty();
        }
        return resultCommand;
    }
}
