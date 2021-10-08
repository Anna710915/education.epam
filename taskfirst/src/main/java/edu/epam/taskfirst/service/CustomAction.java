package edu.epam.taskfirst.service;

public interface CustomAction {
        int findMin(int[] array);
        int findMinStream(int[] array);
        int findMax(int[] array);
        int findMaxStream(int[] array);
        int[] makeCondition(int[] array, int choice);
        int[] makeConditionStream(int[] array, int choice);
        double findAverage(int[] array);
        double findAverageStream(int[] array);
        int sumArray(int[] array);
        int sumArrayStream(int[] array);
        int findPositive(int[] array);
        int findPositiveStream(int[] array);
        int findNegative(int[] array);
        int findNegativeStream(int[] array);
}
