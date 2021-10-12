package edu.epam.tasksecontest.validator;

import edu.epam.tasksecond.validator.CustomValidator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CustomValidatorTest {
    @Test
    public void CustomValidatorTestTrue(){
        String line = "   3.5  4   5.6    3";
        boolean actual = CustomValidator.checkLine(line);
        assertTrue(actual);
    }
    @Test
    public void CustomValidatorTestFalse(){
        String line = "   3.5  4   5c.6    3";
        boolean actual = CustomValidator.checkLine(line);
        assertFalse(actual);
    }
}
