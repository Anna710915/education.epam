package edu.epam.tasksecontest.reader;

import edu.epam.tasksecond.exception.CustomException;
import edu.epam.tasksecond.reader.impl.CustomReaderImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CustomReaderTest {
    CustomReaderImpl reader;
    @BeforeClass
    public void create(){
        reader = new CustomReaderImpl();
    }
    @Test(expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "Resource is null data/data.txt" )
    public void raedFileTest() throws CustomException{
        String filename = "data/data.txt";
        List<String> actual = reader.readFile(filename);
    }
    @Test(expectedExceptions = CustomException.class,
            expectedExceptionsMessageRegExp = "List is empty data/empty.txt")
    public void raedFileTestEmpty() throws CustomException{
        String filename = "data/empty.txt";
        List<String> actual = reader.readFile(filename);
    }
    @AfterClass
    public void endReader(){
        reader = null;
    }
}
