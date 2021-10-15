package edu.epam.tasksecond.repository;

import edu.epam.tasksecond.entity.CustomSphere;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeRepository{
    private List<CustomSphere> item;
    private static ShapeRepository instance;

    private ShapeRepository(){
        item = new ArrayList<>();
    }
    public static ShapeRepository getInstance(){
        if(instance == null){
            instance = new ShapeRepository();
        }
        return instance;
    }
    public boolean add(CustomSphere customSphere) {
        return item.add(customSphere);
    }

    public boolean addAll(Collection<? extends CustomSphere> c) {
        return item.addAll(c);
    }

    public boolean remove(CustomSphere customSphere) {
        return item.remove(customSphere);
    }

    public boolean removeAll(Collection<?> c) {
        return item.removeAll(c);
    }

    public CustomSphere get(int index) {

        return item.get(index);
    }

    public void set(int index, CustomSphere element) {
         item.set(index, element);
    }

    public List<CustomSphere> query(Specification specification){

        return item.stream().filter(o -> specification.specify(o))
                .collect(Collectors.toList());
    }
    public List<CustomSphere> sort(Comparator<CustomSphere> comparator){

        return item.stream().sorted(comparator)
                .collect(Collectors.toList());
    }
}
