package edu.epam.taskfirst.user;

import edu.epam.taskfirst.converter.Parser;
import edu.epam.taskfirst.entity.ArrayCreator;
import edu.epam.taskfirst.reader.Reader;
import edu.epam.taskfirst.service.Action;
import edu.epam.taskfirst.sorting.Sorter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class UserMain {
    static Logger Logger = LogManager.getLogger();
    public static void main(String[] args){
        String filename = "datafile\\array.txt";
        try {
            Reader reader = new Reader();
            String lineNumbers = reader.readFile(filename);
            Logger.log(Level.INFO,"File is read!");
            Parser parser = new Parser();
            ArrayCreator array = new ArrayCreator();
            array.createArray(parser.convert(lineNumbers));
            int[] arrayNumbers=array.getArray();
            Logger.log(Level.INFO,"Array objects are created");
            Action action = new Action();
            action.min_max(arrayNumbers);
            action.makeCondition(arrayNumbers);
            action.findAverage(arrayNumbers);
            action.sumArray(arrayNumbers);
            action.findNegative_Positive(arrayNumbers);
            Sorter sorter= new Sorter();
            sorter.bubble(arrayNumbers);
            sorter.selection(arrayNumbers);
            sorter.insert(arrayNumbers);
            Logger.info(Arrays.toString(arrayNumbers));
        }catch(Exception e){
            Logger.log(Level.ERROR,"Error is", e);
        }
    }
}
