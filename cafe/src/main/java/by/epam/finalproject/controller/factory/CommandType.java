package by.epam.finalproject.controller.factory;

import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.command.impl.ChangeLanguageCommand;
import by.epam.finalproject.controller.command.impl.RegistrationCommand;
import by.epam.finalproject.controller.command.impl.SignInCommand;
import by.epam.finalproject.controller.command.impl.SignOutCommand;
import by.epam.finalproject.controller.command.impl.admin.DeleteUserCommand;
import by.epam.finalproject.controller.command.impl.admin.FindAllUsersCommand;

import java.util.Optional;

public enum CommandType {
    SIGN_IN(new SignInCommand()),
    SIGN_OUT(new SignOutCommand()),
    CHANGE_LANGUAGE(new ChangeLanguageCommand()),
    REGISTRATION(new RegistrationCommand()),
    FIND_ALL_USERS(new FindAllUsersCommand()),
    DELETE_USER(new DeleteUserCommand());

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
