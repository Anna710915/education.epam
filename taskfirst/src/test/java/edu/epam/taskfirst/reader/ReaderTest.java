package edu.epam.taskfirst.reader;

import edu.epam.taskfirst.exception.CustomException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.fail;

public class ReaderTest {

    CustomReader reader;
    @BeforeClass
    public void create() {
        reader = new CustomReader();
    }

    @Test(expectedExceptions = CustomException.class)
    public void readFileTestFalse() throws CustomException {
        String data = "";
        String actual = reader.readFile(data);
        fail("Test is failed");
    }

    @Test
    public void readFileTestTrue() throws CustomException {
        String data = "datafile\\array.txt";
        String actual = reader.readFile(data);
    }

    @AfterClass
    public void endFile(){
        reader=null;
    }
}
