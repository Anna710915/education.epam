package edu.epam.tasksecond.entity;

import edu.epam.tasksecond.generator.GeneratorId;
import edu.epam.tasksecond.observer.Observable;
import edu.epam.tasksecond.observer.Observer;
import edu.epam.tasksecond.observer.SphereEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * Class {@code CustomSphere} contains center and radius fields; getter and
 * setter methods; have a list of observers;
 * Override and implement the methods of the superclass
 * {@code Object}: equals, hashCode, toString.
 */
public class CustomSphere implements Observable, Cloneable {
    static final Logger logger = LogManager.getLogger();
    private long sphereId;
    private CustomPoint center;
    private double radius;
    private List<Observer> observers = new ArrayList<>();

    public CustomSphere(CustomPoint center, double radius){
       this.center = center;
       this.radius = radius;
       this.sphereId = GeneratorId.setSphereID();
   }
   public long getSphereId(){
        return sphereId;
   }
    public void setSphereId(long sphereId){

        this.sphereId = sphereId;
    }
   public CustomPoint getCenter(){

        return  center;
   }

    public void setCenter(CustomPoint center){

        this.center=center;
    }
   public double getRadius(){

        return radius;
   }

    public void setRadius(double radius){
        if(radius > 0){
            this.radius = radius;
            notifyObservers();
        }else{
            logger.log(Level.WARN,"Radius is less than zero. Radius is " + radius);
        }
    }
    @Override
    public void attach (Observer observer){

        observers.add(observer);
    }
    @Override
    public void detach (Observer observer){

        observers.remove(observer);
    }
    @Override
    public void notifyObservers(){
        SphereEvent event = new SphereEvent(this);
        if(!observers.isEmpty()){
            observers.forEach(o-> o.update(event));
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
        if(radius != sphere.radius || sphereId != sphere.sphereId){
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
        final StringBuilder builder = new StringBuilder("Sphere{");
        builder.append("sphereId=").append(sphereId);
        builder.append(center);
        builder.append(", radius=").append(radius);
        builder.append('}');
        return builder.toString();
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
