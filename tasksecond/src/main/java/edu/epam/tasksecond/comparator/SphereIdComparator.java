package edu.epam.tasksecond.comparator;

import edu.epam.tasksecond.entity.CustomSphere;

import java.util.Comparator;

/**
 * Class {@code SphereIdComparator} implements the interface Comparator
 * and contains one method for comparing objects.
 * @see java.util.Comparator
 */
public class SphereIdComparator implements Comparator<CustomSphere> {
    /**
     * Method compares two ID values of the spheres.
     * @param o1 the first object to compare.
     * @param o2 the second object to compare
     * @return the value 0 if the first ID is numerically equal to the second ID;
     * a value -1 if the first ID is numerically less than the second ID;
     * and a value 1 if the first ID is numerically greater than the second ID.
     */
    @Override
    public int compare(CustomSphere o1, CustomSphere o2) {
        long firstId = o1.getSphereId();
        long secondId = o2.getSphereId();
        return Long.compare(firstId,secondId);
    }
}
