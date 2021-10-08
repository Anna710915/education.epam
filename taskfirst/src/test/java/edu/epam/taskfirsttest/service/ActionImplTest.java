package edu.epam.taskfirsttest.service;

import edu.epam.taskfirst.service.impl.ActionImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class ActionImplTest {
    ActionImpl action;
    @BeforeClass
    public void createAction(){
        action = new ActionImpl();
    }

    @Test
    public void findMinTest(){
        int[] array = {2,4,1};
        int expected = 1;
        int actual = action.findMin(array);
        assertEquals(actual,expected);
    }
    @Test
    public void findMinStreamTest(){
        int[] array = {2,4,1};
        int expected = 1;
        int actual = action.findMinStream(array);
        assertEquals(actual,expected);
    }

    @Test
    public void findMaxTest(){
        int[] array = {2,4,1};
        int expected = 4;
        int actual = action.findMax(array);
        assertEquals(actual,expected);
    }

    @Test
    public void findMaxStreamTest(){
        int[] array = {2,4,1};
        int expected = 4;
        int actual = action.findMaxStream(array);
        assertEquals(actual,expected);
    }

    @Test
    public void makeConditionTest(){
        int[] array = {2,4,1};
        int[] expected = {4,8,2};
        int[] actual = action.makeCondition(array,2);
        assertEquals(actual,expected);
    }

    @Test
    public void makeConditionStreamTest(){
        int[] array = {2,4,1};
        int[] expected = {4,8,2};
        int[] actual = action.makeConditionStream(array,2);
        assertEquals(actual,expected);
    }

    @Test
    public void findAverageTest(){
        int[] array = {2,4,1};
        double expected = 2.33;
        double actual = action.findAverage(array);
        assertEquals(actual,expected,0.01);
    }

    @Test
    public void findAverageStreamTest(){
        int[] array = {2,4,1};
        double expected = 2.33;
        double actual = action.findAverageStream(array);
        assertEquals(actual,expected,0.01);
    }

    @Test
    public void sumArrayTest(){
        int[] array = {2,4,1};
        double expected = 7;
        double actual = action.sumArray(array);
        assertEquals(actual,expected,0.01);
    }

    @Test
    public void sumArrayStreamTest(){
        int[] array = {2,4,1};
        double expected = 7;
        double actual = action.sumArrayStream(array);
        assertEquals(actual,expected,0.01);
    }
    @Test
    public void findPositiveTest(){
        int[] array = {2,4,1};
        double expected = 3;
        double actual = action.findPositive(array);
        assertTrue(expected==actual);
    }

    @Test
    public void findPositiveStreamTest(){
        int[] array = {2,4,1};
        double expected = 3;
        double actual = action.findPositiveStream(array);
        assertTrue(expected==actual);
    }

    @Test
    public void findNegativeTest(){
        int[] array = {2,-4,1};
        double expected = 1;
        double actual = action.findNegative(array);
        assertTrue(expected==actual);
    }


    @Test
    public void findNegativeStreamTest(){
        int[] array = {2,-4,1};
        double expected = 1;
        double actual = action.findNegativeStream(array);
        assertTrue(expected==actual);
    }
    @AfterClass
    public void endOfAction(){
        action = null;
    }
}
