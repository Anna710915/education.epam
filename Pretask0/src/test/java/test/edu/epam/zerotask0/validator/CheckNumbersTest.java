package test.edu.epam.zerotask0.validator;

import edu.epam.zerotask0.validator.CheckerNumbers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckNumbersTest {

    CheckerNumbers checker;

    @BeforeClass
    public void createChecker(){
        checker = new CheckerNumbers();
    }

    @Test(expectedExceptions = Exception.class)
    public void numberCheckerTestFalse() throws Exception{
        String[] str = {"3.5", "4.5", "5.5"};
        checker.numberCheck(str);
    }

    @AfterClass
    public void closeChecker(){
        checker = null;
    }
}
