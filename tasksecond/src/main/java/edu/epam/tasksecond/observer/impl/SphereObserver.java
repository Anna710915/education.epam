package edu.epam.tasksecond.observer.impl;

import edu.epam.tasksecond.entity.CustomSphere;
import edu.epam.tasksecond.observer.Observer;
import edu.epam.tasksecond.observer.SphereEvent;
import edu.epam.tasksecond.warehouse.impl.WarehouseEditorImpl;

public class SphereObserver implements Observer {
    @Override
    public void update(SphereEvent event) {
        CustomSphere sphere = event.getSource();
        WarehouseEditorImpl editor = new WarehouseEditorImpl();
        editor.addToWarehouse(sphere);
    }
}
