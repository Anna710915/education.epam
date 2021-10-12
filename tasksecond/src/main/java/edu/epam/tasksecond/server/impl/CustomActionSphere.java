package edu.epam.tasksecond.server.impl;

import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.server.CustomActionable;

public class CustomActionSphere implements CustomActionable {
    static final double PI = Math.PI;

    public double findSquare(CustomSphere shape){

        return 4*PI*Math.pow(shape.getRadius(),2.0);
    }
    public double findVolume(CustomSphere shape){

        return 4/3.0*PI*Math.pow(shape.getRadius(),3.0);
    }
    public boolean planeOx(CustomSphere shape){

        return Math.abs(shape.getCenter().getX())==shape.getRadius();
    }
    public boolean planeOy(CustomSphere shape){

        return Math.abs(shape.getCenter().getY())==shape.getRadius();
    }
    public boolean planeOz(CustomSphere shape){

        return Math.abs(shape.getCenter().getZ())==shape.getRadius();
    }
    public double findSegmentVolume(double radius, double height) {
        double segmentVolume = PI * Math.pow(height, 2) * (radius - 1 / 3.0 * height);
        return segmentVolume;
    }
    public boolean isSphere(CustomSphere shape){

        return shape.getRadius()>0;
    }
    public double findVolumeRatiosOxy(CustomSphere shape, double planeZ){
        double radius = shape.getRadius();
        double centerZ = shape.getCenter().getZ();
        if((centerZ-radius)>=planeZ || (centerZ+radius)<=planeZ){
            return 0;
        }
        double heightSegment = Math.abs(centerZ+radius) - Math.abs(planeZ);
        double segmentVolume = findSegmentVolume(radius,heightSegment);
        double restVolume = findVolume(shape)-segmentVolume;
        return segmentVolume/restVolume;
    }
    public double findVolumeRatiosOxz(CustomSphere shape, double planeY){
        double radius = shape.getRadius();
        double centerY = shape.getCenter().getY();
        if((centerY-radius)>=planeY || (centerY+radius)<=planeY){
            return 0;
        }
        double heightSegment = Math.abs(centerY+radius) - Math.abs(planeY);
        double segmentVolume = findSegmentVolume(radius,heightSegment);
        double restVolume = findVolume(shape)-segmentVolume;
        return segmentVolume/restVolume;
    }
    public double findVolumeRatiosOyz(CustomSphere shape, double planeX){
        double radius = shape.getRadius();
        double centerX = shape.getCenter().getY();
        if((centerX-radius)>=planeX || (centerX+radius)<=planeX){
            return 0;
        }
        double heightSegment = Math.abs(centerX+radius) - Math.abs(planeX);
        double segmentVolume = findSegmentVolume(radius,heightSegment);
        double restVolume = findVolume(shape)-segmentVolume;
        return segmentVolume/restVolume;
    }
}
