package by.epam.finalproject.controller.filter.permission;

import by.epam.finalproject.controller.factory.CommandType;

import java.util.Set;
public enum UserPermission {
    ADMIN(Set.of(CommandType.CHANGE_LANGUAGE.name(),
            CommandType.REGISTRATION.name(),
            CommandType.FIND_ALL_USERS.name(),
            CommandType.SIGN_OUT.name(),
            CommandType.DELETE_USER.name())),
    CLIENT(Set.of(CommandType.CHANGE_LANGUAGE.name(),
            CommandType.SIGN_IN.name(),
            CommandType.SIGN_OUT.name())),
    GUEST(Set.of(CommandType.SIGN_IN.name(),
            CommandType.CHANGE_LANGUAGE.name(),
            CommandType.REGISTRATION.name()));
    private Set<String> commands;

    UserPermission(Set<String> commands){
        this.commands = commands;
    }

    public Set<String> getCommands(){
        return commands;
    }
}
