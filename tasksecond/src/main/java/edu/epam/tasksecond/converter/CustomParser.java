package edu.epam.tasksecond.converter;

/**
 * Interface {@code CustomParser} contains one method which
 * subclasses can override.
 */
public interface CustomParser {
    /**
     * Method converts strings to the double array.
     * @param linePoint some line, which can contains coordinates
     * and parameters of a shape.
     * @return double array
     */
    double[] parseLinePoint(String linePoint);
}
