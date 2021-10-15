package edu.epam.tasksecond.factory.impl;

import edu.epam.tasksecond.entity.CustomPoint;
import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.exception.CustomException;
import edu.epam.tasksecond.factory.SphereFactory;
import edu.epam.tasksecond.validator.SphereValidator;

import java.util.Arrays;

public class SphereFactoryImpl implements SphereFactory {
    public CustomSphere createSphere(double ... parameters) throws CustomException{
        CustomSphere sphere;
        CustomPoint point;
        SphereValidator checker = new SphereValidator();
        if(checker.isSphere(parameters)) {
            point = new CustomPoint(parameters[0],parameters[1],parameters[2]);
            sphere = new CustomSphere(point,parameters[3]);
        }else{
            throw new CustomException("Data is incorrect! " + Arrays.toString(parameters));
        }
        return sphere;
    }
    public CustomSphere createSphere(CustomPoint point, double radius) throws CustomException{
        CustomSphere sphere;
        SphereValidator checker = new SphereValidator();
        if(checker.isSphere(point, radius)) {
            sphere = new CustomSphere(point,radius);
        }else{
            throw new CustomException("Data is incorrect! " + point + ", radius="+ radius);
        }
        return sphere;
    }
}
