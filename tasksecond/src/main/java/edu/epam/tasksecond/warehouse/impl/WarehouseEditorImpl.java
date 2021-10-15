package edu.epam.tasksecond.warehouse.impl;

import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.server.impl.CustomActionSphere;
import edu.epam.tasksecond.entity.SphereParameter;
import edu.epam.tasksecond.warehouse.Warehouse;
import edu.epam.tasksecond.warehouse.WarehouseEditor;

public class WarehouseEditorImpl implements WarehouseEditor {
    public void addToWarehouse(CustomSphere sphere){
        CustomActionSphere action = new CustomActionSphere();
        double square = action.findSquare(sphere);
        double volume = action.findVolume(sphere);
        SphereParameter parameter = new SphereParameter(square,volume);
        Warehouse instance = Warehouse.getInstance();
        instance.put(sphere.getSphereId(), parameter);
    }
}
