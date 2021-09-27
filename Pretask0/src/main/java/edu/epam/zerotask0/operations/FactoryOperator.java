package edu.epam.zerotask0.operations;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class FactoryOperator {
    static Logger Logger = LogManager.getLogger();
    public String operationPlus(Double Number_1, Double Number_2){
        Logger.log(Level.INFO,"Plus operation");
        BigDecimal num_1 = new BigDecimal(String.valueOf(Number_1));
        BigDecimal num_2 = new BigDecimal(String.valueOf(Number_2));
        BigDecimal num = num_1.add(num_2);
        String result = String.valueOf(num);
        return result;
    }
    public String operationMinus(Double Number_1, Double Number_2){
        Logger.log(Level.INFO,"Minus operation");
        BigDecimal num_1 = new BigDecimal(String.valueOf(Number_1));
        BigDecimal num_2 = new BigDecimal(String.valueOf(Number_2));
        BigDecimal num = num_1.subtract(num_2);
        String result = String.valueOf(num);
        return result;
    }
    public String operationMultiply (Double Number_1, Double Number_2){
        Logger.log(Level.INFO,"Multiply operation");
        Double num = Number_1*Number_2;
        String result = String.valueOf(num);
        return result;
    }
    public String operationDivide (Double Number_1, Double Number_2) {
        Logger.log(Level.INFO, "Divide operation");
            if (Number_2 == 0) {
                throw new ArithmeticException();
            }
            Double num = Number_1 / Number_2;
            String result = String.valueOf(num);
        return result;
    }
}
