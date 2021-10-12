package edu.epam.tasksecond.factory.impl;

import edu.epam.tasksecond.entity.CustomPoint;
import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.exception.CustomException;
import edu.epam.tasksecond.factory.SphereShape;

public class SphereFactory implements SphereShape {
    CustomSphere sphere;
    public CustomSphere createSphere(double ... parameters) throws CustomException{
        if(parameters.length==4) {
            if(parameters[3] > 0) {
                CustomPoint point = new CustomPoint(parameters[0], parameters[1], parameters[2]);
                sphere = new CustomSphere(point, parameters[3]);
            }else{
                throw new CustomException("Radius is less than zero!");
            }
        }else{
            throw new CustomException("Parameters are more than 4");
        }
        return sphere;
    }
    public CustomSphere createSphere(CustomPoint point, double radius) throws CustomException{
        if(radius > 0){
            sphere = new CustomSphere(point, radius);
        }
        else{
            throw new CustomException("Radius is less than zero!");
        }
        return sphere;
    }
}
