package edu.epam.tasksecond.factory;

import edu.epam.tasksecond.entity.CustomPoint;
import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.exception.CustomException;

public interface SphereFactory {
    CustomSphere createSphere(double ... parameters) throws CustomException;
    CustomSphere createSphere(CustomPoint point, double radius) throws CustomException;
}
