package edu.epam.tasksecond.converter;

/**
 * Class {@code CustomParser} contains the method to convert strings
 * to array of numbers.
 * @author Anna Merkul
 */
public class CustomParser {
    static final String REGEX_DELIMITER = "\\s+";

    /**
     *
     * @param linePoint is a string, which contains coordinates
     *                  and parameters of a shape.
     * @return the array of numbers.
     */
    public double[] parseLinePoint(String linePoint){
        linePoint=linePoint.trim();
        String[] pointShape = linePoint.split(REGEX_DELIMITER);
        int length = pointShape.length;
        double arrayPoint[] = new double[length];
        for(var i = 0;i<length;i++){
            arrayPoint[i]=Double.parseDouble(pointShape[i]);
        }
        return arrayPoint;
    }
}
