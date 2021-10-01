package edu.epam.taskfirst.entity;

public class ArrayCreator {
    private int[] array;

    public void createArray(int[] arr){
        this.array=new int [arr.length];
        for(int i = 0; i<arr.length;i++) {
            this.array[i]=arr[i];
        }
    }
    public int[] getArray(){
        return this.array;
    }
}
