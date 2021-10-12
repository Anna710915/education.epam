package edu.epam.tasksecond.validator;

/**
 * Class {@code CustomValidator} indicates whether some strings
 * contain a particular substring.
 */
public class CustomValidator {
    static final String REGEX_LINE = "\\s*((-?\\d+(\\.\\d+)?)\\s+){3}(\\d+(\\.\\d+)?)";

    /**
     *
     * @param line is a string to compare.
     * @return {@code true} if this string contains
     * a certain substring; {@code false} otherwise.
     */
    public static boolean checkLine(String line) {

        return line.matches(REGEX_LINE);
    }
}
