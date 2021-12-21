package by.epam.finalproject.util;

public final class LanguageUtil {
    public static final String ENGLISH = "en_US";
    public static final String RUSSIAN = "ru_RU";
    private LanguageUtil(){}

    public static boolean isCorrectLanguage(String language){
        return language!=null && (language == ENGLISH || language == RUSSIAN);
    }
}
