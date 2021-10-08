package edu.epam.taskfirsttest.sorting;

import edu.epam.taskfirst.sorting.impl.SorterImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SorterImplTest {
    SorterImpl sorter;

    @BeforeClass
    public void createSorter(){
        sorter = new SorterImpl();
    }

    @Test
    public void sortStreamTest(){
        int[] array = {5,3,1};
        int[] expected = {1,3,5};
        int[] actual = sorter.sortStream(array);
        assertEquals(actual,expected);
    }

    @Test
    public void bubbleTest(){
        int[] array = {5,3,1};
        int[] expected = {1,3,5};
        int[] actual = sorter.bubble(array);
        assertEquals(actual,expected);
    }

    @Test
    public void selectionTest(){
        int[] array = {5,3,1};
        int[] expected = {1,3,5};
        int[] actual = sorter.selection(array);
        assertEquals(actual,expected);
    }

    @Test
    public void insertTest(){
        int[] array = {5,3,1};
        int[] expected = {1,3,5};
        int[] actual = sorter.insert(array);
        assertEquals(actual,expected);
    }

    @AfterClass
    public void endOfSorter(){
        sorter = null;
    }
}
