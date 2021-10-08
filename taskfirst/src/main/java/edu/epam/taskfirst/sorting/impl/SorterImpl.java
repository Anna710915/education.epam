package edu.epam.taskfirst.sorting.impl;

import edu.epam.taskfirst.sorting.CustomSorter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;


public class SorterImpl implements CustomSorter {
    static Logger logger = LogManager.getLogger();

    public int[] sortStream (int array[]){
        logger.log(Level.INFO,"Sort :");
        return IntStream.of(array).
                sorted().
                toArray();
    }

    public int[] bubble(int array[]){
        logger.log(Level.INFO,"Bubble sort:");
        int buffer=0;
        for(var i =1;i<array.length;i++){
            for(var j =array.length-1;j>=i;j--){
                if(array[j-1]>array[j]){
                    buffer=array[j-1];
                    array[j-1]=array[j];
                    array[j]=buffer;
                }
            }
        }
        return array;
    }

    public int[] selection(int array[]){
        logger.log(Level.INFO,"Selection sort:");
        int buffer=0, imin=0;
        for(var i =0;i<array.length-1;i++){
            imin=i;
            for(var j =i+1;j<array.length;j++){
                imin=array[imin]>array[j]?j:imin;
            }
            if(imin!=i){
                buffer=array[imin];
                array[imin]=array[i];
                array[i]=buffer;
            }
        }
        return array;
    }

    public int[] insert(int array[]){
        logger.log(Level.INFO,"Insert sort:");
        int buffer=0, j=0;
        for(var i =1;i<array.length;i++){
            buffer=array[i];
            for(j =i-1;j>=0 && buffer<array[j];j--){
               array[j+1]=array[j];
            }
            array[j+1]=buffer;
        }
       return array;
    }

}
