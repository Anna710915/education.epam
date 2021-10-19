package edu.epam.tasksecond.factory;

import edu.epam.tasksecond.entity.CustomPoint;
import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.exception.CustomException;

/**
 * Interface Sphere factory contains methods for creating sphere shapes.
 */
public interface SphereFactory {
    /**
     * @param parameters array of numbers.
     * @return CustomSphere object.
     * @throws CustomException
     */
    CustomSphere createSphere(double ... parameters) throws CustomException;

    /**
     *
     * @param point a center coordinate of the sphere.
     * @param radius
     * @return CustomSphere object.
     * @throws CustomException
     */
    CustomSphere createSphere(CustomPoint point, double radius) throws CustomException;
}
