package edu.epam.taskfirst.usermain;

import edu.epam.taskfirst.converter.CustomParser;
import edu.epam.taskfirst.entity.CustomArray;
import edu.epam.taskfirst.exception.CustomException;
import edu.epam.taskfirst.reader.CustomReader;
import edu.epam.taskfirst.service.impl.ActionImpl;
import edu.epam.taskfirst.sorting.impl.SorterImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class UserMain {
    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args){
        String filename = "src\\main\\resources\\datafile\\array.txt";
        try {
            CustomReader reader = new CustomReader();
            String lineNumbers = reader.readFile(filename);
            logger.log(Level.INFO,lineNumbers);
            logger.log(Level.INFO,"File is read!");
            CustomParser parser = new CustomParser();
            CustomArray array = new CustomArray(parser.convert(lineNumbers));
            int[] arrayNumbers=array.getArray();
            int[] a={1,23,4};
            CustomArray array1 = new CustomArray(a);
            CustomArray array2 = new CustomArray(a);
            System.out.println(array1.hashCode());
            System.out.println(array2.hashCode());
            logger.log(Level.INFO,"Array objects are created");
            ActionImpl action = new ActionImpl();
            int result[];
            double res;
            result=action.makeCondition(arrayNumbers, 2);
            logger.info(Arrays.toString(result));
            SorterImpl sorter= new SorterImpl();
            int arr[]=sorter.sortStream(arrayNumbers);
            logger.info(Arrays.toString(arr));
            logger.info(Arrays.toString(arrayNumbers));
        }catch (CustomException ex){
            logger.log(Level.ERROR, ex.getMessage());
        }catch(Exception e){
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
