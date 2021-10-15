package edu.epam.tasksecond.comparator;

import edu.epam.tasksecond.entity.CustomSphere;

import java.util.Comparator;

public class SphereIdComparator implements Comparator<CustomSphere> {
    @Override
    public int compare(CustomSphere o1, CustomSphere o2) {
        return Long.compare(o1.getSphereId(),o2.getSphereId());
    }
}
