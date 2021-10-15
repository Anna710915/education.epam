package edu.epam.tasksecond.repository;

import edu.epam.tasksecond.entity.CustomSphere;

@FunctionalInterface
public interface Specification {
    boolean specify(CustomSphere item);
}
