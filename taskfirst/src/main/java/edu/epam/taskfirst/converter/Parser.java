package edu.epam.taskfirst.converter;

import edu.epam.taskfirst.validator.CheckerNumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parser {
    final String REGEX_3 = "\\s+";
    static Logger Logger = LogManager.getLogger();
    public int[] convert(String line)
    {
        line=line.trim();
        String[] numbers = line.split(REGEX_3);
        int counter = 0, newCounter=0;
        for (String number: numbers){
           counter++;
        }
        int [] array =  new int [counter];
        for (String number: numbers){
            array[newCounter++]=Integer.parseInt(number);
        }
        return array;
    }

}
