package test.edu.epam.zerotask0.operations;

import edu.epam.zerotask0.operations.FactoryOperator;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import static org.testng.Assert.*;

public class FactoryOperatorTest {

    FactoryOperator operator;

    @BeforeClass
    public void setNumbers(){
        operator = new FactoryOperator();
    }

    @Test
    public void operationPlusTest(){
        String actual = operator.operationPlus(-2.4,2.5);
        String expected = "0.1";
        assertEquals(actual,expected);
    }

    @Test
    public void operationMinusTest(){
        String actual = operator.operationMinus(2.4,2.5);
        String expected = "-0.1";
        assertEquals(actual,expected);
    }

    @Test
    public void operationMultiplyTest(){
        String actual = operator.operationMultiply(2.4,2.5);
        String expected = "6.0";
        assertEquals(actual,expected);
    }

    @Test
    public void operationDivideTestTrue(){
        String actual = operator.operationDivide(2.4,2.5);
        String expected = "0.96";
        assertEquals(actual,expected);
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void operationDivideTestFalse(){
        String actual = operator.operationDivide(2.4,0.0);
        fail("Test is failed");
    }

    @AfterClass
    public void endOfTest(){
        operator=null;
    }

}
