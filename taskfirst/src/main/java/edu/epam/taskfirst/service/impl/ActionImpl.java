package edu.epam.taskfirst.service.impl;

import edu.epam.taskfirst.service.CustomAction;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;



public class ActionImpl implements CustomAction {
    static Logger logger = LogManager.getLogger();

    public int findMin(int[] array){
        int max=array[0], min = array[0];
        for(int i = 1;i<array.length;i++) {
            if(array[i]<min){
                min=array[i];
            }
        }
        logger.log(Level.INFO,"Minimum number is ");
        return min;
    }

    public int findMinStream(int[] array){
        int min = IntStream.of(array)
                .min()
                .getAsInt();
        logger.log(Level.INFO,"Minimum number is ");
        return min;
    }

    public int findMax(int[] array){
        int max=array[0];
        for(int i = 1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        logger.log(Level.INFO,"Maximum number is ");
        return max;
    }

    public int findMaxStream(int[] array){
        int max = IntStream.of(array)
                .max()
                .getAsInt();
        logger.log(Level.INFO,"Maximum number is ");
        return max;
    }

    public int[] makeCondition(int[] array, int choice){
        int i = 0;
        while(i<array.length){
            if(array[i]>0){
                array[i]=array[i]*choice;
            }
            i++;
        }
        logger.info("Multiply positive numbers: ");
        return array;
    }

    public int[] makeConditionStream(int[] array, int choice){
        logger.info("Multiply positive numbers: ");
        return IntStream.of(array)
                .filter(s -> s > 0)
                .map(element -> element*choice)
                .toArray();
    }

    public double findAverage(int[] array){
        int sum=0;
        for(int number: array){
            sum+=number;
        }
        double average = (double)sum/array.length;
        return average;
    }

    public double findAverageStream(int[] array){
        logger.log(Level.INFO,"Average number is ");
        return IntStream.of(array)
                .average()
                .getAsDouble();
    }

    public int sumArray(int[] array){
        int sum = 0;
        for(int number: array){
            sum+=number;
        }
        logger.log(Level.INFO,"Numbers's sum is ");
        return sum;
    }

    public int sumArrayStream(int[] array){
        logger.log(Level.INFO,"Numbers's sum is ");
        return IntStream.of(array)
                .sum();
    }

    public int findPositive(int[] array){
        int positiveCounter=0;
        for(int i = 0;i<array.length;i++){
            if(array[i]>0){
                positiveCounter++;
            }
        }
        logger.log(Level.INFO,"Positive numbers are ");
        return positiveCounter;
    }

    public int findPositiveStream(int[] array){
        logger.log(Level.INFO,"Positive numbers are ");
        IntStream stream = IntStream.of(array);
        long positiveCounter = stream.filter(s->s>0)
                .count();
        return (int)positiveCounter;
    }

    public int findNegative(int[] array){
        int negativeCounter=0;
        for(int i = 0;i<array.length;i++){
           if(array[i]<0){
                negativeCounter++;
           }
        }
        logger.log(Level.INFO,"Negative numbers are ");
        return negativeCounter;
    }

    public int findNegativeStream(int[] array){
        IntStream stream = IntStream.of(array);
        long negativeCounter = stream.filter(s->s<0)
                .count();
        logger.log(Level.INFO,"Negative numbers are ");
        return (int)negativeCounter;
    }

}
