package edu.epam.tasksecond.validator;

import edu.epam.tasksecond.entity.CustomPoint;

public class SphereValidator {
    public boolean isSphere(double...parameters){

        return parameters.length == 4 && parameters[3] > 0 ? true:false;
    }
    public boolean isSphere(CustomPoint point, double radius){

        return point != null && radius > 0 ? true:false;
    }

}
