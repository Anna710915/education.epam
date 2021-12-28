package by.epam.finalproject.validator;

public final class Validator {
    private static final String USER_FIRST_LAST_NAME_PATTERN = "^[A-Za-zА-Яа-я]{3,50}$";
    private static final String USER_LOGIN_PATTERN = "^[A-Za-zА-Яа-я0-9_]{4,16}$";
    private static final String USER_PASSWORD_PATTERN = "^[A-Za-zА-Яа-я0-9\\.]{5,40}$";
    private static final String USER_MAIL_PATTERN = "^[A-Za-z0-9\\.]{1,30}@[a-z]{3,7}\\.[a-z]{2,4}$";
    private static final String USER_PHONE_NUMBER = "\\d{9}";
    private static final String USER_BIRTHDAY_DATE = "^(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)$";

    public static boolean isCorrectName(String name){
        return isNotNullOrEmpty(name) && name.matches(USER_FIRST_LAST_NAME_PATTERN);
    }

    public static boolean isCorrectLogin(String login){
        return isNotNullOrEmpty(login) && login.matches(USER_LOGIN_PATTERN);
    }

    public static boolean isCorrectPassword(String password){
        return isNotNullOrEmpty(password) && password.matches(USER_PASSWORD_PATTERN);
    }

    public static boolean isCorrectGmail(String gmail){
        return isNotNullOrEmpty(gmail) && gmail.matches(USER_MAIL_PATTERN);
    }

    public static boolean isCorrectPhoneNumber(String phoneNumber){
        return isNotNullOrEmpty(phoneNumber) && phoneNumber.matches(USER_PHONE_NUMBER);
    }

    public static boolean isCorrectBirthday(String birthday){
        return isNotNullOrEmpty(birthday) && birthday.matches(USER_BIRTHDAY_DATE);
    }

    private static boolean isNotNullOrEmpty(String line){
        return line != null && !line.isEmpty();
    }
}
