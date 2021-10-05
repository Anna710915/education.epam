package edu.epam.taskfirst.service.impl;

import edu.epam.taskfirst.service.CustomAction;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;



public class ActionImpl implements CustomAction {
    static Logger logger = LogManager.getLogger();

    public int findMin(int[] array){
//        int max=array[0], min = array[0];
//        for(int i = 1;i<array.length;i++) {
//            if(array[i]<min){
//                min=array[i];
//            }
//        }
        int min = IntStream.of(array)
                .min()
                .getAsInt();
        logger.log(Level.INFO,"Minimum number is ");
        return min;
    }

    public int findMax(int[] array){
//        int max=array[0];
//        for(int i = 1;i<array.length;i++){
//            if(array[i]>max){
//                max=array[i];
//            }
//        }
        int max = IntStream.of(array)
                .max()
                .getAsInt();
        logger.log(Level.INFO,"Maximum number is ");
        return max;
    }

    public int[] makeCondition(int[] array, int choice){
//        int i = 0;
//        int cloneLength=array.length;
//        int []cloneArray = new int[cloneLength];
//        for(int counter = 0;counter<cloneLength;counter++) {
//            cloneArray[counter]=array[counter];
//        }
//        while(i<cloneLength){
//            if(cloneArray[i]>0){
//                cloneArray[i]=cloneArray[i]*choice;
//            }
//            i++;
//        }
        logger.info("Multiply positive numbers: ");
        return IntStream.of(array)
                .filter(s -> s > 0)
                .map(element -> element*choice)
                .toArray();
    }

    public double findAverage(int[] array){
//        int sum=0;
//        for(int number: array){
//            sum+=number;
//        }
//        double average = (double)sum/array.length;
        logger.log(Level.INFO,"Average number is ");
        return IntStream.of(array)
                .average()
                .getAsDouble();
    }

    public int sumArray(int[] array){
//        int sum = 0;
//        for(int number: array){
//            sum+=number;
//        }
        logger.log(Level.INFO,"Numbers's sum is ");
        return IntStream.of(array)
                .sum();
    }

    public int findPositive(int[] array){
//        int positiveCounter=0;
//        for(int i = 0;i<array.length;i++){
//            if(array[i]>0){
//                positiveCounter++;
//            }
//        }
        logger.log(Level.INFO,"Positive numbers are ");
        IntStream stream = IntStream.of(array);
        long positiveCounter = stream.filter(s->s>0)
                .count();
        return (int)positiveCounter;
    }

    public int findNegative(int[] array){
//        int negativeCounter=0;
//        for(int i = 0;i<array.length;i++){
//           if(array[i]<0){
//                negativeCounter++;
//           }
//        }
        IntStream stream = IntStream.of(array);
        long negativeCounter = stream.filter(s->s<0)
                .count();
        logger.log(Level.INFO,"Negative numbers are ");
        return (int)negativeCounter;
    }

}
