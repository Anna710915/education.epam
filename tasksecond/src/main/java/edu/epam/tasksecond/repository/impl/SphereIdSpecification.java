package edu.epam.tasksecond.repository.impl;

import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.repository.Specification;

public class SphereIdSpecification implements Specification {
    private long id;
    public SphereIdSpecification(long id){
        this.id = id;
    }
    @Override
    public boolean specify(CustomSphere item){

        return item.getSphereId() == id;
    }
}
