package edu.epam.tasksecond.comparator;

import edu.epam.tasksecond.entity.CustomSphere;

import java.util.Comparator;

public class SphereFirstPointX implements Comparator<CustomSphere> {
    @Override
    public int compare(CustomSphere o1, CustomSphere o2) {
        double x1 = o1.getCenter().getX();
        double x2 = o2.getCenter().getY();
        return Double.compare(x1,x2);
    }
}
