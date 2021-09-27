package edu.epam.zerotask0.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckerNumbers {
    final static String REGEX_1 = "(-)?\\d+(\\.\\d+)?";
    static Logger Logger = LogManager.getLogger();
    public String[] numberCheck(String[] numbers) throws Exception {
        int counter = 0, newCounter =0;
        for (String numberStr : numbers) {
            if (numberStr.matches(REGEX_1)) {
                counter++;
            }
        }
        String[] newStr = new String[counter];
        for (String numberStr : numbers) {
            if (numberStr.matches(REGEX_1)) {
                newStr[newCounter++] = numberStr;
            }
        }
        Logger.info(String.valueOf(counter));
        if (counter == 2){
            Logger.log(Level.INFO, "We have two numbers");
        }
        else {
            Logger.log(Level.WARN,"We have either more than two numbers or less two numbers");
            throw new Exception("Incorrect data");
        }
        return newStr;
    }
}

