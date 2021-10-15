package edu.epam.tasksecond.repository.impl;

import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.repository.Specification;

public class IdSpecification implements Specification {
    private long id;
    public IdSpecification(long id){
        this.id = id;
    }
    @Override
    public boolean specify(CustomSphere item){

        return item.getSphereId() == id;
    }
}
