package edu.epam.tasksecond.entity;

import edu.epam.tasksecond.generator.GeneratorId;

/**
 * Custom sphere implementation.
 */
public class CustomSphere {
    private long sphereId;
    private CustomPoint center;
    private double radius;
    public CustomSphere(CustomPoint center, double radius){
       this.center = center;
       this.radius = radius;
       this.sphereId = GeneratorId.setSphereID();
   }
   public CustomPoint getCenter(){

        return  center;
   }

    public void setCenter(CustomPoint center){

        this.center = center;
    }
   public double getRadius(){

        return radius;
   }

    public void setRadius(double radius){
        if(radius > 0){
            this.radius = radius;
        }
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null || getClass()!=o.getClass()){
            return false;
        }
        CustomSphere sphere = (CustomSphere)o;
        if(radius != sphere.radius){
            return false;
        }
        if(center == null){
            if(sphere.center != null){
                return false;
            }
        }else if(!center.equals(sphere.center)){
            return false;
        }
        return true;
    }
    @Override
    public String toString(){

        return "center: " + center + ", radius=" + radius;
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + Math.abs((int)(radius));
        result = prime * result + (int)sphereId;
        return result;
    }
}
