package edu.epam.tasksecontest.reader;

import edu.epam.tasksecond.exception.CustomException;
import edu.epam.tasksecond.reader.CustomReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CustomReaderTest {
    CustomReader reader;
    @BeforeClass
    public void create(){
        reader = new CustomReader();
    }
    @Test(expectedExceptions = CustomException.class)
    public void raedFileTest() throws CustomException{
        String filename = "data/data.txt";
        List<String> actual = reader.readFile(filename);
    }
    @AfterClass
    public void endReader(){
        reader = null;
    }
}
