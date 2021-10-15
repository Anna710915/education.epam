package edu.epam.tasksecond.observer;

import edu.epam.tasksecond.entity.CustomSphere;

import java.util.EventObject;

public class SphereEvent extends EventObject {
    public SphereEvent(CustomSphere source){ super(source);}
    @Override
    public CustomSphere getSource(){
        return (CustomSphere)super.getSource();
    }
}
