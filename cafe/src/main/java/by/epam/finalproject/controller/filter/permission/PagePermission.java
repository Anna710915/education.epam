package by.epam.finalproject.controller.filter.permission;
import java.util.Set;

import static by.epam.finalproject.controller.PathPage.*;


public enum PagePermission {
    ADMIN(Set.of(START_PAGE,
            ADMIN_PAGE,
            GUEST_PAGE,
            ERROR_404,
            REGISTRATION_PAGE,
            USERS_PAGE,
            PROFILE_PAGE,
            MENU_PAGE,
            ADD_MENU_PAGE,
            SETTINGS_PAGE,
            ERROR_500)),
    CLIENT(Set.of(START_PAGE,
            CLIENT_PAGE,
            GUEST_PAGE,
            SIGN_PAGE,
            ERROR_404,
            PROFILE_PAGE,
            DISCOUNT_PAGE,
            MENU_PAGE,
            SETTINGS_PAGE,
            ERROR_500)),
    GUEST(Set.of(START_PAGE,
            GUEST_PAGE,
            SIGN_PAGE,
            ERROR_404,
            REGISTRATION_PAGE,
            ERROR_500));

    Set<String> userPages;
    PagePermission(Set<String> userPages){
        this.userPages = userPages;
    }
    public Set<String> getUserPages(){
        return userPages;
    }
}
