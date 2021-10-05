package edu.epam.taskfirst.entity;

public class CustomArray {
    private int[] array;

    public CustomArray(int[] arr){
        this.array=new int [arr.length];
        for(int i = 0; i<arr.length;i++) {
            this.array[i]=arr[i];
        }
    }

    public int[] getArray(){
        int[] cloneArr= cloneArray();
        return cloneArr;
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
