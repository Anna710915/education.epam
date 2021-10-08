package edu.epam.taskfirsttest.reader;

import edu.epam.taskfirst.exception.CustomException;
import edu.epam.taskfirst.reader.CustomReader;
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
        String data = "src\\main\\resources\\datafile\\array.txt";
        String actual = reader.readFile(data);
    }

    @AfterClass
    public void endFile(){
        reader=null;
    }
}
