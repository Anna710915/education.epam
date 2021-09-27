package test.edu.epam.zerotask0.reader;

import edu.epam.zerotask0.reader.ReaderFile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.fail;

public class ReadFileTest {

    ReaderFile readFile;
    @BeforeClass
    public void createFile(){
        readFile = new ReaderFile();
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void ReadNumbersTestFalse() throws FileNotFoundException {
        String filename="";
        String[] actual = readFile.readNumbers(filename);
        fail("Test is failed");
    }

    @Test
    public void ReadNumbersTestTrue() throws FileNotFoundException {
        String filename="data\\datafile.txt";
        String[] result = readFile.readNumbers(filename);
    }

    @AfterClass
    public void endOfFile(){
        readFile = null;
    }
}
