package edu.epam.zerotask0.creator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatorNumbers {
    static Logger Logger = LogManager.getLogger();
    private Double number_1;
    private Double number_2;


    public Double getFactoryNumber_1(String number_1){
        this.number_1 = Double.parseDouble(number_1);
        return this.number_1;
    }

    public Double getFactoryNumber_2(String numbers_2) {
        this.number_2 = Double.parseDouble(numbers_2);
        return number_2;
    }

}
