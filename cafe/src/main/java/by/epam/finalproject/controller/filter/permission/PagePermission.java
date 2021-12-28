package by.epam.finalproject.controller.filter.permission;
import java.util.Set;

import static by.epam.finalproject.controller.PathPage.*;


public enum PagePermission {
    ADMIN(Set.of(START_PAGE,
            ADMIN_PAGE,
            GUEST_PAGE,
            ERROR_404,
            REGISTRATION_PAGE,
            USERS_PAGE)),
    CLIENT(Set.of(START_PAGE,
            CLIENT_PAGE,
            GUEST_PAGE,
            SIGN_PAGE,
            ERROR_404)),
    GUEST(Set.of(START_PAGE,
            GUEST_PAGE,
            SIGN_PAGE,
            ERROR_404,
            REGISTRATION_PAGE));
    Set<String> userPages;
    PagePermission(Set<String> userPages){
        this.userPages = userPages;
    }
    public Set<String> getUserPages(){
        return userPages;
    }
}
