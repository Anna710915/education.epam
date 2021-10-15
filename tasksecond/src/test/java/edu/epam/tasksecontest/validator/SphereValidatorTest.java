package edu.epam.tasksecontest.validator;

import edu.epam.tasksecond.entity.CustomPoint;
import edu.epam.tasksecond.validator.SphereValidator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SphereValidatorTest {
    @Test
    public void isSphereArrayTrue(){
        SphereValidator checker = new SphereValidator();
        double[] array = {1,1,1,1};
        assertTrue(checker.isSphere(array));
    }
    @Test
    public void isSphereArrayFalse(){
        SphereValidator checker = new SphereValidator();
        double[] array = {1,1,1};
        assertFalse(checker.isSphere(array));
    }
    @Test
    public void isSphereTrue(){
        SphereValidator checker = new SphereValidator();
        CustomPoint point = new CustomPoint(1,1,1);
        double radius = 2.4;
        assertTrue(checker.isSphere(point,radius));
    }
    @Test
    public void isSphereFalse(){
        SphereValidator checker = new SphereValidator();
        CustomPoint point = new CustomPoint(1,1,1);
        double radius = -2.4;
        assertFalse(checker.isSphere(point,radius));
    }
}
