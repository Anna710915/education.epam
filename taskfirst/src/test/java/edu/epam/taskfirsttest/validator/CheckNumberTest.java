package edu.epam.taskfirsttest.validator;

import edu.epam.taskfirst.validator.CheckerNumber;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class CheckNumberTest {

    @Test
    public void checkLineTestFalse() {
        CheckerNumber checker = new CheckerNumber();
        String line = "4 g 8,";
        assertFalse(checker.checkLine(line));
    }
}
