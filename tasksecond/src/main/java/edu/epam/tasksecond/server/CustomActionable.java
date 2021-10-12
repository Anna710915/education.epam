package edu.epam.tasksecond.server;


import edu.epam.tasksecond.entity.CustomSphere;

/**
 * Common interface for calculations.
 */
public interface CustomActionable {
    double findSquare(CustomSphere shape);
    double findVolume(CustomSphere shape);
    boolean planeOx(CustomSphere shape);
    boolean planeOy(CustomSphere shape);
    boolean planeOz(CustomSphere shape);
    boolean isSphere(CustomSphere shape);
    double findVolumeRatiosOxy(CustomSphere shape, double planeZ);
    double findVolumeRatiosOxz(CustomSphere shape, double planeY);
    double findVolumeRatiosOyz(CustomSphere shape, double planeX);
}
