package edu.epam.tasksecond.generator;

/**
 * Class {@code GeneratorID} contains a static
 * method and static variable to generate ID for shapes.
 */
public class GeneratorId {
    static long counter=0;
    static public long setSphereID(){

        return ++counter;
    }
}
