package edu.epam.tasksecond.converter.impl;

import edu.epam.tasksecond.converter.CustomParser;

/**
 * Class {@code CustomParser} implements CustomParser interface and
 * contains the method to convert strings to the array of numbers.
 * @author Anna Merkul
 */
public class CustomParserImpl implements CustomParser {
    static final String REGEX_DELIMITER = "\\s+";

    @Override
    public double[] parseLinePoint(String linePoint){
        linePoint = linePoint.trim();
        String[] pointShape = linePoint.split(REGEX_DELIMITER);
        int length = pointShape.length;
        double arrayPoint[] = new double[length];
        for(var i = 0;i<length;i++){
            arrayPoint[i]=Double.parseDouble(pointShape[i]);
        }
        return arrayPoint;
    }
}
