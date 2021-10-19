package edu.epam.tasksecond.comparator;

import edu.epam.tasksecond.entity.CustomSphere;

import java.util.Comparator;

/**
 * Class {@code SphereFirstPointX} implements the interface Comparator
 * and contains one method for comparing objects.
 * @see java.util.Comparator
 */
public class SphereFirstPointX implements Comparator<CustomSphere> {
    /**
     * Method compares the two specified double values x1 and x2
     * that are X-coordinates of the centres of the spheres.
     * @param o1 the first object to compare
     * @param o2 the second object to compare
     * @return the value 0 if x1 is numerically equal to x2;
     * a value -1 if x1 is numerically less than x2;
     * and a value 1 if x1 is numerically greater than x2.
     */
    @Override
    public int compare(CustomSphere o1, CustomSphere o2) {
        double x1 = o1.getCenter().getX();
        double x2 = o2.getCenter().getX();
        return Double.compare(x1,x2);
    }
}
