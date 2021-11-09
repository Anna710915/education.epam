package by.epam.taskfourth.reader;

import by.epam.taskfourth.exception.CustomException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class CustomReaderTest {
    CustomReader reader;
    @BeforeClass
    public void createReader(){
        reader = new CustomReader();
    }
    @Test
    public void readFile() throws CustomException{
        Optional<List<String>> actual = reader.readFile("data/test.txt");
        assertTrue(actual.isPresent());
    }
    @Test
    public void readFileEmpty() throws CustomException{
        Optional<List<String>> actual = reader.readFile("data/testEmpty.txt");
        assertFalse(actual.isPresent());
    }
    @Test(expectedExceptions = CustomException.class)
    public void readFileException() throws CustomException{
        Optional<List<String>> actual = reader.readFile("data/tes.txt");
        fail();
    }
    @AfterClass
    public void closeReader(){
        reader = null;
    }
}