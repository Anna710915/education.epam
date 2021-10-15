package edu.epam.tasksecontest.server;

import edu.epam.tasksecond.entity.CustomPoint;
import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.server.impl.CustomActionSphere;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import  static org.testng.Assert.*;

public class CustomActionSphereTest {
    CustomActionSphere action;
    CustomPoint point;
    @BeforeClass
    public void createAction(){
        action = new CustomActionSphere();
        point = new CustomPoint(2,2,2);
    }
    @Test
    public void findSquareTest(){
        CustomSphere sphere = new CustomSphere(point,1);
        double actual = action.findSquare(sphere);
        double expended = 12.566;
        assertEquals(actual,expended,0.001);
    }
    @Test
    public void findVolumeTest(){
        CustomSphere sphere = new CustomSphere(point,1);
        double actual = action.findVolume(sphere);
        double expended = 4.188;
        assertEquals(actual,expended,0.001);
    }
    @Test
    public void planeOxTestTrue(){
        CustomSphere sphere = new CustomSphere(point,2);
        assertTrue(action.planeOx(sphere));
    }
    @Test
    public void planeOxTestFalse(){
        CustomSphere sphere = new CustomSphere(point,1);
        assertFalse(action.planeOx(sphere));
    }
    @Test
    public void isSphereTestTrue(){
        CustomSphere sphere = new CustomSphere(point,1);
        assertTrue(action.isSphere(sphere));
    }
    @Test
    public void isSphereTestFalse(){
        CustomSphere sphere = new CustomSphere(point,-1);
        assertFalse(action.isSphere(sphere));
    }
    @AfterClass
    public void endOfAction(){
        action = null;
        point = null;
    }
}
