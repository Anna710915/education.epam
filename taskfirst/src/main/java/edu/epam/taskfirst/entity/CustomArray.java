package edu.epam.taskfirst.entity;

import java.util.Arrays;

public class CustomArray {
    private int[] array;

    public CustomArray(int[] array){
        this.array=new int [array.length];
        for(int i = 0; i<array.length;i++) {
            this.array[i]=array[i];
        }
    }

    public int[] getArray(){
        return cloneArray();
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o==null ||getClass()!=o.getClass()){
            return false;
        }
        CustomArray arr=(CustomArray)o;
        return Arrays.equals(this.array,arr.array);
    }

    @Override
    public int hashCode(){
        String hashNumber="";
        for(int i = 0;i<array.length;i++){
            hashNumber+=Integer.toString(array[i])+Integer.toString(0);
        }
        return Integer.parseInt(hashNumber);
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }

    private int[] cloneArray (){
        int length= array.length;
        int[] cloneArr= new int[length];
        for(int counter = 0;counter<length;counter++) {
            cloneArr[counter]=array[counter];
        }
        return cloneArr;
    }
}
