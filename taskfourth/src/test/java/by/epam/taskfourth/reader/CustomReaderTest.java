package by.epam.taskfourth.reader;

import by.epam.taskfourth.exception.CustomException;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class CustomReaderTest {

    @Test
    public void readFile() throws CustomException{
        CustomReader reader = new CustomReader();
        Optional<List<String>> actual = reader.readFile("data/test.txt");
        assertNotNull(actual.get());
    }
}