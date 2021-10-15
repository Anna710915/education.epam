package edu.epam.tasksecond.repository.impl;

import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.exception.CustomException;
import edu.epam.tasksecond.repository.Specification;
import edu.epam.tasksecond.warehouse.Warehouse;

public class VolumeSpecification implements Specification {
    private double limit;
    public VolumeSpecification(double limit){
        this.limit = limit;
    }

    @Override
    public boolean specify(CustomSphere item) {
        Warehouse instance = Warehouse.getInstance();
        double volume = instance.get(item.getSphereId()).getVolume();
        return volume < limit;
    }
}
