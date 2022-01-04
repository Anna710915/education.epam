package by.epam.finalproject.controller.factory;

import by.epam.finalproject.controller.command.Command;
import by.epam.finalproject.controller.command.impl.admin.DeleteUserCommand;
import by.epam.finalproject.controller.command.impl.admin.FindAllUsersCommand;
import by.epam.finalproject.controller.command.impl.admin.InsertNewProductCommand;
import by.epam.finalproject.controller.command.impl.admin.UploadProductPhotoCommand;
import by.epam.finalproject.controller.command.impl.common.*;

import java.util.Optional;

public enum CommandType {
    INSERT_NEW_PRODUCT(new InsertNewProductCommand()),
    SIGN_IN(new SignInCommand()),
    SIGN_OUT(new SignOutCommand()),
    CHANGE_LANGUAGE(new ChangeLanguageCommand()),
    REGISTRATION(new RegistrationCommand()),
    FIND_ALL_MENU(new FindAllMenuCommand()),
    FIND_ALL_USERS(new FindAllUsersCommand()),
    DELETE_USER(new DeleteUserCommand()),
    UPLOAD_PRODUCT_PHOTO(new UploadProductPhotoCommand()),
    UPDATE_USER_PROFILE(new UpdateUserProfileCommand()),
    CHANGE_PASSWORD(new ChangePasswordCommand());

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
