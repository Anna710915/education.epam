package edu.epam.tasksecontest.comparator;


import edu.epam.tasksecond.comparator.SphereFirstPointX;
import edu.epam.tasksecond.entity.CustomPoint;
import edu.epam.tasksecond.entity.CustomSphere;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SphereFirstPointXTest {
    CustomSphere firstSphere;
    CustomSphere secondSphere;
    @BeforeClass
    public void createSphere(){
        firstSphere = new CustomSphere(new CustomPoint(3.2,2,2),2);
        secondSphere = new CustomSphere(new CustomPoint(3.1,2,2),2);
    }
    @Test
    public void compareXTestPositive(){
        SphereFirstPointX compareX = new SphereFirstPointX();
        int expected = 1;
        int actual = compareX.compare(firstSphere,secondSphere);
        assertEquals(actual,expected);
    }
    @Test
    public void compareXTestNegative(){
        SphereFirstPointX compareX = new SphereFirstPointX();
        int expected = -1;
        int actual = compareX.compare(secondSphere,firstSphere);
        assertEquals(actual,expected);
    }
    @AfterClass
    public void endSphere(){
        firstSphere = null;
        secondSphere = null;
    }
}
