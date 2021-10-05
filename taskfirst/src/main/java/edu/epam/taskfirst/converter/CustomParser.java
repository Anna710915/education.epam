package edu.epam.taskfirst.converter;

public class CustomParser {
    final String REGEX_DELIMITER = "\\s+";
    public int[] convert(String line) {
        line=line.trim();
        String[] numbers = line.split(REGEX_DELIMITER);
        int length = numbers.length;
        int [] array =  new int [length];
        for (int counter = 0; counter< length; counter++){
            array[counter]=Integer.parseInt(numbers[counter]);
        }
        return array;
    }

}
