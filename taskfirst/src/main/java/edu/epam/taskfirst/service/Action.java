package edu.epam.taskfirst.service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Action {
    static Logger Logger = LogManager.getLogger();

    public void min_max(int[] array){
        int max=array[0], min = array[0];
        for(int i = 1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
            else if(array[i]<min){
                min=array[i];
            }
        }
        Logger.log(Level.INFO,"Maximum number is "+ Integer.toString(max));
        Logger.log(Level.INFO,"Minimum number is "+ Integer.toString(min));
    }

    public void makeCondition(int[] array){
        int i = 0;
        int cloneLength=array.length;
        int []cloneArray = new int[cloneLength];
        for(int counter = 0;counter<cloneLength;counter++) {
            cloneArray[counter]=array[counter];
        }
        while(i<cloneLength){
            if(cloneArray[i]>0){
                cloneArray[i]=cloneArray[i]*2;
            }
            i++;
        }
        Logger.info("Multiply positive numbers:"+ Arrays.toString(cloneArray));
    }

    public void findAverage(int[] array){
        int sum=0;
        for(int number: array){
            sum+=number;
        }
        Double average = (double)sum/array.length;
        Logger.log(Level.INFO,"Average number is " + Double.toString(average));
    }

    public void sumArray(int[] array){
        int sum = 0;
        for(int number: array){
            sum+=number;
        }
        Logger.log(Level.INFO,"Numbers's sum is " + Integer.toString(sum));
    }

    public void findNegative_Positive(int[] array){
        int negativeCounter=0;
        int positiveCounter=0;
        for(int i = 0;i<array.length;i++){
            if(array[i]>0){
                positiveCounter++;
            }
            else if(array[i]<0){
                negativeCounter++;
            }
        }
        Logger.log(Level.INFO,"Negative numbers are "+ Integer.toString(negativeCounter));
        Logger.log(Level.INFO,"Positive numbers are "+ Integer.toString(positiveCounter));
    }

}
