package by.epam.finalproject.controller.filter.permission;

import java.util.Set;
public enum UserPermission {
    ADMIN(Set.of(Permission.CHANGE_LANGUAGE)),
    CLIENT(Set.of(Permission.CHANGE_LANGUAGE)),
    GUEST(Set.of(Permission.SIGN_IN,
            Permission.CHANGE_LANGUAGE));
    private Set<String> commands;

    UserPermission(Set<String> commands){
        this.commands = commands;
    }

    public Set<String> getCommands(){
        return commands;
    }
}
