package edu.epam.taskfirst.validator;

public class CheckerNumber {
    static final String REGEX_NUMBER = "(-)?\\d+";
    static final String REGEX_DELIMiTER = "\\s+";
    public static boolean checkLine (String line){
        line=line.trim();
        String[] numbers = line.split(REGEX_DELIMiTER);
        boolean bool = true;
        for (String number: numbers){
            if(!number.matches(REGEX_NUMBER)){
                return number.matches(REGEX_NUMBER);
            }
        }
        return bool;
    }
}
