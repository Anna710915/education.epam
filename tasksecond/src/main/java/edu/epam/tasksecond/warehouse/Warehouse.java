package edu.epam.tasksecond.warehouse;

import edu.epam.tasksecond.entity.SphereParameter;

import java.util.HashMap;

public class Warehouse {
    private HashMap<Long, SphereParameter> mapSphere;
    private static Warehouse instance;

    private Warehouse(){

        mapSphere = new HashMap<>();
    }
    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }
    public void put(Long key, SphereParameter value) {

        mapSphere.put(key, value);
    }
    public SphereParameter get(Long key){

        return mapSphere.get(key);
    }

    public SphereParameter remove(Long key) {
        return mapSphere.remove(key);
    }
}
