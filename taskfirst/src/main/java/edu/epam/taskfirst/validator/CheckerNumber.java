package edu.epam.taskfirst.validator;

public class CheckerNumber {
    final static String REGEX_2 = "(-)?\\d+";
    final String REGEX_3 = "\\s+";
    public boolean checkLine (String line){
        line=line.trim();
        String[] numbers = line.split(REGEX_3);
        boolean bool = true;
        for (String number: numbers){
            if(!number.matches(REGEX_2)){
                return number.matches(REGEX_2);
            }
        }
        return bool;
    }
}
