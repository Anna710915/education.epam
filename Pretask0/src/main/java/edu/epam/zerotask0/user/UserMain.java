package edu.epam.zerotask0.user;

import edu.epam.zerotask0.creator.CreatorNumbers;
import edu.epam.zerotask0.operations.FactoryOperator;
import edu.epam.zerotask0.reader.ReaderFile;
import edu.epam.zerotask0.validator.CheckerNumbers;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;


public class UserMain {
    static Logger Logger = LogManager.getLogger();
    public static void main(String[] args) {
        try {
            String filename = "data\\datafile.txt";
            ReaderFile reader = new ReaderFile();
            String[] str = reader.readNumbers(filename);
            CheckerNumbers checker = new CheckerNumbers();
            String[] strChecker = checker.numberCheck(str);
            CreatorNumbers creator = new CreatorNumbers();
            Double number_1 = creator.getFactoryNumber_1(strChecker[0]);
            Double number_2 = creator.getFactoryNumber_2(strChecker[1]);
            FactoryOperator operator = new FactoryOperator();
            String result;
            result = operator.operationPlus(number_1, number_2);
            Logger.info(result);
            result = operator.operationMinus(number_1, number_2);
            Logger.info(result);
            result = operator.operationMultiply(number_1, number_2);
            Logger.info(result);
            result = operator.operationDivide(number_1, number_2);
            Logger.info(result);
            Logger.info("Operations are completed");
        }
        catch (FileNotFoundException ex){
            Logger.log(Level.ERROR,"File is not found " + ex);
        }
        catch(Exception ex){
            Logger.log(Level.ERROR,"Operations are completed incorrect " + ex);
        }
    }
}
