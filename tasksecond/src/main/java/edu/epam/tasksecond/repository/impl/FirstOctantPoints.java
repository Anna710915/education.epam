package edu.epam.tasksecond.repository.impl;

import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.repository.Specification;

public class FirstOctantPoints implements Specification {
    @Override
    public boolean specify(CustomSphere item) {
        double radius = item.getRadius();
        double x = item.getCenter().getX();
        double y = item.getCenter().getY();
        double z = item.getCenter().getZ();
        return (x - radius) > 0 && (y - radius) > 0 && (z - radius) > 0;
    }
}
