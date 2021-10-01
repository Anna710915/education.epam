package edu.epam.taskfirst.reader;

import edu.epam.taskfirst.reader.Reader;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.fail;
import java.io.FileNotFoundException;

public class ReaderTest {

    Reader reader;
    @BeforeClass
    public void create() {
        reader = new Reader();
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void readFileTestFalse() {
        String data = "";
        String actual = reader.readFile(data);
        fail("Test is failed");
    }

    @Test
    public void readFileTestTrue() {
        String data = "datafile\\array.txt";
        String actual = reader.readFile(data);
    }

    @AfterClass
    public void endFile(){
        reader=null;
    }
}
