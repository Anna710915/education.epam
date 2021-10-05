package edu.epam.taskfirst.sorting.impl;

import edu.epam.taskfirst.sorting.CustomSorter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;


public class SorterImpl implements CustomSorter {
    static Logger logger = LogManager.getLogger();

    private int[] cloneArray (int array[]){
        int length= array.length;
        int[] clone= new int[length];
        for(int counter = 0;counter<length;counter++) {
            clone[counter]=array[counter];
        }
        return clone;
    }

    public int[] sortStream (int array[]){
        logger.log(Level.INFO,"Sort :");
        return IntStream.of(array).
                sorted().
                toArray();
    }

    public int[] bubble(int array[]){
        logger.log(Level.INFO,"Bubble sort:");
        int[] clone = cloneArray(array);
        int buffer=0;
        for(var i =1;i<clone.length;i++){
            for(var j =clone.length-1;j>=i;j--){
                if(clone[j-1]>clone[j]){
                    buffer=clone[j-1];
                    clone[j-1]=clone[j];
                    clone[j]=buffer;
                }
            }
        }
        return clone;
    }

    public int[] selection(int array[]){
        logger.log(Level.INFO,"Selection sort:");
        int[] clone = cloneArray(array);
        int buffer=0, imin=0;
        for(var i =0;i<clone.length-1;i++){
            imin=i;
            for(var j =i+1;j<clone.length;j++){
                imin=clone[imin]>clone[j]?j:imin;
            }
            if(imin!=i){
                buffer=clone[imin];
                clone[imin]=clone[i];
                clone[i]=buffer;
            }
        }
        return clone;
    }

    public int[] insert(int array[]){
        logger.log(Level.INFO,"Insert sort:");
        int[] clone = cloneArray(array);
        int buffer=0, j=0;
        for(var i =1;i<clone.length;i++){
            buffer=clone[i];
            for(j =i-1;j>=0 && buffer<clone[j];j--){
               clone[j+1]=clone[j];
            }
            clone[j+1]=buffer;
        }
       return clone;
    }

}
